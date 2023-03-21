package MD.data;

public class Teacher extends Group {
    public Teacher(String name) {
        super(name);
    }
    private int trainTheApprentice() {
        return this.getObjetName();
    }
    public String processOperation() {
        String name = this.getName();
        return " Учитель с именем " + name + " поставил оценку ученику с ID: " + this.trainTheApprentice();
    }
}
