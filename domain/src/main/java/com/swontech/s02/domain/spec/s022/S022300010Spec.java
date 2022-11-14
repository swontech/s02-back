/****************************************************
 * program : 비용진행현황 및 비용상세처리 (S022300010)
 * desc :
 * 1) 운영자, 회계 담당자가 비용요청 진행 전체 대상 List 조회
 * 2) 비용지급 처리 : 회계 담당자가 비용지급 처리 내용을 등록처리
 ****************************************************/
package com.swontech.s02.domain.spec.s022;

import com.swontech.s02.domain.dto.s022.S022300010Dto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface S022300010Spec {
    /*비용 요청 조회*/
    ResponseEntity<?> retrieveCostPayProTotList(S022300010Dto.RetrieveCostPayList reqDto);
    /*비용 요청 조회 상세*/
    ResponseEntity<?> retrieveCostPayProTotDetail(int eventUsedId);
    /*비용지급 처리 */
    ResponseEntity<?> registerCostPay(S022300010Dto.RegisterCostPayReqDto registerCostPayReqDto);
    /*비용지금 이력 등록*/
    ResponseEntity<?> registerCostPayHistory(S022300010Dto.RegisterCostPayReqDto registerCostPayReqDto);
    /*비용지금 진행상태 update */
    ResponseEntity<?> patchCostPayProgressStatus(int eventUsedId);

    /*excel download 조회*/
    ResponseEntity<?> excelCostPayTotalHead(S022300010Dto.ExcelParamsReqDto reqDto);
    ResponseEntity<?> excelCostPayTotalLine(S022300010Dto.ExcelParamsReqDto reqDto);
}
