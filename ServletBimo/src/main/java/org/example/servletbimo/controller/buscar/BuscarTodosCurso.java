package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.CursoDAO;
import org.example.servletbimo.models.Curso;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarTodosCurso", value = "/buscarTodosCurso")
public class BuscarTodosCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CursoDAO cursoDAO = new CursoDAO();
        StringBuilder lista = new StringBuilder();

        try (ResultSet rs = cursoDAO.buscarTodosCursos()) {
            // Verifica se o resultado está vazio

            // Monta a lista de resultados
            if (rs == null || !rs.isBeforeFirst()) {
                request.setAttribute("resultado", "Nenhum curso encontrado.");
                request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
                return;
            }
            while (rs.next()) {
                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getString("CNOME")).append("</td>")
                        .append("<td>").append(rs.getDouble("FVALOR")).append("</td>")
                        .append("<td>").append(rs.getString("CDURACAO")).append("</td>")
                        .append("<td>").append(rs.getString("CDESCRICAO")).append("</td>")
                        .append("<td>").append(rs.getString("CCERTIFICACAO")).append("</td>")
                        .append("<td>").append(rs.getBoolean("BSTATUS")).append("</td>")
                        .append("<td>").append(rs.getInt("INUMEROINSCRICAO")).append("</td>")
                        .append("<td>").append(rs.getInt("IDCATEGORIACURSO")).append("</td>")
                        .append("<td>").append(rs.getBoolean("TRANSACTION_MADE")).append("</td>")
                        .append("<td>").append(rs.getBoolean("BISUPDATED")).append("</td>")
                        .append("<td>").append(rs.getBoolean("BISINACTIVE")).append("</td>")
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