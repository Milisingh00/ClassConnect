package com.example.classconnect.controller.TeacherController;

import com.example.classconnect.model.dtos.Classroom;
import com.example.classconnect.model.dtos.CLassCodeDto;
import com.example.classconnect.model.dtos.ClassRoomRequestDto;
import com.example.classconnect.model.dtos.ClassRoomCreationRequestDto;
import com.example.classconnect.services.Serviceimpl;
import com.example.classconnect.utils.RequestResponseMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.MediaType;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/teachers")
public class TeacherController extends HttpServlet {

    public Serviceimpl service;
    public RequestResponseMapper mapper;

    public TeacherController() {
        this.service = new Serviceimpl();
        this.mapper = new RequestResponseMapper();
    }

    @Override // return list of classroom for particular teacher
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
//        ClassRoomRequestDto classrooms = (ClassRoomRequestDto) mapper.getRequestObject(resp, req, ClassRoomRequestDto.class);
        ClassRoomRequestDto classrooms = new ClassRoomRequestDto();
        classrooms.setTeacher(req.getParameter("teacher"));
        List<Classroom> classRoomlist = service.findAllClass(classrooms.getTeacher());
        resp.setContentType(MediaType.APPLICATION_JSON);
        if (classRoomlist.size() > 0) {
            out.print(mapper.setResponseObject(classRoomlist));
        } else {
            out.print("Bad Request");
        }
    }

    @Override// add new class for a teacher
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        ClassRoomCreationRequestDto classroom = (ClassRoomCreationRequestDto) mapper.getRequestObject(resp, req, ClassRoomCreationRequestDto.class);
        String path = req.getPathInfo();
        Classroom NewClass = service.creatNewClass(classroom);
        resp.setContentType(MediaType.APPLICATION_JSON);
        out.print(mapper.setResponseObject(NewClass));
    }

    @Override// delete a classroom
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter out = resp.getWriter();
        CLassCodeDto  cLassCode = (CLassCodeDto) mapper.getRequestObject(resp,req,CLassCodeDto.class);
        resp.setContentType(MediaType.APPLICATION_JSON);
        if(service.deleteClassById(cLassCode)){
            out.print(mapper.setResponseObject("200"));
        }else{
            out.print(mapper.setResponseObject("500"));
        }

    }

}
