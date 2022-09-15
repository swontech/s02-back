package com.swontech.s02.domain.logic.s022;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s022.S0221A0030Dto;
import com.swontech.s02.domain.spec.s022.S0221A0030Spec;
import com.swontech.s02.domain.store.s022.S0221A0030Store;
import com.swontech.s02.domain.vo.s022.S0221A0030Vo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class S0221A0030Logic implements S0221A0030Spec {
    private final S0221A0030Store s0221A0030Store;
    private final CustomResponse response;
    public S0221A0030Logic(S0221A0030Store s0221A0030Store, CustomResponse response) {
        this.s0221A0030Store = s0221A0030Store;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> signUp(String eventCode, String hpNo, String memberName) throws NoSuchAlgorithmException {
        String returnMassage = "";

        /** 1. 가입된 모바일 회원이 있는지 체크한다. */
        S0221A0030Dto.MobileMemberExistFlag memberExistFlag = s0221A0030Store.selectMemberExistFlag(
                S0221A0030Vo.SelectMemberExistFlagVo
                        .builder()
                        .eventCode(eventCode)
                        .hpNo(hpNo)
                        .build()
        );
        if(memberExistFlag == null) return response.success("등록되지 않은 부서코드입니다.");

        try {
            /** 등록된 memberId가 없다면 신규 등록 */
            if(memberExistFlag.getMemberId() == null) {
                S0221A0030Vo.InsertNewMobileMemberVo vo
                        = S0221A0030Vo.InsertNewMobileMemberVo
                                .builder()
                                    .orgId(memberExistFlag.getOrgId())
                                    .memberName(memberName)
                                    .hpNo(hpNo)
                                .build();
                s0221A0030Store.insertNewMobileMember(vo);
                s0221A0030Store.updateMobileId(S0221A0030Vo.UpdateMobileIdVo.builder().memberId(vo.getMemberId()).mobileId(encodingMobileId(vo.getMemberId(), hpNo)).build());
                s0221A0030Store.insertNewMobileEventMember(
                    S0221A0030Vo.InsertNewMobileEventMemberVo
                        .builder()
                            .eventId(memberExistFlag.getEventId())
                            .memberId(vo.getMemberId())
                        .build());
                returnMassage = "신규회원가입에 성공했습니다.";
            }

            /** 등록된 memberId가 있다면 업데이트 등록 */
            if(memberExistFlag.getMemberId() != null && memberExistFlag.getMobileId() != null) {
                s0221A0030Store.updateMobileMember(S0221A0030Vo.UpdateMobileMemberVo
                    .builder()
                        .newMobileId(encodingMobileId(memberExistFlag.getMemberId(), memberExistFlag.getHpNo()))
                        .mobileId(memberExistFlag.getMobileId())
                    .build()
                );
                returnMassage = "기 등록된 회원의 로그인 정보 업데이트에 성공했습니다.";
            }
            return response.success(s0221A0030Store.selectMemberExistFlag(S0221A0030Vo.SelectMemberExistFlagVo
                    .builder()
                    .eventCode(eventCode)
                    .hpNo(hpNo)
                    .build()), returnMassage, HttpStatus.OK);
        } catch (Exception e) {
            return response.fail("모바일 회원가입에 실패했습니다. 관리자에게 문의해주세요." + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    private String encodingMobileId(int memberId, String hpNo) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            String text = memberId + hpNo;
            messageDigest.update(text.getBytes());

            return bytesToHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
