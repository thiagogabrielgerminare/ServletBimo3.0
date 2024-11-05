package org.example.servletbimo.controller.alterar;

import jakarta.servlet.ServletException; // Importa a classe para exceções de servlet
import jakarta.servlet.annotation.WebServlet; // Importa a anotação para definir um servlet
import jakarta.servlet.http.HttpServlet; // Importa a classe base para servlets HTTP
import jakarta.servlet.http.HttpServletRequest; // Importa a classe para manipulação de requisições HTTP
import jakarta.servlet.http.HttpServletResponse; // Importa a classe para manipulação de respostas HTTP
import org.example.servletbimo.DAO.PlanoPagamentoDAO; // Importa a classe DAO para interações com a tabela de planos de pagamento
import org.example.servletbimo.models.PlanoPagamento; // Importa a classe de modelo para o plano de pagamento

import java.io.IOException; // Importa a classe de exceções de entrada/saída

// Define o servlet e a URL para acesso
@WebServlet(name = "alterarValorPlano", value = "/alterarValorPlano")
public class AlterarValorPlano extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém os parâmetros 'id' e 'valor' da requisição
        String idStr = request.getParameter("id");
        String valorStr = request.getParameter("valor");

        int idInt = 0;
        double valorDouble = 0.0;

        // Verifica se o ID não é nulo ou vazio
        if (idStr != null && !idStr.isEmpty()) {
            try {
                // Tenta converter o ID de String para inteiro
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trata o caso de formato inválido
                System.out.println("Erro: o parâmetro não é um número válido."); // Log de erro simples
            }
        }

        // Verifica se o valor não é nulo ou vazio
        if (valorStr != null && !valorStr.isEmpty()) {
            try {
                // Tenta converter o valor de String para double
                valorDouble = Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                // Trata o caso de formato inválido
                System.out.println("Erro: o parâmetro não é um número válido."); // Log de erro simples
            }
        }

        // Cria uma nova instância de PlanoPagamento com os dados recebidos
        PlanoPagamento planoPagamento = new PlanoPagamento(idInt, valorDouble);

        // Instancia o DAO para manipular os dados do plano de pagamento
        PlanoPagamentoDAO planoPagamentoDAO = new PlanoPagamentoDAO();

        // Chama o método para alterar o valor do plano de pagamento no banco de dados
        int sucesso = planoPagamentoDAO.alterarNomePlanoPagamento(planoPagamento);

        // Verifica se a alteração foi bem-sucedida
        if (sucesso > 0) {
            request.setAttribute("resultado", "Alteração realizada com sucesso!"); // Define atributo para sucesso
            // Redireciona para a página de alteração
            request.getRequestDispatcher("confirmacao.jsp").forward(request, response);
        } else {
            request.setAttribute("resultado", "Erro ao fazer a alteração!"); // Define atributo para erro
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }
}
