package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.spec.s022.S0221A0070Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/s0221a0070")
public class S0221A0070Controller {
    private final S0221A0070Spec s0221A0070Spec;
    public S0221A0070Controller(S0221A0070Spec s0221A0070Spec) {
        this.s0221A0070Spec = s0221A0070Spec;
    }

    @GetMapping("/retrieve-cost-req")
    public ResponseEntity<?> retrieveCostReq(@RequestParam("mobileMemberId")Integer mobileMemberId, @RequestParam("fromDate")String fromDate, @RequestParam("toDate")String toDate) {
        return s0221A0070Spec.selectCostReqList(mobileMemberId, fromDate, toDate);
    }
}
