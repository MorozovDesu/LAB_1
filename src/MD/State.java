package MD;

import MD.data.Group;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class State {
    public static final ArrayList<Group> GROUPS = new ArrayList();
    public State() {
    }
    public Group getGroup (int index) {
        return (Group)GROUPS.get(index);
    }
    public static void deleteSelectedCompany(int ind) {
        GROUPS.remove(ind);
    }
    public static String doSelectedActivity(int ind) {
        try {
            Group org = (Group)GROUPS.get(ind);
            String name = org.getName();
            Iterator var3 = GROUPS.iterator();
            Group group;
            while(true) {
                if (!var3.hasNext()) {
                    return null;
                }
                group = (Group)var3.next();
                if (group.getName() == null) {
                    if (name == null) {
                        break;
                    }
                } else if (group.getName().equals(name)) {
                    break;
                }
            }
            return group.processOperation();
        }catch (IndexOutOfBoundsException ignored){}

        return null;
    }
    public static void doAllActivities() {
        if (GROUPS.isEmpty()) {
            System.out.println("бом бом...");
        } else {
            System.out.println();
            Iterator var0 = GROUPS.iterator();

            while(var0.hasNext()) {
                Group group = (Group)var0.next();
                group.processOperation();
            }
            System.out.println();
        }
    }
    public static void getGroupList() {
        System.out.println();
        for(int i = 0; i < GROUPS.size(); ++i) {
            System.out.println(i + 1 + " - " + ((Group)GROUPS.get(i)).getName());
        }
        System.out.println();
    }
}