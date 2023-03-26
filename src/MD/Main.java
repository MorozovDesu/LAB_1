package MD;

import MD.data.Administration;
import MD.data.Teacher;
import MD.data.Worker;
import MD.view.MainWindow;

public class Main {
    public Main() {
    }
    public static void main(String[] args) {
        Status.GROUPS.add(new Administration("Олег"));
        Status.GROUPS.add(new Worker("Вася"));
        Status.GROUPS.add(new Teacher("Яна"));
        new MainWindow();
    }
}
