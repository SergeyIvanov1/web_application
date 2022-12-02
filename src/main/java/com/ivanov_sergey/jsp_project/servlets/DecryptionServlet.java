package com.ivanov_sergey.jsp_project.servlets;

import com.ivanov_sergey.cryptoanalyser.text_processing.Decoder;
import com.ivanov_sergey.jsp_project.service.CryptoService;
import com.ivanov_sergey.jsp_project.service.CryptoServiceImpl;

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

    CryptoService service = new CryptoServiceImpl();

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

        String string = service.decryptionWithKey(req);

        req.setAttribute("encrypt", string);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/cryptanalyzer.jsp");
        requestDispatcher.forward(req, resp);
    }
}
