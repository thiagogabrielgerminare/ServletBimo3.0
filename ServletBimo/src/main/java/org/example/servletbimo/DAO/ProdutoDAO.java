package Dao;
import Conexao.Conexao;
import Modelos.Produto;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    Conexao conexao = new Conexao();
    PreparedStatement pstm;

    public boolean removerProduto(Produto prod){
        try{
            conexao.conectar();
            pstm = conexao.getConn().prepareStatement("UPDATE PRODUTO SET bisUpdated = false WHERE sId = ?");
            pstm.setInt(1, prod.getsId());
            return true;
        }catch(SQLException sqle){
            sqle.printStackTrace();
            return false;
        }finally {
            conexao.desconectar();
        }
    }
}
