package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.spec.s022.S0221A0010Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
