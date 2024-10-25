package Modelos;

public class MidiaCurso {
    private int sId;
    private String cURLFoto;
    private boolean btransaction_made;
    private boolean bisInactive;
    private boolean bisUpdates;

    public MidiaCurso(int sId, String cURLFoto){ // Construtor para cadastrar e para alterar
        this.sId = sId;
        this.cURLFoto = cURLFoto;
    }

    public MidiaCurso(int sId){ // Construtor para remoção
        this.sId = sId;
    }

    public String getcURLFoto() {
        return cURLFoto;
    }

    public void setcURLFoto(String cURLFoto) {
        this.cURLFoto = cURLFoto;
    }

    public boolean isBtransaction_made() {
        return btransaction_made;
    }

    public void setBtransaction_made(boolean btransaction_made) {
        this.btransaction_made = btransaction_made;
    }

    public boolean isBisInactive() {
        return bisInactive;
    }

    public void setBisInactive(boolean bisInactive) {
        this.bisInactive = bisInactive;
    }

    public boolean isBisUpdates() {
        return bisUpdates;
    }

    public void setBisUpdates(boolean bisUpdates) {
        this.bisUpdates = bisUpdates;
    }

    public int getsId() {
        return sId;
    }

    public MidiaCurso(String cURLFoto, boolean btransaction_made, boolean bisInactive, boolean bisUpdates) {
        this.cURLFoto = cURLFoto;
        this.btransaction_made = btransaction_made;
        this.bisInactive = bisInactive;
        this.bisUpdates = bisUpdates;
    }

    @Override
    public String toString() {
        return "MidiaCurso{" +
                ", cURLFoto='" + this.cURLFoto + '\'' +
                ", btransaction_made=" + this.btransaction_made +
                ", bisInactive=" + this.bisInactive +
                ", bisUpdates=" + this.bisUpdates +
                '}';
    }
}