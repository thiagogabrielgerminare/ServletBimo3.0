package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.CursoDAO;
import org.example.servletbimo.DAO.ProdutoDAO;
import org.example.servletbimo.models.Curso;
import org.example.servletbimo.models.Produto;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet( name = "buscarNomeCurso", value = "/buscarNomeCurso" )
public class BuscarNomeCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        Curso curso = new Curso(nome, 1);

        CursoDAO cursoDAO = new CursoDAO();

        ResultSet rs = cursoDAO.buscarPorNome(curso);
        StringBuilder lista = new StringBuilder();

        try {
            while (rs.next()) {
                lista.append("<div class=\"linha\">");
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("fValor: ").append("</div>").append(rs.getDouble("FVALOR")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cDuração: ").append("</div>").append(rs.getString("CDURACAO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cDescrição: ").append("</div>").append(rs.getString("CDESCRICAO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cCertificação: ").append("</div>").append(rs.getString("CCERTIFICACAO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("bStatus: ").append("</div>").append(rs.getBoolean("BSTATUS")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("iNúmeroInscrição: ").append("</div>").append(rs.getInt("INUMEROINSCRICAO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("idCategoriaCurso: ").append("</div>").append(rs.getInt("IDCATEGORIACURSO")).append("</p>")
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
