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
        String returnMassage = "";  // <-- 리턴 메시지

        Integer memberId = null;
        String eventPayUserId = null;
        String mobileId = null;
        Integer orgId = null;


        try {
            /** 1. 가입된 모바일 회원이 있는지 체크한다. */
            S0221A0030Vo.SelectMemberExistFlagVo selectMemberExistFlagVo = S0221A0030Vo.SelectMemberExistFlagVo
                    .builder()
                    .eventCode(eventCode)   // <-- 부서코드
                    .hpNo(hpNo)             // <-- 전화번호
                    .build();

            S0221A0030Dto.MobileMemberExistFlag memberExistFlag = s0221A0030Store.selectMemberExistFlag(selectMemberExistFlagVo);
            if(memberExistFlag == null) return response.success("등록되지 않은 부서코드입니다.");

            memberId = memberExistFlag.getMemberId();
            eventPayUserId = memberExistFlag.getEventPayUserId();
            orgId = memberExistFlag.getOrgId();

            // ① 회원정보 (tb_s020_member010) insert 처리
            // ② 부서별 회원정보 (tb_s020_event020) insert 처리
            if(memberId == null && eventPayUserId == null) {
                S0221A0030Vo.InsertMobileMemberVo insertMobileMemberVo = S0221A0030Vo.InsertMobileMemberVo
                        .builder()
                            .orgId(orgId)
                            .memberName(memberName)
                            .hpNo(hpNo)
                        .build();

                s0221A0030Store.insertMobileMember(insertMobileMemberVo);
                int newMemberId = insertMobileMemberVo.getMemberId();
                String newMobileId = encodingMobileId(insertMobileMemberVo.getMemberId(), hpNo);
                s0221A0030Store.updateMobileId(S0221A0030Vo.UpdateMobileIdVo.builder().mobileId(newMobileId).memberId(newMemberId).build());
            }

            // ③ 회원정보 (tb_s020_member010) 로그인정보 update 처리
            // ② 부서별 회원정보 (tb_s020_event020) insert 처리
            if(memberId != null && mobileId == null && eventPayUserId == null) {
                s0221A0030Store.updateMobileMember(S0221A0030Vo.UpdateMobileMemberVo
                        .builder()
                                .mobileId(encodingMobileId(memberId, hpNo))
                                .memberId(memberId)
                        .build());
            }

            if(memberId != null && mobileId != null && eventPayUserId != null) {
                // skip
            }

            if(memberId != null && mobileId != null && eventPayUserId == null) {
                s0221A0030Store.insertMobileMemberEvent(S0221A0030Vo.InsertMobileMemberEventVo
                        .builder()
                                .eventId(memberExistFlag.getEventId())
                                .memberId(memberId)
                        .build());
            }

            if(memberId != null && mobileId == null && eventPayUserId != null) {
                s0221A0030Store.updateMobileMember(S0221A0030Vo.UpdateMobileMemberVo
                        .builder()
                                .mobileId(encodingMobileId(memberId, hpNo))
                                .memberId(memberId)
                        .build());
            }
            return response.success("정상적으로 처리되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            return response.fail("모바일 회원가입에 실패했습니다. 관리자에게 문의해주세요." + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private static String encodingMobileId(int memberId, String hpNo) throws NoSuchAlgorithmException {
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

    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
