package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.dto.s021.S021100030Dto;
import com.swontech.s02.domain.vo.s021.S021100030Vo;

import java.util.List;

public interface S021100030Store {
    List<S021100030Dto.MemberListResponse> selectMemberList(S021100030Vo.SelectMemberListVo selectMemberListVo);
    int deleteMember(int memberId);
    int updateMemberTp(int memberId);
}
