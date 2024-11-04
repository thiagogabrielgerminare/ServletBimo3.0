package org.example.servletbimo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;

import java.io.IOException;

// Define uma servlet que responde a requisições no caminho "/loginjsp"
@WebServlet(name = "loginjsp", value = "/loginjsp")
public class LogarAdm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Captura os parâmetros de email e senha enviados na requisição
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        // Criptografa a senha usando o método definido na própria classe
        senha = criptografarSenha(senha);

        // Instancia o DAO para interagir com os administradores
        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Chama o método para buscar administrador no banco de dados
        if (administradorDAO.BuscarAdministrador(email, senha)) {
            // Se o administrador for encontrado, redireciona para a página admin.jsp
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            // Se não for encontrado, redireciona para a página de erro de login
            request.getRequestDispatcher("erro_login.jsp").forward(request, response);
        }
    }

    // Método para criptografar a senha usando uma chave de criptografia
    public String criptografarSenha(String senha) {
        StringBuilder senhaCriptografada = new StringBuilder(); // Usado para construir a senha criptografada
        String alfabetoMinusculo = "abcdefghijklmnopqrstuvwxyz"; // Alfabeto minúsculo
        String alfabetoMaiusculo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Alfabeto maiúsculo
        // Obtém a chave de criptografia do ambiente (variável de ambiente)
        int chaveSt = Integer.parseInt(System.getenv("CHAVE_CRIPTOGRAFIA"));

        // Itera sobre cada caractere da senha
        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            // Se o caractere é uma letra minúscula
            if (Character.isLowerCase(caractere)) {
                int novaPosicao = (alfabetoMinusculo.indexOf(caractere) + chaveSt) % alfabetoMinusculo.length();
                char novaLetra = alfabetoMinusculo.charAt(novaPosicao); // Calcula nova letra
                senhaCriptografada.append(novaLetra);
            }
            // Se o caractere é uma letra maiúscula
            else if (Character.isUpperCase(caractere)) {
                int novaPosicao = (alfabetoMaiusculo.indexOf(caractere) + chaveSt) % alfabetoMaiusculo.length();
                char novaLetra = alfabetoMaiusculo.charAt(novaPosicao); // Calcula nova letra
                senhaCriptografada.append(novaLetra);
            }
            // Se o caractere é um dígito
            else if (Character.isDigit(caractere)) {
                int novoDigito = (Character.getNumericValue(caractere) + chaveSt) % 10; // Limita a 0-9
                senhaCriptografada.append(novoDigito);
            }
            // Mantém caracteres que não são letras ou dígitos
            else {
                senhaCriptografada.append(caractere);
            }
        }

        // Retorna a senha criptografada como uma string
        return senhaCriptografada.toString();
    }
}
