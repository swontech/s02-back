package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.dto.s021.S021100050Dto;
import com.swontech.s02.domain.vo.s021.S021100050Vo;

import java.util.List;

public interface S021100050Store {
    List<S021100050Dto.MemberListResponse> selectMemberList(S021100050Vo.SelectMemberListVo selectMemberListVo);
}
