package MD.data;

public class Worker extends Group {
    public Worker(String name) {
        super(name);
    }

    public String getShip() {
        return this.getObjetName();
    }

    public String processOperation() {
        String var10000 = this.getName();
        return " Судостроительная компнания под названием " + var10000 + " построила корабль: " + this.getShip();
    }
}