package MD.data;

import MD.State;
import java.util.Random;

public abstract class Group {
    private final String name;
    public Group(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    protected int getObjetName() {
        Random random = new Random();
        return random.nextInt(999);
    }
    public int getCount() {
        return State.GROUPS.size();
    }
    public Group getOrganization(int index) {
        return (Group)State.GROUPS.get(index);
    }
    public abstract String processOperation();
}
