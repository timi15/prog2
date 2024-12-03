public class Crystal implements Comparable{
    private int id;
    private String name;
    private double hardness;
    private int price;

    public Crystal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Crystal(int id, String name, double hardness, int price) {
        this.id = id;
        this.name = name;
        this.hardness = hardness;
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Crystal{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", hardness=").append(hardness);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Crystal){
            return Integer.compare(this.id, ((Crystal) o).id);
        }
        return this.hashCode() - o.hashCode();
    }
}
