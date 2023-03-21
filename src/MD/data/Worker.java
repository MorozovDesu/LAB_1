package MD.data;

public class Worker extends Group {
    public Worker(String name) {
        super(name);
    }
    public int getDetail() {
        return this.getObjetName();
    }
    public String processOperation() {
        String name = this.getName();
        return " Работник по имени " + name + " изготовил деталь с номером : " + this.getDetail();
    }
}