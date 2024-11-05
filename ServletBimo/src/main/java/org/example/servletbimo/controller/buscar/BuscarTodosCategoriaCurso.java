package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.CategoriaCursoDAO;
import org.example.servletbimo.models.CategoriaCurso;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarNomeCategoriaCurso"
@WebServlet(name = "buscarTodosCategoriaCurso", value = "/buscarTodosCategoriaCurso")
public class BuscarTodosCategoriaCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Cria uma instância do DAO para acessar dados da categoria de curso
        CategoriaCursoDAO categoriaCursoDAO = new CategoriaCursoDAO();

        // Busca a categoria de curso pelo nome
        ResultSet rs = categoriaCursoDAO.buscarTodosCategoriaCurso();
        StringBuilder lista = new StringBuilder();

        // Estilo CSS para a tabela
        lista.append("<style>");
        lista.append("table { width: 100%; border-collapse: collapse; }");
        lista.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        lista.append("th { background-color: #f2f2f2; font-weight: bold; }");
        lista.append("tr:nth-child(even) { background-color: #f9f9f9; }");
        lista.append("</style>");

// Início da tabela HTML
        lista.append("<table>");
        lista.append("<thead><tr>");
        lista.append("<th>sId</th>");
        lista.append("<th>cNome</th>");
        lista.append("<th>transaction_made</th>");
        lista.append("<th>bIsUpdated</th>");
        lista.append("<th>bIsInactive</th>");
        lista.append("</tr></thead>");
        lista.append("<tbody>");

        try {
            // Itera sobre os resultados retornados e cria uma linha para cada registro
            if (rs == null || !rs.isBeforeFirst()) {
                request.setAttribute("resultado", "Nenhuma categoria de curso encontrada.");
                request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
                return;
            }
            while (rs.next()) {
                lista.append("<tr>");
                lista.append("<td>").append(rs.getInt("SID")).append("</td>");
                lista.append("<td>").append(rs.getString("CNOME")).append("</td>");
                lista.append("<td>").append(rs.getBoolean("TRANSACTION_MADE")).append("</td>");
                lista.append("<td>").append(rs.getBoolean("BISUPDATED")).append("</td>");
                lista.append("<td>").append(rs.getBoolean("BISINACTIVE")).append("</td>");
                lista.append("</tr>");
            }
        } catch (SQLException sqle) {
            // Armazena a mensagem de erro na requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

// Final da tabela HTML
        lista.append("</tbody></table>");


        // Define o resultado da busca como atributo da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha a requisição para a página JSP que exibe o resultado
    }
}
