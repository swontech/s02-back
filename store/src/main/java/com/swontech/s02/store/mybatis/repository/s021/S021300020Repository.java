package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.store.s021.S021300020Store;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class S021300020Repository implements S021300020Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021300020Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
