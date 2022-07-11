package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.dto.s022.S0221A0060Dto;
import com.swontech.s02.domain.vo.s022.S0221A0060Vo;

public interface S0221A0060Store {
    /** 기존에 등록된 행사비용정보를 eventUseId로 조회한다. */
    S0221A0060Dto.SelectEventCostResponse selectEventCost(Integer eventUseId);
    /** 기존에 등록된 행사비용정보를 update한다. */
    int updateEventCost(S0221A0060Vo.UpdateEventCostVo updateEventCostVo);
    /** 신규행사비용 정보를 insert한다. */
    int insertEventCost(S0221A0060Vo.InsertEventCostVo insertEventCostVo);
    /** 기존에 등록된 행사정보를 삭제한다. */
    int deleteEventCost(int eventUseId);
}
