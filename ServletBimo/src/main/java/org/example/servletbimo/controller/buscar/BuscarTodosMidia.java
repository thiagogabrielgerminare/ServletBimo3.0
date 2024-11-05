package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.MidiaDAO;
import org.example.servletbimo.models.Midia;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarIdMidia"
@WebServlet(name = "buscarTodosMidia", value = "/buscarTodosMidia")
public class BuscarTodosMidia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MidiaDAO midiaDAO = new MidiaDAO();

        // Realiza a busca pela mídia no banco de dados
        ResultSet rs = midiaDAO.buscarTodosMidia();
        StringBuilder lista = new StringBuilder();

        try {
            // Itera sobre o ResultSet para construir a resposta em HTML
            while (rs.next()) {
                lista.append("<div class=\"linha\">");
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("idProduto: ").append("</div>").append(rs.getInt("IDPRODUTO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cUrlFoto: ").append("</div>").append(rs.getString("CURLFOTO")).append("</p>")
                        .append("</div>").append("<br>"); // Quebra de linha na saída HTML
            }
        } catch (SQLException sqle) {
            // Armazena a mensagem de erro na requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        // Define o resultado da busca como atributo da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha a requisição para a página JSP que exibe o resultado
    }
}
