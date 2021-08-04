package br.edu.ifpb.cli;

import br.edu.ifpb.livro.Categoria;
import br.edu.ifpb.livro.Livro;
import br.edu.ifpb.services.CatalogoLivros;

import java.util.Date;
import java.util.EnumSet;
import java.util.Scanner;

public class MainCLI {
    public static void main(String[] args) {

        MainCLI.printHeader("Bem Vindo ao My BookCase!", 3);

        CatalogoLivros myBookCase = new CatalogoLivros();

        if (myBookCase.catalogoVazio()) {
            MainCLI.printMsg("Seu catálogo ainda está vazio, adicione livros!");
        }

        int op;
        MainCLI.printHeader("Menu", 12);
        while (true) {

            MainCLI.printMenu();
            op = inputInt();

            if (op < 1 || op > 6) {
                MainCLI.printMsg("Opção inválida! Tente novamente");

            } else {

                switch (op) {

                    case 1:
                        MainCLI.printMsg("Adicionando Livro! Insira os dados...");

                        System.out.print("Digite o título do livro: ");
                        String título = inputStr();
                        if (myBookCase.pesquisarLivroPorTítulo(título) > 0) {
                            MainCLI.printMsg("Já existe um livro com este título!");
                            break;
                        }

                        System.out.print("Digite o autor do livro: ");
                        String autor = inputStr();

                        System.out.println("|Gêneros disponíveis| ");
                        System.out.println(Livro.listarGêneros());

                        System.out.print("Digite o gênero do livro: ");
                        String gênero = inputStr();
                        if (!Livro.gêneroVálido(gênero)) {
                            MainCLI.printMsg("Gênero Inválido! Digite o nome exatamente como na lista de gêneros!");
                            break;
                        }

                        System.out.print("Digite o preço do livro (use vírgula): ");
                        double preço = inputDouble();

                        Livro novoLivro = new Livro(título, autor, Categoria.valueOf(gênero.toUpperCase()), preço, new Date());

                        if (myBookCase.adicionarLivro(novoLivro)) {
                            MainCLI.printMsg("Livro adicionado ao catálogo com sucesso!");
                            System.out.println("Dados:\n" + novoLivro);
                        } else {
                            MainCLI.printMsg("Houve um erro ._.");
                        }
                        break;

                    case 2:
                        System.out.print("Digite o título do livro à buscar: ");
                        String buscaTítulo = inputStr();
                        int códEncontrado = myBookCase.pesquisarLivroPorTítulo(buscaTítulo);
                        if (códEncontrado > 0) {
                            MainCLI.printMsg("Livro encontrado!");
                            for (Livro livro : myBookCase.getListaDeLivros()) {
                                if (livro.getCódigo() == códEncontrado) {
                                    System.out.println(livro);
                                }
                            }
                        } else {
                            MainCLI.printMsg("Livro não encontrado!");
                        }
                        break;

                    case 3:
                        System.out.print("Digite o título do livro à remover: ");
                        String títuloARemover = inputStr();
                        if (myBookCase.removerLivroPorTítulo(títuloARemover)) {
                            MainCLI.printMsg("Livro removido com sucesso!");
                        } else {
                            MainCLI.printMsg("Livro não encontrado!");
                        }
                        break;

                    case 4:
                        if (myBookCase.catalogoVazio()) {
                            MainCLI.printMsg("O catálogo está vazio!");
                        } else {
                            MainCLI.printHeader("Lista de Livros Catalogados", 3);
                            System.out.println(myBookCase.listarLivros());
                        }
                        break;

                    case 5:
                        while (true) {
                            System.out.print("Tem certeza que deseja remover TODOS os livros do catálogo? [Sim/Nao]: ");
                            String certeza = inputStr();
                            if (certeza.toLowerCase().equals("sim")) {
                                myBookCase.limparCatalogo(); {
                                    MainCLI.printMsg("Todos os livros foram removidos!");
                                    if (myBookCase.catalogoVazio()) {
                                        System.out.println("Catálogo vazio!");
                                    }
                                    break;
                                }
                            } else if (certeza.toLowerCase().equals("nao")) {
                                MainCLI.printMsg("Nada foi excluído.");
                                break;
                            } else {
                                MainCLI.printMsg("Opção inválida!");
                            }
                        }
                        break;

                    case 6:
                        MainCLI.printMsg("Obrigado! =) Volte sempre o/");
                        System.exit(0);
                }
            }
        }

    }

    private static void printHeader(String título, int qtdDeTraços) {
        String header = String.format("|%s %s %s|", "-".repeat(qtdDeTraços), título, "-".repeat(qtdDeTraços));
        System.out.println (
                String.format("%s\n%s\n%s", "-".repeat(header.length()), header, "-".repeat(header.length()))
        );
    }

    private static void printMenu() {
        System.out.print (
                "O que deseja fazer? \n" +
                "- 1. Adicionar Livro \n" +
                "- 2. Buscar Livro (Por Título) \n" +
                "- 3. Remover Livro (Por Título) \n" +
                "- 4. Listar Livros \n" +
                "- 5. Limpar Catálogo \n" +
                "- 6. Sair \n" +
                "  Digite sua opção: "
        );
    }

    private static void printMsg(String msg) {
        System.out.println(String.format("-\n> %s\n-", msg));
    }

    private static int inputInt() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private static double inputDouble() {
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    private static String inputStr() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

}
