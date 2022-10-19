package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.dto.s021.S021100020Dto;
import com.swontech.s02.domain.store.s021.S021100020Store;
import com.swontech.s02.domain.vo.s021.S021100020Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class S021100020Repository implements S021100020Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021100020Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public String selectMemberEmail(String email) {
        return sqlSessionTemplate.selectOne("S021100020.selectMemberEmail", email);
    }

    @Override
    public String selectOrgName(String orgName) {
        return sqlSessionTemplate.selectOne("S021100020.selectOrgName", orgName);
    }

    @Override
    public int insertOrg(S021100020Vo.InsertOrgVo insertOrgVo) {
        return sqlSessionTemplate.insert("S021100020.insertOrg", insertOrgVo);
    }

    @Override
    public int insertMember(S021100020Vo.InsertMemberVo insertMemberVo) {
        return sqlSessionTemplate.insert("S021100020.insertMember", insertMemberVo);
    }

    @Override
    public S021100020Dto.OrgDetailInfo selectOrg(int orgId) {
        return sqlSessionTemplate.selectOne("S021100020.selectOrg", orgId);
    }

    @Override
    public int updateOrg(S021100020Vo.UpdateOrgVo updateOrgVo) {
        return sqlSessionTemplate.update("S021100020.updateOrg", updateOrgVo);
    }


}
