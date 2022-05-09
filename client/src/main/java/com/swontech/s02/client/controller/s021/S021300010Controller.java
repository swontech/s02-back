package com.swontech.s02.client.controller.s021;

/**
 *
 * @param:
 * @return:
 */

import com.swontech.s02.domain.dto.s021.S021300010Dto;
import com.swontech.s02.domain.spec.s021.S021300010Spec;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/v1/s021300010")
@Api(tags = "코드관리화면(S021300010) API", description = "코드관리화면의 코드리스트 검색, 코드삭제, 코드복원 기능 API")
public class S021300010Controller {
    public final S021300010Spec s021300010Spec;
    public S021300010Controller(S021300010Spec s021300010Spec) {
        this.s021300010Spec = s021300010Spec;
    }

    @Operation(summary = "코드리스트 검색", description = "단체ID, 코드ID, 코드명을 통해 코드 리스트를 검색한다.")
    @PostMapping("/code-list")
    public ResponseEntity<List<S021300010Dto.CodeList>> retrieveCodeList(@RequestBody @Valid S021300010Dto.RetrieveWord body) {
        s021300010Spec.retrieveCodeList(body);
        return null;
    }

    @Operation(summary = "코드 END STAUS상태 변경", description = "단체ID, 코드ID를 통해 선택한 코드들의 DATA END 상태를 변경(삭제/복원)시킨다.")
    @PatchMapping("/code-status/{data-end-flag}")
    public void patchCodeStatus(@RequestBody @Valid S021300010Dto.PatchCodeStatus body, @PathVariable("data-end-flag") @Parameter(name = "삭제/복원 Flag", description = "삭제: D, 복원: R") String dataEndFlag) {
        s021300010Spec.patchCodeStatus(body, dataEndFlag);
    }
}
