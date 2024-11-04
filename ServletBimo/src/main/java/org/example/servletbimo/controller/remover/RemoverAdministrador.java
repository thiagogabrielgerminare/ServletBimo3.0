package org.example.servletbimo.controller.remover;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;
import org.example.servletbimo.models.Administrador;

import java.io.IOException;

// Define uma servlet que responde a requisições no caminho "/removerAdm"
@WebServlet(name = "removerAdm", value = "/removerAdm")
public class RemoverAdministrador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém o parâmetro "id" enviado no formulário para remoção do administrador
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

        // Cria um objeto Administrador com o ID para remoção
        Administrador administrador = new Administrador(idInt);

        // Instancia o DAO para realizar a remoção do administrador
        AdministradorDAO administradorDAO = new AdministradorDAO();
        int sucesso = administradorDAO.removerAdministrador(administrador); // Tenta remover o administrador

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
