package com.example.classconnect.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizResponseToStudent {
    private int quizId;
    private String title ;
    private String descriptions;
}