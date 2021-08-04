package br.edu.ifpb;

public class Professor extends Funcionario {
    private int numHorasDisciplinas;

    // default
    public Professor()
    {
        super();
        this.setNumHorasDisciplinas( 2 );
    }

    // com parâmetros
    public Professor( int matricula, String nome, int idade, double salarioBase, int númeroHoras )
    {
        super( matricula, nome, idade, salarioBase );
        this.setNumHorasDisciplinas( númeroHoras );
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