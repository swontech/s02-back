package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.spec.s021.S021100070Spec;
import com.swontech.s02.domain.dto.s021.S021100070Dto;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/s021100070")
@Api(tags = "부서(행사) 등록(s021100070) API", description = "부서(행사) 등록,수정,삭제 기능 API ")
public class S021100070Controller {
    private final S021100070Spec s021100070Spec;

    public S021100070Controller(S021100070Spec s021100070Spec) {
        this.s021100070Spec = s021100070Spec;
    }

    @GetMapping("/dept-level")
    public ResponseEntity<?> retrieveDeptLevel(@RequestParam("orgId") int orgId) {
        return s021100070Spec.retrieveDeptLevel(orgId);
    }

    @GetMapping("/dept-info")
    public ResponseEntity<?> retrieveDeptInfo(@RequestParam("eventId") int eventId) {
        return s021100070Spec.retrieveDeptInfo(eventId);
    }

    @GetMapping("/dept-pay-info")
    public ResponseEntity<?> retrieveDeptPayInfo(@RequestParam("orgId") int orgId,
                                                 @RequestParam("eventId") int eventId) {
        return s021100070Spec.retrieveDeptPayInfo(orgId, eventId);
    }

    @Operation(summary = "[unitTest]부서(행사) 등록", description = "[unitTest]화면에서 저장시 신규 등록인 경우")
    @PostMapping("/reg-event")
    public ResponseEntity<?> registerEvent(final @Valid @RequestBody S021100070Dto.RegisterEventDto registerEventDto) {
        return s021100070Spec.registerEvent(registerEventDto);
    }

    @Operation(summary = "[unitTest]해당 부서(행사) 회원 등록", description = "화면에서 저장시 해당 부서(행사)의 모든 회원 삭제 후 insert ")
    @PostMapping("/reg-eventMember")
    public ResponseEntity<?> registerEventMember(@RequestParam("eventId") @Parameter(name = "부서(행사)id", description = "신규:부서등록시 발번된 eventId, 기존:해당부서의 eventId") int eventId,
                                                 final @Valid @RequestBody
                                                 List<S021100070Dto.RegisterEventMemberDto> listRegEventMemberDto
    ) {
        //list dto 로 받아서 loop insert, 부서(행사)가 신규 등록이면 eventId는 0
        return s021100070Spec.registerEventMember(eventId, listRegEventMemberDto);
    }

    @Operation(summary = "[unitTest]부서(행사) 수정", description = "기등록된 부서(행사)정보를 수정")
    @PostMapping("/patch-event")
    public ResponseEntity<?> patchEvent(final @Valid @RequestBody S021100070Dto.PatchEventDto patchEventDto) {
        return s021100070Spec.patchEvent(patchEventDto);
    }

    @Operation(summary = "부서(행사) 저장-등록,수정,삭제", description = "화면에서 저장버튼 클릭시 기능 처리")
    @PostMapping("/reg-eventMember")
    public ResponseEntity<?> saveEvent(@RequestParam("eventId") @Parameter(name = "부서(행사)id", description = "유:eventId, 무:0") int eventId,
                                       final @Valid @RequestBody S021100070Dto.RegisterEventDto registerEventDto,
                                       final @Valid @RequestBody List<S021100070Dto.RegisterEventMemberDto> listRegEventMemberDto
    ) {
        //list dto 로 받아서 loop insert, 부서(행사)가 신규 등록이면 eventId는 0
        return s021100070Spec.saveEvent(eventId, registerEventDto, listRegEventMemberDto);
    }

}
