package com.echo.pollingbackend.controller;

import com.echo.pollingbackend.entity.Answers;
import com.echo.pollingbackend.entity.Questions;
import com.echo.pollingbackend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/answer/")
public class AnswerController {
     @Autowired
    private AnswerService answerService;

     @PostMapping
    public ResponseEntity<?> addAnswer(@Valid @RequestBody Answers ans) {
         Answers added=answerService.saveAnswer(ans);
         return new ResponseEntity<>(added, HttpStatus.CREATED);
     }

     @GetMapping
    public ResponseEntity<?> getAnswer()
     {
         List<Answers> list=answerService.getAll();
         return new ResponseEntity<>(list,HttpStatus.OK);
     }



}
