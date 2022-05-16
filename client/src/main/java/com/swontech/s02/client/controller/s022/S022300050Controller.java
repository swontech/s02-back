package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.dto.s022.S022300050Dto;
import com.swontech.s02.domain.spec.s022.S022300050Spec;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/s022300050")
@Api(tags = "행사 등록/수정 화면(S022300050) API", description = "행사 신규 등록 및 기등록 행사의 상세 조회 및 수정 기능 API")
public class S022300050Controller {
    private final S022300050Spec s022300050Spec;
    public S022300050Controller(S022300050Spec s022300050Spec) {
        this.s022300050Spec = s022300050Spec;
    }

    @Operation(summary = "신규 행사 등록", description = "클라이언트에서 입력받은 신규행사정보를 저장한다.")
    @PostMapping("/event")
    public ResponseEntity<?> registerEvent(final @Validated S022300050Dto.RegisterEvent reqDto) {
        return s022300050Spec.registerEvent(reqDto);
    }

    @Operation(summary = "행사 상세 정보 조회", description = "기등록행사의 수정을 위한 정보를 조회한다.")
    @GetMapping("/event")
    public ResponseEntity<?> retrieveEvent(@RequestParam("eventId") String eventId) {
        return s022300050Spec.retrieveEvent(eventId);
    }

    @Operation(summary = "행사 상세 정보 수정", description = "기등록행사의 정보를 수정한다.")
    @PatchMapping("/event")
    public ResponseEntity<?> patchEvent(@RequestBody S022300050Dto.PatchEvent reqDto) {
        return s022300050Spec.patchEvent();
    }
}
