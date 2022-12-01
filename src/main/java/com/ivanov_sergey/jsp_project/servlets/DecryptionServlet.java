package com.ivanov_sergey.jsp_project.servlets;

import com.ivanov_sergey.cryptoanalyser.text_processing.Decoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/decryption_with_key")
@MultipartConfig
public class DecryptionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("getForm", "decryption_with_key");
        req.setAttribute("nameAction", "Decryption with key");
        req.setAttribute("needKey", "needKey");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/cryptanalyzer.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuilder stringBuilder = new StringBuilder();

        int key = Integer.parseInt(req.getParameter("key"));

        Decoder.decryptionWithKey(req, stringBuilder, key);

        String string = stringBuilder.toString();
        req.setAttribute("encrypt", string);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/cryptanalyzer.jsp");
        requestDispatcher.forward(req, resp);
    }
}
