package com.ivanov_sergey.module_project.servlets;

import com.ivanov_sergey.module_project.entity.Answer;
import com.ivanov_sergey.module_project.entity.Question;
import com.ivanov_sergey.module_project.entity.Visitor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/remove_attribute")
public class RemoveAttributeSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        RequestDispatcher requestDispatcher;

        session.removeAttribute("visitor");

        requestDispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/module_project_view/hello_page.jsp");
        requestDispatcher.forward(req, resp);
    }
}
