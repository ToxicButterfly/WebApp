package org.example.servlets;

import org.example.Dao.DaoClass;
import org.example.entity.Class1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "GetServlet", value = "/get")
public class GetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("class");
        DaoClass dao = null;
        try {
            dao = new DaoClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        List<Class1> list = null;
        try {
            list = dao.getClass(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list", list);
        request.setAttribute("ClassName", id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
