package com.example.classconnect.controller.TeacherController;

import com.example.classconnect.model.dtos.Student;
import com.example.classconnect.model.dtos.CLassCodeDto;
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
import java.util.ArrayList;
import java.util.List;
@WebServlet("/teachers/classroom")
public class ClassroomController extends HttpServlet {
    public Serviceimpl service;
    public RequestResponseMapper mapper ;

    public ClassroomController() {
        this.service = new Serviceimpl();
        this.mapper = new RequestResponseMapper();
    }
    @Override// return list of all students in a class
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
//        CLassCodeDto classCode = (CLassCodeDto) mapper.getRequestObject(resp,req, CLassCodeDto.class);
        CLassCodeDto classCode = new CLassCodeDto();
        classCode.setClassCode(req.getParameter("classCode"));
        List<Student> list = service.getAllStudentsInClass(classCode);
        resp.setContentType(MediaType.APPLICATION_JSON);
        if(list.size()>0){
            out.print(mapper.setResponseObject(list));
        }else{
            out.print(mapper.setResponseObject(new ArrayList<String>()));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
