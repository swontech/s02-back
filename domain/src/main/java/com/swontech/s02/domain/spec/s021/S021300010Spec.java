package com.swontech.s02.domain.spec.s021;

import com.swontech.s02.domain.dto.S021.S021300010Dto;

import javax.validation.Valid;
import java.util.List;

public interface S021300010Spec {
    List<S021300010Dto.CodeList> retrieveCodeList(S021300010Dto.RetrieveWord body);

    void patchCodeStatus(S021300010Dto.PatchCodeStatus body, String dataEndFlag);
}
