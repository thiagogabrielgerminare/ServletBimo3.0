package Modelos;

public class PlanoPagamento {
    // Atributos da classe, representando as propriedades do plano de pagamento
    private int sId;           // ID do plano
    private String cDescricao; // Descrição do plano
    private String cNome;      // Nome do plano
    private double fValor;     // Valor do plano
    private boolean bis_inactive; // Indica se o plano está inativo
    private boolean bis_updated;   // Indica se o plano foi atualizado
    private boolean btransaction_made; // Indica se uma transação foi realizada

    public PlanoPagamento(){};

    // Construtor da classe que inicializa todos os atributos
    public PlanoPagamento(String cDescricao, String cNome, double fValor,
                          boolean bis_inactive, boolean bis_updated,
                          boolean btransaction_made) {
        this.cDescricao = cDescricao;
        this.cNome = cNome;
        this.fValor = fValor;
        this.bis_inactive = bis_inactive;
        this.bis_updated = bis_updated;
        this.btransaction_made = btransaction_made;
    }

    public PlanoPagamento(String cDescricao, String cNome, Double fValor) { // construtor para cadastro
        this.cDescricao = cDescricao;
        this.cNome = cNome;
        this.fValor = fValor;
    }

    public PlanoPagamento(int sId) {
        this.sId = sId;
    } // construtor para remoção

    public PlanoPagamento(int sId, String cDescricao, String cNome, double fValor) { // construtor para alteração
        this.sId = sId;
        if (cDescricao != null && !cDescricao.isEmpty()) {
            this.cDescricao = cDescricao;
        }
        if (cNome != null && !cNome.isEmpty()) {
            this.cNome = cNome;
        }
        if (fValor >= 0) {
            this.fValor = fValor;
        }
    }

    // Getters e Setters para acessar e modificar os atributos

    public String getcDescricao() {
        return cDescricao;
    }

    public void setcDescricao(String cDescricao) {
        this.cDescricao = cDescricao; // Considerar validação de entrada
    }

    public String getcNome() {
        return cNome;
    }

    public void setcNome(String cNome) {
        this.cNome = cNome; // Considerar validação de entrada
    }

    public double getfValor() {
        return fValor;
    }

    public void setfValor(double fValor) {
        this.fValor = fValor; // Considerar evitar valores negativos
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

    public boolean isBtransaction_made() {
        return btransaction_made;
    }

    public void setBtransaction_made(boolean btransaction_made) {
        this.btransaction_made = btransaction_made;
    }

    public int getsId() {
        return sId;
    }

    // Sobrescrita do método toString para fornecer uma representação legível do objeto
    public String toString() {
        return "PlanoPagamento{" +
                "Descricao='" + cDescricao + '\'' +
                ", Nome='" + cNome + '\'' +
                ", Valor=" + fValor +
                ", Is_inactive=" + bis_inactive +
                ", Is_updated=" + bis_updated +
                ", Transaction_made=" + btransaction_made +
                '}';
    }
}
