package view.sub;

import entities.Course;
import entities.Profile;
import entities.StudentUnofficial;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import service.CourseServiceImpl;
import service.ProfileServiceImpl;
import service.StudentUnofficialServiceImpl;
import utils.ConvertDataTypesUtils;
import utils.DateUtils;
import utils.ImageUtils;

public class ListStudentUnofficialslFrame extends JFrame {

    private JTable tblStudent;
    private DefaultTableModel model;

    public ListStudentUnofficialslFrame() {
        // TODO Auto-generated constructor stub
        /* START - Nếu dùng Netbeans thì không cần quan tâm đến đoạn này làm gì */
        //tblStudent.setPreferredSize(new Dimension(500, 500));
        initComponent();
        initEvents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(1500, 600);
        setTitle("List student register on center");
        setIconImage(ImageUtils.load(getClass().getResource("/images/student.png").getPath()));
        setLocationRelativeTo(null);
        /* END - Nếu dùng Netbeans thì không cần quan tâm đến đoạn này làm gì */
    }

    private void initComponent() {
        tblStudent = new JTable();
        add(new JScrollPane(tblStudent));
    }

    private void initEvents() {
        loadDataIntoJTable();  //đưa column name và data row lên JTable
    }

    private void loadDataIntoJTable() {
        model = new DefaultTableModel();
        //Set Column Title
        Vector column = new Vector();
        column.add("Id number");
        column.add("Name");
        column.add("Day of birth");
        column.add("Gender");
        column.add("Phone number");
        column.add("Email");
        column.add("Hometown");
        column.add("Current address");
        column.add("Cost");
        column.add("DiscountCost");
        column.add("Registered type");
        column.add("Registration course");

        model.setColumnIdentifiers(column);
        List<Profile> profileStudents = new ProfileServiceImpl().getProfileStudents();
        List<StudentUnofficial> studentUnofficials = new StudentUnofficialServiceImpl().getAll();

        for (int i = 0; i < profileStudents.size(); i++) {
            Profile pro = (Profile) profileStudents.get(i);
            StudentUnofficial studentUnofficial = studentUnofficials.get(i);
            Vector row = new Vector();
            row.add(pro.getIdNumber());
            row.add(pro.getFullName());
            row.add(DateUtils.convertToDateFromString(pro.getDayOfBirth()));
            row.add(ConvertDataTypesUtils.valueOf(pro.isGender()));
            row.add(pro.getPhoneNumber());
            row.add(pro.getEmail());
            row.add(pro.getHomeTown());
            row.add(pro.getCurrentAddress());
            row.add(studentUnofficial.getDiscountStatus());
            row.add(studentUnofficial.getCost());
            row.add(studentUnofficial.getRegister().getType());
            row.add(new CourseServiceImpl().getCourseById(studentUnofficial.getIdRegisterCourse()).getNameCourse());
            model.addRow(row);
        }
        tblStudent.setModel(model);
    }
}
