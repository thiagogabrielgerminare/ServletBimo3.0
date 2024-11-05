package org.example.servletbimo.controller.buscar;

// Importações necessárias
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

// Declaração do servlet, mapeado para a URL "/buscarEstadoProduto"
@WebServlet(name = "buscarEstadoProduto", value = "/buscarEstadoProduto")
public class BuscarEstadoProduto extends HttpServlet {

    // Método doPost para processar requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o estado do produto informado pelo usuário a partir dos parâmetros da requisição
        String estado = request.getParameter("estado");

        // Cria um objeto Produto utilizando o estado fornecido
        Produto produto = new Produto(estado, 2);

        // Instancia o DAO de produto para interagir com o banco de dados
        ProdutoDAO produtoDAO = new ProdutoDAO();

        // Realiza a busca dos produtos pelo estado no banco de dados
        ResultSet rs = produtoDAO.buscarProdutoPorEstado(produto);

        // StringBuilder para construir o HTML com os dados do produto
        StringBuilder lista = new StringBuilder();

        try {
            // Itera pelos resultados da consulta para construir a resposta HTML
            while (rs.next()) {
                lista.append("<div class=\"linha\">");

                // Adiciona cada campo ao HTML, com colunas estilizadas
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("fValor: ").append("</div>").append(rs.getDouble("FVALOR")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cEstado: ").append("</div>").append(rs.getString("CESTADO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cDescrição: ").append("</div>").append(rs.getString("CDESCRICAO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("dDataCriação: ").append("</div>").append(rs.getDate("DDATACRIACAO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("idUsuario: ").append("</div>").append(rs.getInt("IDUSUARIO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("idCategoriaProduto: ").append("</div>").append(rs.getInt("IDCATEGORIAPRODUTO")).append("</p>")
                        .append("</div>").append("<br>"); // Pula uma linha na saída HTML
            }
        } catch (SQLException sqle) {
            // Em caso de erro, define uma mensagem de erro como atributo da requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        // Define o resultado da consulta como atributo "resultado" da requisição
        request.setAttribute("resultado", lista.toString());

        // Encaminha a requisição para a página JSP "resultadoBusca.jsp" para exibir o resultado
        request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
    }
}
