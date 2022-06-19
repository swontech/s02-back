package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s021.S021100020Dto;
import com.swontech.s02.domain.spec.s021.S021100020Spec;
import com.swontech.s02.domain.store.s021.S021100020Store;
import com.swontech.s02.domain.vo.s021.S021100020Vo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

public class S021100020Logic implements S021100020Spec {
    private final S021100020Store s021100020Store;
    private final PasswordEncoder passwordEncoder;
    private final CustomResponse responseDto;
    public S021100020Logic(S021100020Store s021100020Store, PasswordEncoder passwordEncoder, CustomResponse responseDto) {
        this.s021100020Store = s021100020Store;
        this.passwordEncoder = passwordEncoder;
        this.responseDto = responseDto;
    }
    /**
     * 이메일 중복 체크
     * @param
     */
    @Override
    public ResponseEntity<?> duplicationCheckEmail(String email) {
        if(s021100020Store.selectMemberEmail(email) == null) {
            return responseDto.success(true, "사용 가능한 이메일 주소입니다.", HttpStatus.OK);
        }
        return responseDto.success(false, "이미 사용중인 이메일 주소입니다.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> retrieveOrg(int orgId) {
        return responseDto.success(s021100020Store.selectOrg(orgId));
    }

    /**
     * 단체 등록 메소드
     * @param "S021100020Dto.RegisterOrg"
     */
    @Override
    public ResponseEntity<?> registerOrg(S021100020Dto.RegisterOrgReqDto reqDto) {
        /**
         * 단체 등록 메소드
         * 컨트롤러로부터 전달받은 request dto parameter를 InsertOrgVo에 담아 DML처리한다.
         * Mybatis의 selectKey를 이용해 발번된 orgId를 insertOrgVo의 String orgId에 자동으로 할당한다.
         */
        S021100020Vo.InsertOrgVo insertOrgVo = S021100020Vo.InsertOrgVo
                .builder()
                    .orgName(reqDto.getOrgName())               // 단체이름
                    .zipCode(reqDto.getZipCode())               // 단체 우편번호
                    .address(reqDto.getAddress())               // 단체 주소
                    .detailAddress(reqDto.getDetailAddress())   // 단체 상세주소
                    .firstTelNo(reqDto.getFirstTelNo())         // 단체 연락처
                    .middleTelNo(reqDto.getMiddleTelNo())       // 단체 연락처
                    .lastTelNo(reqDto.getLastTelNo())           // 단체 연락처
                .build();
        s021100020Store.insertOrg(insertOrgVo);

        /**
         *  insertOrgVo Mapper(S02100020Mapper.xml)에서 데이터 입력 후, 시퀀스를 통해 자동발번된 org_id를 리턴, insertOrgVo에 담아준다.
         *  컨트롤러로부터 전달받은 request dto 중 대표자정보와 insertOrgVo.orgId 및 전화번호를 초기 패스워드로 암호화 인코딩하여 InsertMemberVo에 담는다.
         */
        s021100020Store.insertMember(S021100020Vo.InsertMemberVo
                .builder()
                    .orgId(insertOrgVo.getOrgId())          // 단체 id(insertOrg DML이후 VO에 담긴 orgId)
                    .memberName(reqDto.getMemberName())     // 대표자 이름
                    .firstHpNo(reqDto.getFirstHpNo())       // 대표자 연락처
                    .middleHpNo(reqDto.getMiddleHpNo())     // 대푠자 연락처
                    .lastHpNo(reqDto.getLastHpNo())         // 대표자 연락처
                    .email(reqDto.getEmail())               // 대표자 이메일
                    .pwd(passwordEncoder.encode(reqDto.getFirstHpNo() + reqDto.getMiddleHpNo() + reqDto.getLastHpNo())) // 인코디드 패
                .build()
        );
        return responseDto.success("단체 신규등록에 성공했습니다.");
    }



    /**
     * 단체 상세정보 수정 메소드
     */
    @Override
    public ResponseEntity<?> patchOrgDetail(S021100020Dto.PatchOrgReqDto reqDto) {
        s021100020Store.updateOrg(S021100020Vo.UpdateOrgVo
                .builder()
                        .orgId(reqDto.getOrgId())
                        .orgName(reqDto.getOrgName())
                        .zipCode(reqDto.getZipCode())
                        .address(reqDto.getAddress())
                        .detailAddress(reqDto.getDetailAddress())
                        .firstHpNo(reqDto.getFirstHpNo())
                        .middleHpNo(reqDto.getMiddleHpNo())
                        .lastHpNo(reqDto.getLastHpNo())
                        .memberName(reqDto.getMemberName())
                        .firstHpNo(reqDto.getFirstHpNo())
                        .middleHpNo(reqDto.getMiddleHpNo())
                        .lastHpNo(reqDto.getLastHpNo())
                .build());
        return responseDto.success("단체 상세 정보 수정에 성공했습니다.");
    }
}
