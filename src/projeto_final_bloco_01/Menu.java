package projeto_final_bloco_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import projeto_final_bloco_01.model.GiftCard;
import projeto_final_bloco_01.model.GiftCardFisico;
import projeto_final_bloco_01.model.GiftCardVirtual;

public class Menu {
    private static List<GiftCard> giftCards = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine(); //

            switch (opcao) {
                case 1:
                    cadastrarGiftCard(sc);
                    break;
                case 2:
                    listarTodosGiftCards();
                    break;
                case 3:
                    buscarGiftCardPorCodigo(sc);
                    break;
                case 4:
                    atualizarGiftCard(sc);
                    break;
                case 5:
                    excluirGiftCard(sc);
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        } while (opcao != 6);

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("*****************************************************");
        System.out.println("                                                     ");
        System.out.println("                Digital Game Cards                   ");
        System.out.println("                                                     ");
        System.out.println("*****************************************************");
        System.out.println("                                                     ");
        System.out.println("            1 - Cadastrar Gift Card                  ");
        System.out.println("            2 - Listar Todos os Gift Cards           ");
        System.out.println("            3 - Buscar Gift Card por Código          ");
        System.out.println("            4 - Atualizar Gift Card                  ");
        System.out.println("            5 - Excluir Gift Card                    ");
        System.out.println("            6 - Sair                                 ");
        System.out.println("                                                     ");
        System.out.println("*****************************************************");
        System.out.println("Entre com a opção desejada:                          ");
        System.out.println("                                                     ");
    }

    private static void cadastrarGiftCard(Scanner sc) {
        System.out.println("Escolha o tipo de Gift Card:");
        System.out.println("1 - Gift Card Físico");
        System.out.println("2 - Gift Card Virtual");
        int tipo = sc.nextInt();
        sc.nextLine();

        GiftCard giftCard;

        switch (tipo) {
            case 1:
                giftCard = new GiftCardFisico();
                break;
            case 2:
                giftCard = new GiftCardVirtual();
                break;
            default:
                System.out.println("Opção inválida. Cadastro cancelado.");
                return;
        }

        giftCard.cadastrar(sc);
        giftCards.add(giftCard);
        System.out.println("Gift Card cadastrado com sucesso!");
    }

    private static void listarTodosGiftCards() {
        System.out.println("Listando todos os gift cards disponíveis...");
        for (GiftCard giftCard : giftCards) {
            System.out.println("Código: " + giftCard.getCodigo() + ", Saldo: " + giftCard.getSaldo());
            if (giftCard instanceof GiftCardFisico) {
                System.out.println("Endereço de Entrega: " + ((GiftCardFisico) giftCard).getEnderecoEntrega());
            } else if (giftCard instanceof GiftCardVirtual) {
                System.out.println("Email Destinatário: " + ((GiftCardVirtual) giftCard).getEmailDestinatario());
            }
        }
    }

    private static void buscarGiftCardPorCodigo(Scanner sc) {
        System.out.print("Digite o código do gift card: ");
        String codigo = sc.nextLine();
        for (GiftCard giftCard : giftCards) {
            if (giftCard.getCodigo().equals(codigo)) {
                System.out.println("Gift Card encontrado: Código: " + giftCard.getCodigo() + ", Saldo: " + giftCard.getSaldo());
                if (giftCard instanceof GiftCardFisico) {
                    System.out.println("Endereço de Entrega: " + ((GiftCardFisico) giftCard).getEnderecoEntrega());
                } else if (giftCard instanceof GiftCardVirtual) {
                    System.out.println("Email Destinatário: " + ((GiftCardVirtual) giftCard).getEmailDestinatario());
                }
                return;
            }
        }
        System.out.println("Gift Card não encontrado com o código: " + codigo);
    }

    private static void atualizarGiftCard(Scanner sc) {
        System.out.print("Digite o código do gift card a ser atualizado: ");
        String codigo = sc.nextLine();
        for (GiftCard giftCard : giftCards) {
            if (giftCard.getCodigo().equals(codigo)) {
                giftCard.cadastrar(sc);
                System.out.println("Gift Card atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Gift Card não encontrado com o código: " + codigo);
    }

    private static void excluirGiftCard(Scanner sc) {
        System.out.print("Digite o código do gift card a ser excluído: ");
        String codigo = sc.nextLine();
        for (GiftCard giftCard : giftCards) {
            if (giftCard.getCodigo().equals(codigo)) {
                giftCards.remove(giftCard);
                System.out.println("Gift Card excluído com sucesso!");
                return;
            }
        }
        System.out.println("Gift Card não encontrado com o código: " + codigo);
    }
}