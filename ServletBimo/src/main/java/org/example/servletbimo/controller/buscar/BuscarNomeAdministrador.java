package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;
import org.example.servletbimo.models.Administrador;

import java.io.IOException;
import java.sql.ResultSet;

@WebServlet( name = "buscarNomeAdm", value = "/buscarNomeAdm" )
public class BuscarNomeAdministrador extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        Administrador administrador = new Administrador(nome, 1);

        AdministradorDAO administradorDAO = new AdministradorDAO();
        ResultSet sucesso = administradorDAO.buscarAdministradorPorNome(administrador);


        request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
    }
}
