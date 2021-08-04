import java.util.Scanner;
import java.util.ArrayList;

public class Principal {
    public static void main( String[] args )
    {
        Menu menu = new Menu();
        menu.exibirMenu();
    }
}

class Menu
{
    private int matricula;
    private String nome;
    private int idade;
    private double salario;
    private int numHoras;
    private double comissao;
    private int escolha;

    private Universidade universidade = new Universidade();

    public void exibirMenu()
    {

        System.out.printf(".:::Sistema da Universidade:::.\n" +
                            "Cadastro de Funcionarios\n");

        while (true)
        {

            Scanner input = new Scanner(System.in);

            System.out.printf("========================\n" +
                    "   1. Cadastrar Funcionario\n" +
                    "   2. Cadastrar Professor\n" +
                    "   3. Cadastrar Gerente\n" +
                    "   9. Exibir n\372mero de funcionarios cadastrados\n" +
                    "   0. Sair\n" +
                    "   Digite uma op\347\343o: ");
            // Ler opç\343o com scanner:
            int opcao = input.nextInt();

            if (opcao == 0) {
                // Sair
                System.out.println("Saindo.");
                break;
            }

            else {

                if (opcao == 9) {

                    universidade.getQuantidadeFuncionarios();

                } else if (opcao == 1) {
                    System.out.println("\n  -------------\n|Cadastrando novo Funcionario|");
                    this.matricula = capturaMatricula();
                    this.nome = capturaNome();
                    this.idade = capturaIdade();
                    this.salario = capturaSalario();

                    Funcionario funcionario = new Funcionario(this.matricula, this.nome, this.idade, this.salario);
                    if(universidade.adicionarFuncionario(funcionario))
                        System.out.printf("|Novos Dados|\n" + funcionario.toString());

                    this.escolha = capturaEscolha();

                } else if (opcao == 2) {

                    System.out.println("\n  -------------\n|Cadastrando novo Professor|");
                    this.matricula = capturaMatricula();
                    this.nome = capturaNome();
                    this.idade = capturaIdade();
                    this.salario = capturaSalario();
                    System.out.printf("Digite o n\372mero de horas de disciplinas: ");
                    this.numHoras = input.nextInt();

                    Professor professor = new Professor(this.matricula, this.nome, this.idade, this.salario, this.numHoras);
                    if(universidade.adicionarFuncionario(professor))
                        System.out.printf("|Novos Dados|\n" + professor.toString());

                    this.escolha = capturaEscolha();

                } else if (opcao == 3) {

                    System.out.println("\n  -------------\n|Cadastrando novo Gerente|");
                    this.matricula = capturaMatricula();
                    this.nome = capturaNome();
                    this.idade = capturaIdade();
                    this.salario = capturaSalario();
                    System.out.printf("Digite a comiss\343o: ");
                    this.comissao = input.nextDouble();

                    Gerente gerente = new Gerente(this.matricula, this.nome, this.idade, this.salario, this.comissao);
                    if(universidade.adicionarFuncionario(gerente))
                        System.out.printf("|Novos Dados|\n" + gerente.toString());

                    this.escolha = capturaEscolha();
                }

                if (this.escolha == 0) {
                    System.out.println("Saindo.");
                    break;

                } else if (this.escolha == 1) {
                    System.out.printf("--------------------\n");

                } else if (this.escolha == 2) {
                    universidade.getQuantidadeFuncionarios();
                }

            }
        }
    }

    private static int capturaMatricula() {
        Scanner input = new Scanner( System.in );
        System.out.printf("Digite a matricula: ");
        return input.nextInt();
    }

    private static String capturaNome() {
        Scanner input = new Scanner( System.in );
        System.out.printf("Digite o nome: ");
        return input.nextLine();
    }

    private static int capturaIdade() {
        Scanner input = new Scanner( System.in );
        System.out.printf("Digite a idade: ");
        return input.nextInt();
    }

