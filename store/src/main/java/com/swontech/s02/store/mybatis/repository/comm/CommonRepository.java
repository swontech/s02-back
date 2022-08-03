package com.swontech.s02.store.mybatis.repository.comm;

import com.swontech.s02.domain.dto.comm.CommonDto;
import com.swontech.s02.domain.store.comm.CommonStore;
import com.swontech.s02.domain.vo.comm.CommonVo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommonRepository implements CommonStore {
    private final SqlSessionTemplate sqlSessionTemplate;
    public CommonRepository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<CommonDto.SelectCodeResponse> selectCodeList(CommonVo.SelectCodeVo selectCodeVo) {
        return sqlSessionTemplate.selectList("common.selectCodeList", selectCodeVo);
    }
}
