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
    public String selectMemberId(String hpNo) {
        return sqlSessionTemplate.selectOne("S0221A0030.selectMemberId", hpNo);
    }

    @Override
    public int updateMobileId(S0221A0030Vo.UpdateMobileIdVo updateMobileIdVo) {
        return sqlSessionTemplate.update("S0221A0030.updateMobileId", updateMobileIdVo);
    }

    @Override
    public int insertMemberInfo(S0221A0030Vo.InsertMemberInfoVo insertMemberInfoVo) {
        return sqlSessionTemplate.insert("S0221A0030.insertMemberInfo", insertMemberInfoVo);
    }

    @Override
    public S0221A0030Dto.SignUpResponse selectSignUpInfo(String hpNo) {
        return sqlSessionTemplate.selectOne("S0221A0030.selectSignupResponse", hpNo);
    }


}
