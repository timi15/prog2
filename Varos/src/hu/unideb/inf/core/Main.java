package hu.unideb.inf.core;

import hu.unideb.inf.model.City;
import hu.unideb.inf.service.TextReaderService;
import lombok.AllArgsConstructor;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TextReaderService textReaderService = new TextReaderService();
        String fileName = args[0];
        String delimeter = ":";

        /*
        ArrayList<City> cities = textReaderService.readCitiesFromTxtToArrayList(fileName, delimeter);

        LinkedHashSet<City> cities = new LinkedHashSet<>(textReaderService.readCitiesFromTxtToLHashSet(fileName, delimeter));



        TreeSet<City> cities = textReaderService.readCitiesFromTxtToTreeSet(fileName, ":");


        LinkedHashMap<String, ArrayList<City>> cities = new LinkedHashMap<>(textReaderService.readCitiesFromTxtToHashMap(fileName, delimeter));
        for(Map.Entry<String, ArrayList<City>> city : cities.entrySet()){
            System.out.println(city.getKey()+"\t"+city.getValue());
        }



        TreeMap<String, ArrayList<City>> cities = textReaderService.readCitiesFromTxtToTreeMap(fileName, delimeter);
        for (Map.Entry<String, ArrayList<City>> city : cities.entrySet()){
            System.out.println(city.getKey()+"\t"+city.getValue());
        }

          */
    }
}