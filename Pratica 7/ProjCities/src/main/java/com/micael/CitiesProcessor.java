package com.micael;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class CitiesProcessor {

    private Set<City> citiesSet;

    {
        this.setCitiesSet(new TreeSet<>());
    }

    public Set<City> getCitiesSet() {
        return citiesSet;
    }

    public void setCitiesSet(Set<City> citiesSet) {
        this.citiesSet = citiesSet;
    }


    public Set<City> buildSetOfCities(Path filePath)
    {
        Set<City> citySetTemp = new TreeSet<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(String.valueOf(filePath)))) {

            String linha;

            while ( (linha = bufferedReader.readLine()) != null) {

                String[] palavras = linha.split(",");
                String estado = palavras[0], sigla = palavras[1], zipCode = palavras[2];
                City city = new City(estado, sigla, zipCode);

                citySetTemp.add(city);
            }

        } catch (FileNotFoundException fnf) {
            System.out.println("Arquivo não existe!");
        } catch (IOException ioe) {
            System.out.println("Erro ao ler arquivo!");
        }

        return citySetTemp;
    }

    public void writeSetOfCities(Path destino, Comparator<City> comparador)
    {
        Set<City> setCitiesOrdenado = new TreeSet<>( comparador );
        setCitiesOrdenado.addAll( getCitiesSet() );

        setCitiesOrdenado.forEach(city -> {
            try {
                Files.write (
                        destino,
                        Collections.singleton(String.format(city.getNome() + ", " + city.getSigla() + ", " + city.getZipCode())),
                        Charset.defaultCharset(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND,
                        StandardOpenOption.WRITE
                );
            } catch (IOException e) {
                System.out.println("Erro ao escrever arquivo!");;
            }
        });

    }

    public void printaSet() {
        this.getCitiesSet().forEach(city -> {
            System.out.println(city.getNome() + ", " + city.getSigla() + ", " + city.getZipCode());
        });
    }
}
