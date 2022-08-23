package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.spec.s021.S021100070Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/s021100070")
public class S021100070Controller {
    private final S021100070Spec s021100070Spec;
    public S021100070Controller(S021100070Spec s021100070Spec) {
        this.s021100070Spec = s021100070Spec;
    }

    @GetMapping("/dept-info")
    public ResponseEntity<?> retrieveDeptInfo(@RequestParam("eventId")int eventId) {
        return s021100070Spec.retrieveDeptInfo(eventId);
    }

    @GetMapping("/dept-pay-info")
    public ResponseEntity<?> retrieveDeptPayInfo(@RequestParam("eventId")int eventId) {
        return s021100070Spec.retrieveDeptPayInfo(eventId);
    }
}
