package com.swontech.s02.store.mybatis.repository.s021;

/**
 *
 */

import com.swontech.s02.domain.dto.s021.S021300010Dto;
import com.swontech.s02.domain.store.s021.S021300010Store;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class S021300010Repository implements S021300010Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021300010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Map<String, Object>> retrieveCodeList(S021300010Dto.RetrieveWord param) {
        return sqlSessionTemplate.selectList("S021300010.selectCodeListVO", param);
    }

    @Override
    public void deleteCode(S021300010Dto.PatchCodeStatus param) {
        sqlSessionTemplate.update("S021300010.deleteCodeVO", param);
    }

    @Override
    public void restoreCode(S021300010Dto.PatchCodeStatus param) {
        sqlSessionTemplate.update("S021300010.restoreCodeVO", param);
    }
}
