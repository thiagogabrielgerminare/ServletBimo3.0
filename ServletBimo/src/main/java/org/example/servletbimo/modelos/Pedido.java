package Modelos;

import java.util.Date;

public class Pedido {
    private double fValorTotal;
    private String cTipoPagamento;
    private int iQuantidade;
    private String cStatus;
    private Date dDataPedido;

    public double getfValorTotal() {
        return fValorTotal;
    }

    public void setfValorTotal(double fValorTotal) {
        this.fValorTotal = fValorTotal;
    }

    public String getcTipoPagamento() {
        return cTipoPagamento;
    }

    public void setcTipoPagamento(String cTipoPagamento) {
        this.cTipoPagamento = cTipoPagamento;
    }

    public int getiQuantidade() {
        return iQuantidade;
    }

    public void setiQuantidade(int iQuantidade) {
        this.iQuantidade = iQuantidade;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public Date getdDataPedido() {
        return dDataPedido;
    }

    public void setdDataPedido(Date dDataPedido) {
        this.dDataPedido = dDataPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "fValorTotal=" + this.fValorTotal +
                ", cTipoPagamento='" + this.cTipoPagamento + '\'' +
                ", iQuantidade=" + this.iQuantidade +
                ", cStatus='" + this.cStatus + '\'' +
                ", dDataPedido=" + this.dDataPedido +
                '}';
    }
}
