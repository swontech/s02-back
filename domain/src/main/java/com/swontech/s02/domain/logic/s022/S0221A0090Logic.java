package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s022.S0221A0090Dto;
import com.swontech.s02.domain.spec.s022.S0221A0090Spec;
import com.swontech.s02.domain.store.s022.S0221A0090Store;
import com.swontech.s02.domain.vo.s022.S0221A0090Vo;
import org.springframework.http.ResponseEntity;

public class S0221A0090Logic implements S0221A0090Spec {
    private final CustomResponse response;
    private final S0221A0090Store s0221A0090Store;
    public S0221A0090Logic(CustomResponse response, S0221A0090Store s0221A0090Store) {
        this.response = response;
        this.s0221A0090Store = s0221A0090Store;
    }


    @Override
    public ResponseEntity<?> retrieveCostReqList(Integer mobileMemberId, String fromDate, String toDate) {
        return response.success(s0221A0090Store.selectCostReqList(S0221A0090Vo.SelectCostReqVo
                .builder()
                        .mobileMemberId(mobileMemberId)
                        .fromDate(fromDate)
                        .toDate(toDate)
                .build()));
    }
}
