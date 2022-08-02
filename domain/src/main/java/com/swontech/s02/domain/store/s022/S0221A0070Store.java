package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.dto.s022.S0221A0070Dto;
import com.swontech.s02.domain.vo.s022.S0221A0070Vo;

import java.util.List;

public interface S0221A0070Store {
    List<S0221A0070Dto.CostReqResponse> selectCostReqList(S0221A0070Vo.SelectCostReqVo selectCostReqVo);
}
