package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.store.s021.S021100020Store;
import com.swontech.s02.domain.vo.s021.S021100020Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class S021100020Repository implements S021100020Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021100020Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int registerOrg(S021100020Vo.InsertOrgVo insertOrgVo) {
        return sqlSessionTemplate.insert("S021100020.insertOrgVo", insertOrgVo);
    }

    @Override
    public int registerMember(S021100020Vo.InsertMemberVo insertMemberVo) {
        return sqlSessionTemplate.insert("S021100020.insertMemberVo", insertMemberVo);
    }


}
