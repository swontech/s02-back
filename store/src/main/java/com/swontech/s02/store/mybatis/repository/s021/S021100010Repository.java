package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.store.s021.S021100010Store;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class S021100010Repository implements S021100010Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021100010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public void insertOrgListVo() {

    }

    @Override
    public void selectOrgListVo() {

    }

    @Override
    public void updateOrgListVo() {

    }

    @Override
    public void deleteOrgListVo() {

    }
}
