package Dao;

import Conexao.Conexao;
import Modelos.CategoriaCurso;
import Modelos.CategoriaProduto;
import Modelos.MidiaCurso;
import Modelos.PlanoPagamento;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MidiaCursoDAO{
    private PreparedStatement pstmt; // Objeto para executar comandos SQL preparados
    Conexao conn = new Conexao();// Instância da classe de conexão com o banco de dados;

    public int removerMidiaCurso(MidiaCurso midiaCurso) {
        conn.conectar();
        try {
            this.pstmt = conn.getConn().prepareStatement("UPDATE MIDIACURSO SET bisUpdated = false WHERE sId = ?");
            pstmt.setInt(1, midiaCurso.getsId());
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conn.desconectar();
        }
    }

    public int inserirMidiaCurso(MidiaCurso midiaCurso) {
        this.conn.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para inserção
            this.pstmt = this.conn.getConn().prepareStatement("INSERT INTO MIDIACURSO (cUrlFoto) VALUES(?)");
            // Define os valores dos parâmetros
            this.pstmt.setString(1, midiaCurso.getcURLFoto());
            // Executa a inserção e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conn.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    public int alterarMidiaCursoFoto(MidiaCurso midiaCurso) {
        conn.conectar(); // Abre a conexão com o banco
        try {
            // Prepara a instrução SQL para atualização
            pstmt = conn.getConn().prepareStatement("UPDATE CATEGORIAPRODUTO SET CURLFOTO = ? WHERE SID = ?");
            pstmt.setString(1, midiaCurso.getcURLFoto()); // Define o valor do novo nome
            pstmt.setInt(2, midiaCurso.getsId()); // Define o valor do parâmetro SID
            return pstmt.executeUpdate(); // Executa a atualização e retorna o número de linhas afetadas
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conn.desconectar(); // Fecha a conexão
        }
    }

}

