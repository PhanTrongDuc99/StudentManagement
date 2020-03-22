package view.sub;

import entities.Profile;
import java.awt.Dimension;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import service.ProfileServiceImpl;


public class Demo extends JFrame {

    private JTable tblStudent;
    private DefaultTableModel model;

    public Demo() {
        // TODO Auto-generated constructor stub
        /* START - Nếu dùng Netbeans thì không cần quan tâm đến đoạn này làm gì */
        tblStudent = new JTable();
        //tblStudent.setPreferredSize(new Dimension(500, 500));
        this.add(new JScrollPane(tblStudent));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        /* END - Nếu dùng Netbeans thì không cần quan tâm đến đoạn này làm gì */

        loadDataIntoJTable();  //đưa column name và data row lên JTable
    }

    private void loadDataIntoJTable() {
        model = new DefaultTableModel();
        //Set Column Title
        Vector column = new Vector();
        column.add("Name");
        column.add("Phone number");
        column.add("Email");
        column.add("Gender");
        column.add("Day of Birth");
        column.add("Hometown");
        column.add("Current address");
        column.add("Id Number");
        
        model.setColumnIdentifiers(column);
        List<Profile> list = new ProfileServiceImpl().getProfileStudents();
        for (int i = 0; i < list.size(); i++) {
            Profile pro = (Profile) list.get(i);
            Vector row = new Vector();
            row.add(pro.getFullName());
            row.add(pro.getPhoneNumber());
            row.add(pro.getEmail());
            row.add(pro.isGender());
            row.add(pro.getDayOfBirth());
            row.add(pro.getHomeTown());
            row.add(pro.getCurrentAddress());
            row.add(pro.getIdNumber());
            model.addRow(row);
        }
        tblStudent.setModel(model);
    }
    
    public static void main(String[] args) {
        new Demo();
    }
}
