package com.micael;

public class D20 extends CarroUtilitario implements Impostável {
    private int imposto;

    public void setImposto(int imposto) {
        this.imposto = imposto;
    }

    @Override
    public int getImposto() {
        return this.imposto;
    }
}
