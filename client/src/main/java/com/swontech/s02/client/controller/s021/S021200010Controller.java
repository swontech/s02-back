package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.dto.s021.S021200010Dto;
import com.swontech.s02.domain.spec.s021.S021200010Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/s021200010")
public class S021200010Controller {
    private final S021200010Spec s021200010Spec;
    public S021200010Controller(S021200010Spec s021200010Spec) {
        this.s021200010Spec = s021200010Spec;
    }

    @GetMapping("/sign-in")
    public ResponseEntity<?> logIn(@Validated S021200010Dto.LogInReqDto reqDto) throws Exception {
        return s021200010Spec.logIn(reqDto);
    }
}
