package com.micael;

import java.util.Objects;

public class City implements Comparable<City> {

    private String nome;
    private String sigla;
    private String zipCode; // Na verdade esse é o número da população dos estados né, mas.......


    public City(String nome, String sigla, String zipCode) {
        this.nome = nome;
        this.sigla = sigla;
        this.zipCode = zipCode;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return getNome().equals(city.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getNome());
    }

    @Override
    public int compareTo(City outra) {
        return getNome().compareTo(outra.getNome());
    }
}
