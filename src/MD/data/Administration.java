package MD.data;

public class Administration extends Group {
    public Administration(String name) {
        super(name);
    }
    private int registrHuman() {
        return this.getObjetName();
    }
    public String processOperation() {
        String name = this.getName();
        return " Администратор с именем " + name + " зарегистрировал человека с ID: " + this.registrHuman();
    }
}
