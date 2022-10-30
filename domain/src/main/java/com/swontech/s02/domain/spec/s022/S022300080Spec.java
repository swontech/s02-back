package com.swontech.s02.domain.spec.s022;

import com.swontech.s02.domain.dto.s022.S022300080Dto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface S022300080Spec {
    ResponseEntity<?> retrieveAttendList(S022300080Dto.RetrieveAttendList reqDto);

    ResponseEntity<?> registerAttend(List<S022300080Dto.RegisterAttend> reqDto);

    ResponseEntity<?> deleteAttend(List<S022300080Dto.DeleteAttend> reqDto);

    ResponseEntity<?> retrieveEventLov(int orgId);
}
