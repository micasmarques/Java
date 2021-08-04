package br.com.micael;

public enum TipoDeCarro {
    HATCHBACK("Hatchback"),
    SEDAN("Sedan"),
    COUPE("Coupe");

    private String tipo;

    TipoDeCarro(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
}
