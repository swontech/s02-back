package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.spec.s021.S021300020Spec;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/s021300020")
@Api(tags = "S021300020 API", description = "코드등록/수정화면의 코드 신규등록, 수정, 삭제 기능 API")
public class S021300020Controller {
    private final S021300020Spec s021300020Spec;
    public S021300020Controller(S021300020Spec s021300020Spec) {
        this.s021300020Spec = s021300020Spec;
    }

    @PostMapping("/code")
    public void dmlCode() {

    }
}
