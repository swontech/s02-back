package com.swontech.s02.store.mybatis.repository.s022;

import com.swontech.s02.domain.dto.s022.S0221A0030Dto;
import com.swontech.s02.domain.store.s022.S0221A0030Store;
import com.swontech.s02.domain.vo.s022.S0221A0030Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class S0221A0030Repository implements S0221A0030Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S0221A0030Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public S0221A0030Dto.MobileMemberExistFlag selectMemberExistFlag(S0221A0030Vo.SelectMemberExistFlagVo selectMemberExistFlagVo) {
        return sqlSessionTemplate.selectOne("S0221A0030.selectMemberExistFlag", selectMemberExistFlagVo);
    }

    @Override
    public int insertMobileMember(S0221A0030Vo.InsertMobileMemberVo insertMobileMemberVo) {
        return sqlSessionTemplate.insert("S0221A0030.insertMobileMember", insertMobileMemberVo);
    }

    @Override
    public int insertMobileMemberEvent(S0221A0030Vo.InsertMobileMemberEventVo insertMobileMemberEventMemberVo) {
        return sqlSessionTemplate.insert("S0221A0030.insertMobileMemberEvent", insertMobileMemberEventMemberVo);
    }

    @Override
    public int updateMobileMember(S0221A0030Vo.UpdateMobileMemberVo updateMobileMemberVo) {
        return sqlSessionTemplate.update("S0221A0030.updateMobileMember", updateMobileMemberVo);
    }

    @Override
    public int updateMobileId(S0221A0030Vo.UpdateMobileIdVo updateMobileIdVo) {
        return sqlSessionTemplate.update("S0221A0030.updateMobileId", updateMobileIdVo);
    }


}
