package Dao;

import Conexao.Conexao;
import Modelos.Usuario;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    public boolean removerUsuario(Usuario user){
        Conexao conexao = new Conexao();
        PreparedStatement pstm;
        try{
            conexao.conectar();
            pstm = conexao.getConn().prepareStatement("UPDATE USUARIO SET bisUpdated = false WHERE sId = ?");
            pstm.setInt(1, user.getsId());
            return true;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
}
