package com.example.classconnect.model.dtos;

import com.example.classconnect.model.dtos.QuizSubmitreq;
import lombok.Getter;
import lombok.Setter;
import java.util.*;
@Getter
@Setter
public class QuizSubmitDto {
    private int quizId;
    private String userId;
    private String classId;
    List <QuizSubmitreq> response;
}
