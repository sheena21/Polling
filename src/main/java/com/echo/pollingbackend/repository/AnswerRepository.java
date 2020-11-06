package com.echo.pollingbackend.repository;

import com.echo.pollingbackend.entity.Answers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answers, Integer> {
}
