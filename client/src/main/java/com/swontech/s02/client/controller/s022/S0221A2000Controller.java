package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.spec.s022.S0221A2000Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/s0221a2000")
public class S0221A2000Controller {
    private final S0221A2000Spec s0221A2000Spec;
    public S0221A2000Controller(S0221A2000Spec s0221A2000Spec) {
        this.s0221A2000Spec = s0221A2000Spec;
    }

    @GetMapping("/event-list")
    public ResponseEntity<?> retrieveEventList(@RequestParam(value = "eventCode")String eventCode
                                             , @RequestParam("orgId")int orgId
                                             , String eventNm   /*2022.11.23 kjy 행사명검색*/
                ) {
        return s0221A2000Spec.retrieveEventList(eventCode, orgId, eventNm);
    }

    @GetMapping("/event-detail")
    public ResponseEntity<?> retrieveEventDteail(@RequestParam("eventId")int eventId) {
        return s0221A2000Spec.retrieveEventDetail(eventId);
    }

}
