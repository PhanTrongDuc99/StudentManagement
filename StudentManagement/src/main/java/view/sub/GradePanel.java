/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author SMILE ^^
 */
public class GradePanel extends JPanel {

    private JLabel lbTitle;

    public GradePanel() {
        initComponents();
    }

    private void initComponents() {
        lbTitle = new JLabel();
        lbTitle.setText("<html><b style='color: red; font-size: 18px'>THIS IS GRADE PAGE</b></html>");
        add(lbTitle);
    }
}
