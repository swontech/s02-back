package com.swontech.s02.client.controller.s021.s02110;

import com.swontech.s02.domain.spec.s021.S021100010Spec;
import com.swontech.s02.domain.spec.s021.S021100020Spec;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/v1/s021100010")
@Api(tags = "S021100010 API", description = "단체정보의 조회, 등록, 수정 및 삭제 기능 API")
public class S021100010Controller {
    private final S021100010Spec s021100010Spec;
    public S021100010Controller(S021100010Spec s021100010Spec) {
        this.s021100010Spec = s021100010Spec;
    }

    @GetMapping("/org-list")
    public ResponseEntity<?> retrieveOrgList() {
        s021100010Spec.retrieveOrgList();
        return null;
    }

    @PostMapping("/org-list")
    public ResponseEntity<?> registerOrgList() {
        s021100010Spec.registerOrgList();
        return null;
    }

    @PatchMapping("/org-list")
    public ResponseEntity<?> modifyOrgList() {
        s021100010Spec.modifyOrgList();
        return null;
    }

    @DeleteMapping("/org-list")
    public ResponseEntity<?> deleteOrgList() {
        s021100010Spec.deleteOrgList();
        return null;
    }
}
