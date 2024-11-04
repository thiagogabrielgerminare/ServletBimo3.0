package org.example.servletbimo.controller.alterar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;
import org.example.servletbimo.models.Administrador;

import java.io.IOException;

@WebServlet( name = "alterarSenhaAdm", value = "/alterarSenhaAdm" )
public class AlterarSenhaAdm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String senha = request.getParameter("senha");

        int idInt = 0;

        String senhaCripto = criptografarSenha(senha);

        if (idStr != null && !idStr.isEmpty()) {
            try {
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trate o caso de formato inválido, caso necessário
                System.out.println("Erro: o parâmetro não é um número válido.");
            }
        }

        Administrador administrador = new Administrador(idInt, senhaCripto, 3);

        AdministradorDAO administradorDAO = new AdministradorDAO();
        int sucesso = administradorDAO.alterarSenhaAdministrador(administrador);

        if (sucesso > 0){
            request.setAttribute("resultado", "foi");
        } else {
            request.setAttribute("resultado", "erro ");
        }
        request.getRequestDispatcher("alteracao.jsp").forward(request, response);
    }

    public String criptografarSenha(String senha) {
        StringBuilder senhaCriptografada = new StringBuilder();
        String alfabetoMinusculo = "abcdefghijklmnopqrstuvwxyz";
        String alfabetoMaiusculo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int chaveSt = Integer.parseInt(System.getenv("CHAVE_CRIPTOGRAFIA"));

        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            if (Character.isLowerCase(caractere)) {
                int novaPosicao = (alfabetoMinusculo.indexOf(caractere) + chaveSt) % alfabetoMinusculo.length();
                char novaLetra = alfabetoMinusculo.charAt(novaPosicao);
                senhaCriptografada.append(novaLetra);
            } else if (Character.isUpperCase(caractere)) {
                int novaPosicao = (alfabetoMaiusculo.indexOf(caractere) + chaveSt) % alfabetoMaiusculo.length();
                char novaLetra = alfabetoMaiusculo.charAt(novaPosicao);
                senhaCriptografada.append(novaLetra);
            } else if (Character.isDigit(caractere)) {
                int novoDigito = (Character.getNumericValue(caractere) + chaveSt) % 10; // Limita a 0-9
                senhaCriptografada.append(novoDigito);
            } else {
                senhaCriptografada.append(caractere); // Mantém caracteres não alfabéticos e não numéricos
            }
        }

        return senhaCriptografada.toString();
    }
}
