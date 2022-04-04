package com.swontech.s02.domain.logic.s021;

/**
 *
 */

import com.swontech.s02.domain.dto.s021.S021100020Dto;
import com.swontech.s02.domain.spec.s021.S021100020Spec;
import com.swontech.s02.domain.store.s021.S021100020Store;
import com.swontech.s02.domain.vo.s021.S021100020Vo;
import org.springframework.security.crypto.password.PasswordEncoder;

public class S021100020Logic implements S021100020Spec {
    private final S021100020Store s021100020Store;
    private final PasswordEncoder passwordEncoder;
    public S021100020Logic(S021100020Store s021100020Store, PasswordEncoder passwordEncoder) {
        this.s021100020Store = s021100020Store;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 단체 등록 메소드
     * @param "S021100020Dto.RegisterOrg"
     */
    @Override
    public void registerOrg(S021100020Dto.RegisterOrg reqDto) {
        /**
         *  단체/대표자 정보 Vo 선언
         */
        S021100020Vo.InsertOrgVo insertOrgVo;
        S021100020Vo.InsertMemberVo insertMemberVo;

        try {
            /**
             * 단체 등록 메소드
             * 컨트롤러로부터 전달받은 request dto parameter를 InsertOrgVo에 담는다.
             */
            insertOrgVo = S021100020Vo.InsertOrgVo
                    .builder()
                            .orgName(reqDto.getOrgName())               // 단체이름
                            .zipCode(reqDto.getZipCode())               // 단체 우편번호
                            .address(reqDto.getAddress())               // 단체 주소
                            .detailAddress(reqDto.getDetailAddress())   // 단체 상세주소
                            .firstTelNo(reqDto.getFirstTelNo())         // 단체 연락처
                            .middleTelNo(reqDto.getMiddleTelNo())       // 단체 연락처
                            .lastTelNo(reqDto.getLastTelNo())           // 단체 연락처
                    .build();

            /**
             *  insertOrgVo Mapper(S02100020Mapper.xml)에서 데이터 입력 후, 시퀀스를 통해 자동발번된 org_id를 리턴, insertOrgVo에 담아준다.
             *  insertMemberVo에서 orgId를 입력할 때 사용한다.
             */
            s021100020Store.registerOrg(insertOrgVo);

            /**
             * 대표자 등록
             * 컨트롤러로부터 전달받은 request dto 중 대표자정보와 insertOrgVo.orgId 및 전화번호를 초기 패스워드로 암호화 인코딩하여 InsertMemberVo에 담는다.
             */
            insertMemberVo = S021100020Vo.InsertMemberVo
                    .builder()
                            .orgId(insertOrgVo.getOrgId())          // 단체 id
                            .memberName(reqDto.getMemberName())     // 대표자 이름
                            .firstHpNo(reqDto.getFirstHpNo())       // 대표자 연락처
                            .middleHpNo(reqDto.getMiddleHpNo())     // 대푠자 연락처
                            .lastHpNo(reqDto.getLastHpNo())         // 대표자 연락처
                            .email(reqDto.getEmail())               // 대표자 이메일
                            .pwd(passwordEncoder.encode(reqDto.getFirstHpNo() + reqDto.getMiddleHpNo() + reqDto.getLastHpNo())) // 인코디드 패스워드
                    .build();
            /**
             *  insertMemberVo Mapper(S02100020Mapper.xml)를 통해 데이터 입력
             */
            s021100020Store.registerMember(insertMemberVo);

            /**
             *  회원가입이 완료된 경우 로그인 로직 수행
             */



        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            insertOrgVo = null;
            insertMemberVo = null;
        }
    }

    /**
     * 단체 상세정보 수정 메소드
     */
    @Override
    public void patchOrgDetail() {

    }
}
