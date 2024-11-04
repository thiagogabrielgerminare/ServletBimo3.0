package org.example.servletbimo.controller.cadastrar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.MidiaCursoDAO;
import org.example.servletbimo.DAO.PlanoPagamentoDAO;
import org.example.servletbimo.models.MidiaCurso;
import org.example.servletbimo.models.PlanoPagamento;

import java.io.IOException;

@WebServlet(name = "cadastrarMidiaCurso", value = "/cadastrarMidiaCurso")
public class CadastrarMidiaCurso extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String urlFoto = request.getParameter("url-foto");

        int idInt = 0;

        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        MidiaCurso midiaCurso = new MidiaCurso(idInt, 2, urlFoto);

        MidiaCursoDAO midiaCursoDAO = new MidiaCursoDAO();
        boolean success = midiaCursoDAO.inserirMidiaCurso(midiaCurso);

        if (success){
            request.setAttribute("resultado", "foi");
        }else {
            request.setAttribute("resultado", "não foi");
        }

        request.getRequestDispatcher("cadastro.jsp").forward(request, response);
    }
}