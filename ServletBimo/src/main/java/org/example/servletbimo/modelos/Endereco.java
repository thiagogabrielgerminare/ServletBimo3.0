package Modelos;

public class Endereco {
    private String cRua;
    private String cCep;
    private String cEstado;
    private int iNumero;
    private String cBairro;

    public String getcRua() {
        return cRua;
    }

    public void setcRua(String cRua) {
        this.cRua = cRua;
    }

    public String getcCep() {
        return cCep;
    }

    public void setcCep(String cCep) {
        this.cCep = cCep;
    }

    public String getcEstado() {
        return cEstado;
    }

    public void setcEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public int getiNumero() {
        return iNumero;
    }

    public void setiNumero(int iNumero) {
        this.iNumero = iNumero;
    }

    public String getcBairro() {
        return cBairro;
    }

    public void setcBairro(String cBairro) {
        this.cBairro = cBairro;
    }

    public Endereco(String cRua, String cCep, String cEstado, int iNumero, String cBairro) {
        this.cRua = cRua;
        this.cCep = cCep;
        this.cEstado = cEstado;
        this.iNumero = iNumero;
        this.cBairro = cBairro;
    }
}
