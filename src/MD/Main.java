package MD;

import MD.data.Administration;
import MD.data.Teacher;
import MD.data.Worker;
import MD.view.MainWindow;

public class Main {
    public Main() {
    }
    public static void main(String[] args) {
        State.GROUPS.add(new Administration("Олег"));
        State.GROUPS.add(new Worker("Вася"));
        State.GROUPS.add(new Teacher("Яна"));
        new MainWindow();
    }
}
