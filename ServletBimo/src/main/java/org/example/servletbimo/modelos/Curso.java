package Modelos;

public class Curso {
    // Atributos do curso
    private int sId;                // ID do curso
    private int idCategoriaCurso; // ID da categoria do curso
    private String cNome;            // Nome do curso
    private double fValor;           // Valor do curso
    private boolean bis_inactive;    // Indica se o curso está inativo
    private boolean bis_updated;      // Indica se o curso foi atualizado
    private String cDescricao;       // Descrição do curso
    private boolean bStatus;         // Status do curso (ativo/inativo)
    private int iNumeroInscricao;    // Número de inscrições
    private String cDuracao;         // Duração do curso
    private boolean btransaction_made; // Indica se uma transação foi realizada

    // Construtor para inicializar os atributos
    public Curso(int idCategoriaCurso, String cNome, double fValor,
                 boolean bis_inactive, boolean bis_updated, String cDescricao,
                 boolean bStatus, int iNumeroInscricao, String cDuracao,
                 boolean btransaction_made) {
        this.idCategoriaCurso = idCategoriaCurso;
        this.cNome = cNome;
        this.fValor = fValor;
        this.bis_inactive = bis_inactive;
        this.bis_updated = bis_updated;
        this.cDescricao = cDescricao;
        this.bStatus = bStatus;
        this.iNumeroInscricao = iNumeroInscricao;
        this.cDuracao = cDuracao;
        this.btransaction_made = btransaction_made;
    }

    public Curso(int sId) {
        this.sId = sId;
    } // construtor para remoção

    // Getters e Setters

    public int getsId() {
        return sId;
    }

    public int getIdCategoriaCurso() {
        return idCategoriaCurso; // Retorna ID da categoria
    }

    public void setIdCategoriaCurso(int cCategoria) {
        this.idCategoriaCurso = cCategoria; // Atualiza ID da categoria
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome;
    }

    public double getfValor() {
        return fValor;
    }

    public void setfValor(double fValor) {
        this.fValor = fValor;
    }

    public boolean isBis_inactive() {
        return bis_inactive;
    }

    public void setBis_inactive(boolean bis_inactive) {
        this.bis_inactive = bis_inactive;
    }

    public boolean isBis_updated() {
        return bis_updated;
    }

    public void setBis_updated(boolean bis_updated) {
        this.bis_updated = bis_updated;
    }

    public String getcDescricao() {
        return cDescricao;
    }

    public void setcDescricao(String cDescricao) {
        this.cDescricao = cDescricao;
    }

    public boolean getbStatus() {
        return bStatus;
    }

    public void setbStatus(boolean bStatus) {
        this.bStatus = bStatus;
    }

    public int getiNumeroInscricao() {
        return iNumeroInscricao;
    }

    public void setiNumeroInscricao(int iNumeroInscricao) {
        this.iNumeroInscricao = iNumeroInscricao;
    }

    public String getcDuracao() {
        return cDuracao;
    }

    public void setcDuracao(String cDuracao) {
        this.cDuracao = cDuracao;
    }

    public boolean isBtransaction_made() {
        return btransaction_made;
    }

    public void setBtransaction_made(boolean btransaction_made) {
        this.btransaction_made = btransaction_made; // Atualiza estado da transação
    }

    // Método toString para exibir informações do curso
    public String toString() {
        return "Curso{" +
                "Categoria='" + idCategoriaCurso + '\'' +
                ", Nome='" + cNome + '\'' +
                ", Valor=" + fValor +
                ", Is_inactive=" + bis_inactive +
                ", Is_updated=" + bis_updated +
                ", Descricao='" + cDescricao + '\'' +
                ", Status=" + bStatus +
                ", NumeroInscricao=" + iNumeroInscricao +
                ", Duracao='" + cDuracao + '\'' +
                ", Transaction_made=" + btransaction_made +
                '}';
    }
}
