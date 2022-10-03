package com.swontech.s02.client.controller.s022;

import com.swontech.s02.domain.dto.s022.S0221A0060Dto;
import com.swontech.s02.domain.spec.s022.S0221A0060Spec;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/v1/s0221a0060")
public class S0221A0060Controller {
    private final S0221A0060Spec s0221A0060Spec;
    public S0221A0060Controller(S0221A0060Spec s0221A0060Spec) {
        this.s0221A0060Spec = s0221A0060Spec;
    }

    @GetMapping("/event-cost")
    public ResponseEntity<?> retrieveEventCost(@RequestParam(name = "eventUseId")Integer eventUseId) {
        return s0221A0060Spec.selectEventCost(eventUseId);
    }

    @PostMapping("/register-event-cost")
    public ResponseEntity<?> registerEventCost(@RequestBody S0221A0060Dto.InsertEventCostDto reqDto) {
        return s0221A0060Spec.insertEventCost(reqDto);
    }

    @PostMapping("/patch-event-cost")
    public ResponseEntity<?> patchEventCost(@RequestBody S0221A0060Dto.UpdateEventCostDto reqDto) {
        return s0221A0060Spec.updateEventCost(reqDto);
    }

    @PostMapping("/delete-event-cost")
    public ResponseEntity<?> deleteEventCost(@RequestBody List<Integer> eventUseIdList) {
        return s0221A0060Spec.deleteEventCost(eventUseIdList);
    }
}
