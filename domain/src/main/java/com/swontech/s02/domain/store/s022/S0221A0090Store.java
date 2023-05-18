package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.dto.s022.S0221A0090Dto;
import com.swontech.s02.domain.vo.s022.S0221A0090Vo;

import java.util.List;

public interface S0221A0090Store {
    List<S0221A0090Dto.CostPayList> selectCostPayList(S0221A0090Vo.CostPayListVo costPayListVo);
    S0221A0090Dto.AppPushUser selectAppPushUser(int eventUseId);
}
