package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.dto.s021.S021100080Dto;
import com.swontech.s02.domain.store.s021.S021100080Store;
import com.swontech.s02.domain.vo.s021.S021100080Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S021100080Repository implements S021100080Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021100080Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<S021100080Dto.SelectListResponse> selectList(S021100080Vo.SelectListVo selectListVo) {
        return sqlSessionTemplate.selectList("S021100080.selectList", selectListVo);
    }
}
