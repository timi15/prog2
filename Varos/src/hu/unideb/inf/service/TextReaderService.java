package hu.unideb.inf.service;

import hu.unideb.inf.model.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class TextReaderService {
    public ArrayList<City> readCitiesFromTxtToArrayList(String fileName, String delimeter) {
        ArrayList<City> result = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(delimeter);
                String[] datePart = data[3].split("/");
                int day = Integer.parseInt(datePart[0]);
                int month = Integer.parseInt(datePart[1]);
                int year = Integer.parseInt(datePart[2]);

                result.add(new City(
                        data[0],
                        data[1],
                        Integer.parseInt(data[2]),
                        LocalDate.of(year, month, day),
                        data[4]
                ));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public HashSet<City> readCitiesFromTxtTodHashSet(String fileName, String delimeter) {
        HashSet<City> result = new LinkedHashSet<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(delimeter);
                String[] datePart = data[3].split("/");
                int day = Integer.parseInt(datePart[0]);
                int month = Integer.parseInt(datePart[1]);
                int year = Integer.parseInt(datePart[2]);

                result.add(new City(
                        data[0],
                        data[1],
                        Integer.parseInt(data[2]),
                        LocalDate.of(year, month, day),
                        data[4]
                ));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public TreeSet<City> readCitiesFromTxtToTreeSet(String fileName, String delimeter) {
        TreeSet<City> result = new TreeSet<>(Comparator.comparing(City::getIranyitoszam));
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(delimeter);
                String[] datePart = data[3].split("/");
                int day = Integer.parseInt(datePart[0]);
                int month = Integer.parseInt(datePart[1]);
                int year = Integer.parseInt(datePart[2]);

                result.add(new City(
                        data[0],
                        data[1],
                        Integer.parseInt(data[2]),
                        LocalDate.of(year, month, day),
                        data[4]
                ));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public HashMap<String, ArrayList<City>> readCitiesFromTxtToHashMap(String fileName, String delimeter) {
        HashMap<String, ArrayList<City>> result = new LinkedHashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(delimeter);
                String[] datePart = data[3].split("/");
                int day = Integer.parseInt(datePart[0]);
                int month = Integer.parseInt(datePart[1]);
                int year = Integer.parseInt(datePart[2]);

                City city = new City(data[0], data[1],
                        Integer.parseInt(data[2]), LocalDate.of(year, month, day), data[4]);

                ArrayList<City> cities;
                if (result.containsKey(city.getMegye())) {
                    cities = result.get(city.getMegye());
                } else {
                    cities = new ArrayList<>();
                }
                cities.add(city);
                result.put(city.getMegye(), cities);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public TreeMap<String, ArrayList<City>> readCitiesFromTxtToTreeMap(String fileName, String delimeter) {
        TreeMap<String, ArrayList<City>> result = new TreeMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(delimeter);
                String[] datePart = data[3].split("/");
                int day = Integer.parseInt(datePart[0]);
                int month = Integer.parseInt(datePart[1]);
                int year = Integer.parseInt(datePart[2]);

                City city = new City(data[0], data[1],
                        Integer.parseInt(data[2]), LocalDate.of(year, month, day), data[4]);


                ArrayList<City> cities;
                if (result.containsKey(city.getMegye())) {
                    cities = result.get(city.getMegye());
                } else {
                    cities = new ArrayList<>();
                }
                cities.add(city);
                result.put(city.getMegye(), cities);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
