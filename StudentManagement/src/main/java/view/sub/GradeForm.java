/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import entities.Grade;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import service.GradeService;
import service.GradeServiceImpl;

public class GradeForm extends JFrame {

    private JTable tblGrade;
    private DefaultTableModel model;
    private JScrollPane js;
    private JTextField gradeRegisterTextField;
    private JTextField courseTextField;
    private JTextField costTextField;

    public GradeForm(JTextField gradeRegisterTextField, JTextField courseTextField, JTextField costTextField) {
        this.courseTextField = courseTextField;
        this.costTextField = costTextField;
        this.gradeRegisterTextField = gradeRegisterTextField;
        initComponent();
        events();
    }

    private void initComponent() {
        setTitle("Grades");
        setSize(800, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        tblGrade = new JTable();
        js = new JScrollPane(tblGrade);
        js.setBounds(20, 20, 800, 300);
        add(js);
        loadDataGradeIntoJTable(mockData());
    }
    
    private void loadDataGradeIntoJTable(List<Grade> list) {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Vector column = new Vector();
        column.add("Id");
        column.add("Name");
        column.add("Start Time");
        column.add("End Time");
        column.add("Select");

        model.setColumnIdentifiers(column);
        for (int i = 0; i < list.size(); i++) {
            Grade grade = (Grade) list.get(i);
            Vector row = new Vector();
            row.add(grade.getIdGrade());
            row.add(grade.getNameGrade());
            row.add(grade.getStartTime().toString());
            row.add(grade.getEndTime().toString());
            row.add("<html><a href='select';' >Selected</a></html>");
            model.addRow(row);
        }
        tblGrade.setModel(model);
        tblGrade.setRowSelectionAllowed(false);
        tblGrade.setCellSelectionEnabled(true);
        tblGrade.setFocusable(false);
    }

    private void events() {
        tblGrade.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = tblGrade.rowAtPoint(evt.getPoint());
                int col = tblGrade.columnAtPoint(evt.getPoint());
                if ((row >= 0 && col == 4)) {
                    String IdGrade = (String) tblGrade.getValueAt(row, 0);
                    Grade grade = new GradeServiceImpl().getGrade(IdGrade);
                    gradeRegisterTextField.setText(grade.getIdGrade());
                    courseTextField.setText(grade.getCourse().getNameCourse());
                    costTextField.setText(String.valueOf(grade.getCourse().getCost()));
                    setVisible(false);
                }
            }
        });
    }

    private List<Grade> mockData() {
        GradeService gradeService = new GradeServiceImpl();
        return gradeService.getAll();
    }
}
