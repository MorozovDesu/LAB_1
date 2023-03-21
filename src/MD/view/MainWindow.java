package MD.view;

import MD.MyTableModel;
import MD.data.Group;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MainWindow extends JFrame {
    private final JTable jTable = new JTable();
    private final MyTableModel myTableModel = new MyTableModel(new Group("Cadres") {
        public String processOperation() {
            return null;
        }
    });
    private final JTextField nameField;
    private final JComboBox groupType;
    private final JTextField actField;

    public MainWindow() {
        super("Groups");
        this.jTable.setModel(this.myTableModel);
        JScrollPane jScrollPane = new JScrollPane(this.jTable);
        JButton buttonDelete = new JButton("Удалить сотрудника");
        buttonDelete.addActionListener((e) -> {
            try {
                this.myTableModel.delete(this.jTable.getSelectedRow());
            } catch (IndexOutOfBoundsException exception) {
                JDialog jDialog = new JDialog(this, "Выделите строку", true);
                setResizable(true);
                jDialog.setSize(200, 50);
                pack();
                jDialog.setLocationRelativeTo((Component)null);
                jDialog.setVisible(true);
            }
        });
        String[] group = new String[]{"Worker", "Administration", "Teacher"};
        this.groupType = new JComboBox(group);
        this.nameField = new JTextField();
        this.nameField.setText("Имя сотрудника");
        JButton buttonAdd = new JButton("Добавить сотрудника");
        buttonAdd.addActionListener((e) -> {
            String type = this.groupType.getSelectedItem().toString();
            this.myTableModel.add(this.nameField.getText(), type);
        });
        JButton doAct = new JButton("Выполнить действие");
        doAct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainWindow.this.actField.setText(MainWindow.this.myTableModel.doActivity(MainWindow.this.jTable.getSelectedRow()));
            }
        });
        this.actField = new JTextField("Выполненное действие");
        this.actField.setEditable(false);
        JPanel panel = new JPanel();
        JPanel panelR = new JPanel();
        this.add(jScrollPane);
        panel.setLayout(new FlowLayout());
        panelR.setLayout(new GridLayout(2, 1));
        panel.add(buttonAdd);
        panel.add(this.groupType);
        panel.add(this.nameField);
        panel.add(buttonDelete);
        panelR.add(doAct);
        panelR.add(this.actField);
        this.add(panelR, "North");
        this.add(panel, "South");
        this.setLocationRelativeTo((Component)null);
        this.pack();
        this.setVisible(true);
    }
}
