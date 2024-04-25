package com.example.classconnect.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionResponse {
    private int questionId;
    private int serialNo;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
}
