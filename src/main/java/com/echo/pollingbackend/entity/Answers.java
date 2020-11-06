package com.echo.pollingbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ans", nullable = false)
    @Size(min = 10, max = 500, message = "Word limit 500")
    @NotBlank(message = "write answer..!")
    private String answer;

    @Transient
    @ManyToOne(fetch = FetchType.EAGER)
    private Questions que;

    @JoinColumn(name="que_id")
    private Long questions;

    private Long user;

    public Answers() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Long getQuestions() {
        return questions;
    }

    public void setQuestions(Long questions) {
        this.questions = questions;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
