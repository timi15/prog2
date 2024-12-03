package hu.unideb.inf;

public abstract class Uloalkalmatossag implements Butor {

    private static int osszesUloalkalmatossag = 0;
    private String anyag;
    private int szabadHely;

    protected Uloalkalmatossag(String anyag, int szabadHely) {
        this.anyag = anyag;
        this.szabadHely = szabadHely;
        osszesUloalkalmatossag++;
    }

    protected Uloalkalmatossag(String anyag) {
        this(anyag, 1);
    }

    public abstract int getMaxUlohelyekSzama();

    public void leul() {
        if (szabadHely > 0) {
            szabadHely--;
        }
    }

    public void felall() {
        if(osszesUloalkalmatossag>getMaxUlohelyekSzama()){
            szabadHely++;
        }
    }

    public String getAnyag() {
        return anyag;
    }

    public int getSzabadHely() {
        return szabadHely;
    }

    public static int getOsszesUloalkalmatossag() {
        return osszesUloalkalmatossag;
    }

}
