package com.micael;

public class Porsche extends CarroSport implements Impostável {
    private int imposto;

    public void setImposto(int imposto) {
        this.imposto = imposto;
    }

    @Override
    public int getImposto() {
        return this.imposto;
    }
}
