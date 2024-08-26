public class Model {
    private String name;

    public Model(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
