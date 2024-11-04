package org.example.servletbimo.controller.remover;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.CategoriaProdutoDAO;
import org.example.servletbimo.models.CategoriaCurso;
import org.example.servletbimo.models.CategoriaProduto;

import java.io.IOException;

@WebServlet( name = "removerCategoriaProduto", value = "/removerCategoriaProduto" )
public class RemoverCategoriaProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");

        int idInt = 0;

        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }
        CategoriaProduto categoriaProduto = new CategoriaProduto(idInt);

        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
        int sucesso = categoriaProdutoDAO.removerCategoriaProduto(categoriaProduto);

        if (sucesso > 0){
            request.setAttribute("resultado", "foi");
        } else {
            request.setAttribute("resultado", "erro ");
        }
        request.getRequestDispatcher("remocao.jsp").forward(request, response);
    }
}
