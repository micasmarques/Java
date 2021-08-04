import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca implements Biblioteca_IF {

    public String buscarLivro(String ID) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("files/books.txt"))){

            String linha;

            while ( (linha = bufferedReader.readLine()) != null) {

                String[] conteudo = linha.split(";");
                String id = conteudo[0];

                if (id.equals(ID)) {
                    String titulo = conteudo[1], autor =  conteudo[2], tipo = conteudo[3], preco = conteudo[4];
                    return "Livro encontrado!" +
                            "\n|Dados|" +
                            "\nID: " + id +
                            "\nTítulo: " + titulo +
                            "\nAutor: " + autor +
                            "\nTipo: " + tipo +
                            "\nPreço: " + preco;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro! Arquivo não existe");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Erro desconhecido!");
            e.printStackTrace();
        }

        return "Livro não encontrado";
    }

    public String cadastrarLivro(String ID, String titulo, String autor, String tipo, String preco) {

        Path caminho = Paths.get( "files/books.txt" );

        try {
            Files.write (
                    caminho,
                    Collections.singleton(ID + ";" + titulo + ";" + autor + ";" + tipo + ";" + preco),
                    Charset.defaultCharset(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE
            );

            return "Livro foi cadastrado com sucesso";

        } catch (IOException e) {
            System.out.println("Erro ao gravar arquivo!");
            e.printStackTrace();
        }

        return "Erro - não foi possível cadastrar o livro!";
    }

    public String removerLivro(String ID) {

        String caminho = "files/books.txt";
        Path origem = Paths.get(caminho);

        List<String> todosOsLivros = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(caminho))){

            String linha;
            boolean encontrou = false;

            while ( (linha = bufferedReader.readLine()) != null) {
                String[] conteudo = linha.split(";");
                String id = conteudo[0];

                if (!id.equals(ID)) {
                    todosOsLivros.add(linha);
                    encontrou = true;
                }
            }

            if (encontrou) {
                Files.write(
                        origem,
                        todosOsLivros,
                        Charset.defaultCharset(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING,
                        StandardOpenOption.WRITE
                );

                return "Livro foi removido com sucesso";
            }

        } catch (FileNotFoundException e) {
            System.out.println("Erro! Arquivo não existe");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Erro desconhecido!");
            e.printStackTrace();
        }

        return "Erro - não foi possível remover o livro!";

    }
}
