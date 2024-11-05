package org.example.servletbimo.controller.buscar.Midia;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.MidiaDAO;
import org.example.servletbimo.models.Midia;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "buscarUrlMidia", value = "/buscarUrlMidia")
public class BuscarUrlMidia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");

        // Validação da entrada
        if (url == null || url.trim().isEmpty()) {
            request.setAttribute("resultado", "A URL não pode ser vazia.");
            request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
            return;
        }

        Midia midia = new Midia(url);
        MidiaDAO midiaDAO = new MidiaDAO();
        StringBuilder lista = new StringBuilder();

        try (ResultSet rs = midiaDAO.buscarMidiaPorUrl(midia)) {
            // Verifica se o resultado está vazio
            if (rs == null || !rs.isBeforeFirst()) {
                request.setAttribute("resultado", "Nenhuma mídia encontrada com a URL fornecida.");
                request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
                return;
            }

            // Monta a lista de resultados em uma tabela
            lista.append("<table>");
            lista.append("<tr><th>sId</th><th>idProduto</th><th>cUrlFoto</th></tr>");

            while (rs.next()) {
                lista.append("<tr>")
                        .append("<td>").append(rs.getInt("SID")).append("</td>")
                        .append("<td>").append(rs.getInt("IDPRODUTO")).append("</td>")
                        .append("<td>").append(rs.getString("CURLFOTO")).append("</td>")
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
