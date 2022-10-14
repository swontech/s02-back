package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.dto.s021.S021100070Dto;
import com.swontech.s02.domain.store.s021.S021100070Store;
import com.swontech.s02.domain.vo.s021.S021100070Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class S021100070Repository implements S021100070Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S021100070Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    private final Logger logger = LoggerFactory.getLogger(S021100070Repository.class);

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

    @Override
    public String selectNewEventCode(int orgId) {
        return sqlSessionTemplate.selectOne("S021100070.selectNewEventCode", orgId);
    }

    /**2022.09.28 kjy
     * 부서(행사) 등록
     */
    @Override
    public int insertEvent(S021100070Vo.TbEvent010Vo TbEvent010Vo) {
        logger.info("S021100070Repository insertEvent 호출");
        logger.info("부서(행사) data =>"+ TbEvent010Vo.toString());
        return sqlSessionTemplate.insert("S021100070.insertEvent", TbEvent010Vo);
    }

    /**2022.09.28 kjy
     * 부서(행사)별 회원 등록
     */
    @Override
    public int insertEventMember(S021100070Vo.TbEvent020Vo TbEvent020Vo) {
        logger.info("S021100070Repository insertEventMember 호출");
        logger.info("부서(행사)회원 data =>"+ TbEvent020Vo.toString());
        return sqlSessionTemplate.insert("S021100070.insertEventMember", TbEvent020Vo);
    }

    @Override
    public int updateEvent(S021100070Vo.TbEvent010Vo TbEvent010Vo) {
        logger.info("S021100070Repository updateEvent 호출");
        logger.info("부서(행사) data =>"+ TbEvent010Vo.toString());
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

    @Override
    public int updateEventFinalFlag(S021100070Vo.ParamsVo paramsVo) {
        return sqlSessionTemplate.update("S021100070.updateEventFinalFlag", paramsVo);
    }

    @Override
    public int updateDefaultEventFlag(S021100070Vo.ParamsVo paramsVo) {
        return sqlSessionTemplate.update("S021100070.updateDefaultEventFlag", paramsVo);
    }

}
