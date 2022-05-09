package com.swontech.s02.store.mybatis.repository.s022;

import com.swontech.s02.domain.dto.s022.S022300050Dto;
import com.swontech.s02.domain.store.s022.S022300050Store;
import com.swontech.s02.domain.vo.s022.S022300050Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class S022300050Repository implements S022300050Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S022300050Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public int insertEvent(S022300050Vo.InsertEventVo vo) {
        return sqlSessionTemplate.insert("S022300050.insertEvent", vo);
    }

    @Override
    public S022300050Dto.RetrieveEventResponse retrieveEvent(String eventId) {
        return sqlSessionTemplate.selectOne("S022300050.selectEvent", eventId);
    }
}
