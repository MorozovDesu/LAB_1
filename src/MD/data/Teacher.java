package MD.data;

public class Teacher extends Group {
    public Teacher(String name) {
        super(name);
    }

    private String craftAirPlane() {
        return this.getObjetName();
    }

    public String processOperation() {
        String var10000 = this.getName();
        return "Авиастроительная компания под названием " + var10000 + " построила самолет с ID: " + this.craftAirPlane();
    }
}
