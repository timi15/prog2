package hu.unideb.inf;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Jatek {
    private Character[][] tabla;
    private Character jatekosNeve;
    private boolean jatekFut;
    private LinkedHashSet<Character> jatekosok = new LinkedHashSet<>();
    private ArrayList<Character> jatekosokSorrend = new ArrayList<>();

    public Jatek(Character jatekosNeve) {
        this.tabla = new Character[3][3];
        this.jatekosNeve = jatekosNeve;
        this.jatekFut = true;
        this.jatekosok.add(jatekosNeve);
        this.jatekosokSorrend.add(jatekosNeve);

        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[0].length; j++) {
                tabla[i][j] = '-';
            }
        }
    }

    public String jatekosLep(Character jatekosNeve, int x, int y) {
        jatekosok.add(jatekosNeve);
        if (!jatekFut || jatekosok.size() > 2) {
            throw new AmobaException("A játék nincs elindíva vagy már véget ért");
        }

        if (jatekosokSorrend.getLast().equals(jatekosNeve)) {
            throw new AmobaException("Rossz következő játékost adtál meg");
        }

        if ((x > tabla.length || x < 0) || (y > tabla[0].length || y < 0)) {
            throw new AmobaException("ilyen mező nincs");
        }

        if (tabla[x][y] == jatekosok.getFirst() || tabla[x][y] == jatekosok.getLast()) {
            throw new AmobaException("Ezen a helyen már van jel");
        }

        tabla[x][y] = jatekosNeve;

        jatekosokSorrend.add(jatekosNeve);

        if ((tabla[0][0] == jatekosNeve && tabla[0][1] == jatekosNeve && tabla[0][2] == jatekosNeve) ||
                (tabla[1][0] == jatekosNeve && tabla[1][1] == jatekosNeve && tabla[1][2] == jatekosNeve) ||
                (tabla[2][0] == jatekosNeve && tabla[2][1] == jatekosNeve && tabla[2][2] == jatekosNeve) ||
                (tabla[0][0] == jatekosNeve && tabla[1][0] == jatekosNeve && tabla[2][0] == jatekosNeve) ||
                (tabla[0][1] == jatekosNeve && tabla[1][1] == jatekosNeve && tabla[2][1] == jatekosNeve) ||
                (tabla[0][2] == jatekosNeve && tabla[1][2] == jatekosNeve && tabla[2][2] == jatekosNeve) ||
                (tabla[0][0] == jatekosNeve && tabla[1][1] == jatekosNeve && tabla[2][2] == jatekosNeve) ||
                (tabla[2][0] == jatekosNeve && tabla[1][1] == jatekosNeve && tabla[0][2] == jatekosNeve)) {

            this.jatekFut=false;
            return "nyert";

        }

        return "nem nyert";

    }

    public boolean isJatekFut() {
        return jatekFut;
    }

    public void printTable(){
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[0].length; j++) {
                System.out.print("-"+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printCurrentTabla(){
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[0].length; j++) {
                if(tabla[i][j] == 'o'){
                    System.out.print('o'+" ");
                } else if (tabla[i][j] == '*') {
                    System.out.print("*"+" ");
                }else {
                    System.out.print("-"+" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


}
