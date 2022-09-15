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
    public int insertNewMobileMember(S0221A0030Vo.InsertNewMobileMemberVo insertNewMobileMemberVo) {
        return sqlSessionTemplate.insert("S0221A0030.insertNewMobileMember", insertNewMobileMemberVo);
    }

    @Override
    public int insertNewMobileEventMember(S0221A0030Vo.InsertNewMobileEventMemberVo insertNewMobileEventMemberVo) {
        return sqlSessionTemplate.insert("S0221A0030.insertNewMobileEventMember", insertNewMobileEventMemberVo);
    }

    @Override
    public int updateMobileId(S0221A0030Vo.UpdateMobileIdVo updateMobileIdVo) {
        return sqlSessionTemplate.update("S0221A0030.updateMobileId", updateMobileIdVo);
    }

    @Override
    public int updateMobileMember(S0221A0030Vo.UpdateMobileMemberVo updateMobileMemberVo) {
        return sqlSessionTemplate.update("S0221A0030.updateMobileMember", updateMobileMemberVo);
    }


    @Override
    public S0221A0030Dto.SignUpResponse selectSignUpInfo(String hpNo) {
        return sqlSessionTemplate.selectOne("S0221A0030.selectSignupResponse", hpNo);
    }
}
