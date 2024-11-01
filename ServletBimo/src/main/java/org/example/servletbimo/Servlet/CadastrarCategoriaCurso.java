package org.example.servletbimo.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.CategoriaCursoDAO;
import org.example.servletbimo.models.CategoriaCurso;
import org.example.servletbimo.models.CategoriaCurso;

import java.io.IOException;

@WebServlet( name = "cadastrarCategoriaCurso", value = "/cadastrarCategoriaCurso" )
public class CadastrarCategoriaCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String nome = request.getParameter("nome-categoria-curso");

            CategoriaCurso categoriaCurso = new CategoriaCurso(nome);

            CategoriaCursoDAO categoriaCursoDAO = new CategoriaCursoDAO();
            boolean sucesso = categoriaCursoDAO.inserirCategoriaCurso(categoriaCurso);

            if (sucesso) {
                request.setAttribute("resultado", "foi");
            } else {
                request.setAttribute("resultado", "erro ");
            }
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }
}

