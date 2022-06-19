package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.dto.s021.S021100010Dto;
import com.swontech.s02.domain.store.s021.S021100010Store;
import com.swontech.s02.domain.vo.s021.S021100010Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S021100010Repository implements S021100010Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021100010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<S021100010Dto.OrgListResponse> selectOrgList(S021100010Vo.SelectOrgListVo selectOrgListVo) {
        return sqlSessionTemplate.selectList("S021100010.selectOrgList", selectOrgListVo);
    }

    @Override
    public int updateOrgStatus(int orgId) {
        return sqlSessionTemplate.update("S021100010.updateOrgStatus", orgId);
    }
}