    private static double capturaSalario() {
        Scanner input = new Scanner( System.in );
        System.out.printf("Digite o salario: ");
        return input.nextDouble();
    }

    private static int capturaEscolha() {
        Scanner input = new Scanner( System.in );

        System.out.printf("\n -------------" +
                            "\n O que deseja fazer?\n " +
                            "\t1. Cadastrar mais funcionarios\n" +
                            "\t2. Exibir total de funcionarios cadastrados\n" +
                            "\t0. Sair\n");

        return input.nextInt();
    }

}

class Universidade {
    ArrayList<Funcionario> funcionarios;

    Universidade() {
        funcionarios = new ArrayList<>();
    }

    public boolean adicionarFuncionario(Funcionario func) {
        for( Funcionario f : funcionarios)
            if( f.getMatricula() == func.getMatricula()) {
                System.out.println("Matrícula já cadastrada!");
                System.out.printf("|Dados|\n" + f.toString());
                return false;
            }

        System.out.println("\n  -------------\n Funcionario cadastrado com sucesso!\n -------------");
        return funcionarios.add(func);
    }

    public boolean removerFuncionario(int matricula) {
        for( Funcionario f : funcionarios) {
            if (f.getMatricula() == matricula) {
                System.out.println("Funcion\341rio removido com sucesso!");
                return funcionarios.remove(f);
            }
        }

        System.out.println("N\343o foi encontrado funcionario com essa matricula.");
        return false;
    }

    public int getQuantidadeFuncionarios() {
        System.out.println("Total de funcionarios cadastrados: ");
        return funcionarios.size();
    }

}

class Funcionario {

    private int matricula;
    private String nome;
    private double salarioBase;
    private int idade;

    public Funcionario()
    {
        this( 0, "--- sem nome ---", 21, 900 );
    }

    public Funcionario(int matricula, String nome, int idade, double salarioBase )
    {
        setMatricula( matricula );
        setNome( nome );
        setIdade( idade );
        setSalario( salarioBase );
    }

    public int getMatricula()
    {
        return matricula;
    }

    public void setMatricula( int matricula )
    {
        this.matricula = matricula;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome( String nome )
    {
        this.nome = nome;
    }

    public double getSalario()
    {
        return salarioBase;
    }

    public void setSalario( double salario )
    {
        this.salarioBase = salario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString()
    {
        return
                "Matricula: " + getMatricula() +
                "\nNome: " + getNome() +
                "\nIdade: " + getIdade() +
                "\nSalario Base: " + getSalario();
    }
}

class Professor extends Funcionario {
    private int numHorasDisciplinas;

    // default
    public Professor()
    {
        super();
        this.setNumHorasDisciplinas( 2 );
    }

    // com parâmetros
    public Professor( int matricula, String nome, int idade, double salarioBase, int numeroHoras )
    {
        super( matricula, nome, idade, salarioBase );
        this.setNumHorasDisciplinas( numeroHoras );
    }

    public int getNumHorasDisciplinas()
    {
        return numHorasDisciplinas;
    }

    public void setNumHorasDisciplinas( int numHorasDisciplinas )
    {
        this.numHorasDisciplinas = numHorasDisciplinas;
    }

    @Override
    public double getSalario()
    {
        return super.getSalario() + 2 * getNumHorasDisciplinas();
    }

    @Override
    public String toString()
    {
        return  super.toString() +
                "\nHoras: " + getNumHorasDisciplinas();
    }
}

class Gerente extends Funcionario {
    private double comissao;

    public Gerente()
    {
        super();
        this.setComissao( 100.0 );
    }

    public Gerente( int matricula, String nome, int idade, double salarioBase, double comissao)
    {
        super( matricula, nome, idade, salarioBase );
        this.setComissao( comissao );
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao )
    {
        this.comissao = comissao;
    }

    @Override
    public double getSalario()
    {
        return super.getSalario() + getComissao();
    }

    @Override
    public String toString()
    {
        return  super.toString() +
                "\nComiss\343o: " + getComissao();
    }
}
