package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.dto.s021.S021100070Dto;
import com.swontech.s02.domain.vo.s021.S021100070Vo;

import java.util.List;

public interface S021100070Store {
    List<S021100070Dto.DeptLevel> selectDeptLevel(int orgId);
    S021100070Dto.DeptDetailInfo selectDeptDetailInfo(int eventId);
    List<S021100070Dto.DeptDetailPayInfo> selectDeptDetailPayInfo(S021100070Vo.ParamsVo paramsVo);

    /** kjy 부서(행사) 신규 등록(최상위)인 경우 신규생성 발번된 부서코드 조회 */
    String selectNewEventCode(int orgId);

    /** kjy 부서(행사) 신규 등록 */
    int insertEvent(S021100070Vo.TbEvent010Vo TbEvent010Vo);

    /** kjy 부서(행사)별 회원 등록 */
    int insertEventMember(S021100070Vo.TbEvent020Vo TbEvent020Vo);

    /**kjy 부서(행사) 수정 : 수정구분(updateTp)에 따라 update 처리
     * @param TbEvent010Vo
     * 1.INFO : 부서(행사) 정보 수정
     * 2.DEFAULT_EVENT : 기본사역 삭제 처리, DEFAULT_EVENT_FLAG=NULL
     * 3.FINAL_FLAG: 행사최하위여부 삭제 처리, EVENT_FINAL_FLAG=NULL
     * @return int
     */
    int updateEvent(S021100070Vo.TbEvent010Vo TbEvent010Vo);

    /**kjy 부서(행사) 정보 삭제
     * tb_s020_event010
     * @param eventId :
     * @return int
     */
    int deleteEvent(S021100070Vo.DeleteEventVo deleteEventVo);

    /**kjy 부서(행사)의 회원정보 삭제
     * tb_s020_event020
     * @param eventId :
     * @return int
     */
    int deleteEventMember(int eventId);

    int updateEventFinalFlag(S021100070Vo.ParamsVo paramsVo);

    int updateDefaultEventFlag(S021100070Vo.ParamsVo paramsVo);

    /* 해당 eventId 에 동일 level 의 사역정보 유무 조회 */
    int selectSameLevel(int eventId);
    /* 해당 eventId 의 상위 eventId 가 부서(D) 유무 조회 */
    int selectNoneSameLevelDept(int eventId);
}
