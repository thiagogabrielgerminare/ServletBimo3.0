package Dao;

import java.sql.PreparedStatement; // Importa a classe para executar instruções SQL preparadas
import java.sql.ResultSet; // Importa a classe para manipular resultados de consultas SQL
import java.sql.SQLException; // Importa a classe para tratar exceções relacionadas ao SQL
import Conexao.Conexao;
import Modelos.PlanoPagamento;


// Classe responsável pela manipulação de planos de pagamento
public class PlanoPagamentoDAO {
    private PreparedStatement pstmt; // Objeto para executar comandos SQL preparados
    Conexao conexao = new Conexao();// Instância da classe de conexão com o banco de dados;

    // Construtor da classe
    public PlanoPagamentoDAO() {
    }

    // Método para inserir um novo plano de pagamento
    public int inserirPlanoPagamento(PlanoPagamento planoP) {
        this.conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para inserção
            this.pstmt = this.conexao.getConn().prepareStatement("INSERT INTO PLANO_PAGAMENTO (sId, cNome, cDescricao, fValor) VALUES(?,?,?,?)");
            // Define os valores dos parâmetros
            this.pstmt.setInt(1, planoP.getsId());
            this.pstmt.setString(2, planoP.getcNome());
            this.pstmt.setString(3, planoP.getcDescricao());
            this.pstmt.setDouble(2, planoP.getfValor());
            // Executa a inserção e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar a descrição por ID
    public int alterarDescricao(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização da descrição
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE PLANO_PAGAMENTO SET CDESCRICAO = ? WHERE SID = ?");
            // Define os parâmetros
            pstmt.setString(1, planoP.getcDescricao()); // Atualiza a descrição
            pstmt.setInt(2, planoP.getsId()); // Define o ID do plano a ser atualizado
            // Executa a atualização e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para alterar o valor por ID
    public int alterarValor(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para atualização do valor
            this.pstmt = this.conexao.getConn().prepareStatement("UPDATE PLANO_PAGAMENTO SET FVALOR = ? WHERE SID = ?");
            // Define os parâmetros
            pstmt.setDouble(1, planoP.getfValor()); // Atualiza o valor
            pstmt.setInt(2, planoP.getsId()); // Define o ID do plano a ser atualizado
            // Executa a atualização e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para remover um plano de pagamento por ID
    public int removerPlanoPagamento(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para remoção
            this.pstmt = conexao.getConn().prepareStatement("UPDATE PLANOPAGAMENTO SET bisUpdated = false WHERE sId = ?");
            // Define o parâmetro
            pstmt.setInt(1, planoP.getsId()); // Define o ID do plano a ser removido
            // Executa a remoção e retorna o número de linhas afetadas
            return pstmt.executeUpdate();
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return -1; // Retorna -1 em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para buscar todos os planos de pagamento
    public ResultSet buscarTodosPlanoPagamento() {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de todos os planos
            this.pstmt = this.conexao.getConn().prepareStatement("SELECT * FROM PLANO_PAGAMENTO");
            // Executa a consulta e armazena o resultado no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset; // Retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para buscar um plano de pagamento por ID
    public ResultSet buscarPlanoPagamentoPorId(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por ID
            this.pstmt = conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE SID = ?");
            pstmt.setInt(1, planoP.getsId()); // Define o ID do plano a ser buscado
            // Executa a consulta e armazena o resultado no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset; // Retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para buscar um plano de pagamento por valor
    public ResultSet buscarPlanoPagamentoPorValor(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por valor
            this.pstmt = conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE FVALOR = ?");
            pstmt.setDouble(1, planoP.getfValor()); // Define o valor do plano a ser buscado
            // Executa a consulta e armazena o resultado no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset; // Retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }

    // Método para buscar um plano de pagamento por descrição
    public ResultSet buscarPorDescricao(PlanoPagamento planoP) {
        conexao.conectar(); // Abre a conexão com o banco de dados
        try {
            // Prepara a instrução SQL para seleção de um plano por descrição
            this.pstmt = conexao.getConn().prepareStatement("SELECT * from PLANO_PAGAMENTO WHERE CDESCRICAO = ?");
            pstmt.setString(1, planoP.getcDescricao()); // Define a descrição do plano a ser buscado
            // Executa a consulta e armazena o resultado no ResultSet
            ResultSet rset = pstmt.executeQuery();
            return rset; // Retorna o ResultSet com os resultados
        } catch (SQLException sqle) {
            sqle.printStackTrace(); // Imprime a pilha de erros em caso de exceção
            return null; // Retorna null em caso de erro
        } finally {
            conexao.desconectar(); // Fecha a conexão com o banco de dados
        }
    }
}
