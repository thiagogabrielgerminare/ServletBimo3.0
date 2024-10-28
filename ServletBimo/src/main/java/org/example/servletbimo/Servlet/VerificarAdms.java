package org.example.servletbimo.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;

import java.io.IOException;

@WebServlet ("/login")
public class VerificarAdms extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        AdministradorDAO administradorDAO = new AdministradorDAO();
        if (administradorDAO.BuscarAdministrador(email, senha)) {
            response.sendRedirect(request.getContextPath() + "/admin.jsp");
        }else{
            request.setAttribute("erroLogin", "Email ou senha incorretos");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}
