package org.example.servletbimo.Servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.CategoriaProdutoDAO;
import org.example.servletbimo.DAO.CursoDAO;
import org.example.servletbimo.models.CategoriaProduto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import org.example.servletbimo.models.Curso;


import java.io.IOException;

@WebServlet( name = "cadastrarCurso", value = "/cadastrarCurso" )
public class CadastrarCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String numInscricaoStr = request.getParameter("num-inscricao");
        String valorStr = request.getParameter("valor");
        String statusStr = request.getParameter("status");
        String duracao = request.getParameter("duracao");
        String certificacao = request.getParameter("certificacao");
        String idCategoriaStr = request.getParameter("id-categoria");

        double valorDouble = 0.0;
        int idCategoriaInt = 0;
        int numInscricaoInt = 0;
        boolean statusBool = false;

        if (valorStr != null && !valorStr.isEmpty()) {
            try {
                valorDouble = Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        if (idCategoriaStr != null && !idCategoriaStr.isEmpty()) {
            try {
                idCategoriaInt = Integer.parseInt(idCategoriaStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        if (numInscricaoStr != null && !numInscricaoStr.isEmpty()) {
            try {
                numInscricaoInt = Integer.parseInt(numInscricaoStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        if (statusStr != null && !statusStr.isEmpty()) {
            statusBool = Boolean.parseBoolean(statusStr.trim());
        }

        Curso curso = new Curso(idCategoriaInt, nome, valorDouble, descricao, statusBool, numInscricaoInt, duracao, certificacao);

        CursoDAO cursoDAO = new CursoDAO();
        boolean sucesso = cursoDAO.inserirCurso(curso);

        if (sucesso) {
            request.setAttribute("resultado", "foi");
        } else {
            request.setAttribute("resultado", "erro ");
        }
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }
}

