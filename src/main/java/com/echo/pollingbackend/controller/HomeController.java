package com.echo.pollingbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @GetMapping("/page")
    public ResponseEntity<?> homePage() {
        return new ResponseEntity<>("Welcome to ECHO Test Environment", HttpStatus.OK);
    }

}
