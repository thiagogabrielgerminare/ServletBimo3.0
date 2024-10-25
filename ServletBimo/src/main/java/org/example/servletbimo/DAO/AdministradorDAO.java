package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.Conexao;
import Modelos.Administrador;

import java.util.InputMismatchException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


// Classe responsável pela manipulação de administradores
public class AdministradorDAO {
    private PreparedStatement pstmt; // Objeto para executar comandos SQL
    private ResultSet rs; // Objeto para armazenar resultados de consultas
    private Conexao conexao = new Conexao(); // Instância da classe de conexão ao banco de dados

    // Construtor da classe
    public AdministradorDAO() {}

    // Método para inserir um novo administrador
    public int inserirAdministrador(Administrador adm) {

        this.conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para inserção
            this.pstmt = this.conexao.getConn().prepareStatement("INSERT INTO ADMINISTRADOR (CNOME, CEMAIL, CSENHA) VALUES(?,?,?)");
            this.pstmt.setString(1, adm.getcNome()); // Define o valor do parâmetro CNOME
            this.pstmt.setString(2, adm.getcEmail()); // Define o valor do parâmetro CEMAIL
            this.pstmt.setString(3, adm.getcSenha()); // Define o valor do parâmetro CSENHA
            return pstmt.executeUpdate(); // Executa a inserção e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para remover um administrador pelo SID
    public int removerAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {

            // Prepara a instrução SQL para remoção
            this.pstmt = conexao.getConn().prepareStatement("DELETE FROM ADMINISTRADOR WHERE SID = ?");
            pstmt.setInt(1, adm.getsId()); // Define o valor do parâmetro SID
            return pstmt.executeUpdate(); // Executa a remoção e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar o nome de um administrador
    public int alterarNomeAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CNOME = ? WHERE SID = ?");
            pstmt.setString(1, adm.getcNome()); // Define o novo nome
            pstmt.setInt(2, adm.getsId()); // Define o valor do parâmetro SID
            return pstmt.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar o email de um administrador
    public int alterarEmailAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CEMAIL = ? WHERE SID = ?");
            pstmt.setString(1, adm.getcEmail()); // Define o novo email
            pstmt.setInt(2, adm.getsId()); // Define o valor do parâmetro SID
            return pstmt.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para alterar a senha de um administrador
    public int alterarSenhaAdministrador(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE ADMINISTRADOR SET CSENHA = ? WHERE SID = ?");
            pstmt.setString(1, adm.getcSenha()); // Define a nova senha
            pstmt.setInt(2, adm.getsId()); // Define o valor do parâmetro SID
            return pstmt.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar todos os administradores
    public ResultSet buscarTodosAdministradores() {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca
            this.pstmt = this.conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR");
            // Executa a busca e retorna o ResultSet com os resultados
            return pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar um administrador pelo SID
    public ResultSet buscarAdministradorPorId(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por ID
            this.pstmt = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE SID = ?");
            pstmt.setInt(1, adm.getsId()); // Define o valor do parâmetro SID
            return pstmt.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar um administrador pelo nome
    public ResultSet buscarAdministradorPorNome(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por nome
            this.pstmt = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE CNOME = ?");
            pstmt.setString(1, adm.getcNome()); // Define o valor do parâmetro CNOME
            return pstmt.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }

    // Método para buscar um administrador pelo email
    public ResultSet buscarAdministradorPorEmail(Administrador adm) {
        conexao.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para busca por email
            this.pstmt = conexao.getConn().prepareStatement("SELECT * FROM ADMINISTRADOR WHERE CEMAIL = ?");
            pstmt.setString(1, adm.getcEmail()); // Define o valor do parâmetro CEMAIL
            return pstmt.executeQuery(); // Executa a busca e retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão
        }
    }
}
