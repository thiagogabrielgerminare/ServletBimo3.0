package org.example.servletbimo.controller.buscar;

// Importações para funcionamento do servlet e interação com o banco de dados
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.MidiaCursoDAO;
import org.example.servletbimo.DAO.UsuarioDAO;
import org.example.servletbimo.models.MidiaCurso;
import org.example.servletbimo.models.Usuario;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Declaração do servlet com o nome "buscarCnpjUsuario" e mapeamento para a URL "/buscarCnpjUsuario"
@WebServlet(name = "buscarCnpjUsuario", value = "/buscarCnpjUsuario")
public class BuscarCnpjUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recupera o parâmetro "cnpj" enviado na requisição
        String cnpj = request.getParameter("cnpj");

        // Cria um objeto Usuario com o CNPJ fornecido e um valor numérico fixo (4)
        Usuario usuario = new Usuario(cnpj, 4);

        // Cria uma instância de UsuarioDAO para acessar o banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        // Chama o método buscarUsuarioPorCnpj para buscar o usuário pelo CNPJ
        ResultSet rs = usuarioDAO.buscarUsuarioPorCnpj(usuario);

        // StringBuilder para armazenar o HTML gerado com os dados do usuário
        StringBuilder lista = new StringBuilder();

        try {
            // Itera sobre o ResultSet para extrair os dados dos usuários encontrados
            while (rs.next()) {
                lista.append("<div class=\"linha\">");

                // Monta o HTML com os dados do usuário recuperados do banco
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cEmail: ").append("</div>").append(rs.getString("CEMAIL")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cTelefone: ").append("</div>").append(rs.getString("CTELEFONE")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("dDataNascimento: ").append("</div>").append(rs.getDate("DDATANASCIMENTO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cSobrenome: ").append("</div>").append(rs.getString("CSOBRENOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cCNPJ: ").append("</div>").append(rs.getString("CCNPJ")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cCPF: ").append("</div>").append(rs.getString("CCPF")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("dDataCriação: ").append("</div>").append(rs.getDate("DDATACRIACAO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("idPlano: ").append("</div>").append(rs.getInt("IDPLANO")).append("</p>")
                        .append("</div>").append("<br>"); // Usa <br> para criar uma nova linha na saída HTML
            }
        } catch (SQLException sqle) {
            // Em caso de erro na consulta, adiciona a mensagem de erro como atributo de requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        // Define o resultado gerado como atributo de requisição e encaminha para a página "resultadoBusca.jsp"
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
    }
}
