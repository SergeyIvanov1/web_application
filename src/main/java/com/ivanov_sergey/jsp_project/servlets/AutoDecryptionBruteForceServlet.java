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

@WebServlet("/auto_decryption_brute_force")
@MultipartConfig
public class AutoDecryptionBruteForceServlet extends HttpServlet {

    private CryptoService service = new CryptoServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("getForm", "auto_decryption_brute_force");
        req.setAttribute("nameAction", "Auto decryption brute force method");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/cryptanalyzer.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String encrypt = service.autoDecryptionBruteForce(req);

        req.setAttribute("encrypt", encrypt);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/cryptanalyzer.jsp");
        requestDispatcher.forward(req, resp);
    }
}
