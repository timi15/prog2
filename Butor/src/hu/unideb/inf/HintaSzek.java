package hu.unideb.inf;

public class HintaSzek extends Uloalkalmatossag {

    private boolean hintazik;
    private final int MAX_ULOHELYEK_SZAMA = 1;

    public HintaSzek(String anyag) {
        super(anyag);
        this.hintazik = false;
    }

    public void hintaztat(){
        this.hintazik=true;
    }

    public void megallit(){
        this.hintazik=false;
    }

    @Override
    public int getMaxUlohelyekSzama() {
        return MAX_ULOHELYEK_SZAMA;
    }

    @Override
    public void javitas() {
        this.hintazik = false;
        System.out.println("A hintaszek javitas alatt all!");
    }

    public boolean isHintazik() {
        return hintazik;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HintaSzek{");
        sb.append("hintazik=").append(hintazik);
        sb.append(", MAX_ULOHELYEK_SZAMA=").append(MAX_ULOHELYEK_SZAMA);
        sb.append('}');
        return sb.toString();
    }
}
