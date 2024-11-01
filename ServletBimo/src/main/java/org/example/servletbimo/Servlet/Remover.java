//package org.example.servletbimo.Servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.example.servletbimo.models.*;
//
//import java.io.IOException;
//
//@WebServlet(name = "addAdm", value = "/addadm")
//public class Remover extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Obtém a ação do formulário
//        String action = request.getParameter("action");
//
//        // Tratamento de ações
//        if (action != null) {
//            switch (action) {
//                case "remover-adm":
//                    removerAdministrador(request, response);
//                    break;
//                case "remover-plano":
//                    removerPlanoPagamento(request, response);
//                    break;
//                case "remover-categoria-curso":
//                    removerCategoriaCurso(request, response);
//                    break;
//                case "remover-categoria-produto":
//                    removerCategoriaProduto(request, response);
//                    break;
//                case "remover-usuario":
//                    removerUsuario(request, response);
//                    break;
//                case "remover-produto":
//                    removerProduto(request, response);
//                    break;
//                case "remover-curso":
//                    removerCurso(request, response);
//                    break;
//                default:
//                    // Ação não reconhecida
//                    response.sendRedirect("erro.jsp");
//            }
//        }
//    }
//
//    private void removerAdministrador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        Administrador administrador = new Administrador(id);
//
////        AdministradorDAO administradorDAO = new AdministradorDAO();
////        administradorDAO.removerAdministrador(administrador);
//    }
//
//    private void removerPlanoPagamento(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        PlanoPagamento planoPagamento = new PlanoPagamento(id);
//
////        PlanoPagamentoDAO planoPagamentoDAO = new PlanoPagamentoDAO();
////        planoPagamentoDAO.removerPlanoPagamento(planoPagamento);
//    }
//
//    private void removerCategoriaCurso(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        CategoriaCurso categoriaCurso = new CategoriaCurso(id);
//
////        CategoriaCursoDAO categoriaCursoDAO = new CategoriaCursoDAO();
////        categoriaCursoDAO.removerCategoriaCurso(categoriaCurso);
//    }
//
//    private void removerCategoriaProduto(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        CategoriaProduto categoriaProduto = new CategoriaProduto(id);
//
////        CategoriaProdutoDAO categoriaProdutoDAO = new CategoriaProdutoDAO();
////        categoriaProdutoDAO.removerCategoriaProduto(categoriaProduto);
//    }
//
//    private void removerUsuario(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        Usuario usuario = new Usuario(id);
//
////        UsuarioDAO usuarioDAO = new UsuarioDAO();
////        usuarioDAO.removerUsuario(usuario);
//    }
//
//    private void removerProduto(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        Produto produto = new Produto(id);
//
////        ProdutoDAO produtoDAO = new ProdutoDAO();
////        produtoDAO.removerProduto(produto);
//    }
//
//    private void removerCurso(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//
//        Curso curso = new Curso(id);
//
////        CursoDAO cursoDAO = new CursoDAO();
////        cursoDAO.removerCurso(curso);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        request.getRequestDispatcher("/remocao.jsp").forward(request, response);
//    }
//}
