package hu.unideb.inf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fileName = args[0];
        String deliemter = ";";
        HashMap<String, Hotel> hotels = readHotelsFromTxtToHashMap(fileName, deliemter);

        for (Map.Entry<String, Hotel> hotel : hotels.entrySet()) {
            System.out.println(hotel.getKey() + "\t" + hotel.getValue());
        }

        ArrayList<Hotel> avilableRoomHotels = findAvailableHotels(hotels);
        avilableRoomHotels.sort(Comparator.comparingInt(Hotel::getAvailableRooms).thenComparing(Hotel::getHotelName));
        avilableRoomHotels.forEach(System.out::println);

    }

    public static ArrayList<Hotel> findAvailableHotels(HashMap<String, Hotel> hotels){
        ArrayList<Hotel> result = new ArrayList<>();
        for (Hotel hotel : hotels.values()) {
            if(hotel.isRoomAvailable()){
                result.add(hotel);
            }
        }
        return result;
    }


    public static HashMap<String, Hotel> readHotelsFromTxtToHashMap(String fileName, String delimeter){
        HashMap<String, Hotel> hotelHashMap = new HashMap<>();
        try(Scanner scanner = new Scanner(new File(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] data = line.split(delimeter);

                Hotel hotel = new Hotel(
                        data[0],
                        Integer.parseInt(data[1]),
                        Integer.parseInt(data[2]),
                        Integer.parseInt(data[3])
                );
                hotelHashMap.put(hotel.getHotelName(), hotel);

            }

        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }
        return hotelHashMap;
    }
}