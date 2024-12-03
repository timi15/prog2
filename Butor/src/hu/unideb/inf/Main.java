package hu.unideb.inf;

public class Main {
    public static void main(String[] args) {
        HintaSzek hintaSzek = new HintaSzek("fa");
        MasszazsFotel masszazsFotel = new MasszazsFotel("bőr", 5);

        System.out.println(hintaSzek);
        System.out.println(masszazsFotel);

        System.out.println(Uloalkalmatossag.getOsszesUloalkalmatossag());

        hintaSzek.leul();
        System.out.println(hintaSzek);
        hintaSzek.hintaztat();
        System.out.println(hintaSzek);
        hintaSzek.megallit();
        System.out.println(hintaSzek);



    }
}