package com.swontech.s02.client.controller.s021.s02110;

import com.swontech.s02.domain.dto.S021.S021100020Dto;
import com.swontech.s02.domain.spec.s021.S021100020Spec;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/v1/s021100020")
@Api(tags = "s021100020 API", description = "")
public class S021100020Controller {
    private final S021100020Spec s021100020Spec;
    public S021100020Controller(S021100020Spec s021100020Spec) {
        this.s021100020Spec = s021100020Spec;
    }

    @PostMapping("/org")
    public ResponseEntity<?> registerOrg(@RequestBody @Valid S021100020Dto.RegisterOrg reqDto) {
        s021100020Spec.registerOrg(reqDto);

        return null;
    }
}
