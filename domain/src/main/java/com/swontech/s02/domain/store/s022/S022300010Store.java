/****************************************************
 * program : 비용진행현황 및 비용상세처리 (S022300010)
 * desc :
 * 1) 운영자, 회계 담당자가 비용요청 진행 전체 대상 List 조회
 * 2) 비용지급 처리 : 회계 담당자가 비용지급 처리 내용을 등록처리
 ****************************************************/
package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.dto.s022.S022300010Dto;
import com.swontech.s02.domain.vo.s022.S022300010Vo;

import java.util.List;

public interface S022300010Store {
    /*비용 요청 조회*/
    List<S022300010Dto.CostPayProTotList> selectCostPayProTotList(S022300010Vo.ParamsVo paramsVo);
    /*비용 요청 조회 상세*/
    S022300010Dto.CostPayProTotDetail selectCostPayProTotDetail(int eventUsedId);
    /*비용지금 이력 등록*/
    int insertCostPayHistory(S022300010Vo.RegisterCostPayReqVo registerCostPayReqVo);
    /*비용지금 진행상태 update */
    int updateCostPayProgressStatus(int eventUsedId);
}
