package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.spec.s022.S0221A0010Spec;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.swontech.s02.domain.dto.s022.S0221A0010Dto;

@RestController
@RequestMapping("/rest/v1/s0221a0010")
public class S0221A0010Controller {
    private final S0221A0010Spec s0221A0010Spec;
    public S0221A0010Controller(S0221A0010Spec s0221A0010Spec) {
        this.s0221A0010Spec = s0221A0010Spec;
    }

    @GetMapping("/user-info")
    public ResponseEntity<?> retrieveMobileInitUserInfo(@RequestParam("eventCode")String eventCode, @RequestParam("hpNo")String hpNo) {
        return s0221A0010Spec.retrieveMobileInitUserInfo(eventCode, hpNo);
    }

    @GetMapping("/use-state-cnt")
    public ResponseEntity<?> retrieveMobileInitUseStateCnt(@RequestParam("eventCode")String eventCode, @RequestParam("hpNo")String hpNo) {
        return s0221A0010Spec.retrieveMobileInitUseStateCnt(eventCode, hpNo);
    }


    @GetMapping("/pay-cnt")
    public ResponseEntity<?> retrieveMobileInitPayCnt(@RequestParam("eventCode")String eventCode, @RequestParam("hpNo")String hpNo) {
        return s0221A0010Spec.retrieveMobileInitPayCnt(eventCode, hpNo);
    }

    @GetMapping("mobile-init-recent-event")
    public ResponseEntity<?> retrieveMobileInitRecentEvent(@RequestParam("orgId") int orgId, @RequestParam("eventCode")String eventCode) {
        return s0221A0010Spec.retrieveMobileInitRecentEvent(orgId, eventCode);
    }
    /*2022.11.09 kjy : 부서코드 검색 */
    @Operation(summary = "앱-부서코드검색", description = "단체명,대표자명,부서명,책임자명 조건 검색")
    @PostMapping("/find-eventCode")
    public ResponseEntity<?> patchEvent(@RequestBody S0221A0010Dto.SelectEventCodeParams params) {
        return s0221A0010Spec.retrieveEventCode(params);
    }
}
