package org.example.servletbimo.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.PlanoPagamentoDAO;
import org.example.servletbimo.models.PlanoPagamento;

import java.io.IOException;

@WebServlet(name = "cadastrarPlano", value = "/cadastrarPlano")
public class CadastrarPlanoPagamento extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PlanoPagamentoDAO pgDAO = new PlanoPagamentoDAO();

        String nome = request.getParameter("nome");
        String valorStr = request.getParameter("valor");
        String descricao = request.getParameter("descricao");

        double valorDouble = 0.0;

        if (valorStr != null && !valorStr.isEmpty()) {
            try {
                valorDouble = Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        PlanoPagamento planoPagamento = new PlanoPagamento(descricao, nome, valorDouble);

        boolean success = pgDAO.inserirPlanoPagamento(planoPagamento);

        if (success){
            request.setAttribute("resultado", "foi");
        }else {
            request.setAttribute("resultado", "não foi");
        }

        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }
}