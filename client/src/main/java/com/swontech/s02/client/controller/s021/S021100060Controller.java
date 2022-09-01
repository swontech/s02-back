package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.spec.s021.S021100060Spec;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/s021100060")
public class S021100060Controller {
    private final S021100060Spec s021100060Spec;
    public S021100060Controller(S021100060Spec s021100060Spec) {
        this.s021100060Spec = s021100060Spec;
    }
}
