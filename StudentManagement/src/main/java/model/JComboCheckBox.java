/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

/**
 *
 * @author USER
 */
public class JComboCheckBox extends JComboBox {

    private JTextField textfield;
    private final StringBuilder string = new StringBuilder("");

    public JComboCheckBox() {
        addStuff();
    }

    public JComboCheckBox(JCheckBox[] items) {
        super(items);
        addStuff();
    }

    public JComboCheckBox(Vector items, JTextField textField) {
        super(items);
        this.textfield = textField;
        addStuff();
    }

    public JComboCheckBox(ComboBoxModel aModel) {
        super(aModel);
        addStuff();
    }

    private void addStuff() {
        setRenderer(new ComboBoxRenderer());
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                itemSelected(textfield);
            }
        });
    }

    private void itemSelected(JTextField textfield) {
        if (getSelectedItem() instanceof JCheckBox) {
            JCheckBox jcb = (JCheckBox) getSelectedItem();
            jcb.setSelected(!jcb.isSelected());
            if (jcb.isSelected()) {
                if (string.toString().equals("")) {
                    string.append(jcb.getText());
                } else {
                    string.append(",").append(jcb.getText());
                }
                textfield.setText(string.toString());
            }
        }
    }

    class ComboBoxRenderer implements ListCellRenderer {

        private JLabel defaultLabel;

        public ComboBoxRenderer() {
            setOpaque(true);
        }

        public Component getListCellRendererComponent(JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Component) {
                Component c = (Component) value;
                if (isSelected) {
                    c.setBackground(list.getSelectionBackground());
                    c.setForeground(list.getSelectionForeground());
                } else {
                    c.setBackground(list.getBackground());
                    c.setForeground(list.getForeground());
                }
                return c;
            } else {
                if (defaultLabel == null) {
                    defaultLabel = new JLabel(value.toString());
                } else {
                    defaultLabel.setText(value.toString());
                }
                return defaultLabel;
            }
        }
    }
}
