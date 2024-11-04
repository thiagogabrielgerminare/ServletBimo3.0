package org.example.servletbimo.controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;

import java.io.IOException;

@WebServlet(name = "loginjsp", value = "/loginjsp")
public class LogarAdm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        senha = criptografarSenha(senha);

        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Chama o método para buscar administrador
        if (administradorDAO.BuscarAdministrador(email, senha)) {
            request.getSession().setAttribute("logado",true);
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("erro_login.jsp").forward(request, response);
        }
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