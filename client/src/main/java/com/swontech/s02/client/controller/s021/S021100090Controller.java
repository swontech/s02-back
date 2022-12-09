package com.swontech.s02.client.controller.s021;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.swontech.s02.domain.dto.s021.S021100090Dto;
import com.swontech.s02.domain.spec.s021.S021100090Spec;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/s021100090")
@Slf4j
@Api(tags = "거래처 관리(S021100090) API", description = "거래처 등록,수정,삭제 기능 API ")
public class S021100090Controller {
    private final S021100090Spec s021100090Spec;

    public S021100090Controller(S021100090Spec s021100090Spec) {
        this.s021100090Spec = s021100090Spec;
    }

    @GetMapping("/customer")
    public ResponseEntity<?> retrieveCustomerList(S021100090Dto.ParamsDto paramsDto) {
        return s021100090Spec.retrieveCustomerList(paramsDto);
    }

    @GetMapping("/customer-detail")
    public ResponseEntity<?> retrieveCustomerDetail(S021100090Dto.ParamsDto paramsDto) {
        return s021100090Spec.retrieveCustomerDetail(paramsDto);
    }

    @PostMapping("/save-customer")
    public ResponseEntity<?> saveCustomer(@RequestParam("orgId") int orgId
                                        , @RequestParam("customerId") @Parameter(name = "customerId", description = "신규:부서등록시 발번된 eventId, 기존:해당부서의 eventId") int customerId
                                        , @RequestBody ObjectNode jsonNodes) throws JsonProcessingException
    {
        log.info("거래처 저장 api 호출");
        log.info("customerId=> "+ customerId);
        log.info("data=> "+ jsonNodes);
        log.info("memberList isArray=> "+ jsonNodes.get("memberList").isArray());

        // JSON을 Object화 하기 위한 Jackson ObjectMapper 이용
        ObjectMapper mapper = new ObjectMapper();
        //거래처 정보
        S021100090Dto.RegisterCustomerDto registerCustomerDto
                = mapper.treeToValue(jsonNodes.get("customerInfo"), S021100090Dto.RegisterCustomerDto.class);
        //거래처의 직원 리스트
        List<S021100090Dto.RegisterCustomerMemberDto> listCustomerMemberDto
                = Arrays.asList(mapper.treeToValue(jsonNodes.get("memberList"), S021100090Dto.RegisterCustomerMemberDto[].class));

        //list dto 로 받아서 loop insert, 거래처가 신규 등록이면 customerId는 0
        return s021100090Spec.saveCustomer(orgId, customerId, registerCustomerDto, listCustomerMemberDto);
    }

    @PostMapping("/delete-customer")
    public ResponseEntity<?> deleteCustomer(int orgId, int memberId, List<Integer> customerIdList ) {
        return s021100090Spec.deleteCustomer(orgId, memberId, customerIdList);
    }
}
