package com.echo.pollingbackend.repository;

import com.echo.pollingbackend.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Questions,Integer> {
}
