package com.swontech.s02.client.controller.comm;

import com.swontech.s02.domain.spec.comm.CommonSpec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/common")
public class CommonController {
    private final CommonSpec commonSpec;
    public CommonController(CommonSpec commonSpec) {
        this.commonSpec = commonSpec;
    }

    @GetMapping("/retrieve-code")
    public ResponseEntity<?> retrieveCode(@RequestParam("category")String category, @RequestParam("cdTp")String cdTp, @RequestParam("orgId")Integer orgId) {
        return commonSpec.retrieveCode(category, cdTp, orgId);
    }
}
