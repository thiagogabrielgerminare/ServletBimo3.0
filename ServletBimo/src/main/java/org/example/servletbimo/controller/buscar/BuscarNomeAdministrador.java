package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;
import org.example.servletbimo.models.Administrador;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarNomeAdm"
@WebServlet(name = "buscarNomeAdm", value = "/buscarNomeAdm")
public class BuscarNomeAdministrador extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o nome do administrador da requisição
        String nome = request.getParameter("nome");

        // Cria uma nova instância de Administrador com o nome fornecido
        Administrador administrador = new Administrador(nome, 1); // O '1' aqui parece ser um valor fixo, considere se é necessário

        // Cria uma instância do DAO para acessar dados do administrador
        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Busca o administrador pelo nome
        ResultSet rs = administradorDAO.buscarAdministradorPorNome(administrador);
        StringBuilder lista = new StringBuilder();

        try {
            // Itera sobre os resultados retornados
            while (rs.next()) {
                lista.append("<div class=\"linha\">");
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cEmail: ").append("</div>").append(rs.getString("CEMAIL")).append("</p>")
                        .append("</div>").append("<br>"); // Quebra de linha na saída HTML
            }
        } catch (SQLException sqle) {
            // Armazena a mensagem de erro na requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        // Define o resultado da busca como atributo da requisição
        request.setAttribute("resultado", lista.toString());
        // Encaminha a requisição para a página JSP que exibe o resultado
        request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
    }
}
