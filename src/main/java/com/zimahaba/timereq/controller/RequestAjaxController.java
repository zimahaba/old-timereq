package com.zimahaba.timereq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestAjaxController {

    @PostMapping("/api/period")
    public ResponseEntity<String> startPeriod(@RequestBody Ajax ajax) {
        if (ajax != null) {
            System.out.println("id="+ajax.getRequestId());
        } else {
            System.out.println("nulo");
        }
        return ResponseEntity.ok("success");
    }
}
