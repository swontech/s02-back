package com.swontech.s02.store.mybatis.repository.s022;

import com.swontech.s02.domain.dto.s022.S0221A0090Dto;
import com.swontech.s02.domain.store.s022.S0221A0090Store;
import com.swontech.s02.domain.vo.s022.S0221A0090Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S0221A0090Repository implements S0221A0090Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S0221A0090Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<S0221A0090Dto.CostPayList> selectCostPayList(S0221A0090Vo.CostPayListVo costPayListVo) {
        return sqlSessionTemplate.selectList("S0221A0090.costPayList", costPayListVo);
    }
}
