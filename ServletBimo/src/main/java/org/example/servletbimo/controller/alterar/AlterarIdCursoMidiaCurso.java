package org.example.servletbimo.controller.alterar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.CategoriaCursoDAO;
import org.example.servletbimo.DAO.CategoriaProdutoDAO;
import org.example.servletbimo.DAO.MidiaCursoDAO;
import org.example.servletbimo.models.CategoriaProduto;
import org.example.servletbimo.models.MidiaCurso;

import java.io.IOException;

@WebServlet( name = "alterarIdCurso", value = "/alterarIdCurso" )
public class AlterarIdCursoMidiaCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String idCursoStr = request.getParameter("id-curso");

        int idInt = 0;
        int idCursoInt = 0;

        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        if (idCursoStr != null && !idCursoStr.isEmpty()) {
            try {
                idCursoInt = Integer.parseInt(idCursoStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        MidiaCurso midiaCurso = new MidiaCurso(idInt, idCursoInt);

        MidiaCursoDAO midiaCursoDAO = new MidiaCursoDAO();
        int sucesso = midiaCursoDAO.alterarMidiaCursoidCurso(midiaCurso);

        if (sucesso > 0){
            request.setAttribute("resultado", "foi");
        } else {
            request.setAttribute("resultado", "erro ");
        }
        request.getRequestDispatcher("alteracao.jsp").forward(request, response);
    }
}
