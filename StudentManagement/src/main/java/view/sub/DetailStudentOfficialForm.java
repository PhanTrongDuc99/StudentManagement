/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

/**
 *
 * @author USER
 */
public class DetailStudentOfficialForm extends javax.swing.JFrame {

    /**
     * Creates new form DetailStudentForm
     */
    public DetailStudentOfficialForm() {
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
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
        nameTextFeild = new javax.swing.JTextField();
        nameTextFeild1 = new javax.swing.JTextField();
        phoneTextFeild = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        idNumbertextField = new javax.swing.JTextField();
        idNumberLabel = new javax.swing.JLabel();
        idNumbertextField1 = new javax.swing.JTextField();
        hometownAdressLabel = new javax.swing.JLabel();
        curentAddressTextField = new javax.swing.JTextField();
        curentAdressLabel = new javax.swing.JLabel();
        courseTextField = new javax.swing.JTextField();
        courseLabel = new javax.swing.JLabel();
        gradeLabel = new javax.swing.JLabel();
        gradeTextField = new javax.swing.JTextField();
        birthdayLabel = new javax.swing.JLabel();
        birthdayTextField = new javax.swing.JTextField();
        resPanel = new javax.swing.JPanel();
        learningPointLabel = new javax.swing.JLabel();
        learningPointTextField = new javax.swing.JTextField();
        trainingPointLabel = new javax.swing.JLabel();
        trainingPointTextField = new javax.swing.JTextField();
        rewardLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rewardTextField = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        disciplineTextfield = new javax.swing.JTextArea();
        disciplineLabel = new javax.swing.JLabel();

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
        lbStudentInfo.setText("  THÔNG TIN HỌC VIÊN");
        lbStudentInfo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(lbStudentInfo)
                .addContainerGap(190, Short.MAX_VALUE))
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
        infPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thông tin"));
        infPanel.setPreferredSize(new java.awt.Dimension(366, 250));

        nameLabel.setBackground(new java.awt.Color(0, 51, 204));
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Họ tên");

        emailLabel.setBackground(new java.awt.Color(0, 51, 204));
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLabel.setText("Email");

        genderLabel.setBackground(new java.awt.Color(0, 51, 204));
        genderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        genderLabel.setText("Giới tính");

        nameTextFeild1.setRequestFocusEnabled(false);

        phoneLabel.setBackground(new java.awt.Color(0, 51, 204));
        phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneLabel.setText("Phone");

        idNumberLabel.setBackground(new java.awt.Color(0, 51, 204));
        idNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idNumberLabel.setText("CMND");

        hometownAdressLabel.setBackground(new java.awt.Color(0, 51, 204));
        hometownAdressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hometownAdressLabel.setText("Quê quán");

        curentAdressLabel.setBackground(new java.awt.Color(0, 51, 204));
        curentAdressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        curentAdressLabel.setText("Chỗ ở hiện tại");

        courseLabel.setBackground(new java.awt.Color(0, 51, 204));
        courseLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        courseLabel.setText("Lớp");

        gradeLabel.setBackground(new java.awt.Color(0, 51, 204));
        gradeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gradeLabel.setText("Khóa");

        birthdayLabel.setBackground(new java.awt.Color(0, 51, 204));
        birthdayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        birthdayLabel.setText("Ngày sinh");

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
                            .addGroup(infPanelLayout.createSequentialGroup()
                                .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(birthdayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(birthdayTextField))
                            .addComponent(nameTextFeild)
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
                            .addComponent(idNumbertextField1)))
                    .addGroup(infPanelLayout.createSequentialGroup()
                        .addComponent(courseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(courseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(gradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(birthdayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(birthdayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(genderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTextFeild, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(idNumbertextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hometownAdressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curentAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(curentAdressLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gradeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(gradeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(infPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(courseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(courseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        centerPanel.add(infPanel, java.awt.BorderLayout.LINE_START);

        resPanel.setBackground(new java.awt.Color(255, 255, 204));
        resPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Kết quả học tập"));
        resPanel.setPreferredSize(new java.awt.Dimension(365, 250));

        learningPointLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        learningPointLabel.setText("Điểm học tập");

        trainingPointLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trainingPointLabel.setText("Điểm rèn luyện");

        rewardLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rewardLabel.setText("Khen thưởng");

        rewardTextField.setColumns(20);
        rewardTextField.setRows(5);
        jScrollPane1.setViewportView(rewardTextField);

        disciplineTextfield.setColumns(20);
        disciplineTextfield.setRows(5);
        jScrollPane2.setViewportView(disciplineTextfield);

        disciplineLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disciplineLabel.setText("Kỉ luật");

        javax.swing.GroupLayout resPanelLayout = new javax.swing.GroupLayout(resPanel);
        resPanel.setLayout(resPanelLayout);
        resPanelLayout.setHorizontalGroup(
            resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(resPanelLayout.createSequentialGroup()
                            .addComponent(learningPointLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                            .addComponent(learningPointTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(resPanelLayout.createSequentialGroup()
                            .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(trainingPointLabel)
                                .addComponent(rewardLabel))
                            .addGap(38, 38, 38)
                            .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(trainingPointTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(jScrollPane1)))
                        .addComponent(disciplineLabel))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        resPanelLayout.setVerticalGroup(
            resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(learningPointLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(learningPointTextField))
                .addGap(18, 18, 18)
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(resPanelLayout.createSequentialGroup()
                        .addComponent(trainingPointLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addComponent(trainingPointTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(resPanelLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(rewardLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(resPanelLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(resPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resPanelLayout.createSequentialGroup()
                        .addComponent(disciplineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))))
        );

        centerPanel.add(resPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel birthdayLabel;
    private javax.swing.JTextField birthdayTextField;
    private javax.swing.JPanel centerPanel;
    private javax.swing.JLabel courseLabel;
    private javax.swing.JTextField courseTextField;
    private javax.swing.JTextField curentAddressTextField;
    private javax.swing.JLabel curentAdressLabel;
    private javax.swing.JLabel disciplineLabel;
    private javax.swing.JTextArea disciplineTextfield;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JTextField genderTextField;
    private javax.swing.JLabel gradeLabel;
    private javax.swing.JTextField gradeTextField;
    private javax.swing.JLabel hometownAdressLabel;
    private javax.swing.JLabel idNumberLabel;
    private javax.swing.JTextField idNumbertextField;
    private javax.swing.JTextField idNumbertextField1;
    private javax.swing.JPanel infPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbStudentInfo;
    private javax.swing.JLabel learningPointLabel;
    private javax.swing.JTextField learningPointTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextFeild;
    private javax.swing.JTextField nameTextFeild1;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneTextFeild;
    private javax.swing.JPanel resPanel;
    private javax.swing.JLabel rewardLabel;
    private javax.swing.JTextArea rewardTextField;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel trainingPointLabel;
    private javax.swing.JTextField trainingPointTextField;
    // End of variables declaration//GEN-END:variables
}
