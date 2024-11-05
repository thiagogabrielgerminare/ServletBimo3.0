package org.example.servletbimo.controller.buscar.Administrador;

// Importações necessárias para a criação do servlet e manipulação de dados
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;
import org.example.servletbimo.models.Administrador;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Declaração do servlet "buscarEmailAdm", mapeado para a URL "/buscarEmailAdm"
@WebServlet(name = "buscarEmailAdm", value = "/buscarEmailAdm")
public class BuscarEmailAdministrador extends HttpServlet {

    // Sobrescreve o método doPost para processar requisições POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro "email" da requisição HTTP
        String email = request.getParameter("email");

        // Cria um objeto Administrador com o email fornecido e um valor numérico fixo (2)
        Administrador administrador = new Administrador(email, 2);

        // Instancia o DAO AdministradorDAO para acessar o banco de dados
        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Realiza a consulta no banco de dados para buscar o administrador pelo email
        ResultSet rs = administradorDAO.buscarAdministradorPorEmail(administrador);

        // StringBuilder para armazenar o HTML gerado com os resultados
        StringBuilder lista = new StringBuilder();

        try {
            // Itera pelos resultados do ResultSet para construir o HTML com os dados
            while (rs.next()) {
                lista.append("<div class=\"linha\">");

                // Adiciona cada campo no HTML, com a estrutura organizada em colunas e linhas
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cNome: ").append("</div>").append(rs.getString("CNOME")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cEmail: ").append("</div>").append(rs.getString("CEMAIL")).append("</p>")
                        .append("</div>").append("<br>"); // Usa <br> para pular uma linha no HTML final
            }
        } catch (SQLException sqle) {
            // Em caso de erro de SQL, define a mensagem de erro como atributo da requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        // Define o HTML gerado como atributo "resultado" da requisição
        request.setAttribute("resultado", lista.toString());

        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha para a página JSP "resultadoBusca.jsp" para exibir o resultado

    }
}
