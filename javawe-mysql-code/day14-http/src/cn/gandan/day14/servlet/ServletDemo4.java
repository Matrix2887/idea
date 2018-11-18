package cn.gandan.day14.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet({"/d4","/dd4","/d44"})
//@WebServlet({"/d4/dd4","/d44"})
//@WebServlet({"/d4/dd4","/*"})
//@WebServlet({"/*"})
@WebServlet({"*.shengli"})
public class ServletDemo4 extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("444doGet...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("444doPost....");
    }
}
