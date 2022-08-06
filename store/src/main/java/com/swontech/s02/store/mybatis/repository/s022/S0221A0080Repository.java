package com.swontech.s02.store.mybatis.repository.s022;

import com.swontech.s02.domain.dto.s022.S0221A0080Dto;
import com.swontech.s02.domain.store.s022.S0221A0080Store;
import com.swontech.s02.domain.vo.s022.S0221A0080Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S0221A0080Repository implements S0221A0080Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    S0221A0080Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }



    @Override
    public S0221A0080Dto.SelectCostReqCurrInfoDto selectCostReqCurrInfo(int eventUseId) {
        return sqlSessionTemplate.selectOne("S0221A0080.selectCostReqCurrInfo", eventUseId);
    }

    @Override
    public S0221A0080Dto.CostReqDetailHeader selectCostReqDetailHeader(int eventUseId) {
        return sqlSessionTemplate.selectOne("S0221A0080.selectCostReqDetailHeader", eventUseId);
    }

    @Override
    public List<S0221A0080Dto.CostReqDetailTail> selectCostReqDetailTail(int eventUseId) {
        return sqlSessionTemplate.selectList("S0221A0080.selectCostReqDetailTail", eventUseId);
    }

    @Override
    public int insertCostReqProcess(S0221A0080Vo.InsertCostReqProcessVo insertCostReqProcessVo) {
        return sqlSessionTemplate.insert("S0221A0080.insertCostReqProcess", insertCostReqProcessVo);
    }

    @Override
    public int updateCostReqProcess(S0221A0080Vo.UpdateCostReqProcessVo updateCostReqProcessVo) {
        return sqlSessionTemplate.update("S0221A0080.updateCostReqProcess", updateCostReqProcessVo);
    }
}
