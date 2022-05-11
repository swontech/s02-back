package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.common.exception.CustomException;
import com.swontech.s02.domain.common.exception.ExceptionEnum;
import com.swontech.s02.domain.dto.comm.ResponseDto;
import com.swontech.s02.domain.dto.s022.S0221A0020Dto;
import com.swontech.s02.domain.spec.s022.S0221A0020Spec;
import com.swontech.s02.domain.store.s022.S0221A0020Store;
import com.swontech.s02.domain.vo.s022.S0221A0020Vo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class S0221A0020Logic implements S0221A0020Spec {
    private final S0221A0020Store s0221A0020Store;
    private final ResponseDto response;
    public S0221A0020Logic(S0221A0020Store s0221A0020Store, ResponseDto response) {
        this.s0221A0020Store = s0221A0020Store;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> scanQrInfo(S0221A0020Dto.QrInfo qrInfo) {
        boolean isVaildEventId = s0221A0020Store.selectEventId(
                S0221A0020Vo.SelectEventId
                        .builder()
                            .eventId(qrInfo.getEventId())
                            .orgId(qrInfo.getOrgId())
                .build()) > 0;
        if(!isVaildEventId) {
            return response.fail("유효하지 않은 orgId와 eventId입니다.", HttpStatus.BAD_REQUEST);
        }

        boolean isValidMobileId = s0221A0020Store.selectMobileId(
                S0221A0020Vo.SelectMobileId
                        .builder()
                            .mobileId(qrInfo.getMobileId())
                            .memberId(qrInfo.getMemberId())
                        .build()) > 0;
        if(!isValidMobileId) {
            return response.fail("유효하지 않은 mobileId입니다.", HttpStatus.FORBIDDEN);
        }


        return response.success(s0221A0020Store.insertEnter(
            S0221A0020Vo.InsertEnterVo
                    .builder()
                    .orgId(qrInfo.getOrgId())
                    .memberId(qrInfo.getMemberId())
                    .eventId(qrInfo.getEventId())
                    .build()
            )
        );
    }
}
