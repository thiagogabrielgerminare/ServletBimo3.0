package org.example.servletbimo.controller.buscar;

// Importações necessárias
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

// Declaração do servlet, mapeado para a URL "/buscarIdAdm"
@WebServlet(name = "buscarIdAdm", value = "/buscarIdAdm")
public class BuscarIdAdministrador extends HttpServlet {

    // Método doPost para processar requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o ID do administrador informado pelo usuário
        String idStr = request.getParameter("id");

        int idInt = 0;
        // Converte o ID para int, caso não seja nulo ou vazio
        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Tratamento de erro para formato inválido
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        // Cria um objeto Administrador utilizando o ID fornecido
        Administrador administrador = new Administrador(idInt);

        // Instancia o DAO de administrador para interagir com o banco de dados
        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Realiza a busca do administrador pelo ID no banco de dados
        ResultSet rs = administradorDAO.buscarAdministradorPorId(administrador);

        // StringBuilder para construir o HTML com os dados do administrador
        StringBuilder lista = new StringBuilder();

        try {
            // Itera pelos resultados da consulta para construir a resposta HTML
            while (rs.next()) {
                lista.append("<div class=\"linha\">");

                // Adiciona cada campo ao HTML, com colunas estilizadas
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cEmail: ").append("</div>").append(rs.getString("CEMAIL")).append("</p>")
                        .append("</div>").append("<br>"); // Pula uma linha na saída HTML
            }
        } catch (SQLException sqle) {
            // Em caso de erro, define uma mensagem de erro como atributo da requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        // Define o resultado da consulta como atributo "resultado" da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha a requisição para a página JSP "resultadoBusca.jsp" para exibir o resultado
    }
}
