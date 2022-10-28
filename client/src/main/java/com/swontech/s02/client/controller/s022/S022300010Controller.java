package com.swontech.s02.client.controller.s022;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swontech.s02.domain.dto.s022.S022300010Dto;
import com.swontech.s02.domain.spec.s022.S022300010Spec;
import com.swontech.s02.domain.vo.s022.S022300010Vo;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest/v1/s022300010")
@Api(tags = "비용요청진행현황(S022300010) API", description = "비용요청조회 및 지급처리 기능 API ")
public class S022300010Controller {
    private final S022300010Spec s022300010Spec;
    private final Logger logger = LoggerFactory.getLogger(S022300010Controller.class);

    public S022300010Controller(S022300010Spec s022300010Spec){
        this.s022300010Spec = s022300010Spec;
    }
    /*비용 요청 조회*/
    @GetMapping("/cost-pay-list")
    public ResponseEntity<?> retrieveCostPayProTotList(@RequestParam Map<String, Object> mapParams)
    {
        logger.info("비용요청조회 params =>" + mapParams );
        ObjectMapper mapper = new ObjectMapper();
        S022300010Vo.ParamsVo paramsVo = mapper.convertValue(mapParams, S022300010Vo.ParamsVo.class);
        logger.info("비용요청조회 params convert =>" + mapParams );

        return s022300010Spec.retrieveCostPayProTotList(paramsVo);
    }
    /*비용 요청 조회 상세*/
    @GetMapping("/cost-pay-detail")
    public ResponseEntity<?> retrieveCostPayProTotDetail(@RequestParam("eventUsedId") int eventUsedId) {

        return s022300010Spec.retrieveCostPayProTotDetail(eventUsedId);
    }

    @Operation(summary = "비용지급 처리", description = "회계 담당자가 비용지급 처리 내용을 등록처리")
    @PostMapping("/reg-cost-pay")
    public ResponseEntity<?> registerCostPay(@RequestBody S022300010Dto.RegisterCostPayReqDto reqDto) {

        return s022300010Spec.registerCostPay(reqDto);
    }

    @Operation(summary = "[unitTest]비용지급 이력 등록", description = "회계 담당자가 비용지급 처리 내용을 등록처리")
    @PostMapping("/reg-cost-pay-history")
    public ResponseEntity<?> registerCostPayHistory(@RequestBody S022300010Dto.RegisterCostPayReqDto reqDto) {

        return s022300010Spec.registerCostPayHistory(reqDto);
    }

    @Operation(summary = "[unitTest]비용지급 상태변경", description = "진행 상태를 update 처리")
    @PostMapping("/patch-pay-status")
    public ResponseEntity<?> patchCostPayProgressStatus(@RequestParam("eventUsedId")
                                                        @Parameter(name = "행사비용사용ID", description = "선택된 EVENT_USE_ID") int eventUsedId) {

        return s022300010Spec.patchCostPayProgressStatus(eventUsedId);
    }

}