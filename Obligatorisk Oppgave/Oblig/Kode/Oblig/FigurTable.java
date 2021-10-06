package Oblig;

public class FigurTable {
    private int id;
    private String type;

    public FigurTable() {
    }

    public FigurTable(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FigurTable id(int id) {
        this.id = id;
        return this;
    }

    public FigurTable type(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", type='" + getType() + "'" + "}";
    }

}
