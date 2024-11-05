package org.example.servletbimo.controller.buscar;

// Importações necessárias para a criação do servlet e para manipulação do banco de dados
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.PlanoPagamentoDAO;
import org.example.servletbimo.models.PlanoPagamento;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Declaração do servlet "buscarDescricaoPlano", mapeado para a URL "/buscarDescricaoPlano"
@WebServlet(name = "buscarDescricaoPlano", value = "/buscarDescricaoPlano")
public class BuscarDescricaoPlano extends HttpServlet {

    // Sobrescreve o método doPost para processar requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro "descricao" do pedido HTTP
        String descricao = request.getParameter("descricao");

        // Cria um objeto PlanoPagamento com a descrição fornecida e um valor numérico fixo (2)
        PlanoPagamento planoPagamento = new PlanoPagamento(descricao, 2);

        // Instancia o DAO PlanoPagamentoDAO para acesso ao banco de dados
        PlanoPagamentoDAO planoPagamentoDAO = new PlanoPagamentoDAO();

        // Realiza a consulta no banco de dados para buscar o plano de pagamento pela descrição
        ResultSet rs = planoPagamentoDAO.buscarPlanoPagamentoPorDescricao(planoPagamento);

        // StringBuilder para armazenar o HTML gerado a partir dos resultados
        StringBuilder lista = new StringBuilder();

        try {
            // Itera pelos resultados do ResultSet para construir o HTML com os dados
            while (rs.next()) {
                lista.append("<div class=\"linha\">");

                // Adiciona cada campo retornado no HTML, organizando em colunas e linhas
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cDescricao: ").append("</div>").append(rs.getString("CDESCRICAO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("fValor: ").append("</div>").append(rs.getDouble("FVALOR")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("transaction_made: ").append("</div>").append(rs.getBoolean("TRANSACTION_MADE")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("bIsUpdated: ").append("</div>").append(rs.getBoolean("BISUPDATED")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("bIsInactive: ").append("</div>").append(rs.getBoolean("BISINACTIVE")).append("</p>")
                        .append("</div>").append("<br>"); // Usa <br> para pular uma linha no HTML final
            }
        } catch (SQLException sqle) {
            // Em caso de erro de SQL, define a mensagem de erro como atributo da requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        // Define o HTML gerado como atributo "resultado" da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);

    }
}
