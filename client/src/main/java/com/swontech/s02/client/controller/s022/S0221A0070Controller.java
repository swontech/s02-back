package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.dto.s022.S0221A0070Dto;
import com.swontech.s02.domain.spec.s022.S0221A0070Spec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/rest/v1/s0221a0070")
public class S0221A0070Controller {
    private final S0221A0070Spec s0221A0070Spec;
    public S0221A0070Controller(S0221A0070Spec s0221A0070Spec) {
        this.s0221A0070Spec = s0221A0070Spec;
    }

    @GetMapping("/retrieve-cost-req")
    public ResponseEntity<?> retrieveCostReq(S0221A0070Dto.SelectCostReqDto reqDto) {
        /* 2022.11.10 kjy */
        log.info("[S0221A0070] 비용요청현황 api 호출 => "+ reqDto.getEventCode());
        return s0221A0070Spec.selectCostReqList(reqDto);
//    public ResponseEntity<?> retrieveCostReq(@RequestParam("eventCode")String eventCode,
//                                             @RequestParam("mobileMemberId")Integer mobileMemberId,
//                                             @RequestParam("fromDate")String fromDate,
//                                             @RequestParam("toDate")String toDate) {
//        return s0221A0070Spec.selectCostReqList(eventCode, mobileMemberId, fromDate, toDate);
    }
}
