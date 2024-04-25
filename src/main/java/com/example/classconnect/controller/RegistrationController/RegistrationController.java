package com.example.classconnect.controller.RegistrationController;

import com.example.classconnect.model.dtos.Signup;
import com.example.classconnect.services.Serviceimpl;
import com.example.classconnect.utils.RequestResponseMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {
    public Serviceimpl service;
    public RequestResponseMapper mapper ;

    public RegistrationController() {
        this.service = new Serviceimpl();
        this.mapper = new RequestResponseMapper();
    }

    public void doPost(HttpServletRequest req , HttpServletResponse resp) throws IOException {

        PrintWriter out = resp.getWriter();
        Signup signup = (Signup) mapper.getRequestObject(resp ,req, Signup.class);
        resp.setContentType(MediaType.APPLICATION_JSON);
        if (service.createAccount(signup)) {
            out.print(mapper.setResponseObject(signup));
        }else{
            out.print(mapper.setResponseObject("Account already exist "));
        }
    }
}
