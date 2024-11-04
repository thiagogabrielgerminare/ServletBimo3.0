package org.example.servletbimo.controller.alterar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.CategoriaCursoDAO;
import org.example.servletbimo.models.CategoriaCurso;

import java.io.IOException;

@WebServlet( name = "alterarNomeCategoriaCurso", value = "/alterarNomeCategoriaCurso" )
public class AlterarNomeCategoriaCurso extends HttpServlet {
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

        CategoriaCurso categoriaCurso = new CategoriaCurso(idInt, nome);

        CategoriaCursoDAO categoriaCursoDAO = new CategoriaCursoDAO();
        int sucesso = categoriaCursoDAO.alterarNome(categoriaCurso);

        if (sucesso > 0){
            request.setAttribute("resultado", "foi");
        } else {
            request.setAttribute("resultado", "erro ");
        }
        request.getRequestDispatcher("alteracao.jsp").forward(request, response);
    }
}
