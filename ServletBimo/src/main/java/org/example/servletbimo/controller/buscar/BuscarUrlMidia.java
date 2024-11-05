package org.example.servletbimo.controller.buscar;

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

@WebServlet( name = "buscarUrlMidia", value = "/buscarUrlMidia" )
public class BuscarUrlMidia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");

        Midia midia = new Midia(url);

        MidiaDAO midiaDAO = new MidiaDAO();

        ResultSet rs = midiaDAO.buscarMidiaPorUrl(midia);
        StringBuilder lista = new StringBuilder();

        try {
            while (rs.next()) {
                lista.append("<div class=\"linha\">");
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("idProduto: ").append("</div>").append(rs.getInt("IDPRODUTO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cUrlFoto: ").append("</div>").append(rs.getString("CURLFOTO")).append("</p>")
                        .append("</div>").append("<br>"); // Usando <br> para criar uma nova linha na saída HTML
            }
        } catch (SQLException sqle) {
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
    }
}
