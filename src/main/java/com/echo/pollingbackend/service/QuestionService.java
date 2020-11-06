package com.echo.pollingbackend.service;

import com.echo.pollingbackend.entity.Questions;
import com.echo.pollingbackend.entity.User;
import com.echo.pollingbackend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;
    public Long getCurrentUser() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long currentUser = null;
        if (principal instanceof User) {
            currentUser = ((User) principal).getId();
        } else {
            currentUser = Long.valueOf(principal.toString()); }
        return currentUser;
    }

    public Questions saveQuestion(Questions questions) {
        questions.setUser(getCurrentUser());
        return questionRepository.save(questions);
    }

    public List<Questions> getAllQuestion() {
        return questionRepository.findAll();
    }

}
