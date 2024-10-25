package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Conexao.Conexao;
import Modelos.CategoriaCurso;

public class CategoriaCursoDAO {
    private PreparedStatement pstmt;
    private ResultSet rs;
    Conexao conexao = new Conexao();

    public CategoriaCursoDAO() {}

    public int inserirCategoria(CategoriaCurso catC) {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("INSERT INTO CATEGORIACURSO(CNOME) VALUES (?)");
            this.pstmt.setString(1, catC.getcNome());
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    // Remover
    public int removerCategoriaCurso(CategoriaCurso catC) {
        conexao.conectar();
        try {
            this.pstmt = conexao.getConn().prepareStatement("UPDATE CATEGORIACURSO SET bisUpdated = false WHERE sId = ?");
            pstmt.setInt(1, catC.getsId());
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    // Alterar Nome
    public int alterarNome(CategoriaCurso catC) {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE CATEGORIACURSO SET CNOME = ? WHERE sId = ?");
            pstmt.setString(1, catC.getcNome());
            pstmt.setInt(2, catC.getsId());
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    // Buscar Categoria de Serviço
    public ResultSet buscar() {
        conexao.conectar();
        try {
            this.pstmt = this.conexao.getConn().prepareStatement("SELECT * FROM CATEGORIACURSO");
            return pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } // connection is not closed here as ResultSet is being returned
    }


    // Buscar por ID
    public ResultSet buscarPorId(CategoriaCurso catC) {
        conexao.conectar();
        try {
            this.pstmt = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIACURSO WHERE sId = ?");
            pstmt.setInt(1, catC.getsId());
            return pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } // connection is not closed here as ResultSet is being returned
    }

    // Buscar por Nome
    public ResultSet buscarPorNome(CategoriaCurso catC) {
        conexao.conectar();
        try {
            this.pstmt = conexao.getConn().prepareStatement("SELECT * FROM CATEGORIACURSO WHERE CNOME = ?");
            pstmt.setString(1, catC.getcNome());
            return pstmt.executeQuery();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        } // connection is not closed here as ResultSet is being returned
    }
}

