package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.dto.s021.S021100040Dto;
import com.swontech.s02.domain.store.s021.S021100040Store;
import com.swontech.s02.domain.vo.s021.S021100040Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S021100040Repository implements S021100040Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021100040Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    @Override
    public int insertMember(S021100040Vo.InsertMemberVo insertMemberVo) {
        return sqlSessionTemplate.insert("S021100040.insertMember", insertMemberVo);
    }

    @Override
    public int updateMemberInfo(S021100040Vo.UpdateMemberInfoVo updateMemberInfoVo) {
        return sqlSessionTemplate.update("S021100040.updateMemberInfo", updateMemberInfoVo);
    }

    @Override
    public List<S021100040Dto.MemberOrgMultiFlagDto> selectCheckHpNo(S021100040Vo.MemberOrgMultiFlagVO MemberOrgMultiFlagVO) {
        return sqlSessionTemplate.selectList("S021100040.MemberOrgMultiFlag", MemberOrgMultiFlagVO);
    }
}
