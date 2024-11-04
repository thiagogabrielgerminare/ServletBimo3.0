package org.example.servletbimo.controller.remover;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.MidiaCursoDAO; // Importa o DAO para manipulação de mídias de curso
import org.example.servletbimo.models.MidiaCurso; // Importa o modelo MidiaCurso

import java.io.IOException;

// Define uma servlet que responde a requisições no caminho "/removerMidiaCurso"
@WebServlet(name = "removerMidiaCurso", value = "/removerMidiaCurso")
public class RemoverMidiaCurso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro "id" enviado no formulário para remoção da mídia de curso
        String idStr = request.getParameter("id");

        int idInt = 0; // Inicializa o ID

        // Converte o ID para int, se não for nulo ou vazio
        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Tratamento de erro para formato inválido
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        // Cria um objeto MidiaCurso com o ID para remoção
        MidiaCurso midiaCurso = new MidiaCurso(idInt);

        // Instancia o DAO para realizar a remoção da mídia de curso
        MidiaCursoDAO midiaCursoDAO = new MidiaCursoDAO();
        int sucesso = midiaCursoDAO.removerMidiaCurso(midiaCurso); // Tenta remover a mídia de curso

        // Define o resultado da operação como atributo da requisição
        if (sucesso > 0) {
            request.setAttribute("resultado", "foi"); // Sucesso na remoção
        } else {
            request.setAttribute("resultado", "erro "); // Falha na remoção
        }

        // Redireciona a requisição para a página de remoção
        request.getRequestDispatcher("remocao.jsp").forward(request, response);
    }
}
