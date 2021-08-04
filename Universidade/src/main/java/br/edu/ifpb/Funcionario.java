package br.edu.ifpb;

public class Funcionario {

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
