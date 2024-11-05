package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.MidiaCursoDAO;
import org.example.servletbimo.models.MidiaCurso;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarTodosMidiaCurso", value = "/buscarTodosMidiaCurso")
public class BuscarTodosMidiaCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MidiaCursoDAO midiaCursoDAO = new MidiaCursoDAO();
        StringBuilder lista = new StringBuilder();

        try (ResultSet rs = midiaCursoDAO.buscarTodosMidiaCurso()) {
            // Verifica se o resultado está vazio
            if (rs == null || !rs.isBeforeFirst()) {
                request.setAttribute("resultado", "Nenhuma midiaCurso encontrada.");
                request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
                return;
            }

            // Adiciona estilo CSS para a tabela
            lista.append("<style>");
            lista.append("table { width: 100%; border-collapse: collapse; margin-top: 20px; }");
            lista.append("th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }");
            lista.append("th { background-color: #f2f2f2; font-weight: bold; }");
            lista.append("tr:nth-child(even) { background-color: #f9f9f9; }"); // Linhas alternadas
            lista.append("</style>");

// Monta a lista de resultados em uma tabela
            lista.append("<table>");
            lista.append("<tr><th>sId</th><th>idProduto</th><th>cUrlFoto</th><th>transaction_made</th><th>bIsUpdated</th><th>bIsInactive</th></tr>");
                while (rs.next()) {
                    lista.append("<tr>")
                            .append("<td>").append(rs.getInt("SID")).append("</td>")
                            .append("<td>").append(rs.getInt("IDCURSO")).append("</td>")
                            .append("<td>").append(rs.getString("CURLFOTO")).append("</td>")
                            .append("<td>").append(rs.getBoolean("TRANSACTION_MADE")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BISUPDATED")).append("</td>")
                            .append("<td>").append(rs.getBoolean("BISINACTIVE")).append("</td>")
                            .append("</tr>");
                }
                lista.append("</table>"); // Fecha a tabela

        } catch (SQLException sqle) {
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
    }
}