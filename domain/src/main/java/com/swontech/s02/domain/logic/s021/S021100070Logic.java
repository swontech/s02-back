package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s021.S021100070Dto;
import com.swontech.s02.domain.spec.s021.S021100070Spec;
import com.swontech.s02.domain.store.s021.S021100070Store;
import com.swontech.s02.domain.vo.s021.S021100070Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class S021100070Logic implements S021100070Spec {
    private final CustomResponse response;
    private final S021100070Store s021100070Store;
    private final Logger logger = LoggerFactory.getLogger(S021100070Logic.class);
    public S021100070Logic(CustomResponse response, S021100070Store s021100070Store) {
        this.response = response;
        this.s021100070Store = s021100070Store;
    }

    @Override
    public ResponseEntity<?> retrieveDeptLevel(int orgId) {
        return response.success(s021100070Store.selectDeptLevel(orgId));
    }

    @Override
    public ResponseEntity<?> retrieveDeptInfo(int eventId) {
        return response.success(s021100070Store.selectDeptDetailInfo(eventId));
    }

    @Override
    public ResponseEntity<?> retrieveDeptPayInfo(int orgId, int eventId) {
        return response.success(
                s021100070Store.selectDeptDetailPayInfo(
                        S021100070Vo.ParamsVo
                                .builder()
                                .orgId(orgId)
                                .eventId(eventId)
                                .build()
                )
        );
    }

    /** kjy 부서(행사) 신규 등록(최상위 level)시 부서코드 발번 조회 */
    @Override
    public ResponseEntity<?> retrieveNewEventCode(int orgId) {
        return response.success(
                s021100070Store.selectNewEventCode(orgId)
        );
    }

    /** kjy 부서(행사) 신규 등록 */
    @Override
    public ResponseEntity<?> registerEvent(S021100070Dto.RegisterEventDto registerEventDto) {
        logger.info("[unitTest]부서(행사) 등록 registerEvent() 호출");

        S021100070Vo.TbEvent010Vo registerEventVo = this.setDataRegisterEventVo(registerEventDto);
        s021100070Store.insertEvent(registerEventVo);

        //신규등록시 자동발번된 시퀀스를 넘겨준다(for 회원 정보 insert)
        return response.success(registerEventVo.getEventId(), "부서(행사) 신규등록에 성공했습니다.", HttpStatus.OK);
    }

    /** kjy 부서(행사)단위 회원 등록 : 기존 부서(행사)이면 해당 부서의 회원정보 삭제 후 등록처리, 신규이면 insert */
    @Override
    public ResponseEntity<?> registerEventMember(int eventId, List<S021100070Dto.RegisterEventMemberDto> litRegEventMemberDto)
    {
        try {
            //list dto ->  vo 로 변환
    //        litRegEventMemberDto.stream().map(S021100070Vo.TbEvent020Vo).collect(Collectors.toList());

            // insert : 넘겨받은 회원정보수 만큼 vo로 변환하여 looping
            // ModelMapper
            for (S021100070Dto.RegisterEventMemberDto eventMemberDto : litRegEventMemberDto )
            {
                S021100070Vo.TbEvent020Vo eventMemberVo = S021100070Vo.TbEvent020Vo.builder()
                        .eventId(eventId)
                        .eventPayUserId(eventMemberDto.getEventPayUserId())
                        .eventPayLevel(eventMemberDto.getEventPayLevel())
                        .eventPayRoleCd(eventMemberDto.getEventPayRoleCd())
                        .build();

                s021100070Store.insertEventMember(eventMemberVo);
            }

            return response.success("해당 부서(행사) 회원 등록에 성공했습니다.");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public ResponseEntity<?> patchEvent(S021100070Dto.PatchEventDto patchEventDto) {
        S021100070Vo.TbEvent010Vo eventVo = getPatchEventVo(patchEventDto);
        s021100070Store.updateEvent(eventVo);

        return response.success( "부서(행사) 정보 수정에 성공했습니다.");
    }

    /** 부서(행사) 저장 : 화면에서 저장버튼 기능
     * 조건 : 기존 부서(행사)이면 해당 부서의 회원정보 삭제 후 등록처리, 신규이면 insert
     * @param eventId : 유=eventId, 무=0
     * @param registerEventDto : 화면에서 넘겨받은 부서(행사) 정보
     * @param litRegEventMemberDto : 해당 부서(행사)의 회원 리스트 정보
     * @return
     */
    @Override
    public ResponseEntity<?> saveEvent(int eventId,
                                       S021100070Dto.RegisterEventDto registerEventDto,
                                       List<S021100070Dto.RegisterEventMemberDto> litRegEventMemberDto)
    {
        try
        {
            int result = 0;
            boolean isSuccess = false;

            //1.기존 부서(행사)이면 (즉, eventId<>0) 해당 부서의 회원정보 삭제 후 등록처리
            if( eventId > 0 ) {
                logger.info("[S021100070] 부서(행사) 등록 : 기존 부서(행사) 정보 수정");
                // 1)기존 부서(행사) 정보 수정
                S021100070Dto.PatchEventDto patchEventDto = new S021100070Dto.PatchEventDto();
                //use : registerEventDto:getter, patchEventDto:setter
                BeanUtils.copyProperties(registerEventDto, patchEventDto);
                patchEventDto.setEventId(eventId);
                patchEventDto.setMemberId(registerEventDto.getEventRegId());

                logger.info("[S021100070] 부서(행사) 수정 enevtId=>"+ patchEventDto.getEventId() );
                logger.info("[S021100070] 부서(행사) 수정 enevtNm=>"+ patchEventDto.getEventNm() );
                logger.info("[S021100070] 부서(행사) 수정 getDefaultEventFlag=>"+ patchEventDto.getDefaultEventFlag());

                result = s021100070Store.updateEvent(getPatchEventVo(patchEventDto));

                logger.info("[S021100070] 부서(행사) 수정 결과 : "+ result);
                // 정상 수정이면
                if(result > 0) {
                    // 2)부서 회원정보 delete 후 insert
                    result = s021100070Store.deleteEventMember(eventId);
                    logger.info("[S021100070] 부서(행사) 회원 삭제 결과 : "+ result);
                    isSuccess = true;
                }

            } else {
                logger.info("[S021100070] 부서(행사) 등록 : 신규 부서(행사) 정보 등록");
            //2.부서(행사) 신규인 경우
                S021100070Vo.ParamsVo paramsVo = S021100070Vo.ParamsVo.builder()
                        .orgId(registerEventDto.getOrgId())
                        .eventId(eventId)
                        .build();
                //부서(행사) 신규 등록
                S021100070Vo.TbEvent010Vo registerEventVo = this.setDataRegisterEventVo(registerEventDto);
                //최상위 즉, level=0 이면 부서코드 발번조회하여 set
                if(registerEventVo.getEventLevel() == 0)
                {
                    String newEventCode = s021100070Store.selectNewEventCode(registerEventDto.getOrgId());
                    logger.info("[S021100070] 부서(행사) 신규등록 부서코드 발번조회 : " + newEventCode);

                    registerEventVo.setEventCode(newEventCode);
                }
                result = s021100070Store.insertEvent(registerEventVo);

                //정상등록이면 해당 부서의 회원정보 등록처리
                if(result > 0) {
                    //해당 신규 등록된 부서(행사)정보의 eventId get
                    eventId = registerEventVo.getEventId();

                    logger.info("[S021100070] 부서(행사) 신규등록 처리결과 eventId : " + eventId);

                    /* 하위부서(행사) 즉, level > 0 인 경우
                     * 등록시 선택한 상위 부서(행사)의 행사최하위여부 null update
                     * : 최하위부서만 행사최하위여부( EVENT_FINAL_FLAG)='Y' 임.
                     */
                    paramsVo = S021100070Vo.ParamsVo.builder()
                            .orgId(registerEventDto.getOrgId())
                            .eventId(registerEventDto.getHighEventId())
                            .build();
                    s021100070Store.updateEventFinalFlag(paramsVo);
                }
                isSuccess = true;
            }

            if(isSuccess) {
                // 회원정보 insert : 넘겨받은 회원정보수 만큼 vo로 변환하여 looping
                for (S021100070Dto.RegisterEventMemberDto eventMemberDto : litRegEventMemberDto) {
                    result = 0;
                    S021100070Vo.TbEvent020Vo eventMemberVo = S021100070Vo.TbEvent020Vo.builder()
                            .eventId(eventId)
                            .eventPayUserId(eventMemberDto.getEventPayUserId())
                            .eventPayLevel(eventMemberDto.getEventPayLevel())
                            .eventPayRoleCd(eventMemberDto.getEventPayRoleCd())
                            .memberId(eventMemberDto.getMemberId())
                            .build();
                    logger.info("[S021100070] 부서(행사) 회원등록 대상 MemberId: " + eventMemberVo.getMemberId());

                    result = s021100070Store.insertEventMember(eventMemberVo);

                    logger.info("[S021100070] 부서(행사) 회원등록 처리결과: " + result);
                }
            }

            //최종 회원등록까지 정상이면 success
            if(result > 0) {
                return response.success(eventId, "부서(행사) 정보 등록에 성공했습니다.", HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
//            throw e;
        }
        return response.fail("부서(행사) 저장에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /*행사최하위여부( EVENT_FINAL_FLAG) null update */
    @Override
    public ResponseEntity<?> patchEventFinalFlag(int orgId, int eventId) {
        s021100070Store.updateEventFinalFlag(S021100070Vo.ParamsVo.builder()
                .orgId(orgId).eventId(eventId)
                .build()
        );
        return response.success( "부서(행사) 정보[최하위여부] 수정에 성공했습니다.");
    }

    /* 기본사역 삭제 처리 update  */
    @Override
    public ResponseEntity<?> patchDefaultEventFlag(int orgId, int eventId) {
        s021100070Store.updateDefaultEventFlag(S021100070Vo.ParamsVo.builder()
                .orgId(orgId).eventId(eventId)
                .build()
        );
        return response.success( "부서(행사) 정보[기본사역] 수정에 성공했습니다.");
    }

    /** 화면에서 넘겨받은 부서(행사) 정보 항목을 등록대상 vo로 변환한다. */
    private S021100070Vo.TbEvent010Vo setDataRegisterEventVo(S021100070Dto.RegisterEventDto registerEventDto) {

        logger.info("[unitTest]부서(행사) 등록 setDataRegisterEventVo() 호출");

        return S021100070Vo.TbEvent010Vo.builder()
                .eventNm(registerEventDto.getEventNm())
                .eventCode(registerEventDto.getEventCode())
                .eventStartDate(registerEventDto.getEventStartDate())
                .eventEndDate(registerEventDto.getEventEndDate())
                .payFlag(registerEventDto.getPayFlag())
                .eventLoc(registerEventDto.getEventLoc())
                .eventHostId(registerEventDto.getEventHostId())
                .eventComment(registerEventDto.getEventComment())
                .eventStatus(registerEventDto.getEventStatus())
                .eventRegId(registerEventDto.getEventRegId())
                .eventBudgetAmount(registerEventDto.getEventBudgetAmount())
                .orgId(registerEventDto.getOrgId())
                .defaultEventFlag(registerEventDto.getDefaultEventFlag())
                .highEventId(registerEventDto.getHighEventId())
                .eventLevel(registerEventDto.getEventLevel())
                .eventFinalFlag(registerEventDto.getEventFinalFlag())
                .eventTp(registerEventDto.getEventTp())
                .eventPayDept(registerEventDto.getEventPayDept())
                .memberId(registerEventDto.getEventRegId())
                .build();
    }

    /** */
    private S021100070Vo.TbEvent010Vo getPatchEventVo(S021100070Dto.PatchEventDto eventDto) {

        return S021100070Vo.TbEvent010Vo.builder()
                .eventNm(eventDto.getEventNm())
                .eventCode(eventDto.getEventCode())
                .eventStartDate(eventDto.getEventStartDate())
                .eventEndDate(eventDto.getEventEndDate())
                .payFlag(eventDto.getPayFlag())
                .eventLoc(eventDto.getEventLoc())
                .eventHostId(eventDto.getEventHostId())
                .eventComment(eventDto.getEventComment())
                .eventStatus(eventDto.getEventStatus())
                .eventBudgetAmount(eventDto.getEventBudgetAmount())
                .defaultEventFlag(eventDto.getDefaultEventFlag())
                .memberId(eventDto.getMemberId())
                .eventId(eventDto.getEventId())
                .build();
    }

}
