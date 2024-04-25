package com.example.classconnect.model.dtos;

import com.example.classconnect.model.dtos.QuestionResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class QuestionListResponseDto {
    private List<QuestionResponse> Questions;
    private int quizId;
}
