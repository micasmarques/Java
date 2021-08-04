package br.com.micael;

import java.util.ArrayList;
import java.util.List;

public class Demo
{
    public static void main( String[] args )
    {
        List<Carro> listaDeCarros = new ArrayList<>();

        listaDeCarros.add(new Carro());
        listaDeCarros.add(new Fusca());

        for (Carro carro : listaDeCarros) {
            System.out.println(carro + "\n");
        }
    }
}
