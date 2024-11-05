package org.example.servletbimo.controller.buscar;

// Importações necessárias para o funcionamento do servlet e interação com o banco de dados
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

// Declaração do servlet com o nome "buscarCertificacaoCurso" e mapeamento para a URL "/buscarCertificacaoCurso"
@WebServlet(name = "buscarCertificacaoCurso", value = "/buscarCertificacaoCurso")
public class BuscarCertificacaoCurso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera o parâmetro "certificacao" enviado na requisição
        String certificacao = request.getParameter("certificacao");

        // Cria um objeto Curso com a certificação fornecida e um valor numérico fixo (2)
        Curso curso = new Curso(certificacao, 2);

        // Cria uma instância de CursoDAO para acessar o banco de dados
        CursoDAO cursoDAO = new CursoDAO();

        // Chama o método buscarPorCertificacao para buscar cursos com a certificação fornecida
        ResultSet rs = cursoDAO.buscarPorCertificacao(curso);

        // StringBuilder para armazenar o HTML gerado com os dados dos cursos
        StringBuilder lista = new StringBuilder();

        try {
            // Itera sobre o ResultSet para extrair os dados dos cursos encontrados
            while (rs.next()) {
                lista.append("<div class=\"linha\">");

                // Monta o HTML com os dados do curso recuperados do banco
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
                        .append("</div>").append("<br>"); // Usa <br> para criar uma nova linha na saída HTML
            }
        } catch (SQLException sqle) {
            // Em caso de erro na consulta, adiciona a mensagem de erro como atributo de requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        // Define o resultado gerado como atributo de requisição e encaminha para a página "resultadoBusca.jsp"
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
    }
}
