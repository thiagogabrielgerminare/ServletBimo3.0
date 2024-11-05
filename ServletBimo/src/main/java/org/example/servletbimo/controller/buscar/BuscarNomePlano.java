package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;
import org.example.servletbimo.DAO.PlanoPagamentoDAO;
import org.example.servletbimo.models.Administrador;
import org.example.servletbimo.models.PlanoPagamento;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet( name = "buscarNomePlano", value = "/buscarNomePlano" )
public class BuscarNomePlano extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        PlanoPagamento planoPagamento = new PlanoPagamento(nome, 1);

        PlanoPagamentoDAO planoPagamentoDAO = new PlanoPagamentoDAO();

        ResultSet rs = planoPagamentoDAO.buscarPlanoPagamentoPorNome(planoPagamento);
        StringBuilder lista = new StringBuilder();

        try {
            if (rs == null){
                request.setAttribute("resultado", "Erro no banco de dados");
            } else {
                while (rs.next()) {
                    lista.append("<div class=\"linha\">");
                    lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("cDescricao: ").append("</div>").append(rs.getString("CDESCRICAO")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("fValor: ").append("</div>").append(rs.getDouble("FVALOR")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("transaction_made: ").append("</div>").append(rs.getBoolean("TRANSACTION_MADE")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("bIsUpdated: ").append("</div>").append(rs.getBoolean("BISUPDATED")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("bIsInactive: ").append("</div>").append(rs.getBoolean("BISINACTIVE")).append("</p>")

                            .append("</div>").append("<br>"); // Usando <br> para criar uma nova linha na saída HTML
                }
            }
        } catch (SQLException sqle) {
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
    }
}
