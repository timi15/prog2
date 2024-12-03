package hu.unideb.inf.service;

import hu.unideb.inf.model.Telepules;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class TxtReaderService {
    public LinkedHashMap<String, ArrayList<Telepules>> readCitiesFromTxtToLinkedHashMap(String fileName, String delimeter) {
        LinkedHashMap<String, ArrayList<Telepules>> result = new LinkedHashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(delimeter);

                Telepules city = new Telepules(
                        data[0],
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]),
                        LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        data[4]
                );


                ArrayList<Telepules> cities;
                if(result.containsKey(city.getMegye())){
                    cities = result.get(city.getMegye());
                }else{
                    cities = new ArrayList<>();
                }

                cities.add(city);
                result.put(city.getMegye(), cities);
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

}
