package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.UsuarioDAO;
import org.example.servletbimo.models.Usuario;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarIdUsuario"
@WebServlet(name = "buscarIdUsuario", value = "/buscarIdUsuario")
public class BuscarIdUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o ID passado na requisição
        String idStr = request.getParameter("id");

        int idInt = 0;
        // Converte o ID para inteiro se não for nulo ou vazio
        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Tratamento de erro para formato inválido
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        // Cria uma nova instância de Usuario usando o ID
        Usuario usuario = new Usuario(idInt);
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Realiza a busca pelo usuário no banco de dados
        ResultSet rs = usuarioDAO.buscarUsuarioPorId(usuario);
        StringBuilder lista = new StringBuilder();

        try {
                // Adiciona o estilo da tabela
            lista.append("<style>")
                    .append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }")
                    .append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }")
                    .append("th { background-color: #f2f2f2; font-weight: bold; }")
                    .append("tr:nth-child(even) { background-color: #f9f9f9; }")
                    .append("tr:hover { background-color: #e2e2e2; }")
                    .append("td, th { text-align: center; }")
                    .append("</style>");

                // Começa a construção da tabela HTML
                lista.append("<table>");
                lista.append("<tr>")
                        .append("<th>sId</th>")
                        .append("<th>cEmail</th>")
                        .append("<th>cTelefone</th>")
                        .append("<th>dDataNascimento</th>")
                        .append("<th>cNome</th>")
                        .append("<th>cSobrenome</th>")
                        .append("<th>cCNPJ</th>")
                        .append("<th>cCPF</th>")
                        .append("<th>dDataCriação</th>")
                        .append("<th>idPlano</th>")
                        .append("</tr>");

                // Itera sobre o ResultSet e adiciona os dados à tabela
                while (rs.next()) {
                    lista.append("<tr>")
                            .append("<td>").append(rs.getInt("SID")).append("</td>")
                            .append("<td>").append(rs.getString("CEMAIL")).append("</td>")
                            .append("<td>").append(rs.getString("CTELEFONE")).append("</td>")
                            .append("<td>").append(rs.getDate("DDATANASCIMENTO")).append("</td>")
                            .append("<td>").append(rs.getString("CNOME")).append("</td>")
                            .append("<td>").append(rs.getString("CSOBRENOME")).append("</td>")
                            .append("<td>").append(rs.getString("CCNPJ")).append("</td>")
                            .append("<td>").append(rs.getString("CCPF")).append("</td>")
                            .append("<td>").append(rs.getDate("DDATACRIACAO")).append("</td>")
                            .append("<td>").append(rs.getInt("IDPLANO")).append("</td>")
                            .append("</tr>");
                }

                lista.append("</table>");  // Fecha a tabela
        } catch (SQLException sqle) {
            // Em caso de erro na consulta, armazena a mensagem de erro na requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        // Define o resultado da busca como atributo da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha a requisição para a página JSP que exibe o resultado
    }
}
