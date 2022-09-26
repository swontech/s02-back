package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.dto.comm.CustomResponse;
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
    public ResponseEntity<?> retrieveCostPayList(String eventCode, int eventPayUserId, String fromDate, String toDate) {
        return response.success(s0221A0090Store.selectCostPayList(S0221A0090Vo.CostPayListVo
                .builder()
                        .eventCode(eventCode)
                        .eventPayUserId(eventPayUserId)
                        .fromDate(fromDate)
                        .toDate(toDate)
                .build()));
    }
}
