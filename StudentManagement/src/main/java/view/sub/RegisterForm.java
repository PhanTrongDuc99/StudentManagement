/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import common.RegisterStatus;
import common.RegisterType;
import entities.Course;
import entities.Profile;
import entities.Register;
import entities.StudentUnofficial;
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
import service.CourseService;
import service.CourseServiceImpl;
import service.ProfileService;
import service.ProfileServiceImpl;
import service.RegisterService;
import service.RegisterServiceImpl;
import service.StudentUnofficialService;
import service.StudentUnofficialServiceImpl;
import utils.CheckUtil;
import utils.RandomUtils;

/**
 *
 * @author USER
 */
public class RegisterForm extends javax.swing.JFrame {

    public RegisterForm() {
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
        registerButtonEvents();
        showGradeButtonEvens();
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
        registerButton = new javax.swing.JButton();
        noteLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        addressTextFied = new javax.swing.JTextField();
        gradeRegisterLabel = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        idNumberTextField = new javax.swing.JTextField();
        idNumberLabel = new javax.swing.JLabel();
        addressLabel1 = new javax.swing.JLabel();
        courseRegisterTextField = new javax.swing.JTextField();
        showCoursesButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(670, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register.setBackground(new java.awt.Color(204, 255, 204));
        register.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        register.setLayout(null);

        title.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(204, 0, 0));
        title.setText("INFORMATION");
        register.add(title);
        title.setBounds(130, 10, 160, 30);

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
        nameTextField.setBounds(90, 50, 260, 30);

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
        phoneTextField.setBounds(70, 100, 90, 30);

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
        emailTextField.setBounds(80, 200, 270, 30);

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
        hometownTextField.setBounds(120, 250, 230, 30);

        hometowmLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        hometowmLabel.setText("Hometown");
        register.add(hometowmLabel);
        hometowmLabel.setBounds(20, 250, 70, 30);

        registerButton.setBackground(new java.awt.Color(255, 0, 0));
        registerButton.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        registerButton.setForeground(new java.awt.Color(255, 255, 255));
        registerButton.setText("Register");
        registerButton.setRequestFocusEnabled(false);
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        register.add(registerButton);
        registerButton.setBounds(70, 430, 220, 50);

        noteLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        noteLabel.setForeground(new java.awt.Color(255, 0, 0));
        noteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register.add(noteLabel);
        noteLabel.setBounds(40, 400, 280, 20);

        genderLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        genderLabel.setText("Gender");
        register.add(genderLabel);
        genderLabel.setBounds(180, 150, 41, 30);

        genderComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        genderComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderComboBoxActionPerformed(evt);
            }
        });
        register.add(genderComboBox);
        genderComboBox.setBounds(230, 150, 70, 30);

        addressTextFied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextFiedActionPerformed(evt);
            }
        });
        register.add(addressTextFied);
        addressTextFied.setBounds(120, 300, 230, 30);

        gradeRegisterLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        gradeRegisterLabel.setText("Grade want to register");
        register.add(gradeRegisterLabel);
        gradeRegisterLabel.setBounds(20, 350, 130, 30);
        register.add(jDateChooser1);
        jDateChooser1.setBounds(80, 150, 91, 30);

        idNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idNumberTextFieldActionPerformed(evt);
            }
        });
        register.add(idNumberTextField);
        idNumberTextField.setBounds(260, 100, 90, 30);

        idNumberLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        idNumberLabel.setText("Id Number");
        register.add(idNumberLabel);
        idNumberLabel.setBounds(180, 100, 70, 30);

        addressLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addressLabel1.setText("Current Address");
        register.add(addressLabel1);
        addressLabel1.setBounds(20, 300, 93, 30);

        courseRegisterTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseRegisterTextFieldActionPerformed(evt);
            }
        });
        register.add(courseRegisterTextField);
        courseRegisterTextField.setBounds(160, 350, 80, 30);

        showCoursesButton.setBackground(new java.awt.Color(255, 255, 153));
        showCoursesButton.setText("Show Courses");
        showCoursesButton.setFocusPainted(false);
        register.add(showCoursesButton);
        showCoursesButton.setBounds(250, 350, 120, 30);

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

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerButtonActionPerformed

    private void genderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboBoxActionPerformed

    private void addressTextFiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextFiedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextFiedActionPerformed

    private void idNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idNumberTextFieldActionPerformed

    private void courseRegisterTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseRegisterTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseRegisterTextFieldActionPerformed

    public static void main(String args[]) {
        RegisterForm reg = new RegisterForm();
        reg.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JTextField addressTextFied;
    private javax.swing.JLabel background;
    private javax.swing.JTextField courseRegisterTextField;
    private javax.swing.JLabel dayOfBirthLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel gradeRegisterLabel;
    private javax.swing.JLabel hometowmLabel;
    private javax.swing.JTextField hometownTextField;
    private javax.swing.JLabel idNumberLabel;
    private javax.swing.JTextField idNumberTextField;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JPanel register;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton showCoursesButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
    private final Border highLightBorder = BorderFactory.createLineBorder(Color.RED, 1);
    private final Border defaultBorder = new JTextField().getBorder();

    public void registerButtonEvents() {
        RandomUtils rand = new RandomUtils();
        List<String> strings = new ProfileServiceImpl().getProfileStudents().stream().map(Profile::getId).collect(Collectors.toList());
        String id = rand.randomId(strings, "");
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String name = nameTextField.getText();
                String phone = phoneTextField.getText();
                String email = emailTextField.getText();
                String address = addressTextFied.getText();
                String hometown = hometownTextField.getText();
                Date dayOfBirth = jDateChooser1.getDate();
                String idNumber = idNumberTextField.getText();
                Boolean gender = genderComboBox.getSelectedIndex() == 1;

                ProfileService profileServices = new ProfileServiceImpl();
                RegisterService registerService = new RegisterServiceImpl();
                StudentUnofficialService studentService = new StudentUnofficialServiceImpl();
                CourseService courseService = new CourseServiceImpl();

                Course course = courseService.getCourse(courseRegisterTextField.getText());
                Profile profile = new Profile(id, name, gender, dayOfBirth, idNumber, phone, email, hometown, address);
                Register register = new Register(id, RegisterStatus.WAITTING, RegisterType.DIRECT);
                StudentUnofficial student = new StudentUnofficial(id, profile, 0d, course.getCost(), register, course.getIdCourse());

                profileServices.insertProfile(profile);
                registerService.insertRegister(register);
                studentService.insertStudent(student);
                noteLabel.setText("Registered Successfully!!!");
            }
        });
    }

    public void showGradeButtonEvens() {
        showCoursesButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CourseForm courseForm = new CourseForm(courseRegisterTextField);
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
        numberTextFieldEvents(idNumberTextField);
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

}
