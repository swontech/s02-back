package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.spec.s022.S0221A0030Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/rest/v1/s0221a0030")
public class S0221A0030Controller {
    private final S0221A0030Spec s0221A0030Spec;
    public S0221A0030Controller(S0221A0030Spec s0221A0030Spec) {
        this.s0221A0030Spec = s0221A0030Spec;
    }

    @GetMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestParam("eventCode") String eventCode, @RequestParam("hpNo") String hpNo, @RequestParam("memberName")String memberName, String token) throws NoSuchAlgorithmException {
        return s0221A0030Spec.signUp(eventCode, hpNo, memberName, token);
    }
}
