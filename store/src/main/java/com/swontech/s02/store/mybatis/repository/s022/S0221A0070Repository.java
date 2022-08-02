package com.swontech.s02.store.mybatis.repository.s022;

import com.swontech.s02.domain.dto.s022.S0221A0070Dto;
import com.swontech.s02.domain.store.s022.S0221A0070Store;
import com.swontech.s02.domain.vo.s022.S0221A0070Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S0221A0070Repository implements S0221A0070Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S0221A0070Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<S0221A0070Dto.CostReqResponse> selectCostReqList(S0221A0070Vo.SelectCostReqVo selectCostReqVo) {
        return sqlSessionTemplate.selectList("S0221A0070.selectCostReqList", selectCostReqVo);
    }
}
