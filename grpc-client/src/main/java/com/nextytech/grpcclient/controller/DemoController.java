package com.nextytech.grpcclient.controller;

import com.nextytech.grpcclient.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@Controller
public class DemoController {

    @Autowired
    DemoService demoService;

    @GetMapping("/greeting/{name}")
    public ResponseEntity<Object> greeting(@PathVariable String name) {
        HashMap<String, String> response = new HashMap<>();
        response.put("greeting", demoService.receivegreeting(name));
        return ResponseEntity.ok(response);
    }
}
