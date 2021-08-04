package br.edu.ifpb;

public class Gerente extends Funcionario {
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
                "\nComissão: " + getComissao();
    }
}
