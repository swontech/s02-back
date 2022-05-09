package com.swontech.s02.store.mybatis.repository.s022;

import com.swontech.s02.domain.store.s022.S0221A0020Store;
import com.swontech.s02.domain.vo.s022.S0221A0020Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class S0221A0020Repository implements S0221A0020Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S0221A0020Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertEnter(S0221A0020Vo.insertEnterVo insertEnterVo) {
        return sqlSessionTemplate.insert("S0221A0020.insertEnter", insertEnterVo);
    }
}
