package com.example.classconnect.model.dtos;
import com.example.classconnect.model.dtos.Question;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionsDto {
    private int quizId;
    private List<Question>questions;
}
