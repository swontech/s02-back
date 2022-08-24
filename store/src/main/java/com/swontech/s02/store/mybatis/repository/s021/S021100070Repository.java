package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.dto.s021.S021100070Dto;
import com.swontech.s02.domain.store.s021.S021100070Store;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S021100070Repository implements S021100070Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021100070Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<S021100070Dto.DeptLevel> selectDeptLevel(int orgId) {
        return sqlSessionTemplate.selectList("S021100070.selectDeptLevel", orgId);
    }

    @Override
    public S021100070Dto.DeptDetailInfo selectDeptDetailInfo(int eventId) {
        return sqlSessionTemplate.selectOne("S021100070.selectDeptDetailInfo", eventId);
    }

    @Override
    public List<S021100070Dto.DeptDetailPayInfo> selectDeptDetailPayInfo(int eventId) {
        return sqlSessionTemplate.selectList("S021100070.selectDeptDetailPayInfo", eventId);
    }
}
