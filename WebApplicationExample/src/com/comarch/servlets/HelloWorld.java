package com.comarch.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Adam Kołodziejek
 * @since 09-07-2017
 */

//@WebServlet(name = "HelloWorld", urlPatterns = "/HelloWorld")
public class HelloWorld extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        // initialization
        message = "Servlet Hello World";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // add header to page body
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destroy() {
        // do nothing
    }
}
