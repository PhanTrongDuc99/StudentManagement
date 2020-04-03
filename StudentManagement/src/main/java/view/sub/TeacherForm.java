/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import entities.Profile;
import entities.Teacher;
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
import service.TeacherService;
import service.TeacherServiceImpl;

public class TeacherForm extends JFrame {

    private JTable tblTeacher;
    private DefaultTableModel model;
    private JScrollPane js;
    private JTextField teacherTextField;

    public TeacherForm(JTextField teacherTextField) {
        this.teacherTextField = teacherTextField;
        initComponent();
        events();
    }

    private void initComponent() {
        setTitle("Grades");
        setSize(800, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        tblTeacher = new JTable();
        js = new JScrollPane(tblTeacher);
        js.setBounds(20, 20, 800, 300);
        add(js);
        loadDataGradeIntoJTable(mockData());
    }

    private void loadDataGradeIntoJTable(List<Teacher> list) {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Vector column = new Vector();
        column.add("Id");
        column.add("Name");
        column.add("Email");
        column.add("Work place");
        column.add("Select");

        model.setColumnIdentifiers(column);
        for (int i = 0; i < list.size(); i++) {
            Profile pro = list.get(i).getProfileTeacher();
            Vector row = new Vector();
            row.add(list.get(i).getIdTeacher());
            row.add(pro.getFullName());
            row.add(pro.getEmail());
            row.add(list.get(i).getWorkPlace());
            row.add("<html><a href='select';' >Selected</a></html>");
            model.addRow(row);
        }
        tblTeacher.setModel(model);
        tblTeacher.setRowSelectionAllowed(false);
        tblTeacher.setCellSelectionEnabled(true);
        tblTeacher.setFocusable(false);
    }

    private void events() {
        tblTeacher.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = tblTeacher.rowAtPoint(evt.getPoint());
                int col = tblTeacher.columnAtPoint(evt.getPoint());
                if ((row >= 0 && col == 4)) {
                    teacherTextField.setText((String) tblTeacher.getValueAt(row, 0));
                    setVisible(false);
                }
            }
        });
    }

    private List<Teacher> mockData() {
        TeacherService tcService = new TeacherServiceImpl();
        return tcService.getAll();
    }
}
