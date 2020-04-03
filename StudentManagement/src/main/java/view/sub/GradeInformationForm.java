/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import entities.Grade;
import entities.Teacher;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.JComboCheckBox;
import org.apache.commons.io.FilenameUtils;
import service.CourseServiceImpl;
import service.GradeServiceImpl;
import service.TeacherServiceImpl;
import utils.DayOfWeekUtils;
import utils.FileUtils;
import utils.ImageUtils;
import utils.SizeUtils;
import utils.TimeUtils;

/**
 *
 * @author Mr.Chien
 */
public class GradeInformationForm extends javax.swing.JFrame {

    private final String[] EXT_FILE = {"png", "jpg", "jpeg", "gif"};
    private File selectedFile;
    private Grade grade;
    private Integer currentStudentQuantity;

    public GradeInformationForm(Grade grade, Integer currentStudentQuantity) {
        this.currentStudentQuantity = currentStudentQuantity;
        this.grade = grade;
        initComponents();
        init();
        setTextField();
        initEvent();
    }

    private Vector getVecto() {
        Vector vector = new Vector();
        for (DayOfWeek day : DayOfWeek.values()) {
            vector.add(new JCheckBox(day.toString(), false));
        }
        return vector;
    }

    private void init() {
        JComboBox jcombo = new JComboCheckBox(getVecto(), tfDayOfWeek);
        jcombo.setBounds(tfDayOfWeek.getX() + SizeUtils.getWidth(tfDayOfWeek) + 30,
                tfDayOfWeek.getY(), SizeUtils.getPreWidth(jcombo),
                SizeUtils.getPreHeight(jcombo));
        pnCLeft.add(jcombo);
    }

    private void setTextField() {
        tfFullname.setText(grade.getNameGrade());
        tfCurrentStudentQuantity.setText(String.valueOf(currentStudentQuantity));
        studentQuantity1.setText(String.valueOf(grade.getStudentQuantity()));
        startTime.setText(grade.getStartTime().toString());
        endTime.setText(grade.getEndTime().toString());
        teacher.setText(grade.getTeacher().getIdTeacher() + " - " + grade.getTeacher().getProfileTeacher().getFullName());
        tfCurrentStudentQuantity.setEditable(false);
        tfDayOfWeek.setText(DayOfWeekUtils.convertDayOfWeekToString(grade.getDaysOfWeek()));
    }

    private void initEvent() {
        btUploadEvent();
        btSubmitEvent();
        showTeacherButtonEvents();
        addButtonEvents();
        showCourseButtonEvents();
    }

