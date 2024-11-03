package org.example.servletbimo.Servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.CategoriaProdutoDAO;
import org.example.servletbimo.models.CategoriaProduto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;


import java.io.IOException;

@WebServlet( name = "cadastrarCategoriaProduto", value = "/cadastrarCategoriaProduto" )
public class CadastrarCategoriaProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        CategoriaProduto categoriaCurso = new CategoriaProduto(nome);

        CategoriaProdutoDAO categoriaCursoDAO = new CategoriaProdutoDAO();
        boolean sucesso = categoriaCursoDAO.inserirCategoriaProduto(categoriaCurso);

        if (sucesso) {
            request.setAttribute("resultado", "foi");
        } else {
            request.setAttribute("resultado", "erro ");
        }
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }
}

