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
                request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
                return;
            }

            // Monta a lista de resultados
            // Adiciona estilo CSS para a tabela
            lista.append("<style>");
            lista.append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            lista.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
            lista.append("th { background-color: #f2f2f2; font-weight: bold; }");
            lista.append("tr:nth-child(even) { background-color: #f9f9f9; }"); // Linhas alternadas
            lista.append("tr:hover { background-color: #e2e2e2; }"); // Efeito hover nas linhas
            lista.append("</style>");

// Monta a lista de resultados em uma tabela
            lista.append("<table>");
            lista.append("<tr><th>sId</th><th>cNome</th><th>fValor</th><th>cEstado</th><th>cDescrição</th>")
                    .append("<th>dDataCriação</th><th>idUsuario</th><th>idCategoriaProduto</th></tr>");

            try {
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
                lista.append("</table>"); // Fecha a tabela
            } catch (SQLException sqle) {
                // Armazena a mensagem de erro na requisição
                request.setAttribute("resultado", "Erro: " + sqle.getMessage());
            }

        } catch (SQLException sqle) {
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
    }
}
