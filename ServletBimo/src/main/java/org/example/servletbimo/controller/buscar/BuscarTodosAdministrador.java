package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarNomeAdm"
@WebServlet(name = "buscarTodosAdm", value = "/buscarTodosAdm")
public class BuscarTodosAdministrador extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Cria uma instância do DAO para acessar dados do administrador
        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Busca o administrador pelo nome
        ResultSet rs = administradorDAO.buscarTodosAdministradores();
        StringBuilder lista = new StringBuilder();
        lista.append("<style>");
        lista.append("table { width: 100%; border-collapse: collapse; }");
        lista.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
        lista.append("th { background-color: #f2f2f2; font-weight: bold; }");
        lista.append("tr:nth-child(even) { background-color: #f9f9f9; }");
        lista.append("</style>");
        lista.append("<table>");
        lista.append("<thead><tr>");
        lista.append("<th>sId</th>");
        lista.append("<th>cNome</th>");
        lista.append("<th>cEmail</th>");
        lista.append("</tr></thead>");
        lista.append("<tbody>");

        try {
            if (rs == null || !rs.isBeforeFirst()) {
                request.setAttribute("resultado", "Nenhum Administrador encontrado com o nome fornecido.");
                request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
                return;
            }
            // Itera sobre os resultados retornados e cria uma linha para cada registro
            while (rs.next()) {
                lista.append("<tr>");
                lista.append("<td>").append(rs.getInt("SID")).append("</td>");
                lista.append("<td>").append(rs.getString("CNOME")).append("</td>");
                lista.append("<td>").append(rs.getString("CEMAIL")).append("</td>");
                lista.append("</tr>");
            }
        } catch (SQLException sqle) {
            // Armazena a mensagem de erro na requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        lista.append("</tbody></table>");



        // Define o resultado da busca como atributo da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha a requisição para a página JSP que exibe o resultado
    }
}