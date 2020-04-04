/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import entities.Grade;
import entities.Profile;
import entities.Result;
import entities.StudentOfficial;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import service.GradeService;
import service.GradeServiceImpl;
import service.ProfileService;
import service.ProfileServiceImpl;
import service.ResultService;
import service.ResultServiceImpl;
import service.StudentOfficialService;
import service.StudentOfficialServiceImpl;
import utils.ImageUtils;

/**
 *
 * @author USER
 */
public class DetailStudentOfficialForm extends javax.swing.JFrame {

    /**
     * Creates new form DetailStudentForm
     */
    private StudentOfficial student;
    private DefaultTableModel model;
    private Integer row;

    public DetailStudentOfficialForm(StudentOfficial student, DefaultTableModel model, Integer row) {
        this.model = model;
        this.row = row;
        this.student = student;
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
        setTextField(student);
        editButtonEvents();
        showButtonEvents();
        saveButtonEvents();
    }

    public void setTextField(StudentOfficial student) {
        Profile profile = student.getProfile();
        nameTextFeild1.setText(profile.getFullName());
        phoneTextFeild.setText(profile.getPhoneNumber());
        emailTextFeild.setText(profile.getEmail());
        genderTextField.setText(String.valueOf(profile.isGender()));
        birthdayTextField.setText(profile.getDayOfBirth().toString());
        System.out.println(profile.getDayOfBirth().toString());
        curentAddressTextField.setText(profile.getCurrentAddress());
        hometowntextField.setText(profile.getHomeTown());
        idNumbertextField.setText(profile.getIdNumber());
        gradeTextField.setText(student.getGrade().getIdGrade());
        courseTextField.setText(student.getGrade().getCourse().getNameCourse());
        learningPointTextField.setText(String.valueOf(student.getResultStudy().getStudyMark()));
        rewardTextField.setText(String.valueOf(student.getResultStudy().getRewardMark()));
        disciplineTextField.setText(String.valueOf(student.getResultStudy().getDisciplineMark()));
        numberOfAbsencesTextField.setText(String.valueOf(student.getResultStudy().getNumberOfAbsences()));
        moneyPaidTextField.setText(String.valueOf(student.getResultStudy().getMoneyPaid()));
        costTextField.setText(String.valueOf(student.getGrade().getCourse().getCost()));
        setEditable(infPanel, false);
        setEditable(resPanel, false);
    }

