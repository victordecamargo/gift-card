package projeto_final_bloco_01.controller;

import java.util.Scanner;

import projeto_final_bloco_01.model.GiftCard;
import projeto_final_bloco_01.model.GiftCardFisico;
import projeto_final_bloco_01.model.GiftCardVirtual;
import projeto_final_bloco_01.repository.GiftCardRepository;

public class GiftCardController implements GiftCardRepository {

    @Override
    public void cadastrar(Scanner sc) {
        System.out.println("Escolha o tipo de Gift Card:");
        System.out.println("1 - Gift Card Físico");
        System.out.println("2 - Gift Card Virtual ");
        int tipo = sc.nextInt();
        sc.nextLine();

        GiftCard giftCard;

        switch (tipo) {

            case 1:
                giftCard = cadastrarGiftCardFisico(sc);
                break;
            case 2:
                giftCard = cadastrarGiftCardVirtual(sc);
                break;
            default:
                System.out.println("Opção inválida. Cadastro cancelado.");
                return;
        }


    }

    private GiftCardFisico cadastrarGiftCardFisico(Scanner sc) {
        System.out.print("Digite o código do Gift Card Físico: ");
        String codigo = sc.nextLine();
        System.out.print("Digite o saldo do Gift Card Físico: ");
        double saldo = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite o endereço de entrega do Gift Card Físico: ");
        String enderecoEntrega = sc.nextLine();

        return new GiftCardFisico(codigo, saldo, enderecoEntrega);
    }

    private GiftCardVirtual cadastrarGiftCardVirtual(Scanner sc) {
        System.out.print("Digite o código do Gift Card Virtual: ");
        String codigo = sc.nextLine();
        System.out.print("Digite o saldo do Gift Card Virtual: ");
        double saldo = sc.nextDouble();
        sc.nextLine();
        System.out.print("Digite o email do destinatário do Gift Card Virtual: ");
        String emailDestinatario = sc.nextLine();

        return new GiftCardVirtual(codigo, saldo, emailDestinatario);
    }

}

