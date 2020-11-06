package com.echo.pollingbackend.controller;

import com.echo.pollingbackend.entity.Questions;
import com.echo.pollingbackend.service.MapValidationErrorService;
import com.echo.pollingbackend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/question/")
public class QuestionController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;
    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<?> addQuestion(@Valid @RequestBody Questions questions) {
        Questions addedQuestion = questionService.saveQuestion(questions);
        return new ResponseEntity<>(addedQuestion, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getQuestions() {
        List<Questions> allQuestion = questionService.getAllQuestion();
        return new ResponseEntity<>(allQuestion, HttpStatus.OK);
    }


}
