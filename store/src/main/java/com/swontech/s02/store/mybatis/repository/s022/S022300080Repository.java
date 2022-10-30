package com.swontech.s02.store.mybatis.repository.s022;

import com.swontech.s02.domain.dto.s022.S022300080Dto;
import com.swontech.s02.domain.store.s022.S022300080Store;
import com.swontech.s02.domain.vo.s022.S022300080Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S022300080Repository implements S022300080Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S022300080Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<S022300080Dto.RetrieveAttendList> selectEnterList(S022300080Vo.SelectEnterListVo selectEnterListVo) {
        return sqlSessionTemplate.selectList("S022300080.selectEnterList", selectEnterListVo);
    }

    @Override
    public int insertEnter(List<S022300080Vo.InsertEnterVo> insertEnterVo) {
        return sqlSessionTemplate.insert("S022300080.insertEnter", insertEnterVo);
    }

    @Override
    public int deleteEnter(List<S022300080Vo.DeleteEnterVo> deleteEnterVo) {
        return sqlSessionTemplate.delete("S022300080.deleteEnter", deleteEnterVo);
    }

    @Override
    public List<S022300080Dto.SelectEventLov> selectEventLov(int orgId) {
        return sqlSessionTemplate.selectList("S022300080.selectEventLov", orgId);
    }
}
