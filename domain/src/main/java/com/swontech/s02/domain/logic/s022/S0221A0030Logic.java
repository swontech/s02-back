package com.swontech.s02.domain.logic.s022;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.swontech.s02.domain.dto.comm.ResponseDto;
import com.swontech.s02.domain.spec.s022.S0221A0030Spec;
import com.swontech.s02.domain.store.s022.S0221A0030Store;
import com.swontech.s02.domain.vo.s022.S0221A0030Vo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class S0221A0030Logic implements S0221A0030Spec {
    private final S0221A0030Store s0221A0030Store;
    private final ResponseDto response;
    public S0221A0030Logic(S0221A0030Store s0221A0030Store, ResponseDto response) {
        this.s0221A0030Store = s0221A0030Store;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> signUp(String memberName, String hpNo) throws NoSuchAlgorithmException {
        /** 1. 가입된 hp_no가 있는지 체크한다. */
        String memberId = s0221A0030Store.selectMemberId(hpNo);

        /** 2. 가입된 hp_no가 있다면 모바일아이디를 update한다. */
        if(memberId != null) {
            s0221A0030Store.updateMobileId(
                    S0221A0030Vo.UpdateMobileIdVo
                        .builder()
                            .memberId(Integer.parseInt(memberId))
                            .mobileId(encodingMobileId(Integer.parseInt(memberId), hpNo))
                        .build());
            return response.success(s0221A0030Store.selectSignUpInfo(hpNo), "모바일 로그인에 성공했습니다.", HttpStatus.OK);

        /** 3. 가입된 hp_no가 없다면 신규 등록한다. */
        } else {
            S0221A0030Vo.InsertMemberInfoVo insertMemberInfoVo = S0221A0030Vo.InsertMemberInfoVo
                .builder()
                    .memberName(memberName)
                    .hpNo(hpNo)
                .build();
            s0221A0030Store.insertMemberInfo(insertMemberInfoVo);


                s0221A0030Store.updateMobileId(S0221A0030Vo.UpdateMobileIdVo
                    .builder()
                        .memberId(insertMemberInfoVo.getMemberId())
                        .mobileId(encodingMobileId(insertMemberInfoVo.getMemberId(), hpNo))
                    .build()
                );


            return response.success(s0221A0030Store.selectSignUpInfo(hpNo), "신규회원가입에 성공했습니다.", HttpStatus.OK);
        }
    }




    private String encodingMobileId(int memberId, String hpNo) throws NoSuchAlgorithmException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            String text = memberId + hpNo.replace("-", "");
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
