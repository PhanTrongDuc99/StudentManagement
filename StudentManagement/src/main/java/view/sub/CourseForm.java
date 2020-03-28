/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import entities.Course;
import java.awt.Container;
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
import service.CourseService;
import service.CourseServiceImpl;

/**
 *
 * @author USER
 */
public class CourseForm extends JFrame {

    private JTable tblGrade;
    private DefaultTableModel model;
    private JScrollPane js;
    private JTextField courseRegisterTextField;

    private final Container container = getContentPane();

    public CourseForm(JTextField courseRegisterTextField) {
        this.courseRegisterTextField = courseRegisterTextField;
        initComponent();
        evens();
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

    private void loadDataGradeIntoJTable(List<Course> list) {
        model = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        Vector column = new Vector();
        column.add("Id");
        column.add("Name");
        column.add("Start Day");
        column.add("End Day");
        column.add("Cost");
        column.add("Select");

        model.setColumnIdentifiers(column);
        for (int i = 0; i < list.size(); i++) {
            Course course = (Course) list.get(i);
            Vector row = new Vector();
            row.add(course.getIdCourse());
            row.add(course.getNameCourse());
            row.add(course.getStartTime().toString());
            row.add(course.getEndTime().toString());
            row.add(course.getCost());
            row.add("<html><a href='select';' >Selected</a></html>");
            model.addRow(row);
        }
        tblGrade.setModel(model);
        tblGrade.setRowSelectionAllowed(false);
        tblGrade.setCellSelectionEnabled(true);
        tblGrade.setFocusable(false);
    }

    private void evens() {
        tblGrade.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = tblGrade.rowAtPoint(evt.getPoint());
                int col = tblGrade.columnAtPoint(evt.getPoint());
                if ((row >= 0 && col == 5)) {
                    Object[] rowData = new Object[tblGrade.getColumnCount()];
                    for (int i = 0; i < tblGrade.getColumnCount(); i++) {
                        rowData[i] = tblGrade.getValueAt(row, i);
                    }
                    courseRegisterTextField.setText((String) rowData[0]);
                    setVisible(false);
                }
            }
        });
    }

    private List<Course> mockData() {
        CourseService courseService = new CourseServiceImpl();
        return courseService.getAll();
    }
}
