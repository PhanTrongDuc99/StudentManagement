/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author PC
 */
public class DivisionGradePanel extends javax.swing.JPanel {

    private Color defaultButtonBackground = new Color(0, 153, 204);
    private Color selectedButtonBackground = new Color(204, 204, 255);
    private Color defaultButtonForeground = Color.WHITE;
    private Color selectedButtonForeground = Color.BLUE;
    private MatteBorder defautButtonBorder = new MatteBorder(1, 0, 1, 1, Color.BLACK);
    private MatteBorder selectedButtonBorder = new MatteBorder(1, 0, 0, 1, Color.BLACK);

    /**
     * Creates new form DivisionGradePanel
     */
    public DivisionGradePanel() {
        initComponents();
        initEvents();
    }

    private void initEvents() {
        btDivideByLevelEvents();
        btPutGradeEvents();
        btDivideForReservedStudentEvents();

    }

    private void setStatusButtons(String buttonName) {
        Component[] components = pnTop.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (!buttonName.equalsIgnoreCase(button.getText())) {
                    button.setBorder(defautButtonBorder);
                    button.setBackground(defaultButtonBackground);
                    button.setForeground(defaultButtonForeground);
                } else {
                    button.setBorder(selectedButtonBorder);
                    button.setBackground(selectedButtonBackground);
                    button.setForeground(selectedButtonForeground);
                }

            }
        }
    }

    private void btDivideByLevelEvents() {
        btDivideByLevel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setStatusButtons(btDivideByLevel.getText());
            }
        });
    }

    private void btPutGradeEvents() {
        btPutGrade.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setStatusButtons(btPutGrade.getText());
            }
        });
    }

    private void btDivideForReservedStudentEvents() {
        btDivideForReservedStudent.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setStatusButtons(btDivideForReservedStudent.getText());
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

        pnTop = new javax.swing.JPanel();
        btDivideByLevel = new javax.swing.JButton();
        btPutGrade = new javax.swing.JButton();
        btDivideForReservedStudent = new javax.swing.JButton();
        pnBottom = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1587, 903));

        pnTop.setBackground(new java.awt.Color(0, 153, 204));

        btDivideByLevel.setBackground(new java.awt.Color(0, 153, 204));
        btDivideByLevel.setForeground(new java.awt.Color(255, 255, 255));
        btDivideByLevel.setText("According to educational level");
        btDivideByLevel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(51, 51, 51)));
        btDivideByLevel.setFocusPainted(false);
        btDivideByLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDivideByLevelActionPerformed(evt);
            }
        });

        btPutGrade.setBackground(new java.awt.Color(0, 153, 204));
        btPutGrade.setForeground(new java.awt.Color(255, 255, 255));
        btPutGrade.setText("Put the grade");
        btPutGrade.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        btPutGrade.setFocusPainted(false);
        btPutGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPutGradeActionPerformed(evt);
            }
        });

        btDivideForReservedStudent.setBackground(new java.awt.Color(0, 153, 204));
        btDivideForReservedStudent.setForeground(new java.awt.Color(255, 255, 255));
        btDivideForReservedStudent.setText("Class placement for reserved students");
        btDivideForReservedStudent.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        btDivideForReservedStudent.setFocusPainted(false);

        javax.swing.GroupLayout pnTopLayout = new javax.swing.GroupLayout(pnTop);
        pnTop.setLayout(pnTopLayout);
        pnTopLayout.setHorizontalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createSequentialGroup()
                .addComponent(btDivideByLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btPutGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btDivideForReservedStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 909, Short.MAX_VALUE))
        );
        pnTopLayout.setVerticalGroup(
            pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(btPutGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btDivideByLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btDivideForReservedStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnTopLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btDivideByLevel, btDivideForReservedStudent, btPutGrade});

        pnBottom.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout pnBottomLayout = new javax.swing.GroupLayout(pnBottom);
        pnBottom.setLayout(pnBottomLayout);
        pnBottomLayout.setHorizontalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnBottomLayout.setVerticalGroup(
            pnBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 782, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnBottom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btDivideByLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDivideByLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btDivideByLevelActionPerformed

    private void btPutGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPutGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPutGradeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDivideByLevel;
    private javax.swing.JButton btDivideForReservedStudent;
    private javax.swing.JButton btPutGrade;
    private javax.swing.JPanel pnBottom;
    private javax.swing.JPanel pnTop;
    // End of variables declaration//GEN-END:variables
}