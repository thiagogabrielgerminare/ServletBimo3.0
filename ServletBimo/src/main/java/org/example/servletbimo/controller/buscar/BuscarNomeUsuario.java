package org.example.servletbimo.controller.buscar.Usuario;

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

@WebServlet(name = "buscarNomeUsuario", value = "/buscarNomeUsuario")
public class BuscarNomeUsuario extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        // Validação da entrada
        if (nome == null || nome.trim().isEmpty()) {
            request.setAttribute("resultado", "O nome do usuário não pode ser vazio.");
            request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
            return;
        }

        Usuario usuario = new Usuario(nome, 1);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        StringBuilder lista = new StringBuilder();

        try (ResultSet rs = usuarioDAO.buscarUsuarioPorNome(usuario)) {
            // Verifica se o resultado está vazio
            if (rs == null || !rs.isBeforeFirst()) {
                request.setAttribute("resultado", "Nenhum usuário encontrado com o nome fornecido.");
                request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
                return;
            }

            // Monta a lista de resultados
            lista.append("<table>");
            lista.append("<tr><th>sId</th><th>cEmail</th><th>cTelefone</th><th>dDataNascimento</th>")
                    .append("<th>cNome</th><th>cSobrenome</th><th>cCNPJ</th><th>cCPF</th>")
                    .append("<th>dDataCriação</th><th>idPlano</th></tr>");

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
            lista.append("</table>");
        } catch (SQLException sqle) {
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
    }
}
