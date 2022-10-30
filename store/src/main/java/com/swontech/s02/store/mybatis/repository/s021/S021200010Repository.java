package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.dto.s021.S021200010Dto;
import com.swontech.s02.domain.store.s021.S021200010Store;
import com.swontech.s02.domain.vo.s021.S021200010Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class S021200010Repository implements S021200010Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021200010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public S021200010Dto.MemberInfoDto selectMemberInfo(S021200010Vo.SelectMemberEmailVo selectMemberEmailVo) {
        return sqlSessionTemplate.selectOne("S021200010.selectMemberInfo", selectMemberEmailVo);
    }

    @Override
    public S021200010Vo.Member selectMember(String email) {
        return sqlSessionTemplate.selectOne("S021200010.selectMember", email);
    }

    @Override
    public String selectEmail(S021200010Vo.SelectEmailVo selectEmailVo) {
        return sqlSessionTemplate.selectOne("S021200010.selectEmail", selectEmailVo);
    }

    @Override
    public int updatePwd(S021200010Vo.UpdatePwdVo updatePwdVo) {
        return sqlSessionTemplate.update("S021200010.updatePwd", updatePwdVo);
    }
}
