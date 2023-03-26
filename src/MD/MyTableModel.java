package MD;

import MD.data.Administration;
import MD.data.Group;
import MD.data.Teacher;
import MD.data.Worker;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
    private final Group data;
    public MyTableModel(Group group) {
        this.data = group;
    }
    public int getRowCount() {
        return this.data.getCount();
    }
    public int getColumnCount() {
        return 2;
    }
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Имя сотрудника";
            case 1:
                return "Должность сотрудника";
            default:
                return "";
        }
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.data.getOrganization(rowIndex).getName();
            case 1:
                Group org = this.data.getOrganization(rowIndex);
                if (org instanceof Administration) {
                    return "Administration";
                } else {
                    if (org instanceof Worker) {
                        return "Worker";
                    }
                    return "Teacher";
                }
            default:
                return "default";
        }
    }
    public void delete(int ind) {
        Status.deleteSelectedCompany(ind);
        this.fireTableDataChanged();
    }
    public void add(String name, String ind) {
        switch (ind) {
            case "Worker":
                Status.GROUPS.add(new Worker(name));
                break;
            case "Administration":
                Status.GROUPS.add(new Administration(name));
                break;
            case "Teacher":
                Status.GROUPS.add(new Teacher(name));
                break;
            default:
                Status.GROUPS.add(new Teacher("default"));
        }
        this.fireTableDataChanged();
    }
    public String doActivity(int ind) {
        return Status.doSelectedActivity(ind);
    }

    public String find(String name){
        return Status.findAct(name);
    }
}
