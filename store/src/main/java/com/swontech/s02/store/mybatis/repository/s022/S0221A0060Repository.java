package com.swontech.s02.store.mybatis.repository.s022;

import com.swontech.s02.domain.dto.s022.S0221A0060Dto;
import com.swontech.s02.domain.store.s022.S0221A0060Store;
import com.swontech.s02.domain.vo.s022.S0221A0060Vo;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class S0221A0060Repository implements S0221A0060Store {
    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public S0221A0060Dto.SelectEventCostHeader selectEventCostHeader(Integer eventUseId) {
        return sqlSessionTemplate.selectOne("S0221A0060.selectEventCostHeader", eventUseId);
    }

    @Override
    public List<S0221A0060Dto.SelectEventCostDetail> selectEventCostDetail(Integer eventUseId) {
        return sqlSessionTemplate.selectList("S0221A0060.selectEventCostDetail", eventUseId);
    }

    @Override
    public int updateEventCost(S0221A0060Vo.UpdateEventCostVo updateEventCostVo) {
        return sqlSessionTemplate.update("S0221A0060.updateEventCost", updateEventCostVo);
    }

    @Override
    public int insertEventCost(S0221A0060Vo.InsertEventCostVo insertEventCostVo) {
        return sqlSessionTemplate.insert("S0221A0060.insertEventCost", insertEventCostVo);
    }

    @Override
    public int deleteEventCost(int eventUseId) {
        return sqlSessionTemplate.update("S0221A0060.deleteEventCost", eventUseId);
    }

    @Override
    public String selectAvailableFlag(int eventUseId) {
        return sqlSessionTemplate.selectOne("S0221A0060.selectAvailableFlag", eventUseId);
    }

    @Override
    public S0221A0060Dto.PayInfo selectPayInfo(int eventId) {
        return sqlSessionTemplate.selectOne("S0221A0060.selectPayInfo", eventId);
    }
}
