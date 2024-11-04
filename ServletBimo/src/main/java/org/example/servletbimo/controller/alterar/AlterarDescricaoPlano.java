package org.example.servletbimo.controller.alterar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.PlanoPagamentoDAO;
import org.example.servletbimo.models.PlanoPagamento;

import java.io.IOException;

@WebServlet( name = "alterarDescricaoPlano", value = "/alterarDescricaoPlano" )
public class AlterarDescricaoPlano extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String descricao = request.getParameter("descricao");

        int idInt = 0;

        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        PlanoPagamento planoPagamento = new PlanoPagamento(idInt, descricao, 2);

        PlanoPagamentoDAO planoPagamentoDAO = new PlanoPagamentoDAO();
        int sucesso = planoPagamentoDAO.alterarNomePlanoPagamento(planoPagamento);

        if (sucesso > 0){
            request.setAttribute("resultado", "foi");
        } else {
            request.setAttribute("resultado", "erro ");
        }
        request.getRequestDispatcher("alteracao.jsp").forward(request, response);
    }
}
