package hu.unideb.inf;

public class Main {
    public static void main(String[] args) {

        char[][] betuk = {
            {'a', 'b', 'c', 'd'},
            {'a', 'b', 'c', 'd'},
        };

        Jatek jatek = new Jatek(betuk);

        //jatek.printTabla();

        System.out.println(jatek.megnez(0,0, 0,3));
        jatek.printTabla();
        System.out.println(jatek.megnez(0,1, 1,1));
        jatek.printTabla();
        System.out.println(jatek.megnez(0,2, 1,2));
        jatek.printTabla();
        System.out.println(jatek.megnez(0,3, 1,3));
        jatek.printTabla();
        jatek.printBetuk();

    }
}