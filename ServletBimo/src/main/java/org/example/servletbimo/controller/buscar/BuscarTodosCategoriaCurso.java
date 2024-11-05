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

        try {
            // Itera sobre os resultados retornados
            while (rs.next()) {
                lista.append("<div class=\"linha\">");
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("transaction_made: ").append("</div>").append(rs.getBoolean("TRANSACTION_MADE")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("bIsUpdated: ").append("</div>").append(rs.getBoolean("BISUPDATED")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("bIsInactive: ").append("</div>").append(rs.getBoolean("BISINACTIVE")).append("</p>")
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
