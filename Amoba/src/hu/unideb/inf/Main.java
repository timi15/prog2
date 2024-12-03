package hu.unideb.inf;

public class Main {
    public static void main(String[] args) {
        Character jel1='*';
        Character jel2='o';
        Jatek jatek = new Jatek(jel1);


        jatek.printTable();

        System.out.println(jatek.jatekosLep(jel1, 0,0));
        jatek.printCurrentTabla();

        System.out.println(jatek.jatekosLep(jel2, 0,1));
        jatek.printCurrentTabla();

        System.out.println(jatek.jatekosLep(jel1, 1,1));
        jatek.printCurrentTabla();

        System.out.println(jatek.jatekosLep(jel2, 0,2));
        jatek.printCurrentTabla();

        System.out.println(jatek.jatekosLep(jel1, 2,2));
        jatek.printCurrentTabla();

    }
}