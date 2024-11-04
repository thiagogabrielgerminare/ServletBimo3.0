package org.example.servletbimo.controller.alterar;

import jakarta.servlet.ServletException; // Importa a classe para exceções de servlet
import jakarta.servlet.annotation.WebServlet; // Importa a anotação para definir um servlet
import jakarta.servlet.http.HttpServlet; // Importa a classe base para servlets HTTP
import jakarta.servlet.http.HttpServletRequest; // Importa a classe para manipulação de requisições HTTP
import jakarta.servlet.http.HttpServletResponse; // Importa a classe para manipulação de respostas HTTP
import org.example.servletbimo.DAO.AdministradorDAO; // Importa a classe DAO para interações com a tabela de administradores
import org.example.servletbimo.models.Administrador; // Importa a classe de modelo para o administrador

import java.io.IOException; // Importa a classe de exceções de entrada/saída

// Define o servlet e a URL para acesso
@WebServlet(name = "alterarSenhaAdm", value = "/alterarSenhaAdm")
public class AlterarSenhaAdm extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtém os parâmetros 'id' e 'senha' da requisição
        String idStr = request.getParameter("id");
        String senha = request.getParameter("senha");

        int idInt = 0;

        // Criptografa a senha recebida
        String senhaCripto = criptografarSenha(senha);

        // Verifica se o ID não é nulo ou vazio
        if (idStr != null && !idStr.isEmpty()) {
            try {
                // Tenta converter o ID de String para inteiro
                idInt = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                // Trata o caso de formato inválido
                System.out.println("Erro: o parâmetro não é um número válido."); // Log de erro simples
            }
        }

        // Cria uma nova instância de Administrador com os dados recebidos
        Administrador administrador = new Administrador(idInt, senhaCripto, 3);

        // Instancia o DAO para manipular os dados do administrador
        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Chama o método para alterar a senha do administrador no banco de dados
        int sucesso = administradorDAO.alterarSenhaAdministrador(administrador);

        // Verifica se a alteração foi bem-sucedida
        if (sucesso > 0) {
            request.setAttribute("resultado", "foi"); // Define atributo para sucesso
        } else {
            request.setAttribute("resultado", "erro "); // Define atributo para erro
        }

        // Redireciona para a página de alteração
        request.getRequestDispatcher("alteracao.jsp").forward(request, response);
    }

    // Método para criptografar a senha
    public String criptografarSenha(String senha) {
        StringBuilder senhaCriptografada = new StringBuilder();
        String alfabetoMinusculo = "abcdefghijklmnopqrstuvwxyz"; // Alfabeto minúsculo
        String alfabetoMaiusculo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Alfabeto maiúsculo
        int chaveSt = Integer.parseInt(System.getenv("CHAVE_CRIPTOGRAFIA")); // Obtém a chave de criptografia do ambiente

        // Itera sobre cada caractere da senha
        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            // Criptografa letras minúsculas
            if (Character.isLowerCase(caractere)) {
                int novaPosicao = (alfabetoMinusculo.indexOf(caractere) + chaveSt) % alfabetoMinusculo.length();
                char novaLetra = alfabetoMinusculo.charAt(novaPosicao);
                senhaCriptografada.append(novaLetra);
            }
            // Criptografa letras maiúsculas
            else if (Character.isUpperCase(caractere)) {
                int novaPosicao = (alfabetoMaiusculo.indexOf(caractere) + chaveSt) % alfabetoMaiusculo.length();
                char novaLetra = alfabetoMaiusculo.charAt(novaPosicao);
                senhaCriptografada.append(novaLetra);
            }
            // Criptografa dígitos
            else if (Character.isDigit(caractere)) {
                int novoDigito = (Character.getNumericValue(caractere) + chaveSt) % 10; // Limita a 0-9
                senhaCriptografada.append(novoDigito);
            }
            // Mantém caracteres não alfabéticos e não numéricos
            else {
                senhaCriptografada.append(caractere);
            }
        }

        return senhaCriptografada.toString(); // Retorna a senha criptografada
    }
}
