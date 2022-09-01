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

    @GetMapping("/re-issue")
    public ResponseEntity<?> reIssueToken(@RequestParam("access-token")String accessToken, @RequestParam("refresh-token") String refreshToken) {
        return authSpec.reIssueToken(accessToken, refreshToken);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> deleteToken(@RequestParam("email")String email) {
        return authSpec.deleteToken(email);
    }
}
