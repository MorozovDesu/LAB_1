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

    protected String getObjetName() {
        int leftLimit = 97;
        int rightLimit = 122;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(5);

        for(int i = 0; i < 5; ++i) {
            int randomLimitedInt = leftLimit + (int)(random.nextFloat() * (float)(rightLimit - leftLimit + 1));
            buffer.append((char)randomLimitedInt);
        }

        return buffer.toString();
    }

    public int getCount() {
        return State.GROUPS.size();
    }

    public Group getOrganization(int index) {
        return (Group)State.GROUPS.get(index);
    }

    public abstract String processOperation();
}