    private void showCourseButtonEvents() {
        showCourseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                CourseForm courseForm = new CourseForm(courseTf);
                courseForm.setVisible(true);
            }

        });
    }

    private void btSubmitEvent() {
        btSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                getGrade();
                if (new GradeServiceImpl().updateGradeById(grade.getIdGrade(), grade)) {
                    JOptionPane.showMessageDialog(GradeInformationForm.this,
                            "This grade is updated successfully!!!", "Notification",
                            JOptionPane.OK_OPTION, ImageUtils.loadImageIcon(getClass().getResource("/images/alarm.png").getPath()));
                    setVisible(false);
                }

            }
        });
    }

    private void getGrade() {
        Teacher teacherSelected = new TeacherServiceImpl().getTeacher(teacher.getText());
        grade.setNameGrade(tfFullname.getText());
        grade.setTeacher(teacherSelected);
        grade.setStudentQuantity(Integer.parseInt(tfCurrentStudentQuantity.getText()));
        grade.setStartTime(TimeUtils.convertStringToLocalTime(startTime.getText()));
        grade.setEndTime(TimeUtils.convertStringToLocalTime(endTime.getText()));
        grade.setCourse(new CourseServiceImpl().getCourseById(courseTf.getText()));
        String dayOfWeek = tfDayOfWeek.getText();
        grade.setDaysOfWeek(DayOfWeekUtils.convertStringToDayOfWeek(dayOfWeek));
    }

    private void addButtonEvents() {
        addButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                getGrade();
                if (new GradeServiceImpl().insertGrade(grade)) {
                    JOptionPane.showMessageDialog(GradeInformationForm.this,
                            "This grade is inserted successfully!!!", "Notification",
                            JOptionPane.OK_OPTION, ImageUtils.loadImageIcon(getClass().getResource("/images/alarm.png").getPath()));
                    setVisible(false);
                }
            }

        });
    }

    private void showTeacherButtonEvents() {
        showButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                TeacherForm teacherForm = new TeacherForm(teacher);
                teacherForm.setVisible(true);
            }
        });
    }

    private void btUploadEvent() {
        btUpload.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JFileChooser fc = new JFileChooser(FileUtils.getPath("images", "python.jfif"));
                if (fc.showDialog(null, "Open") == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fc.getSelectedFile();
                    final String ext = FilenameUtils.getExtension(selectedFile.getName());
                    if (Arrays.stream(EXT_FILE).anyMatch(t -> t.equalsIgnoreCase(ext))) {
                        lbAvatar.setIcon(ImageUtils.loadImageIcon(selectedFile.getPath(), 120, 150));
                    }
                }
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnTop = new javax.swing.JPanel();
        lbStudentInfo = new javax.swing.JLabel();
        PnBottom = new javax.swing.JPanel();
        btSubmit = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        PnCenter = new javax.swing.JPanel();
        pnCLeft = new javax.swing.JPanel();
        lbFullname = new javax.swing.JLabel();
        tfFullname = new javax.swing.JTextField();
        lbClassQuantity = new javax.swing.JLabel();
        lbStartDay = new javax.swing.JLabel();
        lbEndDay = new javax.swing.JLabel();
        tfCurrentStudentQuantity = new javax.swing.JTextField();
        lbCost = new javax.swing.JLabel();
        teacher = new javax.swing.JTextField();
        lbAvatar = new javax.swing.JLabel();
        btUpload = new javax.swing.JButton();
        endTime = new javax.swing.JTextField();
        startTime = new javax.swing.JTextField();
        studentQuantity1 = new javax.swing.JTextField();
        lbClassQuantity1 = new javax.swing.JLabel();
        showButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfDayOfWeek = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        courseTf = new javax.swing.JTextField();
        showCourseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        PnTop.setBackground(new java.awt.Color(255, 255, 255));
        PnTop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbStudentInfo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbStudentInfo.setForeground(new java.awt.Color(0, 51, 153));
        lbStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/course.png"))); // NOI18N
        lbStudentInfo.setText("Information Grade");
        lbStudentInfo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PnTop.add(lbStudentInfo);

        getContentPane().add(PnTop, java.awt.BorderLayout.PAGE_START);

        PnBottom.setBackground(new java.awt.Color(255, 255, 255));
        PnBottom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PnBottom.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 10));

        btSubmit.setBackground(new java.awt.Color(255, 51, 153));
        btSubmit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btSubmit.setText("Submit");
        btSubmit.setFocusPainted(false);
        PnBottom.add(btSubmit);

        addButton.setBackground(new java.awt.Color(0, 0, 255));
        addButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Add Grade");
        addButton.setFocusPainted(false);
        PnBottom.add(addButton);

        getContentPane().add(PnBottom, java.awt.BorderLayout.PAGE_END);

        PnCenter.setBackground(new java.awt.Color(255, 255, 255));
        PnCenter.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 0, 255), 1, true), javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204)))); // NOI18N
        PnCenter.setLayout(new java.awt.BorderLayout());

        pnCLeft.setBackground(new java.awt.Color(255, 204, 255));

        lbFullname.setText("Name: ");

        tfFullname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFullnameActionPerformed(evt);
            }
        });

        lbClassQuantity.setText("Current Student quantity: ");

        lbStartDay.setText("Start time:");

        lbEndDay.setText("End day:");

        lbCost.setText("Teacher:");

        lbAvatar.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 0)));
        lbAvatar.setPreferredSize(new java.awt.Dimension(100, 100));

        btUpload.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btUpload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/upload.png"))); // NOI18N
        btUpload.setFocusPainted(false);

        lbClassQuantity1.setText("Student quantity: ");

        showButton.setText("Show Teacher");
        showButton.setFocusPainted(false);
        showButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Days of week: ");

        jLabel2.setText("Course");

        courseTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseTfActionPerformed(evt);
            }
        });

        showCourseButton.setText("Show Courses");
        showCourseButton.setFocusPainted(false);

        javax.swing.GroupLayout pnCLeftLayout = new javax.swing.GroupLayout(pnCLeft);
        pnCLeft.setLayout(pnCLeftLayout);
        pnCLeftLayout.setHorizontalGroup(
            pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCLeftLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnCLeftLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btUpload)))
                .addGap(59, 59, 59)
                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCLeftLayout.createSequentialGroup()
                        .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCLeftLayout.createSequentialGroup()
                                .addComponent(lbFullname)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(courseTf, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(showCourseButton))
                            .addGroup(pnCLeftLayout.createSequentialGroup()
                                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                    .addComponent(lbCost, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbEndDay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbStartDay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnCLeftLayout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(startTime, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(endTime, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfDayOfWeek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(showButton)))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(pnCLeftLayout.createSequentialGroup()
                        .addComponent(lbClassQuantity)
                        .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCLeftLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbClassQuantity1)
                                .addGap(18, 18, 18)
                                .addComponent(studentQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92))
                            .addGroup(pnCLeftLayout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(tfCurrentStudentQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        pnCLeftLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lbClassQuantity, lbFullname});

        pnCLeftLayout.setVerticalGroup(
            pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCLeftLayout.createSequentialGroup()
                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCLeftLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lbAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCLeftLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFullname)
                            .addComponent(tfFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(courseTf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showCourseButton))
                        .addGap(38, 38, 38)
                        .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbClassQuantity)
                            .addComponent(studentQuantity1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbClassQuantity1)
                            .addComponent(tfCurrentStudentQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btUpload)
                    .addGroup(pnCLeftLayout.createSequentialGroup()
                        .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbStartDay)
                            .addComponent(startTime, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(endTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbEndDay))
                        .addGap(30, 30, 30)
                        .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(teacher, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showButton)
                            .addComponent(lbCost))))
                .addGap(30, 30, 30)
                .addGroup(pnCLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCLeftLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9))
                    .addComponent(tfDayOfWeek, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        PnCenter.add(pnCLeft, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(PnCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showButtonActionPerformed

    private void tfFullnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFullnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFullnameActionPerformed

    private void courseTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseTfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnBottom;
    private javax.swing.JPanel PnCenter;
    private javax.swing.JPanel PnTop;
    private javax.swing.JButton addButton;
    private javax.swing.JButton btSubmit;
    private javax.swing.JButton btUpload;
    private javax.swing.JTextField courseTf;
    private javax.swing.JTextField endTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbAvatar;
    private javax.swing.JLabel lbClassQuantity;
    private javax.swing.JLabel lbClassQuantity1;
    private javax.swing.JLabel lbCost;
    private javax.swing.JLabel lbEndDay;
    private javax.swing.JLabel lbFullname;
    private javax.swing.JLabel lbStartDay;
    private javax.swing.JLabel lbStudentInfo;
    private javax.swing.JPanel pnCLeft;
    private javax.swing.JButton showButton;
    private javax.swing.JButton showCourseButton;
    private javax.swing.JTextField startTime;
    private javax.swing.JTextField studentQuantity1;
    private javax.swing.JTextField teacher;
    private javax.swing.JTextField tfCurrentStudentQuantity;
    private javax.swing.JTextField tfDayOfWeek;
    private javax.swing.JTextField tfFullname;
    // End of variables declaration//GEN-END:variables

}
