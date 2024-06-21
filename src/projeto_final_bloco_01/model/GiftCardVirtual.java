package projeto_final_bloco_01.model;

import java.util.Scanner;

public class GiftCardVirtual extends GiftCard {
    private String emailDestinatario;

    public GiftCardVirtual() {
    }

    public GiftCardVirtual(String codigo, double saldo, String emailDestinatario) {
        super(codigo, saldo);
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public void cadastrar(Scanner sc) {
        System.out.print("Digite o código do Gift Card Virtual: ");
        String codigo = sc.nextLine();
        System.out.print("Digite o saldo do Gift Card Virtual: ");
        double saldo = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite o email do destinatário do Gift Card Virtual: ");
        String emailDestinatario = sc.nextLine();

        this.setCodigo(codigo);
        this.setSaldo(saldo);
        this.setEmailDestinatario(emailDestinatario);
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }
}
//fim