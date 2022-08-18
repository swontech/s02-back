package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.spec.s021.S021100050Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/s021100050")
public class S021100050Controller {
    private final S021100050Spec s021100050Spec;
    public S021100050Controller(S021100050Spec s021100050Spec) {
        this.s021100050Spec = s021100050Spec;
    }

    @GetMapping("/retrieve-member-list")
    public ResponseEntity<?> retrieveMemberList(@RequestParam("orgId") int orgId, @RequestParam(value = "memberName", required = false) String memberName) {
        return s021100050Spec.retrieveMemberList(orgId, memberName);
    }
}
