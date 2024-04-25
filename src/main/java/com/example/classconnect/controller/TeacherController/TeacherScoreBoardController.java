package com.example.classconnect.controller.TeacherController;
import com.example.classconnect.model.dtos.QuizIdDto;
import com.example.classconnect.model.dtos.ScoreResponse;
import com.example.classconnect.services.Serviceimpl;
import com.example.classconnect.utils.RequestResponseMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/teacher/classrooms/quizzes/score")
public class TeacherScoreBoardController extends HttpServlet {
    public Serviceimpl service;
    public RequestResponseMapper mapper;

    public TeacherScoreBoardController() {
        this.service = new Serviceimpl();
        this.mapper = new RequestResponseMapper();
    }

    @Override // return total score of the quiz
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
//        QuizIdDto quizId = (QuizIdDto) mapper.getRequestObject(resp,req, QuizIdDto.class);
        QuizIdDto quizId = new QuizIdDto();
        quizId.setQuizId(Integer.parseInt(req.getParameter("quizId")));
        List<ScoreResponse> list = service.getScoresOfStudentAttendedTheQuiz(quizId);
        resp.setContentType(MediaType.APPLICATION_JSON);
        out.print(mapper.setResponseObject(list));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
