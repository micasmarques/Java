import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {

        String host = (args.length < 1) ? "localhost" : args[0];

        try {
            System.out.println("Conectando com o servidor...");

            Registry registry = LocateRegistry.getRegistry(host);
            Biblioteca_IF stub = (Biblioteca_IF) registry.lookup("biblioteca");

            while (true) {
                System.out.print(
                        "|Bem-Vindo a Biblioteca RMI|\n" +
                        "\tDigite sua opção:\n" +
                        "\t\t1 - Buscar Livro" +
                        "\t\t2 - Cadastrar Livro" +
                        "\t\t3 - Remover Livro" +
                        "\t\t0 - Sair" +
                        "\n\t\t  Opção: "
                );

                Scanner input = new Scanner(System.in);
                int op = input.nextInt();

                // Dados do livro
                String id, titulo, autor, tipo, preco;

                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        System.exit(0);

                    case 1:
                        System.out.print("Insira o código do livro: ");
                        id = input.nextLine();
                        System.out.println(stub.buscarLivro(id));
                        break;

                    case 2:
                        System.out.println("|Insira os dados do livro|");

                        System.out.print("ID: ");
                        id = input.nextLine();

                        System.out.print("Título: ");
                        titulo = input.nextLine();

                        System.out.print("Autor: ");
                        autor = input.nextLine();

                        System.out.print("Tipo: ");
                        tipo = input.nextLine();

                        System.out.print("Preço: ");
                        preco = input.nextLine();

                        System.out.println("Cadastrando...");
                        System.out.println(stub.cadastrarLivro(id, titulo, autor, tipo, preco));

                        break;

                    case 3:
                        System.out.print("Insira o código do livro que deseja remover: ");
                        id = input.nextLine();

                        System.out.println(stub.removerLivro(id));
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("Erro no Cliente: " + e.toString());
            e.printStackTrace();
        }
    }

}

// exec: java -classpath . Cliente