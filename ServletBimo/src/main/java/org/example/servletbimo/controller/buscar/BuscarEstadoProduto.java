package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.ProdutoDAO;
import org.example.servletbimo.models.Produto;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet( name = "buscarEstadoProduto", value = "/buscarEstadoProduto" )
public class BuscarEstadoProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String estado = request.getParameter("estado");

        Produto produto = new Produto(estado, 2);

        ProdutoDAO produtoDAO = new ProdutoDAO();

        ResultSet rs = produtoDAO.buscarProdutoPorEstado(produto);
        StringBuilder lista = new StringBuilder();

        try {
            while (rs.next()) {
                lista.append("<div class=\"linha\">");
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("fValor: ").append("</div>").append(rs.getDouble("FVALOR")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cEstado: ").append("</div>").append(rs.getString("CESTADO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cDescrição: ").append("</div>").append(rs.getString("CDESCRICAO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("dDataCriação: ").append("</div>").append(rs.getDate("DDATACRIACAO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("idUsuario: ").append("</div>").append(rs.getInt("IDUSUARIO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("idCategoriaProduto: ").append("</div>").append(rs.getInt("IDCATEGORIAPRODUTO")).append("</p>")


                        .append("</div>").append("<br>"); // Usando <br> para criar uma nova linha na saída HTML
            }
        } catch (SQLException sqle) {
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }


        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
    }
}
