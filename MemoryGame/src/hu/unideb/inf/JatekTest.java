package hu.unideb.inf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class JatekTest {

    @Test
    void testWinningSequence(){
        char[][] betuk = {
                {'a', 'b', 'c', 'd'},
                {'a', 'b', 'c', 'd'},
        };

        assertDoesNotThrow(()-> new Jatek(betuk));
        Jatek jatek = new Jatek(betuk);

        assertEquals("A lapok megegyeznek", jatek.megnez(0,0, 1,0));
        assertEquals("A lapok megegyeznek", jatek.megnez(0,1, 1,1));
        assertEquals("A lapok megegyeznek", jatek.megnez(0,2, 1,2));
        assertEquals("Nyert", jatek.megnez(0,3, 1,3));


        assertFalse(jatek.isJatekFut());
    }

    @Test
    void testNotStartedGame(){
        char[][] betuk = {
                {'a', 'b', 'c', 'd'},
                {'a', 'b', 'c', 'd'},
        };

        assertDoesNotThrow(()-> new Jatek(betuk));
        Jatek jatek = new Jatek(betuk);

        assertEquals("A lapok megegyeznek", jatek.megnez(0,0, 1,0));
        assertEquals("A lapok megegyeznek", jatek.megnez(0,1, 1,1));
        assertEquals("A lapok megegyeznek", jatek.megnez(0,2, 1,2));
        assertEquals("Nyert", jatek.megnez(0,3, 1,3));

        Exception exception = assertThrows(MemoriaExcepion.class, ()->{
            jatek.megnez(0,0,0,0);
        });

        assertNotNull(exception.getMessage());
        assertEquals("A játék nincs elindítva vagy már fut", exception.getMessage());
    }

    @Test
    void pairNotEquals(){
        char[][] betuk = {
                {'a', 'b', 'c', 'd'},
                {'a', 'b', 'c', 'd'},
        };

        Jatek jatek = new Jatek(betuk);

        int x1 = 0;
        int y1 = 0;
        char lap1 = betuk[x1][y1];
        int x2 = 0;
        int y2 = 3;
        char lap2 = betuk[x2][y2];


        String expected = String.format("A lapok nem egyeznek: (%d, %d)=%c, (%d, %d)=%c", x1, y1, lap1, x2, y2, lap2);
        System.out.println(expected);

        assertEquals(expected, jatek.megnez(x1,y1, x2,y2));
    }

    @Test
    void testOccupiedLetter(){
        char[][] betuk = {
                {'a', 'b', 'c', 'd'},
                {'a', 'b', 'c', 'd'},
        };
        assertDoesNotThrow(()-> new Jatek(betuk));
        Jatek jatek = new Jatek(betuk);

        assertEquals("A lapok megegyeznek", jatek.megnez(0,0, 1,0));
        assertEquals("Az egyik vagy mindkettő lap már felvan fordítva",jatek.megnez(0,0, 1,1) );
    }

    @Test
    void testInvalidLetter(){
        char[][] betuk = {
                {'a', 'b', 'c', 'd'},
                {'a', 'b', 'c', 'e'},
        };

        Exception exception = assertThrows(MemoriaExcepion.class, ()->new Jatek(betuk));
        assertNotNull(exception.getMessage());
        assertEquals("A tabla csak az 'a'-'d' betűket tartalmazhatja.", exception.getMessage());
    }

    @Test
    void testInvalidLetterPair(){
        char[][] betuk = {
                {'a', 'b', 'c', 'd'},
                {'a', 'b', 'd', 'd'},
        };

        Exception exception = assertThrows(MemoriaExcepion.class, ()-> new Jatek(betuk));
        assertNotNull(exception.getMessage());
        assertEquals("az egyik betű nem pontosan kétszer szerepel.", exception.getMessage());
    }

    @Test
    void testInvalidIndex(){
        char[][] betuk = {
                {'a', 'b', 'c', 'd'},
                {'a', 'b', 'c', 'd'},
        };
        Jatek jatek = new Jatek(betuk);
        Exception exception = assertThrows(MemoriaExcepion.class, ()->{
            jatek.megnez(4,0, 1,0);
        });

        assertNotNull(exception.getMessage());
        assertEquals("A megadotott paraméterek nem megfelelők", exception.getMessage());
    }

}