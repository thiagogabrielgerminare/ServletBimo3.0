package org.example.servletbimo.modelos;

public class Curso {
    // Atributos do curso
    private int sId;                // ID do curso
    private String idCategoriaCurso; // ID da categoria do curso
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
    public Curso(String idCategoriaCurso, String cNome, double fValor,
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

    public String getIdCategoriaCurso() {
        return idCategoriaCurso; // Retorna ID da categoria
    }

    public void setIdCategoriaCurso(String cCategoria) {
        this.idCategoriaCurso = cCategoria; // Atualiza ID da categoria
    }

    public String getcNome() {
        return cNome; // Retorna nome do curso
    }

    public void setcNome(String cNome) {
        this.cNome = cNome; // Atualiza nome do curso
    }

    public double getfValor() {
        return fValor; // Retorna valor do curso
    }

    public void setfValor(double fValor) {
        this.fValor = fValor; // Atualiza valor do curso
    }

    public boolean isBis_inactive() {
        return bis_inactive; // Retorna estado inativo
    }

    public void setBis_inactive(boolean bis_inactive) {
        this.bis_inactive = bis_inactive; // Atualiza estado inativo
    }

    public boolean isBis_updated() {
        return bis_updated; // Retorna estado atualizado
    }

    public void setBis_updated(boolean bis_updated) {
        this.bis_updated = bis_updated; // Atualiza estado atualizado
    }

    public String getcDescricao() {
        return cDescricao; // Retorna descrição do curso
    }

    public void setcDescricao(String cDescricao) {
        this.cDescricao = cDescricao; // Atualiza descrição do curso
    }

    public boolean isbStatus() {
        return bStatus; // Retorna status do curso
    }

    public void setbStatus(boolean bStatus) {
        this.bStatus = bStatus; // Atualiza status do curso
    }

    public int getiNumeroInscricao() {
        return iNumeroInscricao; // Retorna número de inscrições
    }

    public void setiNumeroInscricao(int iNumeroInscricao) {
        this.iNumeroInscricao = iNumeroInscricao; // Atualiza número de inscrições
    }

    public String getcDuracao() {
        return cDuracao; // Retorna duração do curso
    }

    public void setcDuracao(String cDuracao) {
        this.cDuracao = cDuracao; // Atualiza duração do curso
    }

    public boolean isBtransaction_made() {
        return btransaction_made; // Retorna estado da transação
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
