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

        lista.append("<style>");
        lista.append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
        lista.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        lista.append("th { background-color: #f2f2f2; font-weight: bold; }");
        lista.append("tr:nth-child(even) { background-color: #f9f9f9; }");
        lista.append("</style>");

// Início da tabela HTML
        lista.append("<table>");
        lista.append("<tr><th>sId</th><th>idProduto</th><th>cUrlFoto</th></tr>");

        try {
            // Itera sobre o ResultSet para criar uma linha de dados para cada registro
            if (rs == null || !rs.isBeforeFirst()) {
                request.setAttribute("resultado", "Nenhuma plano midia encontrada.");
                request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
                return;
            }
            while (rs.next()) {
                lista.append("<tr>");
                lista.append("<td>").append(rs.getInt("SID")).append("</td>");
                lista.append("<td>").append(rs.getInt("IDPRODUTO")).append("</td>");
                lista.append("<td>").append(rs.getString("CURLFOTO")).append("</td>");
                lista.append("</tr>");
            }
            lista.append("</table>"); // Fecha a tabela
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
