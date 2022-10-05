package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.dto.s022.S0221A0020Dto;
import com.swontech.s02.domain.spec.s022.S0221A0020Spec;
import io.swagger.models.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/s0221a0020")
public class S0221A0020Controller {
    private final S0221A0020Spec s0221A0020Spec;
    public S0221A0020Controller(S0221A0020Spec s0221A0020Spec) {
        this.s0221A0020Spec = s0221A0020Spec;
    }

    @PostMapping("/qr-scan")
    public ResponseEntity<?> scanQr(@RequestBody S0221A0020Dto.QrInfo reqDto) {
        return s0221A0020Spec.scanQrInfo(reqDto);
    }

    @GetMapping("/qr-info")
    public ResponseEntity<?> retrieveQrScanInfo(@RequestParam("eventId")int eventId) {
        return s0221A0020Spec.selectQrScanInfo(eventId);
    }
}
