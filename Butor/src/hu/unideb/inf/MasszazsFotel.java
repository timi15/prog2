package hu.unideb.inf;

public class MasszazsFotel extends Uloalkalmatossag implements ElektronikusEszkoz {
    private boolean bekapcsolt = false;
    private int erosseg;
    private final int MAX_ULOHELYEK_SZAMA = 1;

    public MasszazsFotel(String anyag, int erosseg) {
        super(anyag);
        this.erosseg = erosseg;
    }

    @Override
    public void bekapcsol() {
        this.bekapcsolt=true;
    }

    @Override
    public void kikapcsol() {
        this.bekapcsolt=false;
    }

    @Override
    public int getMaxUlohelyekSzama() {
        return this.MAX_ULOHELYEK_SZAMA;
    }

    @Override
    public void javitas() {
        this.bekapcsolt = false;
        System.out.println("A masszazsfotel javitas alatt all!");
    }

    public boolean isBekapcsolt() {
        return bekapcsolt;
    }

    public int getErosseg() {
        return erosseg;
    }

    public void setErosseg(int erosseg) {
        this.erosseg = erosseg;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MasszazsFotel{");
        sb.append("bekapcsolt=").append(bekapcsolt);
        sb.append(", erosseg=").append(erosseg);
        sb.append(", MAX_ULOHELYEK_SZAMA=").append(MAX_ULOHELYEK_SZAMA);
        sb.append('}');
        return sb.toString();
    }
}
