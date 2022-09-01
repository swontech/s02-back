package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s021.S021100040Dto;
import com.swontech.s02.domain.spec.s021.S021100040Spec;
import com.swontech.s02.domain.store.s021.S021100040Store;
import com.swontech.s02.domain.vo.s021.S021100040Vo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class S021100040Logic implements S021100040Spec {
    private final S021100040Store s021100040Store;
    private final CustomResponse response;
    public S021100040Logic(S021100040Store s021100040Store, CustomResponse response) {
        this.s021100040Store = s021100040Store;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> registerMember(S021100040Dto.RegisterMemberDto reqDto) {
        int result = s021100040Store.insertMember(
                            S021100040Vo.InsertMemberVo
                                .builder()
                                    .orgId(reqDto.getOrgId())
                                    .memberName(reqDto.getMemberName())
                                    .birth(reqDto.getBirth())
                                    .hpNo(reqDto.getHpNo())
                                    .zipCode(reqDto.getZipCode())
                                    .address(reqDto.getAddress())
                                    .detailAddress(reqDto.getDetailAddress())
                                    .email(reqDto.getEmail())
                                    .pwd(reqDto.getPwd())
                                    .accountNo(reqDto.getAccountNo())
                                    .bankNm(reqDto.getBackNm())
                                .build()
                    );
        if(result > 0) {
            return response.success("회원등록에 성공했습니다.");
        }
        return response.fail("회원을 등록하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> updateMemberInfo(S021100040Dto.UpdateMemberInfoDto reqDto) {
        try {
            int result = s021100040Store.updateMemberInfo(
                    S021100040Vo.UpdateMemberInfoVo
                            .builder()
                                .memberName(reqDto.getMemberName())
                                .memberId(reqDto.getMemberId())
                                .birth(reqDto.getBirth())
                                .hpNo(reqDto.getHpNo())
                                .zipCode(reqDto.getZipCode())
                                .address(reqDto.getAddress())
                                .detailAddress(reqDto.getDetailAddress())
                                .email(reqDto.getEmail())
                                .accountNo(reqDto.getAccountNo())
                                .bankNm(reqDto.getBankNm())
                            .build()
            );
            if(result > 0) {
                return response.success("회원정보 수정에 성공했습니다.");
            }
            return response.success("수정된 내역이 없습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return response.fail("회원정보를 수정하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
