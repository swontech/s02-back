package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.dto.s021.S021100020Dto;
import com.swontech.s02.domain.spec.s021.S021100020Spec;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/v1/s021100020")
@Api(tags = "단체 등록/수정 화면(S021100020) API", description = "단체 등록을 위한 이메일 중복체크, 단체정보 신규등록과 단체 수정을 위한 단체 정보 조회, 정보 수정 기능 API ")
public class S021100020Controller {
    private final S021100020Spec s021100020Spec;
    public S021100020Controller(S021100020Spec s021100020Spec) {
        this.s021100020Spec = s021100020Spec;
    }

    @Operation(summary = "이메일 중복 체크", description = "클라이언트에서 입력받은 이메일 정보로 이미 등록된 이메일이 있는지 조회한다.")
    @GetMapping("/dup-check-email")
    public ResponseEntity<?> duplicationCheckEmail(@RequestParam("email")String email) {
        return s021100020Spec.duplicationCheckEmail(email);
    }

    @Operation(summary = "단체 신규 등록")
    @PostMapping("/org")
    public ResponseEntity<?> registerOrg(final @Valid @RequestBody S021100020Dto.RegisterOrg reqDto) {
        return s021100020Spec.registerOrg(reqDto);
    }

    @Operation(summary = "단체 정보 조회", description = "단체 정보를 수정하기 위해 기등록된 단체 정보를 조회한다.")
    @GetMapping("/org")
    public ResponseEntity<?> retrieveOrg(@RequestParam("org-id")int orgId) {
        return s021100020Spec.retrieveOrg(orgId);

    }

    @Operation(summary = "단체 정보 수정", description = "기등록된 단체 정보를 수정한다.")
    @PostMapping("/patch-org")
    public ResponseEntity<?> patchOrg() {
        return null;
    }
}