    public void setEditable(JPanel panel, Boolean bool) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                textField.setEditable(bool);
            }
        }
    }

    public void editButtonEvents() {
        editButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setEditable(infPanel, true);
                setEditable(resPanel, true);
            }
        });
    }

    public void saveButtonEvents() {
        saveButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                StudentOfficialService stsv = new StudentOfficialServiceImpl();
                ProfileService prsv = new ProfileServiceImpl();
                ResultService ressv = new ResultServiceImpl();
                GradeService grsv = new GradeServiceImpl();

                stsv.deleteStudentById(student.getId());

                prsv.deleteProfileById(student.getProfile().getId());

                ressv.deleteResultById(student.getResultStudy().getId());

                Boolean gender = Boolean.parseBoolean(String.valueOf(genderTextField.getText()));

                Profile profile = null;
                try {
                    profile = new Profile(student.getProfile().getId(), nameTextFeild1.getText(),
                            gender, new SimpleDateFormat("yyyy-MM-dd").parse(birthdayTextField.getText()),
                            idNumbertextField.getText(), phoneTextFeild.getText(), emailTextFeild.getText(),
                            hometowntextField.getText(), curentAddressTextField.getText());
                } catch (ParseException ex) {
                    Logger.getLogger(DetailStudentOfficialForm.class.getName()).log(Level.SEVERE, null, ex);
                }

                Result result = new Result(Double.valueOf(learningPointTextField.getText()),
                        Double.valueOf(rewardTextField.getText()), Double.valueOf(disciplineTextField.getText()),
                        Double.valueOf(moneyPaidTextField.getText()), Integer.parseInt(String.valueOf(numberOfAbsencesTextField.getText())),
                        gradeTextField.getText(), student.getResultStudy().getId());

                Grade grade = grsv.getGrade(gradeTextField.getText());

                StudentOfficial stdOff = new StudentOfficial(result, grade, student.getId(),
                        profile, student.getDiscountStatus(), Double.valueOf(costTextField.getText()), student.getRegister());

                prsv.insertProfile(profile);
                ressv.insertResult(result);
                stsv.insertStudent(stdOff);
                model.setValueAt(stdOff.getId(), row, 0);
                model.setValueAt(stdOff.getProfile().getFullName(), row, 1);
                model.setValueAt(stdOff.getGrade().getNameGrade(), row, 2);
                model.setValueAt(stdOff.getProfile().getEmail(), row, 3);
                model.setValueAt(stdOff.getProfile().isGender(), row, 4);
                model.setValueAt(stdOff.getProfile().getIdNumber(), row, 5);
                model.setValueAt(stdOff.getProfile().getCurrentAddress(), row, 6);
                JOptionPane.showMessageDialog(DetailStudentOfficialForm.this,
                        "Updated!!!", "Notification",
                        JOptionPane.OK_OPTION, ImageUtils.loadImageIcon(getClass().getResource("/images/msg-error.gif").getPath()));
                setVisible(false);

            }

        });
    }

    public void showButtonEvents() {
        showButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                GradeForm gradeForm = new GradeForm(gradeTextField, courseTextField, costTextField);
                gradeForm.setVisible(true);
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

        topPanel = new javax.swing.JPanel();
        lbStudentInfo = new javax.swing.JLabel();
        centerPanel = new javax.swing.JPanel();
        infPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        genderTextField = new javax.swing.JTextField();
        emailTextFeild = new javax.swing.JTextField();
        nameTextFeild1 = new javax.swing.JTextField();
        phoneTextFeild = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        idNumbertextField = new javax.swing.JTextField();
        idNumberLabel = new javax.swing.JLabel();
        hometowntextField = new javax.swing.JTextField();
        hometownAdressLabel = new javax.swing.JLabel();
        curentAddressTextField = new javax.swing.JTextField();
        curentAdressLabel = new javax.swing.JLabel();
        courseLabel = new javax.swing.JLabel();
        gradeLabel = new javax.swing.JLabel();
        gradeTextField = new javax.swing.JTextField();
        birthdayLabel = new javax.swing.JLabel();
        birthdayTextField = new javax.swing.JTextField();
        showButton = new javax.swing.JButton();
        courseTextField = new javax.swing.JTextField();
        resPanel = new javax.swing.JPanel();
        learningPointLabel = new javax.swing.JLabel();
        learningPointTextField = new javax.swing.JTextField();
        trainingPointLabel = new javax.swing.JLabel();
        rewardTextField = new javax.swing.JTextField();
        rewardLabel = new javax.swing.JLabel();
        disciplineTextField = new javax.swing.JTextField();
        numberOfAbsencesTextField = new javax.swing.JTextField();
        rewardLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        moneyPaidTextField = new javax.swing.JTextField();
        costTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Details Student");
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(820, 550));
        setResizable(false);

        topPanel.setBackground(new java.awt.Color(255, 255, 255));
        topPanel.setPreferredSize(new java.awt.Dimension(820, 70));

        lbStudentInfo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbStudentInfo.setForeground(new java.awt.Color(0, 51, 153));
        lbStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/student.png"))); // NOI18N
        lbStudentInfo.setText("INFORMATION OFFICIAL STUDENT");
        lbStudentInfo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(lbStudentInfo)
                .addGap(86, 86, 86))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbStudentInfo)
                .addContainerGap())
        );

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        centerPanel.setBackground(new java.awt.Color(255, 255, 255));
        centerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        centerPanel.setLayout(new java.awt.BorderLayout());

        infPanel.setBackground(new java.awt.Color(204, 255, 255));
        infPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Personal Information"));
        infPanel.setPreferredSize(new java.awt.Dimension(366, 250));

        nameLabel.setBackground(new java.awt.Color(0, 51, 204));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Full name");

        emailLabel.setBackground(new java.awt.Color(0, 51, 204));
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLabel.setText("Email");

        genderLabel.setBackground(new java.awt.Color(0, 51, 204));
        genderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genderLabel.setText("Gender");

        nameTextFeild1.setRequestFocusEnabled(false);

        phoneLabel.setBackground(new java.awt.Color(0, 51, 204));
        phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneLabel.setText("Phone");

        idNumberLabel.setBackground(new java.awt.Color(0, 51, 204));
        idNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idNumberLabel.setText("Id Number");

        hometownAdressLabel.setBackground(new java.awt.Color(0, 51, 204));
        hometownAdressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hometownAdressLabel.setText("Hometown");

        curentAdressLabel.setBackground(new java.awt.Color(0, 51, 204));
        curentAdressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        curentAdressLabel.setText("Current Address");

        courseLabel.setBackground(new java.awt.Color(0, 51, 204));
        courseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseLabel.setText("Grade");

        gradeLabel.setBackground(new java.awt.Color(0, 51, 204));
        gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradeLabel.setText("Course");

        birthdayLabel.setBackground(new java.awt.Color(0, 51, 204));
        birthdayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        birthdayLabel.setText("Day of birth");

        showButton.setText("Show");
        showButton.setFocusPainted(false);

        javax.swing.GroupLayout infPanelLayout = new javax.swing.GroupLayout(infPanel);
        infPanel.setLayout(infPanelLayout);
        infPanelLayout.setHorizontalGroup(
            infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infPanelLayout.createSequentialGroup()
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infPanelLayout.createSequentialGroup()
                        .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(infPanelLayout.createSequentialGroup()
                                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(infPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)))
                        .addGap(7, 7, 7)
                        .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infPanelLayout.createSequentialGroup()
                                .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(birthdayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(birthdayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(emailTextFeild)
                            .addComponent(nameTextFeild1)))
                    .addGroup(infPanelLayout.createSequentialGroup()
                        .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hometownAdressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curentAdressLabel)
                            .addComponent(idNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneTextFeild)
                            .addComponent(idNumbertextField)
                            .addComponent(curentAddressTextField)
                            .addComponent(hometowntextField)))
                    .addGroup(infPanelLayout.createSequentialGroup()
                        .addComponent(courseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(gradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        infPanelLayout.setVerticalGroup(
            infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextFeild1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(birthdayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(birthdayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phoneTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idNumbertextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(infPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(idNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hometowntextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hometownAdressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curentAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(curentAdressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(courseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(showButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(courseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26))
        );

        centerPanel.add(infPanel, java.awt.BorderLayout.LINE_START);

        resPanel.setBackground(new java.awt.Color(255, 255, 204));
        resPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Study Result "));
        resPanel.setPreferredSize(new java.awt.Dimension(365, 250));

        learningPointLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        learningPointLabel.setText("Study Mark");

        trainingPointLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trainingPointLabel.setText("Reward Mark");

        rewardLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rewardLabel.setText("Discipline Mark");

        rewardLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rewardLabel1.setText("Number Of Absences");

        jLabel1.setText("Money Paid");

        moneyPaidTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyPaidTextFieldActionPerformed(evt);
            }
        });

        costTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Cost");

        saveButton.setBackground(new java.awt.Color(0, 0, 204));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        editButton.setBackground(new java.awt.Color(255, 0, 0));
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit");
        editButton.setFocusPainted(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout resPanelLayout = new javax.swing.GroupLayout(resPanel);
        resPanel.setLayout(resPanelLayout);
        resPanelLayout.setHorizontalGroup(
            resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resPanelLayout.createSequentialGroup()
                        .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(learningPointLabel)
                            .addComponent(rewardLabel)
                            .addComponent(trainingPointLabel)
                            .addComponent(rewardLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numberOfAbsencesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(resPanelLayout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(learningPointTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(resPanelLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(disciplineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resPanelLayout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(rewardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(resPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(resPanelLayout.createSequentialGroup()
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(resPanelLayout.createSequentialGroup()
                                .addComponent(moneyPaidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(costTextField)))))
                .addGap(36, 36, 36))
        );
        resPanelLayout.setVerticalGroup(
            resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(learningPointLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(learningPointTextField))
                .addGap(34, 34, 34)
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rewardTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trainingPointLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rewardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(disciplineTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rewardLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberOfAbsencesTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moneyPaidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        centerPanel.add(resPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moneyPaidTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyPaidTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moneyPaidTextFieldActionPerformed

    private void costTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JTextField birthdayTextField;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JTextField costTextField;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JTextField courseTextField;
    private javax.swing.JTextField curentAddressTextField;
    private javax.swing.JLabel curentAdressLabel;
    private javax.swing.JTextField disciplineTextField;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextFeild;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField genderTextField;
    private javax.swing.JLabel gradeLabel;
    private javax.swing.JTextField gradeTextField;
    private javax.swing.JLabel hometownAdressLabel;
    private javax.swing.JTextField hometowntextField;
    private javax.swing.JLabel idNumberLabel;
    private javax.swing.JTextField idNumbertextField;
    private javax.swing.JPanel infPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbStudentInfo;
    private javax.swing.JLabel learningPointLabel;
    private javax.swing.JTextField learningPointTextField;
    private javax.swing.JTextField moneyPaidTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextFeild1;
    private javax.swing.JTextField numberOfAbsencesTextField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextFeild;
    private javax.swing.JPanel resPanel;
    private javax.swing.JLabel rewardLabel;
    private javax.swing.JLabel rewardLabel1;
    private javax.swing.JTextField rewardTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton showButton;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel trainingPointLabel;
    // End of variables declaration//GEN-END:variables
}
