package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.spec.s022.S0221A0070Spec;
import com.swontech.s02.domain.store.s022.S0221A0070Store;
import com.swontech.s02.domain.vo.s022.S0221A0070Vo;
import org.springframework.http.ResponseEntity;

public class S0221A0070Logic implements S0221A0070Spec {
    private final S0221A0070Store s0221A0070Store;
    private final CustomResponse response;
    public S0221A0070Logic(S0221A0070Store s0221A0070Store, CustomResponse response) {
        this.s0221A0070Store = s0221A0070Store;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> selectCostReqList(Integer mobileMemberId, String fromDate, String toDate) {
        return response.success(s0221A0070Store.selectCostReqList(
                S0221A0070Vo.SelectCostReqVo
                        .builder()
                            .mobileMemberId(mobileMemberId)
                            .fromDate(fromDate)
                            .toDate(toDate)
                        .build()));
    }
}
