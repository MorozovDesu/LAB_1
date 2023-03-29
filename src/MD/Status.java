package MD;

import MD.data.Group;

import java.util.ArrayList;
import java.util.Iterator;

public class Status {
    public static final ArrayList<Group> GROUPS = new ArrayList();
    public Status() {
    }
    public Group getGroup (int index) {
        return (Group)GROUPS.get(index);
    }
    public static void deleteSelectedCompany(int ind) {
        GROUPS.remove(ind);
    }
    public static String doSelectedActivity(int ind) {
        try {
            Group grp = (Group)GROUPS.get(ind);
            String name = grp.getName();
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
    public static String findName(String name) {
        for (Group group: GROUPS) {
            if (group.getName() == null ? name == null : group.getName().equals(name)) {
                return group.processOperation();
            }
        }
        return ("Человека с таким именем нет");
    }
}