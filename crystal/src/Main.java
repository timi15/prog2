import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // JSON fájl betöltése
            ObjectMapper objectMapper = new ObjectMapper();

            // Lista deszerializálása
            ArrayList<Crystal> gems = objectMapper.readValue(
                    new File("crystals.json"), // A JSON fájl neve
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Crystal.class)
            );

            // Kiírás a konzolra
            gems.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}