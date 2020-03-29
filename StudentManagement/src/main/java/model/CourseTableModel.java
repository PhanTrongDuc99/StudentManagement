/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.CourseTableColumns;
import entities.Course;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import service.CourseService;
import service.CourseServiceImpl;

/**
 *
 * @author Mr.Chien
 */
public class CourseTableModel extends AbstractTableModel {

    private final CourseTableColumns COLUMNS_NAME[] = CourseTableColumns.values();
    private final CourseService courseService;
    private final List<Course> courses;
    private final JTable tbCourse;

    public CourseTableModel(JTable tbTable) {

        courseService = new CourseServiceImpl();
        courses = courseService.getAll();
        tbCourse = tbTable;

    }

    @Override
    public int getRowCount() {
        return courses != null ? courses.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return COLUMNS_NAME != null ? COLUMNS_NAME.length : 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object object = null;
        Course course = courses.get(rowIndex);
        CourseTableColumns stc = COLUMNS_NAME[columnIndex];
        switch (stc) {
            case ID:
                object = course.getIdCourse();
                break;
            case NAME:
                object = course.getNameCourse();
                break;
            case CLASSQUANTITY:
                object = course.getGradeQuantity();
                break;
            case STARTDAY:
                object = course.getStartTime();
                break;
            case ENDDAY:
                object = course.getEndTime();
                break;
            case COST:
                object = course.getCost();
                break;

        }
        return object;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNS_NAME[column].getText();
    }

    public void loadDataTable() {
        tbCourse.setModel(this);
    }

    public void cssForTable() {

        tbCourse.getTableHeader().setPreferredSize(new Dimension(0, 26));
        tbCourse.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 18));
        tbCourse.getTableHeader().setBackground(Color.CYAN);
        tbCourse.getTableHeader().setReorderingAllowed(false);
        tbCourse.setRowHeight(26);
        //hide ID column;
        tbCourse.getColumnModel().getColumn(0).setMinWidth(0);
        tbCourse.getColumnModel().getColumn(0).setMaxWidth(0);
    }
}
