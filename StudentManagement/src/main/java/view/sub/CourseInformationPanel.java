/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;
//import model.StudentTableModel;

import common.CourseTableColumns;
import entities.Course;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.RowFilter;
import javax.swing.WindowConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import model.CourseTableModel;
import service.CourseService;
import service.CourseServiceImpl;
import service.GradeService;
import service.GradeServiceImpl;
import service.StudentUnofficialService;
import service.StudentUnofficialServiceImpl;
import utils.DateUtils;
import utils.RandomUtils;

/**
 *
 * @author Mr.Chien
 */
public class CourseInformationPanel extends javax.swing.JPanel {

    private final CourseTableModel courseModel;
    private Font defaultFont;
    private final CourseService courseService;
    private final Font newFont = new Font("Tahoma", Font.BOLD, 14);
    private final Color defaultBackgroundAdd = new Color(0, 0, 255);
    private final Color newBackgroundAdd = new Color(10, 50, 255);
    private final Color defaultBackgroundEdit = new Color(51, 204, 0);
    private final Color newBackgroundEdit = new Color(60, 255, 0);
    private final Color defaultBackgroundDelete = new Color(204, 0, 0);
    private final Color newBackgroundDelete = new Color(255, 0, 0);
    private Course course;
    private String idSelected;
    private final CourseTableColumns COLUMNS_NAME[] = CourseTableColumns.values();
    private int rowIndex;
    private int colIndex;
    private int selectedRow;
    private int selectedCol;

