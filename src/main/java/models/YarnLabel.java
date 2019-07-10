package models;

public class YarnLabel implements RetrieveId {

    public enum Ply { SINGLE, DOUBLE, FOUR, EIGHT}
    public enum Weight {THREAD, LACE, SOCK, SPORT, DK, WORSTED, ARAN, BULKY}

    private int id;
    private String primaryFiber;
    private String secondaryFiber;
    private Ply ply;
    private Weight weight;
    private String color;

    public YarnLabel() {
    }

    public YarnLabel(int id, String primaryFiber, String secondaryFiber, Ply ply, Weight weight, String color) {
        this.id = id;
        this.primaryFiber = primaryFiber;
        this.secondaryFiber = secondaryFiber;
        this.ply = ply;
        this.weight = weight;
        this.color = color;
    }

    public YarnLabel(String primaryFiber, String secondaryFiber, Ply ply, Weight weight, String color) {
        this.primaryFiber = primaryFiber;
        this.secondaryFiber = secondaryFiber;
        this.ply = ply;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimaryFiber() {
        return primaryFiber;
    }

    public void setPrimaryFiber(String primaryFiber) {
        this.primaryFiber = primaryFiber;
    }

    public String getSecondaryFiber() {
        return secondaryFiber;
    }

    public void setSecondaryFiber(String secondaryFiber) {
        this.secondaryFiber = secondaryFiber;
    }

    public Ply getPly() {
        return ply;
    }

    public void setPly(Ply ply) {
        this.ply = ply;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
