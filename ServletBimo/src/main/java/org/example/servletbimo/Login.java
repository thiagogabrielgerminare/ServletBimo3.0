package org.example.servletbimo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Credenciais válidas (por simplicidade, definidas fixamente)
    private final String validEmail = "bimo@gmail.com"; //Falta conectar o DAO
    private final String validPassword = "123"; //Falta conectar o DAO

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Captura o email e senha do formulário
        String emailADM = request.getParameter("email");
        String senhaADM = request.getParameter("senha");

        if (emailADM != null && senhaADM != null) {
            if (emailADM.equals(validEmail) && senhaADM.equals(validPassword)) {
                // Redireciona para a página de administração se as credenciais forem válidas
                response.sendRedirect("admin.html");
                // Obtém a ação do formulário
                String action = request.getParameter("action");
                // Tratamento de ações
                if (action != null) {
                    switch (action) {
                        case "cadastrarAdministrador":
                            cadastrarAdministrador(request, response);
                            break;
                        case "cadastrarPlanoPagamento":
                            cadastrarPlanoPagamento(request, response);
                            break;
                        case "cadastrarCategoriaCurso":
                            cadastrarCategoriaCurso(request, response);
                            break;
                        case "cadastrarCategoriaProduto":
                            cadastrarCategoriaProduto(request, response);
                            break;
                        case "removerAdministrador":
                            removerAdministrador(request, response);
                            break;
                        case "removerPlanoPagamento":
                            removerPlanoPagamento(request, response);
                            // Outros casos de remoção e alteração
                        default:
                            // Ação não reconhecida
                            response.sendRedirect("erro.jsp");
                    }
                }
            } else {
                // Redireciona para a página de erro se as credenciais forem inválidas, com parâmetro de erro
                response.sendRedirect("erro_login.jsp?erro=true");
            }
        } else {
            // Em caso de parâmetros nulos, redireciona para a página de erro
            response.sendRedirect("erro_login.jsp?erro=true");
        }
    }

    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-MÉTODOS CADASTRAR-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-
    private void cadastrarAdministrador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Administrador administrador = new Administrador(nome, email, senha);
        // DAO
    }

    private void cadastrarPlanoPagamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        Double valor = Double.parseDouble(request.getParameter("valor"));
        String descricao = request.getParameter("descricao");

        PlanoPagamento planoPagamento = new PlanoPagamento(descricao, nome, valor);
        // DAO

    }

    private void cadastrarCategoriaCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        CategoriaCurso categoriaCurso = new CategoriaCurso(nome);
        // DAO
    }

    private void cadastrarCategoriaProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        CategoriaProduto categoriaProduto = new CategoriaProduto(nome);
        // DAO'
    }



    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-MÉTODOS REMOVER-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-

    private void removerAdministrador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Administrador administrador = new Administrador(id);
        // DAO
    }

    private void removerPlanoPagamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        PlanoPagamento planoPagamento = new PlanoPagamento(id);
        // DAO
    }

    private void removerCategoriaCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        CategoriaCurso categoriaCurso = new CategoriaCurso(id);
        // DAO
    }

    private void removerCategoriaProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        CategoriaProduto categoriaProduto = new CategoriaProduto(id);
        // DAO

        RequestDispatcher dispatcher = request.getRequestDispatcher("confirmacao.jsp");
        dispatcher.forward(request, response);
    }

    private void removerUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Usuario Usuario = new Usuario(id);
        // DAO
    }

    private void removerProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Produto produto = new Produto(id);
        // DAO
    }

    private void removerCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Curso curso = new Curso(id);
        // DAO
    }


    //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-MÉTODOS ALTERAR-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-

    private void alterarAdministrador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Administrador administrador = new Administrador(id, nome, email, senha);
        // DAO
    }

    private void alterarPlanoPagamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String descricao = request.getParameter("descricao");
        String nome = request.getParameter("nome");
        double valor;
        if (request.getParameter("valor") != null){
            valor = Double.parseDouble(request.getParameter("valor"));
        }
        else{
            valor = -1.0;
        }

        PlanoPagamento planoPagamento = new PlanoPagamento(id, descricao, nome, valor);
        // DAO
    }

    private void alterarCategorioCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");

        CategoriaCurso categoriaCurso = new CategoriaCurso(id, nome);
        // DAO
    }

    private void alterarCategorioProduto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");

        CategoriaProduto categoriaProduto = new CategoriaProduto(id, nome);
        // DAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}