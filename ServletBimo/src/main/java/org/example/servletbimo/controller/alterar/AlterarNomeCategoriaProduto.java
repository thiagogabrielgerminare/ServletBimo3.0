package org.example.servletbimo.controller.alterar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.CategoriaCursoDAO;
import org.example.servletbimo.DAO.CategoriaProdutoDAO;
import org.example.servletbimo.models.CategoriaProduto;

import java.io.IOException;

@WebServlet( name = "alterarNomeCategoriaProduto", value = "/alterarNomeCategoriaProduto" )
public class AlterarNomeCategoriaProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nome = request.getParameter("nome");

        int idInt = 0;

        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        CategoriaProduto categoriaProduto = new CategoriaProduto(idInt, nome);

        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
        int sucesso = categoriaProdutoDAO.alterarNome(categoriaProduto);

        if (sucesso > 0){
            request.setAttribute("resultado", "foi");
        } else {
            request.setAttribute("resultado", "erro ");
        }
        request.getRequestDispatcher("alteracao.jsp").forward(request, response);
    }
}
