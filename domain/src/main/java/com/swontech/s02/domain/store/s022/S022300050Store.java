package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.dto.s022.S022300050Dto;
import com.swontech.s02.domain.vo.s022.S022300050Vo;

public interface S022300050Store {
    // 행사등록
    int insertEvent(S022300050Vo.InsertEventVo vo);

    // 저장된 행사 검색(수정을 위한)
    S022300050Dto.RetrieveEventResponse retrieveEvent(String eventId);
}
