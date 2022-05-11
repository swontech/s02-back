package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.vo.s022.S0221A0020Vo;

public interface S0221A0020Store {
    int selectEventId(S0221A0020Vo.SelectEventId selectEventId);
    int selectMobileId(S0221A0020Vo.SelectMobileId selectMobileId);
    int insertEnter(S0221A0020Vo.InsertEnterVo insertEnterVo);
}
