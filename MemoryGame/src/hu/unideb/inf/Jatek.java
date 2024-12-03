package hu.unideb.inf;

import java.util.HashMap;
import java.util.Map;

public class Jatek {

    private char[][] tabla;
    private char[][] betuk;
    private boolean jatekFut;
    private static int counter = 4;

    public Jatek(char[][] betuk) {
        validateBetuk(betuk);

        this.betuk = betuk;
        this.tabla = new char[2][4];
        this.jatekFut = true;


        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                tabla[i][j] = '-';
            }

        }
    }

    public String megnez(int x1, int y1, int x2, int y2) {

        if (!isJatekFut()) {
            throw new MemoriaExcepion("A játék nincs elindítva vagy már fut");
        }
        if (!validIndex(x1, y1) || !validIndex(x2, y2)) {
            throw new MemoriaExcepion("A megadotott paraméterek nem megfelelők");
        }

        char lap1 = betuk[x1][y1];
        char lap2 = betuk[x2][y2];

        if (lap1 == '\"' || lap2 == '\"') {
            return "Az egyik vagy mindkettő lap már felvan fordítva";
        }

        if (lap1 != lap2) {
            return String.format("A lapok nem egyeznek: (%d, %d)=%c, (%d, %d)=%c", x1, y1, lap1, x2, y2, lap2);
        }

        counter--;

        betuk[x1][y1] = '\"';
        betuk[x2][y2] = '\"';
        tabla[x1][y1] = '\"';
        tabla[x2][y2] = '\"';
        setJatekFut(false);
        return "Nyert";

    }

    private boolean validIndex(int x, int y) {
        return x >= 0 && x < tabla.length && y >= 0 && y < tabla[0].length;
    }

    private void validateBetuk(char[][] betuk) {
        Map<Character, Integer> betuelofordulas = new HashMap<>();

        for (char[] sor : betuk) {
            for (char betu : sor) {
                if (betu < 'a' || betu > 'd') {
                    throw new MemoriaExcepion("A tabla csak az 'a'-'d' betűket tartalmazhatja.");
                }
                betuelofordulas.put(betu, betuelofordulas.getOrDefault(betu, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : betuelofordulas.entrySet()) {
            if (entry.getValue() != 2) {
                throw new MemoriaExcepion("nem pontosan kétszer szerepel.");
            }
        }
    }

    public boolean isJatekFut() {
        return jatekFut;
    }

    public void setJatekFut(boolean jatekFut) {
        this.jatekFut = jatekFut;
    }

    public void printTabla() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tabla[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printBetuk() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(betuk[i][j] + " ");
            }
            System.out.println();

        }
    }
}
