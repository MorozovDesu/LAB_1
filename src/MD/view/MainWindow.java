package MD.view;

import MD.MyTableModel;
import MD.data.Group;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

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
                if (this.jTable.getSelectedRow() != -1) {
                    this.myTableModel.delete(this.jTable.getSelectedRow());
                } else if (this.myTableModel.getRowCount() > 0) {
                    this.myTableModel.delete(this.myTableModel.getRowCount() - 1);
                }
            } catch (IndexOutOfBoundsException ignored  ) { }
        });
        String[] group = new String[]{"Worker", "Administration", "Teacher"};
        this.groupType = new JComboBox(group);
        this.nameField = new JTextField();
        this.nameField.setText("Имя сотрудника");
        JButton buttonAdd = new JButton("Добавить сотрудника");
        buttonAdd.addActionListener((e) -> {
            String type = Objects.requireNonNull(this.groupType.getSelectedItem()).toString();
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

        JComboBox<String> filterComboBox = new JComboBox<>(new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"});

        filterComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedLetter = (String) filterComboBox.getSelectedItem();
                myTableModel.filterByLetter(selectedLetter);
            }
        });

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new FlowLayout());
        filterPanel.add(new JLabel("Фильтр по букве:"));
        filterPanel.add(filterComboBox);

        panel.add(filterPanel, "West");



        panelR.add(doAct);
        panelR.add(this.actField);
        this.add(panelR, "South");

        this.add(panel, "North");
        this.setLocationRelativeTo((Component)null);
        this.pack();
        this.setVisible(true);
    }
}
