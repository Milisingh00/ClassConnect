package com.example.classconnect.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuizCreationDto {
    private String classId;
    private String quizTitle;
    private String quizDescription;
}
