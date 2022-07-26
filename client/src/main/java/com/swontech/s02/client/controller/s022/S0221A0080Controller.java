package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.dto.s022.S0221A0080Dto;
import com.swontech.s02.domain.spec.s022.S0221A0080Spec;
import io.swagger.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/s0221a0080")
public class S0221A0080Controller {
    private final S0221A0080Spec s0221A0080Spec;
    public S0221A0080Controller(S0221A0080Spec s0221A0080Spec) {
        this.s0221A0080Spec = s0221A0080Spec;
    }

    @GetMapping("/cost-req-detail")
    public ResponseEntity<?> retrieveReqCostDetail(@RequestParam("eventUseId") int eventUseId) {
        return s0221A0080Spec.retrieveCostReqDetail(eventUseId);
    }

    @PostMapping("/processing-cost-req")
    public ResponseEntity<?> processingCostReq(@RequestBody S0221A0080Dto.ProcessingCostReqDto reqDto) {
        return s0221A0080Spec.processingCostReq(reqDto);
    }
}
