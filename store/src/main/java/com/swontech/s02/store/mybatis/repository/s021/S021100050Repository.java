package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.dto.s021.S021100050Dto;
import com.swontech.s02.domain.store.s021.S021100050Store;
import com.swontech.s02.domain.vo.s021.S021100050Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S021100050Repository implements S021100050Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021100050Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    @Override
    public List<S021100050Dto.MemberListResponse> selectMemberList(S021100050Vo.SelectMemberListVo selectMemberListVo) {
        return sqlSessionTemplate.selectList("S021100050.selectMemberList", selectMemberListVo);
    }
}
