package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.ProdutoDAO;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarTodosProduto", value = "/buscarTodosProduto")
public class BuscarTodosProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProdutoDAO produtoDAO = new ProdutoDAO();
        StringBuilder lista = new StringBuilder();

        try (ResultSet rs = produtoDAO.buscarTodosProduto()) {
            // Verifica se o resultado está vazio
            if (rs == null || !rs.isBeforeFirst()) {
                request.setAttribute("resultado", "Nenhum produto encontrado com o nome fornecido.");
                request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
                return;
            }

            // Monta a lista de resultados
            lista.append("<table>");
            lista.append("<tr><th>sId</th><th>cNome</th><th>fValor</th><th>cEstado</th><th>cDescrição</th>")
                    .append("<th>dDataCriação</th><th>idUsuario</th><th>idCategoriaProduto</th></tr>");

            while (rs.next()) {
                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getString("CNOME")).append("</td>")
                        .append("<td>").append(rs.getDouble("FVALOR")).append("</td>")
                        .append("<td>").append(rs.getString("CESTADO")).append("</td>")
                        .append("<td>").append(rs.getString("CDESCRICAO")).append("</td>")
                        .append("<td>").append(rs.getDate("DDATACRIACAO")).append("</td>")
                        .append("<td>").append(rs.getInt("IDUSUARIO")).append("</td>")
                        .append("<td>").append(rs.getInt("IDCATEGORIAPRODUTO")).append("</td>")
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
