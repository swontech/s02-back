package com.swontech.s02.client.controller.comm;

import com.swontech.s02.domain.dto.comm.AuthDto;
import com.swontech.s02.domain.spec.comm.AuthSpec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/v1/auth")
public class AuthController {
    private final AuthSpec authSpec;
    public AuthController(AuthSpec authSpec) {
        this.authSpec = authSpec;
    }

    @PatchMapping("/reissue-token")
    public ResponseEntity<?> reIssueToken(@Valid AuthDto.ReIssue reIssue) {
        return authSpec.reIssueToken(reIssue);
    }

    @DeleteMapping("/delete-token")
    public ResponseEntity<?> deleteToken() {
        return authSpec.deleteToken();
    }
}
