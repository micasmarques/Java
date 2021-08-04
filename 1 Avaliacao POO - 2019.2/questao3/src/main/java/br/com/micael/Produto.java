package br.com.micael;

public class Produto {
    private int codigo;
    private String produto;
    private int preco;

    public Produto(int codigo, String produto, int preco) {
        this.setCodigo( codigo );
        this.setProduto( produto );
        this.setPreco( preco );
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }
}
