package com.swontech.s02.client.controller.s021;

import com.swontech.s02.domain.dto.s021.S021100030Dto;
import com.swontech.s02.domain.spec.s021.S021100030Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/v1/s021100030")
public class S021100030Controller {
    private final S021100030Spec s021100030Spec;
    public S021100030Controller(S021100030Spec s021100030Spec) {
        this.s021100030Spec = s021100030Spec;
    }

    @GetMapping("/retrieve-member-detail")
    public ResponseEntity<?> retrieveMemberDetail(@RequestParam("memberId") int memberId) {
        return s021100030Spec.selectMemberDetailInfo(memberId);
    }


    @GetMapping("/retrieve-member-list")
    public ResponseEntity<?> retrieveMemberList(S021100030Dto.RetriveMemberList reqDto) {
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

}
