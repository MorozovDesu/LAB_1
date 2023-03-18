package MD.data;

public class Administration extends Group {
    public Administration(String name) {
        super(name);
    }

    private String insuranceHuman() {
        return this.getObjetName();
    }

    public String processOperation() {
        String var10000 = this.getName();
        return " Страховая компания под названием " + var10000 + " застраховала человека с ID: " + this.insuranceHuman();
    }
}
