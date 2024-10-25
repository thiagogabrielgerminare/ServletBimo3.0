package org.example.servletbimo.DAO;

public class mainTeste {

    public static void main(String[] args) {
        Conexao conexao = new Conexao();

        // Tenta estabelecer a conexão com o banco de dados
        if (conexao.conectar()) {
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            // Desconecta do banco após a verificação
            conexao.desconectar();
            System.out.println("Conexão com o banco de dados encerrada.");
        } else {
            System.out.println("Falha ao conectar com o banco de dados.");
        }
    }

}
