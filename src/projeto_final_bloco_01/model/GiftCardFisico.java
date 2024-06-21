package projeto_final_bloco_01.model;

import java.util.Scanner;

public class GiftCardFisico extends GiftCard {
    private String enderecoEntrega;

    public GiftCardFisico() {
    }

    public GiftCardFisico(String codigo, double saldo, String enderecoEntrega) {
        super(codigo, saldo);
        this.enderecoEntrega = enderecoEntrega;
    }

    @Override
    public void cadastrar(Scanner sc) {
        System.out.print("Digite o código do Gift Card Físico: ");
        String codigo = sc.nextLine();
        System.out.print("Digite o saldo do Gift Card Físico: ");
        double saldo = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite o endereço de entrega do Gift Card Físico: ");
        String enderecoEntrega = sc.nextLine();

        this.setCodigo(codigo);
        this.setSaldo(saldo);
        this.setEnderecoEntrega(enderecoEntrega);
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
}
//fim