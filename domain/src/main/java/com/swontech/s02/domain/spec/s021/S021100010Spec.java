package com.swontech.s02.domain.spec.s021;

import com.swontech.s02.domain.dto.s021.S021100010Dto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface S021100010Spec {
    ResponseEntity<?> retrieveOrgList(String orgName, String memberName);
    ResponseEntity<?> deleteOrgList(List<Integer> orgIdList);
}
