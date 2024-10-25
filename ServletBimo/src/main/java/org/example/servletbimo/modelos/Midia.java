package Modelos;

public class Midia {
    private int sId;
    private String cURLFoto;
    private boolean bis_inactive;     // Indica se a categoria está inativa
    private boolean bis_updated;       // Indica se a categoria foi atualizada
    private boolean btransaction_made;

    public Midia(int sId) { // Construtor para remoção
        this.sId = sId;
    } // Construtor para remoção

    public String getcURLFoto() {
        return cURLFoto;
    }

    public void setcURLFoto(String cURLFoto) {
        this.cURLFoto = cURLFoto;
    }

    public Midia(String cURLFoto) {
        this.cURLFoto = cURLFoto;
    }
}
