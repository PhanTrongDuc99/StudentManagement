/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import entities.Profile;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import utils.EmailUtil;

/**
 *
 * @author USER
 */
public class RegisterForm extends javax.swing.JFrame {

    public RegisterForm() {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(null);
        initEvens();
    }

    public void initEvens() {
        nameTextFieldEvens();
        phoneTextFieldEvens();
        hometownTextFieldEvens();
        addressTextFieldEvens();
        EmailTextFieldEvens();
        registerButtonEvens();
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
        hometownTextFied = new javax.swing.JTextField();
        hometowmLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        noteLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        genderComboBox = new javax.swing.JComboBox<>();
        addressTextFied = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(670, 500));
        setMinimumSize(new java.awt.Dimension(670, 500));
        setPreferredSize(new java.awt.Dimension(670, 500));
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        register.setBackground(new java.awt.Color(204, 255, 204));
        register.setLayout(null);

        title.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(204, 0, 0));
        title.setText("INFORMATION");
        register.add(title);
        title.setBounds(100, 10, 140, 30);

        nameLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        nameLabel.setText("Name");
        register.add(nameLabel);
        nameLabel.setBounds(20, 50, 50, 30);

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });
        register.add(nameTextField);
        nameTextField.setBounds(80, 50, 130, 30);

        phoneLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        phoneLabel.setText("Phone");
        register.add(phoneLabel);
        phoneLabel.setBounds(20, 100, 50, 30);

        phoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextFieldActionPerformed(evt);
            }
        });
        register.add(phoneTextField);
        phoneTextField.setBounds(80, 100, 220, 30);

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
        emailTextField.setBounds(80, 200, 220, 30);

        emailLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        emailLabel.setText("Email");
        register.add(emailLabel);
        emailLabel.setBounds(20, 200, 50, 30);

        hometownTextFied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hometownTextFiedActionPerformed(evt);
            }
        });
        register.add(hometownTextFied);
        hometownTextFied.setBounds(120, 250, 180, 30);

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
        registerButton.setBounds(60, 370, 220, 50);

        noteLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        noteLabel.setForeground(new java.awt.Color(255, 0, 0));
        noteLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register.add(noteLabel);
        noteLabel.setBounds(30, 340, 280, 20);

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
        addressTextFied.setBounds(120, 300, 180, 30);

        addressLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        addressLabel.setText("Current Address");
        register.add(addressLabel);
        addressLabel.setBounds(20, 300, 100, 30);
        register.add(jDateChooser1);
        jDateChooser1.setBounds(80, 150, 91, 30);

        getContentPane().add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 320, 440));

        background.setBackground(new java.awt.Color(204, 204, 255));
        background.setIcon(new javax.swing.ImageIcon("F:\\JavaProject\\StudentManagement\\StudentManagement\\src\\main\\java\\image\\background.jpg")); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 480));

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

    private void hometownTextFiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hometownTextFiedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hometownTextFiedActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerButtonActionPerformed

    private void genderComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderComboBoxActionPerformed

    private void addressTextFiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextFiedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextFiedActionPerformed

    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new RegisterForm().setVisible(true);
//            }
//        });
        RegisterForm reg = new RegisterForm();
        reg.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addressLabel;
    private javax.swing.JTextField addressTextFied;
    private javax.swing.JLabel background;
    private javax.swing.JLabel dayOfBirthLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JComboBox<String> genderComboBox;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel hometowmLabel;
    private javax.swing.JTextField hometownTextFied;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JPanel register;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

    public void registerButtonEvens() {
        registerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String name = nameTextField.getText();
                String phone = phoneTextField.getText();
                String email = emailTextField.getText();
                String address = addressTextFied.getText();
                String hometown = hometownTextFied.getText();
                Date dayOfBirth = jDateChooser1.getDate();
                
                Profile profile = new Profile();
                

            }
        });
    }

    public void nameTextFieldEvens() {
        nameTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                if (nameTextField.getText().isEmpty()) {
                    noteLabel.setText("Your name is empty!!!");
                }
            }
        });
    }

    public void phoneTextFieldEvens() {
        phoneTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                String phone = phoneTextField.getText();
                if (phone.isEmpty()) {
                    noteLabel.setText("Your phone is empty!!!");
                }
                try {
                    Double phoneString = Double.parseDouble(phone);
                } catch (NumberFormatException ex) {
                    noteLabel.setText("Your phone number is invalid!!!");
                }
            }

        });
    }

    public void EmailTextFieldEvens() {
        emailTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                String email = emailTextField.getText();

                if (email.isEmpty()) {
                    noteLabel.setText("Your email is empty!!!");
                } else if (EmailUtil.validateEmail(email)) {
                    noteLabel.setText("Your email is invalid!!!");
                }
            }
        });
    }

    public void hometownTextFieldEvens() {
        hometownTextFied.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                if (hometownTextFied.getText().isEmpty()) {
                    noteLabel.setText("Your Hometown is empty!!!");
                }
            }
        });
    }

    public void addressTextFieldEvens() {
        addressTextFied.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                if (addressTextFied.getText().isEmpty()) {
                    noteLabel.setText("Your Current address is empty!!!");
                }
            }
        });
    }
}
