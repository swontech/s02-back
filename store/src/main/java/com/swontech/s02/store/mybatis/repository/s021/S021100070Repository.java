package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.dto.s021.S021100070Dto;
import com.swontech.s02.domain.store.s021.S021100070Store;
import com.swontech.s02.domain.vo.s021.S021100070Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S021100070Repository implements S021100070Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021100070Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<S021100070Dto.DeptLevel> selectDeptLevel(int orgId) {
        return sqlSessionTemplate.selectList("S021100070.selectDeptLevel", orgId);
    }

    @Override
    public S021100070Dto.DeptDetailInfo selectDeptDetailInfo(int eventId) {
        return sqlSessionTemplate.selectOne("S021100070.selectDeptDetailInfo", eventId);
    }

    @Override
    public List<S021100070Dto.DeptDetailPayInfo> selectDeptDetailPayInfo(S021100070Vo.ParamsVo paramsVo) {
        return sqlSessionTemplate.selectList("S021100070.selectDeptDetailPayInfo", paramsVo);
    }

    /**2022.09.28 kjy
     * 부서(행사) 등록
     */
    @Override
    public int insertEvent(S021100070Vo.TbEvent010Vo TbEvent010Vo) {
        return sqlSessionTemplate.insert("S021100070.insertEvent", TbEvent010Vo);
    }

    /**2022.09.28 kjy
     * 부서(행사)별 회원 등록
     */
    @Override
    public int insertEventMember(S021100070Vo.TbEvent020Vo TbEvent020Vo) {
        return sqlSessionTemplate.insert("S021100070.insertEventMember", TbEvent020Vo);
    }

    @Override
    public int updateEvent(S021100070Vo.TbEvent010Vo TbEvent010Vo) {
        return sqlSessionTemplate.update("S021100070.updateEvent", TbEvent010Vo);
    }

    @Override
    public int deleteEvent(int eventId) {
        return sqlSessionTemplate.delete("S021100070.deleteEvent", eventId);
    }

    @Override
    public int deleteEventMember(int eventId) {
        return sqlSessionTemplate.delete("S021100070.deleteEventMember", eventId);
    }


}
