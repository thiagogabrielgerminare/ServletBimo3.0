package org.example.servletbimo.controller.cadastrar;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.servletbimo.DAO.AdministradorDAO;
import org.example.servletbimo.models.Administrador;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Define a servlet que responde a requisições no caminho "/cadastrarAdm"
@WebServlet(name = "cadastrarAdm", value = "/cadastrarAdm")
public class CadastrarAdministrador extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdministradorDAO administradorDAO = new AdministradorDAO();

        // Obtém os parâmetros do formulário de cadastro
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        // Criptografa a senha fornecida
        String senhaCriptografada = criptografarSenha(senha);

        if (verificarSenha(senha)) {
            if (administradorDAO.verificarAdministrador(email) && verificarEmail(email)){
                // Cria um novo objeto Administrador com os dados capturados
                Administrador administrador = new Administrador(nome, email, senhaCriptografada);

                // Instancia o DAO para realizar a inserção no banco de dados
                boolean sucesso = administradorDAO.inserirAdministrador(administrador); // Tenta inserir o administrador

                // Define o resultado da operação como atributo da requisição
                if (sucesso) {
                    request.setAttribute("resultado", "cadastro realizado com sucesso!"); // Sucesso
                    // Redireciona a requisição para a página de cadastro
                    request.getRequestDispatcher("confirmacao.jsp").forward(request, response);
                } else {
                    request.setAttribute("resultado", "Erro ao cadastrar!"); // Falha
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("resultado", "Email inválido! Certifique-se de que não existe nenhum administrador cadastrado com esse email e que ele segue o padrão correto.");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("resultado", "Senha inválida! Certifique-se de que a senha tem mais de 8 caracteres e contém letras maiúsculas, números e caracteres especiais.");
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    // Método para criptografar a senha
    public String criptografarSenha(String senha) {
        StringBuilder senhaCriptografada = new StringBuilder(); // StringBuilder para construir a senha criptografada
        String alfabetoMinusculo = "abcdefghijklmnopqrstuvwxyz"; // Alfabeto minúsculo
        String alfabetoMaiusculo = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Alfabeto maiúsculo
        int chaveSt = Integer.parseInt(System.getenv("CHAVE_CRIPTOGRAFIA")); // Obtém a chave de criptografia do ambiente

        // Itera sobre cada caractere da senha
        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);

            // Verifica se o caractere é uma letra minúscula
            if (Character.isLowerCase(caractere)) {
                // Calcula a nova posição do caractere e adiciona ao resultado
                int novaPosicao = (alfabetoMinusculo.indexOf(caractere) + chaveSt) % alfabetoMinusculo.length();
                char novaLetra = alfabetoMinusculo.charAt(novaPosicao);
                senhaCriptografada.append(novaLetra); // Adiciona a nova letra à senha criptografada
            }
            // Verifica se o caractere é uma letra maiúscula
            else if (Character.isUpperCase(caractere)) {
                // Calcula a nova posição do caractere e adiciona ao resultado
                int novaPosicao = (alfabetoMaiusculo.indexOf(caractere) + chaveSt) % alfabetoMaiusculo.length();
                char novaLetra = alfabetoMaiusculo.charAt(novaPosicao);
                senhaCriptografada.append(novaLetra); // Adiciona a nova letra à senha criptografada
            }
            // Verifica se o caractere é um dígito
            else if (Character.isDigit(caractere)) {
                // Calcula o novo dígito e adiciona ao resultado (limita entre 0-9)
                int novoDigito = (Character.getNumericValue(caractere) + chaveSt) % 10;
                senhaCriptografada.append(novoDigito); // Adiciona o novo dígito à senha criptografada
            } else {
                // Mantém caracteres que não são letras nem dígitos inalterados
                senhaCriptografada.append(caractere);
            }
        }

        // Retorna a senha criptografada como uma string
        return senhaCriptografada.toString();
    }

    //Metodo com regex para verificar email;
    public static boolean verificarEmail(String email){
        String regexEmail = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        try{
            // Cria um objeto Pattern compilando o padrão
            Pattern pattern = Pattern.compile(regexEmail);
            // Cria um objeto Matcher chamando o metodo matcher no objeto Pattern, passando a string de email de entrada
            Matcher verificacao = pattern.matcher(email);
            if(verificacao.matches()){
                return true;
            }else{
                return false;
            }
        }catch(InputMismatchException ime){
            ime.printStackTrace();
            return false;
        }
    }

    //Metodo com regex para verificar senha;
    public static boolean verificarSenha(String senha){
        String regexSenha = "^(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        try{
            // Cria um objeto Pattern compilando o padrão
            Pattern pattern = Pattern.compile(regexSenha);
            // Cria um objeto Matcher chamando o método matcher no objeto Pattern, passando a string de email de entrada
            Matcher verificacao = pattern.matcher(senha);
            if(verificacao.matches()){
                return true;
            }else{
                return false;
            }
        }catch(InputMismatchException ime){
            ime.printStackTrace();
            return false;
        }
    }
}
