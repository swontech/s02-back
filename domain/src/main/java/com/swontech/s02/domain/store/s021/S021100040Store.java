package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.dto.s021.S021100040Dto;
import com.swontech.s02.domain.vo.s021.S021100040Vo;

import java.util.List;

public interface S021100040Store {
    int insertMember(S021100040Vo.InsertMemberVo insertMemberVo);
    int updateMemberInfo(S021100040Vo.UpdateMemberInfoVo updateMemberInfoVo);
    List<S021100040Dto.MemberOrgMultiFlagDto> selectCheckHpNo(S021100040Vo.MemberOrgMultiFlagVO MemberOrgMultiFlagVO);
}
