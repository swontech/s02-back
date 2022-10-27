package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.dto.s021.S021100030Dto;
import com.swontech.s02.domain.store.s021.S021100030Store;
import com.swontech.s02.domain.vo.s021.S021100030Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S021100030Repository implements S021100030Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021100030Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<S021100030Dto.MemberListResponse> selectMemberList(S021100030Vo.SelectMemberListVo selectMemberListVo) {
        return sqlSessionTemplate.selectList("S021100030.selectMemberList", selectMemberListVo);
    }

    @Override
    public S021100030Dto.MemberDetailInfo selectMemberDetailInfo(int memberId) {
        return sqlSessionTemplate.selectOne("S021100030.selectMemberDetailInfo", memberId);
    }

    @Override
    public int deleteMember(S021100030Vo.UpdateMemberTp updateMemberTpVo) {
        return sqlSessionTemplate.update("S021100030.deleteMember", updateMemberTpVo);
    }

    @Override
    public int updateMemberTp(S021100030Vo.UpdateMemberTp updateMemberTpVo) {
        return sqlSessionTemplate.update("S021100030.updateMemberTp", updateMemberTpVo);
    }
}
