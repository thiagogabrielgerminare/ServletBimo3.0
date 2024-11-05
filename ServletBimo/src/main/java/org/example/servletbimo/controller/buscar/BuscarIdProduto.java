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

// Mapeia este servlet para a URL "/buscarIdProduto"
@WebServlet(name = "buscarIdProduto", value = "/buscarIdProduto")
public class BuscarIdProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o ID passado na requisição
        String idStr = request.getParameter("id");

        int idInt = 0;
        // Converte o ID para inteiro se não for nulo ou vazio
        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Tratamento de erro para formato inválido
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        // Cria uma nova instância de Produto usando o ID
        Produto produto = new Produto(idInt);
        ProdutoDAO produtoDAO = new ProdutoDAO();

        // Realiza a busca pelo produto no banco de dados
        ResultSet rs = produtoDAO.buscarProdutoPorId(produto);
        StringBuilder lista = new StringBuilder();

        try {
            // Itera sobre o ResultSet para construir a resposta em HTML
            if (!rs.isBeforeFirst()) {
                request.setAttribute("resultado", "Nenhum produto encontrado para o ID fornecido.");
            } else {
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
                            .append("</div>").append("<br>"); // Quebra de linha na saída HTML
                }
            }
        } catch (SQLException sqle) {
            // Armazena a mensagem de erro na requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        // Define o resultado da busca como atributo da requisição
        request.setAttribute("resultado", lista.toString());
        // Encaminha a requisição para a página JSP que exibe o resultado
        request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
    }
}
