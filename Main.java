import java.util.Scanner;

public class Main {
    private static int rdInt(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    private static double rdDbl(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número.");
            }
        }
    }

    private static Double rdDblOpc(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) return null;
            try {
                return Double.parseDouble(s.replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número ou Enter para pular.");
            }
        }
    }

    private static Integer rdIntOpc(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            if (s.isEmpty()) return null;
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um inteiro ou Enter para pular.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gerir g = new Gerir();
        int op;

        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1 - Cadastrar Colaborador Padrão");
            System.out.println("2 - Cadastrar Comm");
            System.out.println("3 - Cadastrar Produção");
            System.out.println("4 - Listar Todos");
            System.out.println("5 - Atualizar Colaborador");
            System.out.println("6 - Remover Colaborador");
            System.out.println("7 - Folha de Pagamento (individual)");
            System.out.println("8 - Folha de Pagamento (todos)");
            System.out.println("0 - Sair");
            op = rdInt(sc, "Escolha: ");

            switch (op) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nm = sc.nextLine();
                    System.out.print("Matrícula: ");
                    String mat = sc.nextLine();
                    g.add(new Colab(nm, mat));
                }
                case 2 -> {
                    System.out.print("Nome: ");
                    String nm = sc.nextLine();
                    System.out.print("Matrícula: ");
                    String mat = sc.nextLine();
                    double vend = rdDbl(sc, "Valor de vendas: ");
                    double perc = rdDbl(sc, "Percentual de comissão (%): ");
                    g.add(new Comm(nm, mat, vend, perc));
                }
                case 3 -> {
                    System.out.print("Nome: ");
                    String nm = sc.nextLine();
                    System.out.print("Matrícula: ");
                    String mat = sc.nextLine();
                    int qtd = rdInt(sc, "Quantidade de peças: ");
                    double vlr = rdDbl(sc, "Valor por peça: ");
                    g.add(new Prod(nm, mat, qtd, vlr));
                }
                case 4 -> g.listar();
                case 5 -> {
                    System.out.print("Matrícula do colaborador: ");
                    String mat = sc.nextLine();
                    System.out.print("Novo nome (Enter p/ manter): ");
                    String nm = sc.nextLine();
                    Double vend = rdDblOpc(sc, "Novo valor de vendas (Enter p/ pular): ");
                    Double perc = rdDblOpc(sc, "Novo percentual (Enter p/ pular): ");
                    Integer qtd = rdIntOpc(sc, "Nova qtd de peças (Enter p/ pular): ");
                    Double vlr = rdDblOpc(sc, "Novo valor por peça (Enter p/ pular): ");
                    g.atual(mat, nm.isBlank() ? null : nm, vend, perc, qtd, vlr);
                }
                case 6 -> {
                    System.out.print("Matrícula a remover: ");
                    g.rem(sc.nextLine());
                }
                case 7 -> {
                    System.out.print("Matrícula: ");
                    g.folha(sc.nextLine());
                }
                case 8 -> g.folhaTodos();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (op != 0);

        sc.close();
    }
}
