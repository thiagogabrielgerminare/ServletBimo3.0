package org.example.servletbimo.controller.buscar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.MidiaCursoDAO;
import org.example.servletbimo.models.MidiaCurso;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

// Mapeia este servlet para a URL "/buscarIdMidiaCurso"
@WebServlet(name = "buscarIdMidiaCurso", value = "/buscarIdMidiaCurso")
public class BuscarIdMidiaCurso extends HttpServlet {
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

        // Cria uma nova instância de MidiaCurso usando o ID
        MidiaCurso midiaCurso = new MidiaCurso(idInt);
        MidiaCursoDAO midiaCursoDAO = new MidiaCursoDAO();

        // Realiza a busca pela mídia do curso no banco de dados
        ResultSet rs = midiaCursoDAO.buscarMidiaCursoPorId(midiaCurso);
        StringBuilder lista = new StringBuilder();

        try {
            // Itera sobre o ResultSet para construir a resposta em HTML
            while (rs.next()) {
                lista.append("<div class=\"linha\">");
                lista.append("<p>").append("<div class=\"nomeColuna\">").append("sId: ").append("</div>").append(rs.getInt("SID")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("idProduto: ").append("</div>").append(rs.getInt("IDCURSO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("cUrlFoto: ").append("</div>").append(rs.getString("CURLFOTO")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("transaction_made: ").append("</div>").append(rs.getBoolean("TRANSACTION_MADE")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("bIsUpdated: ").append("</div>").append(rs.getBoolean("BISUPDATED")).append("</p>")
                        .append("<p>").append("<div class=\"nomeColuna\">").append("bIsInactive: ").append("</div>").append(rs.getBoolean("BISINACTIVE")).append("</p>")
                        .append("</div>").append("<br>"); // Quebra de linha na saída HTML
            }
        } catch (SQLException sqle) {
            // Armazena a mensagem de erro na requisição
            request.setAttribute("resultado", "Erro: " + sqle.getMessage());
        }

        // Define o resultado da busca como atributo da requisição
        request.setAttribute("resultado", lista.toString());
        request.getRequestDispatcher("/BiMO_Site/index/resultadoBusca.jsp").forward(request, response);
        // Encaminha a requisição para a página JSP que exibe o resultado
    }
}
