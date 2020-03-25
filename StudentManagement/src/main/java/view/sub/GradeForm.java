/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import entities.Grade;
import entities.Schedule;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class GradeForm extends JFrame {

    private JTable tblGrade;
    private DefaultTableModel model;
    private JScrollPane js;
    private JTextField gradeRegisterTextField;

    private final Container container = getContentPane();

    public GradeForm(JTextField gradeRegisterTextField) {
        this.gradeRegisterTextField = gradeRegisterTextField;
        initComponent();
        evens();
    }

    private void initComponent() {
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        tblGrade = new JTable();
        js = new JScrollPane(tblGrade);
        js.setBounds(20, 20, 800, 350);
        add(js);
        loadDataGradeIntoJTable(mock());
    }

    private void loadDataGradeIntoJTable(List<Grade> list) {
        list.forEach(t -> System.out.println(t.getIdGrade()));
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Vector column = new Vector();
        column.add("Id");
        column.add("name");
        column.add("start time");
        column.add("end time");
        column.add("day of week");
        column.add("student quantity");
        column.add("select");

        model.setColumnIdentifiers(column);
        for (int i = 0; i < list.size(); i++) {
            Grade pro = (Grade) list.get(i);
            Vector row = new Vector();
            row.add(pro.getIdGrade());
            row.add(pro.getNameGrade());
            row.add(pro.getScheduleGrade().getStartTime());
            row.add(pro.getScheduleGrade().getEndTime());
            row.add(pro.getScheduleGrade().getDayOfWeek());
            row.add(pro.getStudentQuantity());
            row.add("<html><a href='select';' >Selected</a></html>");
            model.addRow(row);
        }
        tblGrade.setModel(model);
        tblGrade.setRowSelectionAllowed(false);
        tblGrade.setCellSelectionEnabled(true);
        tblGrade.setFocusable(false);
    }

    public List<Grade> mock() {
        List<Grade> grades = new ArrayList<>();
        Grade grade1 = new Grade("g-01", "java-01", new Schedule("s-01", LocalTime.MIN, LocalTime.MIN, DayOfWeek.MONDAY), 30);
        Grade grade2 = new Grade("g-02", "java-02", new Schedule("s-02", LocalTime.MIN, LocalTime.MIN, DayOfWeek.MONDAY), 30);
        Grade grade3 = new Grade("g-03", "java-03", new Schedule("s-03", LocalTime.MIN, LocalTime.MIN, DayOfWeek.MONDAY), 28);
        Grade grade4 = new Grade("g-04", "java-04", new Schedule("s-04", LocalTime.MIN, LocalTime.MIN, DayOfWeek.MONDAY), 29);
        Grade grade5 = new Grade("g-05", "java-05", new Schedule("s-05", LocalTime.MIN, LocalTime.MIN, DayOfWeek.MONDAY), 30);
        Grade grade6 = new Grade("g-06", "java-06", new Schedule("s-06", LocalTime.MIN, LocalTime.MIN, DayOfWeek.MONDAY), 15);
        Grade grade7 = new Grade("g-06", "java-06", new Schedule("s-06", LocalTime.MIN, LocalTime.MIN, DayOfWeek.MONDAY), 15);
        Grade grade8 = new Grade("g-06", "java-06", new Schedule("s-06", LocalTime.MIN, LocalTime.MIN, DayOfWeek.MONDAY), 15);
        Grade grade9 = new Grade("g-06", "java-06", new Schedule("s-06", LocalTime.MIN, LocalTime.MIN, DayOfWeek.MONDAY), 15);
        grades.add(grade1);
        grades.add(grade2);
        grades.add(grade3);
        grades.add(grade4);
        grades.add(grade5);
        grades.add(grade6);
        grades.add(grade7);
        grades.add(grade8);
        grades.add(grade9);
        return grades;
    }

    private void evens() {
        tblGrade.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = tblGrade.rowAtPoint(evt.getPoint());
                int col = tblGrade.columnAtPoint(evt.getPoint());
                if ((row >= 0 && col == 6)) {
                    Object[] rowData = new Object[tblGrade.getColumnCount()];
                    for (int i = 0; i < tblGrade.getColumnCount(); i++) {
                        rowData[i] = tblGrade.getValueAt(row, i);
                    }
                    gradeRegisterTextField.setText((String) rowData[0]);
                    setVisible(false); 
                }
            }
        });
    }
}
