package com.micael;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Set;

public class CitiesProcessorDemo
{
    public static void main( String[] args ) {

        CitiesProcessor cp = new CitiesProcessor();

        Set<City> set = cp.buildSetOfCities(Path.of("C:\\Users\\Guilherme\\Documents\\Engenharia de Computação\\Programação Orientada à Objetos\\com Java\\Prática 7\\ProjCities\\src\\main\\java\\com\\guilherme\\files\\cities.txt")); // Assim funciona.
        // Set<City> set = cp.buildSetOfCities(Path.of("files/cities.txt")); // ASSIM NÃO FUNCIONA!
        cp.setCitiesSet( set );

        cp.printaSet();

        cp.writeSetOfCities( Path.of( "C:\\Users\\Guilherme\\Documents\\Engenharia de Computação\\Programação Orientada à Objetos\\com Java\\Prática 7\\ProjCities\\src\\main\\java\\com\\guilherme\\files\\ordered\\cities_ordered_by_name.txt" ), Comparator.naturalOrder() ); // Assim funciona.
        // cp.writeSetOfCities( Path.of( "files/ordered/cities_ordered_by_name.txt" ), Comparator.naturalOrder() ); // ASSIM NÃO FUNCIONA!

        ComparadorByZipCode comparadorByZipCode = new ComparadorByZipCode();
        cp.writeSetOfCities( Path.of( "C:\\Users\\Guilherme\\Documents\\Engenharia de Computação\\Programação Orientada à Objetos\\com Java\\Prática 7\\ProjCities\\src\\main\\java\\com\\guilherme\\files\\ordered\\cities_ordered_by_zipcode.txt" ), comparadorByZipCode); // Assim funciona.
        // cp.writeSetOfCities( Path.of( "files/ordered/cities_ordered_by_zipcode.txt" ), comparadorByZipCode); // ASSIM NÃO FUNCIONA!

        ComparadorByState comparadorByState = new ComparadorByState();
        cp.writeSetOfCities( Path.of( "C:\\Users\\Guilherme\\Documents\\Engenharia de Computação\\Programação Orientada à Objetos\\com Java\\Prática 7\\ProjCities\\src\\main\\java\\com\\guilherme\\files\\ordered\\cities_ordered_by_state.txt" ), comparadorByState); // Assim funciona.
        // cp.writeSetOfCities( Path.of( "files/ordered/cities_ordered_by_state.txt" ), comparadorByState); // ASSIM NÃO FUNCIONA!

    }
}
