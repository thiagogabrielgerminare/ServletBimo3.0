package org.example.servletbimo.controller.alterar;

import jakarta.servlet.ServletException; // Importa a classe para exceções de servlet
import jakarta.servlet.annotation.WebServlet; // Importa a anotação para definir um servlet
import jakarta.servlet.http.HttpServlet; // Importa a classe base para servlets HTTP
import jakarta.servlet.http.HttpServletRequest; // Importa a classe para manipulação de requisições HTTP
import jakarta.servlet.http.HttpServletResponse; // Importa a classe para manipulação de respostas HTTP
import org.example.servletbimo.dao.PlanoPagamentoDAO; // Importa a classe DAO para interações com o banco de dados
import org.example.servletbimo.models.PlanoPagamento; // Importa a classe de modelo do plano de pagamento

import java.io.IOException; // Importa a classe de exceções de entrada/saída

// Define o servlet e a URL para acesso
@WebServlet(name = "alterarDescricaoPlano", value = "/alterarDescricaoPlano")
public class AlterarDescricaoPlano extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém os parâmetros 'id' e 'descricao' da requisição
        String idStr = request.getParameter("id");
        String descricao = request.getParameter("descricao");

        int idInt = 0; // Inicializa a variável para armazenar o ID como inteiro

        // Verifica se o ID não é nulo ou vazio
        if (idStr != null && !idStr.isEmpty()) {
            try {
                // Tenta converter o ID de String para inteiro
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido."); // Log de erro simples
            }
        }

        // Cria uma nova instância de PlanoPagamento com os dados recebidos
        PlanoPagamento planoPagamento = new PlanoPagamento(idInt, descricao, 2);

        // Instancia o DAO para manipular os dados do plano de pagamento
        PlanoPagamentoDAO planoPagamentoDAO = new PlanoPagamentoDAO();

        // Chama o método para alterar o nome do plano de pagamento no banco de dados
        int sucesso = planoPagamentoDAO.alterarNomePlanoPagamento(planoPagamento);

        // Verifica se a alteração foi bem-sucedida
        if (sucesso > 0) {
            request.setAttribute("resultado", "Alteração realizada com sucesso!"); // Define atributo para sucesso
            // Redireciona para a página de alteração
            request.getRequestDispatcher("/BiMO_Site/index/confirmacao.jsp").forward(request, response);
        } else {
            request.setAttribute("resultado", "Erro ao fazer a alteração!"); // Define atributo para erro
            request.getRequestDispatcher("/BiMO_Site/index/erro.jsp").forward(request, response);
        }
    }
}
