package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.spec.s022.S0221A0090Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/s0221a0090")
public class S0221A0090Controller {
    private final S0221A0090Spec s0221A0090Spec;
    public S0221A0090Controller(S0221A0090Spec s0221A0090Spec) {
        this.s0221A0090Spec = s0221A0090Spec;
    }

    @GetMapping("/cost-pay-list")
    public ResponseEntity<?> retrieveCostPayList(
            @RequestParam("eventCode")String eventCode,
            @RequestParam("eventPayUserId")Integer eventPayUserId,
            @RequestParam("fromDate") String fromDate,
            @RequestParam("toDate") String toDate ) {
        return s0221A0090Spec.retrieveCostPayList(eventCode, eventPayUserId, fromDate, toDate);
    }
}
