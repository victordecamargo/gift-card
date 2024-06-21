package projeto_final_bloco_01.model;


import projeto_final_bloco_01.repository.GiftCardRepository;

public abstract class GiftCard implements GiftCardRepository {
    private String codigo;
    private double saldo;

    public GiftCard() {
    }

    public GiftCard(String codigo, double saldo) {
        this.codigo = codigo;
        this.saldo = saldo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
