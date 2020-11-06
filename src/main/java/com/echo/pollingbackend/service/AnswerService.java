package com.echo.pollingbackend.service;

import com.echo.pollingbackend.entity.Answers;
import com.echo.pollingbackend.entity.User;
import com.echo.pollingbackend.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public Long getCurrentUser() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long currentUser = null;
        if (principal instanceof User) {
            currentUser = ((User) principal).getId();
        } else {
            currentUser = Long.valueOf(principal.toString()); }
        return currentUser;
    }


    public Answers saveAnswer(Answers ans) {
        ans.setUser(getCurrentUser());
        return answerRepository.save(ans);

    }

    public List<Answers> getAll() {
       return answerRepository.findAll();
    }
}
