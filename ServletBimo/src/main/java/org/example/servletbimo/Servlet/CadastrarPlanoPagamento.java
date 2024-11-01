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
        String nome = request.getParameter("nome-plano");
        String valorStr = request.getParameter("valor-plano");
        String descricao = request.getParameter("descricao-plano");

        // Verifique se os parâmetros não são nulos
        if (nome == null || valorStr == null || descricao == null) {
            request.setAttribute("resultado", "erro"); // Tratamento para erro
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            return; // Encerra o método para evitar execução adicional
        }

        double valor = 0; // Inicializa valor

        // Tente converter o valorStr para double
        try {
            valor = Double.parseDouble(valorStr);
        } catch (NumberFormatException e) {
            request.setAttribute("resultado", "erro"); // Tratamento para erro de formatação
            request.getRequestDispatcher("cadastro.jsp").forward(request, response);
            return; // Encerra o método
        }

        // Crie o objeto PlanoPagamento
        PlanoPagamento planoPagamento = new PlanoPagamento(descricao, nome, valor);

        // Insira o plano de pagamento no banco de dados
        PlanoPagamentoDAO planoPagamentoDAO = new PlanoPagamentoDAO();
        boolean sucesso = planoPagamentoDAO.inserirPlanoPagamento(planoPagamento);

        // Verifique se a inserção foi bem-sucedida
        if (sucesso) {
            request.setAttribute("resultado", "foi");
        } else {
            request.setAttribute("resultado", "erro");
        }

        // Redirecione para a página de cadastro
        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }
}