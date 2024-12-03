


import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

 class Runner {

    public static void main(String[] args) throws Exception {
        int i = 0; // Sor indexe a fájl beolvasásához.
        ArrayList<Konyv> konyvek = new ArrayList<>(); // Könyvek tárolására használt lista.

        // Fájl beolvasása
        try (Scanner sc = new Scanner(new File("konyv.txt"))) { // Beolvassuk a "konyv.txt" fájlt.
            while (sc.hasNextLine()) { // Soronként végigmegyünk a fájl tartalmán.
                String sor = sc.nextLine(); // A következő sort beolvassuk.
                String[] sorElemek = sor.split(";"); // A sort pontosvessző mentén daraboljuk.

                if (i != 0) { // Az első sor fejléc, azt kihagyjuk.
                    Konyv k1; // Egy könyv objektum tárolására szolgáló változó.
                    try {
                        // Minden adat rendelkezésre áll, megpróbáljuk létrehozni a könyv objektumot.
                        k1 = new Konyv(sorElemek[0], sorElemek[1], sorElemek[2], sorElemek[3],
                                LocalDate.parse(sorElemek[4], DateTimeFormatter.ofPattern("yyyy.MM.dd")),
                                Integer.parseInt(sorElemek[5]), sorElemek[6], Integer.parseInt(sorElemek[7]));
                    } catch (ArrayIndexOutOfBoundsException e1) {
                        // Ha hiányzik néhány adat, a könyv árát null értékre állítjuk.
                        k1 = new Konyv(sorElemek[0], sorElemek[1], sorElemek[2], null, null, null, null, null);
                    }
                    konyvek.add(k1); // Hozzáadjuk az elkészült objektumot a listához.
                }
                i++; // Növeljük a sor számlálót.
            }
        } catch (Exception e) {
            System.out.println(e.getMessage()); // Ha hiba történik, kiírjuk az üzenetet.
            throw e; // Újradobjuk a kivételt.
        }

        // Minden könyv kiíratása iterációval.
        System.out.println("\n=== 1. Az összes könyv (iterációval): ===");
        for (Konyv konyv : konyvek) {
            System.out.println(konyv); // Kiírjuk az összes könyv objektumot.
        }

        /* ----------------------------------------- */
        /* STREAM API MŰVELETEK                     */
        /* ----------------------------------------- */

        // 1. Összes könyv kiíratása stream használatával.
        System.out.println("\n=== 2. Az összes könyv (stream segítségével): ===");
        konyvek.stream() // A könyvek listáját stream-mé alakítjuk.
                .forEach(e -> System.out.println(e)); // Minden könyvet kiírunk.

        // 2. Könyvek szűrése: azok, amelyek címében 'i' karakter van.
        System.out.println("\n=== 3. Könyvek, amelyek címében 'i' karakter van: ===");
        konyvek.stream()
                .filter(e -> e.getCim().contains("i")) // Csak azok a könyvek maradnak, amelyek címében szerepel az 'i' betű.
                .forEach(e -> System.out.println(e)); // A szűrt könyvek kiíratása.

        // 3. Könyvek átlagos árának kiszámítása (csak ahol az ár nem null).
        System.out.println("\n=== 4. A könyvek átlagos ára: ===");
        System.out.println(
                konyvek.stream()
                        .filter(e -> e.getAr() != null) // Csak azok a könyvek, ahol az ár nem null.
                        .mapToInt(Konyv::getAr) // A könyvek objektumait az árukra képezzük le.
                        .average() // Az árak átlagát számítjuk.
                        .getAsDouble()); // Az átlagot double típusban visszük ki.

        // 4. Könyvek számának meghatározása.
        System.out.println("\n=== 5. A könyvek száma: ===");
        System.out.println(konyvek.stream().count()); // A stream-ben lévő könyvek számát adja vissza.

        // 5. Legdrágább könyv keresése.
        System.out.println("\n=== 6. A legdrágább könyv: ===");
        System.out.println(konyvek.stream()
                .max(Comparator.comparing(e -> e.getAr() != null ? e.getAr() : 0)) // Az ár alapján keresünk, null ár esetén 0-t használva.
                .get()); // Az eredményként kapott legdrágább könyvet kiírjuk.

        // 6. Könyvcímek összefűzése egyetlen szövegbe.
        System.out.println("\n=== 7. A könyvek címeinek összefűzése: ===");
        System.out.println(konyvek.stream()
                .map(Konyv::getCim) // A könyveket a címükre képezzük le.
                .reduce("", (a, b) -> a + " " + b)); // A címeket egyetlen szöveggé fűzzük össze.

        // 7. Könyvek csoportosítása kiadó szerint.
        System.out.println("\n=== 8. Könyvek kiadók szerinti csoportosítása: ===");
        System.out.println(konyvek.stream()
                .filter(e -> e.getTema() != null
                        && (e.getTema().equals("sci-fi") || e.getTema().equals("krimi") || e.getTema().equals("horror")))
                .collect(Collectors.groupingBy(Konyv::getKiado))); // A könyveket kiadó szerint csoportosítjuk.

        // 8. Kiadónkénti átlagárak kiszámítása.
        System.out.println("\n=== 9. Kiadónkénti átlagárak: ===");
        System.out.println(konyvek.stream()
                .filter(e -> e.getTema() != null
                        && (e.getTema().equals("sci-fi") || e.getTema().equals("krimi") || e.getTema().equals("horror")))
                .collect(Collectors.groupingBy(Konyv::getKiado, Collectors.averagingInt(Konyv::getAr)))); 
        // Kiadónként az árak átlagát számítjuk.

        // 9. Kiadónként a legolcsóbb könyv keresése.
        System.out.println("\n=== 10. Kiadónként a legolcsóbb könyv: ===");
        System.out.println(konyvek.stream()
                .filter(e -> e.getTema() != null
                        && (e.getTema().equals("sci-fi") || e.getTema().equals("krimi") || e.getTema().equals("horror")))
                .collect(Collectors.groupingBy(Konyv::getKiado, Collectors.minBy(Comparator.comparing(Konyv::getAr))))); 

        // 10. Kiadónként a témák összefűzése egyetlen szöveggé.
        System.out.println("\n=== 11. Kiadónként a témák összefűzése: ===");
        System.out.println(konyvek.stream()
                .filter(e -> e.getTema() != null
                        && (e.getTema().equals("sci-fi") || e.getTema().equals("krimi") || e.getTema().equals("horror")))
                .collect(Collectors.groupingBy(Konyv::getKiado, 
                        Collectors.reducing("", Konyv::getTema, String::concat)))); 
        // A témák szöveggé alakítása, csoportosítva kiadó szerint.
    }
}
