package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.dto.s022.S0221A0080Dto;
import com.swontech.s02.domain.vo.s022.S0221A0080Vo;

import java.util.List;
import java.util.Map;

public interface S0221A0080Store {
    List<S0221A0080Dto.RetrieveCostReqDetailResponse> selectCostReqDetail(int eventUseId);
    Map<String, Object> selectCostReqInfo(int eventUseId);
    int insertCostReqProcess(S0221A0080Vo.InsertCostReqProcessVo insertCostReqProcessVo);
    int updateCostReqProcess(S0221A0080Vo.UpdateCostReqProcessVo updateCostReqProcessVo);
}