    public CourseInformationPanel() {
        initComponents();
        btAdd.setFocusPainted(false);
        btEdit.setFocusPainted(false);
        btDelete.setFocusPainted(false);
        courseModel = new CourseTableModel(tbCourse);
        course = new Course();
        courseService = new CourseServiceImpl();
        courseModel.loadDataTable();
        courseModel.cssForTable();
        initEvents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initEvents() {
        tbCourseEvent();
        btAddEvents();
        btEditEvents();
        btDeleteEvents();
        tfSearchEvent();
    }

    private void tfSearchEvent() {
        tfSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = tfSearch.getText();
                TableRowSorter<AbstractTableModel> sorter = new TableRowSorter<>();
                sorter.setModel(courseModel);
                RowFilter<AbstractTableModel, Object> filter = RowFilter.regexFilter("(?i)" + text);
                sorter.setRowFilter(filter);
                tbCourse.setRowSorter(sorter);
            }
        });
    }

    private void setInformationSelectedCourse() {
        lbFulname.setText(course.getNameCourse());
        lbClassQuantity.setText(course.getGradeQuantity() + "");
        lbStartDay.setText(DateUtils.convertToDateFromString(course.getStartTime()));
        lbEndday.setText(DateUtils.convertToDateFromString(course.getEndTime()));
        lbCost.setText(course.getCost() + "");
    }

    private void tbCourseEvent() {
        tbCourse.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedRow = tbCourse.getSelectedRow();
                selectedCol = tbCourse.getSelectedColumn();
                rowIndex = tbCourse.convertColumnIndexToModel(selectedRow);
                colIndex = tbCourse.convertColumnIndexToModel(selectedCol);
                idSelected = String.valueOf(tbCourse.getValueAt(rowIndex, 0));
                System.out.println("IdSelected: " + idSelected);
                System.out.println("rowIndex: " + rowIndex);
                System.out.println("colIndex: " + colIndex);
                System.out.println("selectedRow: " + selectedRow);
                System.out.println("selectedCol: " + selectedCol);

                course = courseService.getCourseById(idSelected);

                //set thong tin khoa hoc
                setInformationSelectedCourse();
            }

        });
    }

    private void btAddEvents() {
        defaultFont = btAdd.getFont();
        btAdd.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                Course course = new Course();
                CourseInformationForm courseInformationForm = new CourseInformationForm(course) {
                    @Override
                    public void callbackInformation(Course course) {
                        //insertOnDatabase
                        List<String> strings = courseService.getAll().stream().map(Course::getIdCourse).collect(Collectors.toList());
                        course.setIdCourse(RandomUtils.randomId(strings, "K"));
                        courseService.insertCourse(course);
                        //insertOnTable ngay sau khi submit
                    }
                };

                courseInformationForm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                courseInformationForm.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btAdd.setFont(newFont);
                btAdd.setBackground(newBackgroundAdd);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btAdd.setFont(defaultFont);
                btAdd.setBackground(defaultBackgroundAdd);
            }

        });
    }

    private void btEditEvents() {
        btEdit.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                CourseInformationForm courseInformationForm = new CourseInformationForm(course) {
                    @Override
                    public void callbackInformation(Course course) {
                        
                        //setInformationSelectedCourse
                        setInformationSelectedCourse();
                        //updateCourseById(Database)
                        courseService.updateCourseById(course.getIdCourse(), course);
                        //updateTableCourse???

                    }
                };
                courseInformationForm.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                courseInformationForm.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btEdit.setFont(newFont);
                btEdit.setBackground(newBackgroundEdit);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btEdit.setFont(defaultFont);
                btEdit.setBackground(defaultBackgroundEdit);
            }

        });
    }

    private void btDeleteEvents() {
        btDelete.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("IdSelected: " + idSelected);
                System.out.println("Xoá thành công khoá: " + idSelected);
                //courseService.deleteCourseById(idSelected);
                GradeService gradeService = new GradeServiceImpl();
                StudentUnofficialService studentUnofficialService = new StudentUnofficialServiceImpl();
                gradeService.deleteGradeByIdCourse(idSelected);
                studentUnofficialService.deleteStudentByIdCourse(idSelected);
                courseService.deleteCourseById(idSelected);
                //vẫn chưa xoá được rowSelectedCourse???
                //set thong tin khoa hoc
                lbFulname.setText("");
                lbClassQuantity.setText("");
                lbStartDay.setText(null);
                lbEndday.setText(null);
                lbCost.setText("");
            }

            @Override

            public void mouseEntered(MouseEvent e) {
                btDelete.setFont(newFont);
                btDelete.setBackground(newBackgroundDelete);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btDelete.setFont(defaultFont);
                btDelete.setBackground(defaultBackgroundDelete);
            }

        }
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTop = new javax.swing.JPanel();
        lbFind = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        pnBottom = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbFulname = new javax.swing.JLabel();
        lbClassQuantity = new javax.swing.JLabel();
        lbStartDay = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbEndday = new javax.swing.JLabel();
        lbCost = new javax.swing.JLabel();
        lbAvatarCourse = new javax.swing.JLabel();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        pnCenter = new javax.swing.JPanel();
        jSCourse = new javax.swing.JScrollPane();
        tbCourse = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1587, 903));
        setLayout(new java.awt.BorderLayout());

        pnTop.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 2, 5, 2), javax.swing.BorderFactory.createEtchedBorder()));

        lbFind.setBackground(new java.awt.Color(0, 204, 255));
        lbFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbFind.setText("Search");

        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        btAdd.setBackground(new java.awt.Color(0, 0, 255));
        btAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btAdd.setForeground(new java.awt.Color(255, 255, 255));
        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 953, Short.MAX_VALUE)
                .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFind)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAdd))
                .addGap(3, 59, Short.MAX_VALUE))
        );

        add(pnTop, java.awt.BorderLayout.PAGE_START);

        pnBottom.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information Of Courses", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 204, 51))); // NOI18N
        pnBottom.setPreferredSize(new java.awt.Dimension(400, 150));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Class quantity:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Start day:");

        lbFulname.setText("............");

        lbClassQuantity.setText("............");

        lbStartDay.setText("...........");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("End day:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cost: ");

        lbEndday.setText("...........");

        lbCost.setText(".......");

        lbAvatarCourse.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 204, 204)));
        lbAvatarCourse.setPreferredSize(new java.awt.Dimension(100, 100));

        btEdit.setBackground(new java.awt.Color(51, 204, 0));
        btEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEdit.setForeground(new java.awt.Color(255, 255, 255));
        btEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.gif"))); // NOI18N
        btEdit.setText("Edit");
        btEdit.setMaximumSize(new java.awt.Dimension(67, 25));
        btEdit.setMinimumSize(new java.awt.Dimension(67, 25));
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setBackground(new java.awt.Color(204, 0, 0));
        btDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btDelete.setForeground(new java.awt.Color(255, 255, 255));
        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBottomLayout = new javax.swing.GroupLayout(pnBottom);
        pnBottom.setLayout(pnBottomLayout);
        pnBottomLayout.setHorizontalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lbAvatarCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbClassQuantity)
                    .addComponent(lbFulname))
                .addGap(85, 85, 85)
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbStartDay)
                    .addComponent(lbEndday))
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel8)
                        .addGap(30, 30, 30)
                        .addComponent(lbCost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 453, Short.MAX_VALUE)
                        .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        pnBottomLayout.setVerticalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBottomLayout.createSequentialGroup()
                .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbFulname)
                            .addComponent(jLabel3)
                            .addComponent(lbStartDay)
                            .addComponent(btEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel8)
                            .addComponent(lbCost)
                            .addComponent(lbEndday)
                            .addComponent(jLabel7)
                            .addComponent(lbClassQuantity)
                            .addComponent(jLabel2)))
                    .addGroup(pnBottomLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btDelete))
                    .addComponent(lbAvatarCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        add(pnBottom, java.awt.BorderLayout.PAGE_END);

        pnCenter.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(5, 2, 5, 2), javax.swing.BorderFactory.createEtchedBorder()));
        pnCenter.setLayout(new javax.swing.OverlayLayout(pnCenter));

        tbCourse.setAutoCreateRowSorter(true);
        tbCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Class Quantity", "Start day", "End day"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbCourse.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jSCourse.setViewportView(tbCourse);
        tbCourse.getAccessibleContext().setAccessibleParent(pnCenter);

        pnCenter.add(jSCourse);

        add(pnCenter, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSearchActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAddActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEditActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jSCourse;
    private javax.swing.JLabel lbAvatarCourse;
    private javax.swing.JLabel lbClassQuantity;
    private javax.swing.JLabel lbCost;
    private javax.swing.JLabel lbEndday;
    private javax.swing.JLabel lbFind;
    private javax.swing.JLabel lbFulname;
    private javax.swing.JLabel lbStartDay;
    private javax.swing.JPanel pnBottom;
    private javax.swing.JPanel pnCenter;
    private javax.swing.JPanel pnTop;
    private javax.swing.JTable tbCourse;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables

}
