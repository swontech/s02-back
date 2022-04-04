package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.store.s021.S021200010Store;
import com.swontech.s02.domain.vo.s021.S021200010Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class S021200010Repository implements S021200010Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021200010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public String selectMemberEmail(S021200010Vo.SelectMemberEmailVo selectMemberEmailVo) {
        return sqlSessionTemplate.selectOne("S021200010.selectMemberEmailVo", selectMemberEmailVo);
    }

    @Override
    public S021200010Vo.Member selectMember(String email) {
        return sqlSessionTemplate.selectOne("S021200010.selectMemberVo", email);
    }
}
