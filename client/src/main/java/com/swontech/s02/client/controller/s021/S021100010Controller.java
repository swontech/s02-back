package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.spec.s021.S021100010Spec;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/s021100010")
@Api(tags = "단체관리(리스트) 화면 (S021100010) API", description = "단체정보의 조회, 등록, 수정 및 삭제 기능 API")
public class S021100010Controller {
    private final S021100010Spec s021100010Spec;
    public S021100010Controller(S021100010Spec s021100010Spec) {
        this.s021100010Spec = s021100010Spec;
    }

    @Operation(summary = "단체 정보 리스트 조회", description = "등록된 단체 정보 리스트를 조회한다.")
    @GetMapping("/org-list")
    public ResponseEntity<?> retrieveOrgList() {
        return s021100010Spec.retrieveOrgList();
    }

    @Operation(summary = "단체 정보 리스트 신규 등록", description = "단체 정보 리스트를 신규로 등록한다.")
    @PostMapping("/org-list")
    public ResponseEntity<?> registerOrgList() {
        return s021100010Spec.registerOrgList();
    }

    @Operation(summary = "단체 정보 리스트 수정", description = "단체 정보 리스트를 신규로 등록한다.")
    @PatchMapping("/org-list")
    public ResponseEntity<?> patchOrgList() {
        return s021100010Spec.patchOrgList();
    }

    @Operation(summary = "단체 정보 리스트 삭제", description = "단체 정보 리스트를 신규로 등록한다.")
    @DeleteMapping("/org-list")
    public ResponseEntity<?> deleteOrgList() {
        return s021100010Spec.deleteOrgList();
    }
}
