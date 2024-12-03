package hu.unideb.inf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JatekTest {

    @Test
    void testWinningSequence(){

        Character jel1='*';
        Character jel2='o';
        Jatek jatek = new Jatek(jel2);

        assertDoesNotThrow(()->AmobaException.class);
        assertEquals("nem nyert",jatek.jatekosLep(jel1, 0,0));
        assertEquals("nem nyert",jatek.jatekosLep(jel2, 0,1));
        assertEquals("nem nyert",jatek.jatekosLep(jel1, 1,1));
        assertEquals("nem nyert",jatek.jatekosLep(jel2, 0,2));
        assertEquals("nyert",jatek.jatekosLep(jel1, 2,2));

        assertFalse(jatek.isJatekFut());


    }

    @Test
    void testOccupiedPlace(){
        Character jel1='*';
        Character jel2='o';
        Jatek jatek = new Jatek(jel2);

        assertEquals("nem nyert",jatek.jatekosLep(jel1, 0,0));
        Exception exception = assertThrows(AmobaException.class, ()->{
            jatek.jatekosLep(jel2, 0,0);
        });

        assertEquals("Ezen a helyen már van jel", exception.getMessage());
    }

    @Test
    void gameNotStarted(){
        Character jel1='*';
        Character jel2='o';
        Character jel3='x';
        Jatek jatek = new Jatek(jel2);

        jatek.jatekosLep(jel1, 0,0);
        jatek.jatekosLep(jel2, 1,0);
        Exception exception = assertThrows(AmobaException.class, ()->{
            jatek.jatekosLep(jel3, 0,2);
        });

        assertEquals("A játék nincs elindíva vagy már véget ért", exception.getMessage());
    }

}