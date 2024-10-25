package Modelos;

public class CategoriaCurso {
    private int sId;                 // Id da categoria
    private String cNome;            // Nome da categoria
    private boolean bis_inactive;     // Indica se a categoria está inativa
    private boolean bis_updated;       // Indica se a categoria foi atualizada
    private boolean btransaction_made; // Indica se uma transação foi realizada

    public CategoriaCurso(String cNome) {
        this.cNome = cNome;
    } // construtor para cadastro

    public CategoriaCurso(int sId) {
        this.sId = sId;
    } // construtor para remoção

    public CategoriaCurso(int sId, String cNome) { //construtor para alteração
        this.sId = sId;
        if (cNome != null && !cNome.isEmpty()) {
            this.cNome = cNome;
        }
    }

    public boolean isBis_updated() {
        return bis_updated;
    }

    public void setBis_updated(boolean bis_updated) {
        this.bis_updated = bis_updated;
    }

    public boolean isBtransaction_made() {
        return btransaction_made;
    }

    public void setBtransaction_made(boolean btransaction_made) {
        this.btransaction_made = btransaction_made;
    }

    public boolean isBis_inactive() {
        return bis_inactive;
    }

    public void setBis_inactive(boolean bis_inactive) {
        this.bis_inactive = bis_inactive;
    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome;
    }

    public int getsId() {
        return sId;
    }

    @Override
    public String toString() {
        return "CategoriaCurso{" +
                "bis_updated=" + this.bis_updated +
                ", btransaction_made=" + this.btransaction_made +
                ", bis_inactive=" + this.bis_inactive +
                ", cNome='" + this.cNome + '\'' +
                '}';
    }
}
