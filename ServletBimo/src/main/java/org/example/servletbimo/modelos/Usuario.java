package Modelos;

import java.util.Date;

public class Usuario {
    private int sId;
    private String cCnpj;
    private Date dDataCriacao;
    private Date dDataNascimento;
    private String ctelefone;
    private String cSobrenome;
    private String cSenha;
    private String cCpf;
    private String cNome;
    private String cEmail;

    public Usuario(int sId) {
        this.sId = sId;
    } // construtor para remoção

    public String getcCnpj() {
        return cCnpj;
    }

    public void setcCnpj(String cCnpj) {
        this.cCnpj = cCnpj;
    }

    public Date getdDataCriacao() {
        return dDataCriacao;
    }

    public void setdDataCriacao(Date dDataCriacao) {
        this.dDataCriacao = dDataCriacao;
    }

    public Date getdDataNascimento() {
        return dDataNascimento;
    }

    public void setdDataNascimento(Date dDataNascimento) {
        this.dDataNascimento = dDataNascimento;
    }

    public String getCtelefone() {
        return ctelefone;
    }

    public void setCtelefone(String ctelefone) {
        this.ctelefone = ctelefone;
    }

    public String getcSobrenome() {
        return cSobrenome;
    }

    public void setcSobrenome(String cSobrenome) {
        this.cSobrenome = cSobrenome;
    }

    public String getcSenha() {
        return cSenha;
    }

    public void setcSenha(String cSenha) {
        this.cSenha = cSenha;
    }

    public String getcCpf() {
        return cCpf;
    }

    public void setcCpf(String cCpf) {
        this.cCpf = cCpf;
    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public int getsId() {
        return sId;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "cCnpj='" + this.cCnpj + '\'' +
                ", dDataCriacao=" + this.dDataCriacao +
                ", dDataNascimento=" + this.dDataNascimento +
                ", ctelefone='" + this.ctelefone + '\'' +
                ", cSobrenome='" + this.cSobrenome + '\'' +
                ", cSenha='" + this.cSenha + '\'' +
                ", cCpf='" + this.cCpf + '\'' +
                ", cNome='" + this.cNome + '\'' +
                ", cEmail='" + this.cEmail + '\'' +
                '}';
    }
}
