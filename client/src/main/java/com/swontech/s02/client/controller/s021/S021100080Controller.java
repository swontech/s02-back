package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.spec.s021.S021100080Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/s021100080")
public class S021100080Controller {
    private final S021100080Spec s021100080Spec;
    public S021100080Controller(S021100080Spec s021100080Spec) {
        this.s021100080Spec = s021100080Spec;
    }


    @GetMapping("/list")
    public ResponseEntity<?> retrieveList(@RequestParam("orgId")int orgId, @RequestParam("eventNm")String eventNm) {
        return s021100080Spec.retrieveList(orgId, eventNm);
    }
}
