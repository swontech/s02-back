package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.dto.s021.S021100040Dto;
import com.swontech.s02.domain.spec.s021.S021100040Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/s021100040")
public class S021100040Controller {
    private final S021100040Spec s021100040Spec;
    public S021100040Controller(S021100040Spec s021100040Spec) {
        this.s021100040Spec = s021100040Spec;
    }

    @PostMapping("/register-member")
    public ResponseEntity<?> registerMember(@RequestBody S021100040Dto.RegisterMemberDto reqDto) {
        return s021100040Spec.registerMember(reqDto);
    }

    @PostMapping("/update-member-info")
    public ResponseEntity<?> updateMemberInfo(@RequestBody S021100040Dto.UpdateMemberInfoDto reqDto) {
        return s021100040Spec.updateMemberInfo(reqDto);
    }
}
