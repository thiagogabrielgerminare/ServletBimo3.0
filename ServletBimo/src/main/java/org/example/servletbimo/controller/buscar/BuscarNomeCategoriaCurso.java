package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;
import org.example.servletbimo.DAO.CategoriaCursoDAO;
import org.example.servletbimo.models.Administrador;
import org.example.servletbimo.models.CategoriaCurso;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet( name = "buscarNomeCategoriaCurso", value = "/buscarNomeCategoriaCurso" )
public class BuscarNomeCategoriaCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        CategoriaCurso categoriaCurso = new CategoriaCurso(nome);

        CategoriaCursoDAO categoriaCursoDAO = new CategoriaCursoDAO();

        ResultSet rs = categoriaCursoDAO.buscarPorNome(categoriaCurso);
        StringBuilder lista = new StringBuilder();

        try {
            while (rs.next()) {
                lista.append("<div class=\"linha\">");
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("transaction_made: ").append("</div>").append(rs.getBoolean("TRANSACTION_MADE")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("bIsUpdated: ").append("</div>").append(rs.getBoolean("BISUPDATED")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("bIsInactive: ").append("</div>").append(rs.getBoolean("BISINACTIVE")).append("</p>")
                        .append("</div>").append("<br>"); // Usando <br> para criar uma nova linha na saída HTML
            }
        } catch (SQLException sqle) {
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
    }
}
