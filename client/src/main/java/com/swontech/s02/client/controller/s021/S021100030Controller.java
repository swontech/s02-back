package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.dto.s021.S021100030Dto;
import com.swontech.s02.domain.spec.s021.S021100030Spec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/s021100030")
public class S021100030Controller {
    private final S021100030Spec s021100030Spec;
    public S021100030Controller(S021100030Spec s021100030Spec) {
        this.s021100030Spec = s021100030Spec;
    }
    private final Logger logger = LoggerFactory.getLogger(S021100030Controller.class);

    @GetMapping("/retrieve-member-detail")
    public ResponseEntity<?> retrieveMemberDetail(@RequestParam("memberId") int memberId) {
        return s021100030Spec.selectMemberDetailInfo(memberId);
    }


    @GetMapping("/retrieve-member-list")
    public ResponseEntity<?> retrieveMemberList(S021100030Dto.RetriveMemberList reqDto) {
//        logger.info("회원리스트 =>"+ reqDto.getPagingReqDto());

        return s021100030Spec.selectMemberList(reqDto);
    }

    @PostMapping("/delete-member")
    public ResponseEntity<?> deleteMember(@RequestBody S021100030Dto.UpdateMemberTp reqDto) {
        return s021100030Spec.deleteMember(reqDto);
    }

    @PostMapping("/update-member-tp")
    public ResponseEntity<?> updateMemberTp(@RequestBody S021100030Dto.UpdateMemberTp reqDto) {
        return s021100030Spec.updateMember(reqDto);
    }

    @PostMapping("/upload-member")
    public ResponseEntity<?> registerMember(@RequestParam("orgId") int orgId
                                            , @RequestParam("loginId") int loginId
                                            , @RequestBody List<S021100030Dto.UploadMemberDto> uploadMemberDtoList)
    {
        logger.info("회원리스트 upload count =>" + uploadMemberDtoList.size() );
//        uploadMemberDtoList.forEach(
//                memberDto -> logger.info("부서(행사)회원 parse =>"+memberDto.getEventPayRoleCd())
//        );
        return s021100030Spec.insertUploadMember(orgId, loginId, uploadMemberDtoList) ;
    }

}
