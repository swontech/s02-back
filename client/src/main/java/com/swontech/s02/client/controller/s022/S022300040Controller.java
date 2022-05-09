package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.dto.s022.S022300040Dto;
import com.swontech.s02.domain.spec.s022.S022300040Spec;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/vi/s022300040")
@Api(tags = "행사현황 화면(S022300040) API", description = "등록된 행사리스트 조회 및 삭제")
public class S022300040Controller {


    @Operation(summary = "행사리스트 검색", description = "클라이언트에서 입력받은 행사명, 운영자, 진행상태 키워드를 바탕으로 행사리스트를 검색한다.")
    @GetMapping("/event-list")
    public ResponseEntity<?> retrieveEventList(final @Validated S022300040Dto reqDto) {
        return null;
    }

    @Operation(summary = "행사삭제", description = "클라이언트에서 입력받은 행사 ID를 바탕으로 행사리스트를 삭제한다.")
    @DeleteMapping("/event-list")
    public ResponseEntity<?> deleteEventList(final @Validated S022300040Dto reqDto) {
        return null;
    }

}
