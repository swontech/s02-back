package com.swontech.s02.store.mybatis.repository.s022;

import com.swontech.s02.domain.dto.s022.S0221A2000Dto;
import com.swontech.s02.domain.store.s022.S0221A2000Store;
import com.swontech.s02.domain.vo.s022.S0221A2000Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S0221A2000Repository implements S0221A2000Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S0221A2000Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<S0221A2000Dto.EventListResponse> selectEventList(S0221A2000Vo.SelectEventListVo selectEventListVo) {
        return sqlSessionTemplate.selectList("S0221A2000.selectEventList", selectEventListVo);
    }
}
