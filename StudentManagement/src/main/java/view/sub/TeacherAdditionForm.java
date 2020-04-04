/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import entities.Profile;
import entities.Teacher;
import entities.TimeKeeping;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import service.ProfileService;
import service.ProfileServiceImpl;
import service.TeacherService;
import service.TeacherServiceImpl;
import service.TimeKeepingService;
import service.TimeKeepingServiceImpl;
import utils.CheckUtil;
import utils.RandomUtils;

/**
 *
 * @author USER
 */
public class TeacherAdditionForm extends javax.swing.JFrame {

    public TeacherAdditionForm() {
        initComponents();
        setLocationRelativeTo(null);
        initEvens();
    }

    public void initEvens() {
        nameTextFieldEvents();
        phoneTextFieldEvents();
        emailTextFieldEvents();
        hometownTextFieldEvents();
        addressTextFieldEvents();
        idNumberTextFieldEvents();
        btAddEvents();
        btShowTimekeepingEvens();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        register = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        dayOfBirthLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        hometownTextField = new javax.swing.JTextField();
        hometowmLabel = new javax.swing.JLabel();
        btAdd = new javax.swing.JButton();
        genderLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        addressTextFied = new javax.swing.JTextField();
        gradeRegisterLabel = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        tfTimekeeping = new javax.swing.JTextField();
        idNumberLabel = new javax.swing.JLabel();
        addressLabel1 = new javax.swing.JLabel();
        tfWorkplace = new javax.swing.JTextField();
        btShowTimekeeping = new javax.swing.JButton();
        timekeepingLb = new javax.swing.JLabel();
        idNumberTextField1 = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(670, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register.setBackground(new java.awt.Color(204, 255, 204));
        register.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        register.setLayout(null);

        title.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        title.setText("Timekeeping");
        register.add(title);
        title.setBounds(20, 390, 80, 30);

        nameLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLabel.setText("Full Name");
        register.add(nameLabel);
        nameLabel.setBounds(20, 50, 60, 30);

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        register.add(nameTextField);
        nameTextField.setBounds(90, 50, 270, 30);

        phoneLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        phoneLabel.setText("Phone");
        register.add(phoneLabel);
        phoneLabel.setBounds(20, 100, 40, 30);

        phoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextFieldActionPerformed(evt);
            }
        });
        register.add(phoneTextField);
        phoneTextField.setBounds(90, 100, 90, 30);

        dayOfBirthLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dayOfBirthLabel.setText("Birthday");
        register.add(dayOfBirthLabel);
        dayOfBirthLabel.setBounds(20, 150, 60, 30);

        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        register.add(emailTextField);
        emailTextField.setBounds(90, 200, 270, 30);

        emailLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emailLabel.setText("Email");
        register.add(emailLabel);
        emailLabel.setBounds(20, 200, 50, 30);

        hometownTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hometownTextFieldActionPerformed(evt);
            }
        });
        register.add(hometownTextField);
        hometownTextField.setBounds(120, 250, 240, 30);

        hometowmLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        hometowmLabel.setText("Hometown");
        register.add(hometowmLabel);
        hometowmLabel.setBounds(20, 250, 70, 30);

        btAdd.setBackground(new java.awt.Color(255, 0, 0));
        btAdd.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        btAdd.setForeground(new java.awt.Color(255, 255, 255));
        btAdd.setText("Add");
        btAdd.setRequestFocusEnabled(false);
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });
        register.add(btAdd);
        btAdd.setBounds(70, 430, 220, 50);

        genderLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        genderLabel.setText("Gender");
        register.add(genderLabel);
        genderLabel.setBounds(190, 150, 41, 30);

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboBoxActionPerformed(evt);
            }
        });
        register.add(genderComboBox);
        genderComboBox.setBounds(260, 150, 70, 30);

        addressTextFied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextFiedActionPerformed(evt);
            }
        });
        register.add(addressTextFied);
        addressTextFied.setBounds(120, 300, 240, 30);

        gradeRegisterLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        gradeRegisterLabel.setText("Workplace");
        register.add(gradeRegisterLabel);
        gradeRegisterLabel.setBounds(20, 350, 80, 30);
        register.add(jDateChooser1);
        jDateChooser1.setBounds(90, 150, 91, 30);

        tfTimekeeping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimekeepingActionPerformed(evt);
            }
        });
        register.add(tfTimekeeping);
        tfTimekeeping.setBounds(120, 390, 100, 30);

        idNumberLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        idNumberLabel.setText("Id Number");
        register.add(idNumberLabel);
        idNumberLabel.setBounds(190, 100, 70, 30);

        addressLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addressLabel1.setText("Current Address");
        register.add(addressLabel1);
        addressLabel1.setBounds(20, 300, 93, 30);

        tfWorkplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfWorkplaceActionPerformed(evt);
            }
        });
        register.add(tfWorkplace);
        tfWorkplace.setBounds(120, 350, 240, 30);

        btShowTimekeeping.setBackground(new java.awt.Color(255, 255, 153));
        btShowTimekeeping.setText("Show TimeKeepings");
        btShowTimekeeping.setFocusPainted(false);
        btShowTimekeeping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btShowTimekeepingActionPerformed(evt);
            }
        });
        register.add(btShowTimekeeping);
        btShowTimekeeping.setBounds(220, 390, 140, 30);

        timekeepingLb.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        timekeepingLb.setForeground(new java.awt.Color(255, 0, 0));
        timekeepingLb.setText("NEW TEACHER");
        register.add(timekeepingLb);
        timekeepingLb.setBounds(130, 10, 160, 30);

        idNumberTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idNumberTextField1ActionPerformed(evt);
            }
        });
        register.add(idNumberTextField1);
        idNumberTextField1.setBounds(260, 100, 100, 30);

        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 380, 500));

        background.setBackground(new java.awt.Color(204, 204, 255));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTextFieldActionPerformed
    }//GEN-LAST:event_phoneTextFieldActionPerformed

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void hometownTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hometownTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hometownTextFieldActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAddActionPerformed

    private void genderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboBoxActionPerformed

    private void addressTextFiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextFiedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextFiedActionPerformed

    private void tfTimekeepingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimekeepingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTimekeepingActionPerformed

    private void tfWorkplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfWorkplaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfWorkplaceActionPerformed

    private void idNumberTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idNumberTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idNumberTextField1ActionPerformed

    private void btShowTimekeepingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btShowTimekeepingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btShowTimekeepingActionPerformed

    public static void main(String args[]) {
        TeacherAdditionForm reg = new TeacherAdditionForm();
        reg.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JTextField addressTextFied;
    private javax.swing.JLabel background;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btShowTimekeeping;
    private javax.swing.JLabel dayOfBirthLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel gradeRegisterLabel;
    private javax.swing.JLabel hometowmLabel;
    private javax.swing.JTextField hometownTextField;
    private javax.swing.JLabel idNumberLabel;
    private javax.swing.JTextField idNumberTextField1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JPanel register;
    private javax.swing.JTextField tfTimekeeping;
    private javax.swing.JTextField tfWorkplace;
    private javax.swing.JLabel timekeepingLb;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
    private final Border highLightBorder = BorderFactory.createLineBorder(Color.RED, 1);
    private final Border defaultBorder = new JTextField().getBorder();

    public void btAddEvents() {
        RandomUtils rand = new RandomUtils();
        List<String> strings = new ProfileServiceImpl().getProfileStudents().stream().map(Profile::getId).collect(Collectors.toList());
        String id = rand.randomId(strings, "");
        btAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String name = nameTextField.getText();
                String phone = phoneTextField.getText();
                String email = emailTextField.getText();
                String address = addressTextFied.getText();
                String hometown = hometownTextField.getText();
                Date dayOfBirth = jDateChooser1.getDate();
                String idNumber = tfTimekeeping.getText();
                Boolean gender = genderComboBox.getSelectedIndex() == 1;
                String workplace = tfWorkplace.getText();

                ProfileService profileServices = new ProfileServiceImpl();
                TeacherService teacherService = new TeacherServiceImpl();
                TimeKeepingService timeKeepingService = new TimeKeepingServiceImpl();
                TimeKeeping timeKeeping = timeKeepingService.getTimeKeeping(tfTimekeeping.getText());
                Profile profile = new Profile(id, name, gender, dayOfBirth, idNumber, phone, email, hometown, address);
                Teacher teacher = new Teacher(id, profile, 0.0, timeKeeping, workplace);

                profileServices.insertProfile(profile);
                teacherService.insertTeacher(teacher);

            }
        });
    }

    public void showGradeButtonEvens() {
        btShowTimekeeping.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CourseForm courseForm = new CourseForm(tfWorkplace);
                courseForm.setVisible(true);
            }
        });
    }

    private void nameTextFieldEvents() {
        stringTextFieldEvents(nameTextField);
    }

    private void phoneTextFieldEvents() {
        numberTextFieldEvents(phoneTextField);
    }

    private void idNumberTextFieldEvents() {
        numberTextFieldEvents(tfTimekeeping);
    }

    private void emailTextFieldEvents() {
        emailTextField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (emailTextField.getText().isEmpty()) {
                    emailTextField.setBorder(highLightBorder);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                String email = emailTextField.getText();
                if (!email.isEmpty()) {
                    emailTextField.setBorder(defaultBorder);
                }
                if (!CheckUtil.validateEmail(email)) {
                    emailTextField.setBorder(highLightBorder);
                }
            }
        });

        emailTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                emailTextField.setBorder(defaultBorder);
            }
        });

    }

    private void hometownTextFieldEvents() {
        stringTextFieldEvents(hometownTextField);
    }

    private void addressTextFieldEvents() {
        stringTextFieldEvents(addressTextFied);
    }

    private void stringTextFieldEvents(JTextField textField) {
        textField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setBorder(highLightBorder);
                } else {
                    textField.setBorder(defaultBorder);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!textField.getText().isEmpty()) {
                    textField.setBorder(defaultBorder);
                }
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textField.setBorder(defaultBorder);
            }
        });

    }

    private void numberTextFieldEvents(JTextField textField) {
        textField.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setBorder(highLightBorder);
                } else {
                    textField.setBorder(defaultBorder);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                String phone = textField.getText();
                if (phone.isEmpty()) {
                    textField.setBorder(highLightBorder);
                } else if (!CheckUtil.validatePhone(phone)) {
                    textField.setBorder(highLightBorder);
                } else {
                    textField.setBorder(defaultBorder);
                }
            }
        });

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                textField.setBorder(defaultBorder);
            }
        });

    }

    public void btShowTimekeepingEvens() {
        btShowTimekeeping.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TimeKeepingTable timeKeepingTable = new TimeKeepingTable(tfTimekeeping);
                timeKeepingTable.setVisible(true);
            }
        });
    }
}
