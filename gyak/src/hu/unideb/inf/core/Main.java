package hu.unideb.inf.core;

import hu.unideb.inf.model.Telepules;
import hu.unideb.inf.service.JsonReaderService;
import hu.unideb.inf.service.TxtReaderService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        JsonReaderService jsonReaderService = new JsonReaderService();
        TxtReaderService txtReaderService = new TxtReaderService();
        String fileName = "telepulesek.json";
        String fileNameTxt = "telepulesek.txt";
        String delimeter = ":";

        ArrayList<Telepules> citiesJson = new ArrayList<>(jsonReaderService.readCitiesFromJsonToList(fileName));

        //citiesJson.forEach(System.out::println);

        Map<String, String> collect = citiesJson.stream()
                .collect(Collectors.groupingBy(Telepules::getMegye, Collectors.reducing(" ", Telepules::getNev, String::concat)));

        for (Map.Entry<String, String> stringStringEntry : collect.entrySet()) {
            System.out.println(stringStringEntry.getKey()+"\t"+stringStringEntry.getValue());
        }
/*
        LinkedHashMap<String, ArrayList<Telepules>> citiesTxt = txtReaderService.readCitiesFromTxtToLinkedHashMap(fileNameTxt, delimeter);
        for (Map.Entry<String, ArrayList<Telepules>> city: citiesTxt.entrySet()){
            System.out.println(city.getKey()+"\t"+city.getValue());
        }

 */


    }
}