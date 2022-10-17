package com.swontech.s02.client.controller.s021;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.swontech.s02.domain.spec.s021.S021100070Spec;
import com.swontech.s02.domain.dto.s021.S021100070Dto;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/s021100070")
@Api(tags = "부서(행사) 등록(s021100070) API", description = "부서(행사) 등록,수정,삭제 기능 API ")
public class S021100070Controller {
    private final S021100070Spec s021100070Spec;
    private final Logger logger = LoggerFactory.getLogger(S021100070Controller.class);

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

    @GetMapping("/newEventCode")
    public ResponseEntity<?> retrieveNewEventCode(@RequestParam("orgId") int orgId) {
        return s021100070Spec.retrieveNewEventCode(orgId);
    }

    @Operation(summary = "[unitTest]부서(행사) 등록", description = "[unitTest]화면에서 저장시 신규 등록인 경우")
    @PostMapping("/reg-event")
    public ResponseEntity<?> registerEvent(@RequestBody S021100070Dto.RegisterEventDto registerEventDto) {
        logger.info("[unitTest]부서(행사) 등록 /reg-event api 호출");
        logger.info("부서(행사)data =>"+ registerEventDto.toString());
        return s021100070Spec.registerEvent(registerEventDto);
    }

    @Operation(summary = "[unitTest]해당 부서(행사) 회원 등록", description = "화면에서 저장시 해당 부서(행사)의 모든 회원 삭제 후 insert ")
    @PostMapping("/reg-eventMember")
    public ResponseEntity<?> registerEventMember(@RequestParam("eventId") @Parameter(name = "부서(행사)id", description = "신규:부서등록시 발번된 eventId, 기존:해당부서의 eventId") int eventId,
                                                 @RequestBody
                                                 List<S021100070Dto.RegisterEventMemberDto> listRegEventMemberDto
    ) {
        logger.info("[unitTest]해당 부서(행사) 회원 등록 /reg-eventMember api 호출");
        logger.info("eventId=>"+ eventId);
        logger.info("부서(행사)회원 data =>"+ listRegEventMemberDto.toString());
        //list dto 로 받아서 loop insert, 부서(행사)가 신규 등록이면 eventId는 0
        return s021100070Spec.registerEventMember(eventId, listRegEventMemberDto);
    }

    @Operation(summary = "[unitTest]부서(행사) 수정", description = "기등록된 부서(행사)정보를 수정")
    @PostMapping("/patch-event")
    public ResponseEntity<?> patchEvent(@RequestBody S021100070Dto.PatchEventDto patchEventDto) {
        logger.info("[unitTest]부서(행사) 등록 /reg-event api 호출");
        logger.info("부서(행사)data =>"+ patchEventDto.toString());
        return s021100070Spec.patchEvent(patchEventDto);
    }

    @Operation(summary = "부서(행사) 저장-등록,수정,삭제", description = "화면에서 저장버튼 클릭시 기능 처리")
    @PostMapping("/save-event")
    public ResponseEntity<?> saveEvent(@RequestParam("eventId") @Parameter(name = "부서(행사)id", description = "유:eventId, 무:0") int eventId,
                                       @RequestBody ObjectNode jsonNodes
                                       ) throws JsonProcessingException {
        logger.info("부서(행사) 저장-등록,수정,삭제 api 호출");
        logger.info("eventId=> "+ eventId);
        logger.info("data=> "+ jsonNodes);
        logger.info("memberList isArray=> "+ jsonNodes.get("memberList").isArray());

        // JSON을 Object화 하기 위한 Jackson ObjectMapper 이용
        ObjectMapper mapper = new ObjectMapper();
        //부서(행사)정보
        S021100070Dto.RegisterEventDto registerEventDto
                = mapper.treeToValue(jsonNodes.get("eventInfo"), S021100070Dto.RegisterEventDto.class);
        //부서(행사) 회원 정보
        List<S021100070Dto.RegisterEventMemberDto> listRegEventMemberDto
                = Arrays.asList(mapper.treeToValue(jsonNodes.get("memberList"), S021100070Dto.RegisterEventMemberDto[].class));
        //회원정보 확인
        logger.info("부서(행사)회원 parse count =>" + listRegEventMemberDto.size() );
        listRegEventMemberDto.forEach(
                memberDto -> logger.info("부서(행사)회원 parse =>"+memberDto.getEventPayRoleCd())
        );

        //list dto 로 받아서 loop insert, 부서(행사)가 신규 등록이면 eventId는 0
        return s021100070Spec.saveEvent(eventId, registerEventDto, listRegEventMemberDto);
    }

    /*행사최하위여부( EVENT_FINAL_FLAG) null update */
    @Operation(summary = "[unitTest]부서(행사) 수정", description = "상위 부서(행사)정보:행사최하위여부 수정")
    @PostMapping("/patch-finalFlag")
    public ResponseEntity<?> patchEventFinalFlag(@RequestParam("orgId") int orgId,
                                                 @RequestParam("highEventId") int eventId) {
        logger.info("부서(행사) 저장-등록,수정,삭제 api 호출");
        return s021100070Spec.patchEventFinalFlag(orgId, eventId);        
    }

    /* 기본사역 삭제 처리 update  */
    @Operation(summary = "[unitTest]부서(행사) 수정", description = "상위 부서(행사)정보:기본사역 수정")
    @PostMapping("/patch-defaultFlag")
    public ResponseEntity<?> patchDefaultEventFlag(@RequestParam("orgId") int orgId,
                                                 @RequestParam("eventId") int eventId) {
        logger.info("부서(행사) 저장-등록,수정,삭제 api 호출");
        return s021100070Spec.patchDefaultEventFlag(orgId, eventId);
    }

}
