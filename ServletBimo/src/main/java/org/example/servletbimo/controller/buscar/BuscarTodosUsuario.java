package org.example.servletbimo.controller.buscar.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.UsuarioDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarIdUsuario"
@WebServlet(name = "buscarTodosUsuarios", value = "/buscarTodosUsuarios")
public class BuscarTodosUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Realiza a busca pelo usuário no banco de dados
        ResultSet rs = usuarioDAO.buscarTodosUsuario();
        StringBuilder lista = new StringBuilder();

        try {
            // Verifica se o ResultSet contém resultados
            if (!rs.isBeforeFirst()) {
                request.setAttribute("resultado", "Nenhum usuário encontrado para o ID fornecido.");
            } else {
                while (rs.next()) {
                    lista.append("<div class=\"linha\">");
                    lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("cEmail: ").append("</div>").append(rs.getString("CEMAIL")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("cTelefone: ").append("</div>").append(rs.getString("CTELEFONE")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("dDataNascimento: ").append("</div>").append(rs.getDate("DDATANASCIMENTO")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("cSobrenome: ").append("</div>").append(rs.getString("CSOBRENOME")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("cCNPJ: ").append("</div>").append(rs.getString("CCNPJ")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("cCPF: ").append("</div>").append(rs.getString("CCPF")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("dDataCriação: ").append("</div>").append(rs.getDate("DDATACRIACAO")).append("</p>")
                            .append("<p>").append("<div class=\"nomeColuna\">").append("idPlano: ").append("</div>").append(rs.getInt("IDPLANO")).append("</p>")
                            .append("</div>").append("<br>"); // Quebra de linha na saída HTML
                }
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
