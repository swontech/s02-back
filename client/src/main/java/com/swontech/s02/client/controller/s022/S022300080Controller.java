package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.dto.s022.S022300080Dto;
import com.swontech.s02.domain.spec.s022.S022300080Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/s022300080")
public class S022300080Controller {
    private final S022300080Spec s022300080Spec;
    public S022300080Controller(S022300080Spec s022300080Spec) {
        this.s022300080Spec = s022300080Spec;
    }

    @GetMapping("/attend-list")
    public ResponseEntity<?> retrieveAttendList(S022300080Dto.RetrieveAttendList reqDto) {
        return s022300080Spec.retrieveAttendList(reqDto);
    }

    @PostMapping("/register-attend")
    public ResponseEntity<?> registerAttend(@RequestBody List<S022300080Dto.RegisterAttend> reqDto) {
        return s022300080Spec.registerAttend(reqDto);
    }

    @PostMapping("/delete-attend")
    public ResponseEntity<?> deleteAttend(@RequestBody List<S022300080Dto.DeleteAttend> reqDto) {
        return s022300080Spec.deleteAttend(reqDto);
    }
}
