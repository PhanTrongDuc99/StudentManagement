/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import utils.ImageUtils;
import view.sub.CourseInformationPanel;
import view.sub.CoursePanel;
import view.sub.DivisionGradePanel;
import view.sub.EnrollmentGradePlacementPanel;
import view.sub.FinancialPanel;
import view.sub.GradeInformationPanel;
import view.sub.GradePanel;
import view.sub.HomepagePanel;
import view.sub.SettingFrame;
import view.sub.StudentPanel;
import view.sub.TeacherPanel;
import view.sub.TrainingPanel;

/**
 * private final BorderLayout borderLayout = new BorderLayout();
 *
 *
 * @author SMILE ^^
 */
public class TrainingCenterFrame extends JFrame {

    private final Container container = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();
    private final GridLayout gridLayout = new GridLayout(8, 0, 25, 5);
    private final GridLayout gridLayoutPanelItemCourse = new GridLayout(2, 0, 5, 5);
    private final GridLayout gridLayoutPanelItemGrade = new GridLayout(2, 0, 5, 5);
    private final GridLayout gridLayoutPanelItemStudent = new GridLayout(3, 0, 5, 5);
    private final GridLayout gridLayoutPanelItemTeacher = new GridLayout(3, 0, 5, 5);
    private final GridLayout gridLayoutPanelItemFinancial = new GridLayout(2, 0, 5, 5);
    private final GridLayout gridLayoutPanelItemTraining = new GridLayout(3, 0, 5, 5);
    private final CardLayout cardLayout = new CardLayout();
    private final JSplitPane splitPane = new JSplitPane();
    private final JSplitPane splitPanePnLeft = new JSplitPane();
    private final int pnCenterHeight = 903;
    private final int pnCenterWidth = 1587;

    private JPanel pnTop;
    private JPanel pnLeftTop;
    private JPanel pnLeftBottom;
    private JPanel pnCenter;

    private HomepagePanel pnHomepage;
    private GradePanel pnGrade;
    private CoursePanel pnCourse;
    private StudentPanel pnStudent;
    private TeacherPanel pnTeacher;
    private FinancialPanel pnFinancial;
    private TrainingPanel pnTraining;

    private JButton btHomePage;
    private JButton btGrade;
    private JButton btCourse;
    private JButton btStudent;
    private JButton btTeacher;
    private JButton btFinancial;
    private JButton btTraining;

    private JPanel pnItemCourse;
    private JPanel pnItemGrade;
    private JPanel pnItemStudent;
    private JPanel pnItemTeacher;
    private JPanel pnItemFinancial;
    private JPanel pnItemTraining;

    private final JButton[] itemCourses = {new JButton("Admissions and Class arrangement"), new JButton("List of courses")};
    private final JButton[] itemGrades = {new JButton("List of grades"), new JButton("Grade division")};
    private final JButton[] itemStudents = {new JButton("List of students"), new JButton("Study results"), new JButton("List of students warned, reminded")};
    private final JButton[] itemTeachers = {new JButton("List of teacher"), new JButton("Assess, reward and discipline lecturers"), new JButton("Salary")};
    private final JButton[] itemFinancials = {new JButton("Student tuition management"), new JButton("Central management of revenue and expenditure")};
    private final JButton[] itemTrainings = {new JButton("Plan for the new courses"), new JButton("Arrange lecturers, classrooms, class schedule"), new JButton("Detailed plan for each course")};

    private boolean statusBtCourse = false;
    private boolean statusBtGrade = false;
    private boolean statusBtStudent = false;
    private boolean statusBtTeacher = false;
    private boolean statusBtFinancial = false;
    private boolean statusBtTraining = false;

    private final Border defaultBorder = new JButton().getBorder();
    private final Border pnLeftButtonHighLightBorder = BorderFactory.createLineBorder(new Color(0, 0, 50), 1);

    //private final Color selectedItemBackground = new Color(0, 0, 90);
    private final Color defaultBackground = new Color(0, 0, 50);
    private final Color defaultItemBackground = new Color(0, 0, 150);
    private final Color selectedItemBackground = new Color(0, 0, 250);
    private final Color defaultPnItemBackground = new Color(0, 102, 153);

    private JLabel lbAccount;
    private JLabel lbWelcome;
    private JLabel lbAdmin;
    private JLabel lbTilte;

    private JButton btSetting;
    private JButton btAlarm;
    private JButton btEmail;
    private long amountGmail = 0;
    private TitledBorder titledBorder = new TitledBorder(defaultBorder, String.valueOf(amountGmail), 0, 1, new Font("Tahoma", Font.PLAIN, 14), Color.RED);

    private final Font pnLeftButtonsFont = new Font("Tahoma", Font.BOLD, 18);

    public TrainingCenterFrame(String title) {
        super(title);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1080, 700);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setIconImage(ImageUtils.load(getClass().getResource("/images/logoApp.png").getPath()));
        container.setLayout(borderLayout);
        initComponents();
        initEvents();
    }

    private void initComponents() {
        splitPane.setOneTouchExpandable(true);
        splitPanePnLeft.setOrientation(JSplitPane.VERTICAL_SPLIT);
        initPnTopComponents();
        initPnLeftComponentsDefault();
        initPnCenterComponents();
    }

    private void initPnTopComponents() {
        pnTop = new JPanel();
        pnTop.setBackground(new Color(100, 255, 255));
        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setLayout(null);

        lbTilte = new JLabel("WELCOME TO HTD CENTER TRAINING CENTER MANAGEMENT SYSTEM");
        lbTilte.setFont(new Font(Font.MONOSPACED, Font.BOLD, 45));
        lbTilte.setForeground(Color.RED);
        lbTilte.setBounds(300, 20, (int) lbTilte.getPreferredSize().getWidth(), (int) lbTilte.getPreferredSize().getHeight());
        pnTop.add(lbTilte);

        lbAccount = new JLabel(ImageUtils.loadImageIcon(getClass().getResource("/images/default_avatar.png").getPath(), 50, 50));
        lbAccount.setBounds(100, 20, 50, 50);
        pnTop.add(lbAccount);

        lbWelcome = new JLabel("Welcome");
        lbWelcome.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        lbWelcome.setForeground(Color.BLUE);
        lbWelcome.setBounds(10, 20, (int) lbWelcome.getPreferredSize().getWidth(), (int) lbWelcome.getPreferredSize().getHeight());
        pnTop.add(lbWelcome);

        lbAdmin = new JLabel("Admin");
        lbAdmin.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        lbAdmin.setForeground(Color.BLUE);
        lbAdmin.setBounds(20, 45, (int) lbAdmin.getPreferredSize().getWidth(), (int) lbAdmin.getPreferredSize().getHeight());
        pnTop.add(lbAdmin);

        btAlarm = new JButton();
        btAlarm.setBackground(Color.WHITE);
        btAlarm.setFocusPainted(false);
        btAlarm.setBounds(180, 15, 35, 35);
        btAlarm.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/alarm.png").getPath(), 40, 40));
        pnTop.add(btAlarm);

        btSetting = new JButton();
        btSetting.setBackground(Color.WHITE);
        btSetting.setFocusPainted(false);
        btSetting.setBounds(180, 60, 35, 35);
        btSetting.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/setting.png").getPath(), 40, 40));
        pnTop.add(btSetting);

        btEmail = new JButton();
        btEmail.setBackground(Color.WHITE);
        btEmail.setBorder(titledBorder);
        btEmail.setFocusPainted(false);
        btEmail.setBounds(1855, 55, 50, 40);
        btEmail.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/icons8-gmail-50.png").getPath(), 50, 40));
        pnTop.add(btEmail);

        container.add(pnTop, BorderLayout.NORTH);
    }

    private void initPnLeftComponentsSelectedBtCourse() {
        pnLeftTop = new JPanel();
        pnLeftTop.setLayout(gridLayout);
        pnLeftTop.setBackground(defaultBackground);
        pnLeftTop.setPreferredSize(new Dimension(220, 300));
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        //Homepage
        btHomePage = new JButton("Home Page");
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        //Course
        btCourse = new JButton("Course management");
        createButton(btCourse);
        pnLeftTop.add(btCourse);
        pnItemCourse = new JPanel();
        pnItemCourse.setLayout(gridLayoutPanelItemCourse);
        createItemPanel(pnItemCourse, itemCourses);
        pnLeftTop.add(pnItemCourse);

        //Grade
        btGrade = new JButton("Grade management");
        createButton(btGrade);
        pnLeftTop.add(btGrade);

        btStudent = new JButton("Student management");
        createButton(btStudent);
        pnLeftTop.add(btStudent);

        //Teacher
        btTeacher = new JButton("Teacher management");
        createButton(btTeacher);
        pnLeftTop.add(btTeacher);

        //Financial
        btFinancial = new JButton("Financial management");
        createButton(btFinancial);
        pnLeftTop.add(btFinancial);

        //Training
        btTraining = new JButton("Training management");
        createButton(btTraining);
        pnLeftTop.add(btTraining);

        //Training
        createButton(btTraining);
        pnLeftTop.add(btTraining);

        btHomePage.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/homeNoBg.png").getPath()));
        btCourse.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/courseNoBg.png").getPath()));
        btGrade.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/gradeNoBg.png").getPath()));
        btStudent.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/studentNoBg.png").getPath()));
        btTeacher.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/teacherNoBg.png").getPath()));
        btFinancial.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/financialNoBg.png").getPath()));
        btTraining.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/trainingnoBg.png").getPath()));
        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(new Color(0, 102, 153));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
    }

    private void initPnLeftComponentsSelectedBtGrade() {
        pnLeftTop = new JPanel();
        pnLeftTop.setLayout(gridLayout);
        pnLeftTop.setBackground(defaultBackground);
        pnLeftTop.setPreferredSize(new Dimension(220, 300));
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        btHomePage = new JButton("Home Page");
        btGrade = new JButton("Grade management");
        btCourse = new JButton("Course management");
        btStudent = new JButton("Student management");
        btTeacher = new JButton("Teacher management");
        btFinancial = new JButton("Financial management");
        btTraining = new JButton("Training management");
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        createButton(btCourse);
        pnLeftTop.add(btCourse);

        createButton(btGrade);
        pnLeftTop.add(btGrade);
        pnItemGrade = new JPanel();
        pnItemGrade.setLayout(gridLayoutPanelItemGrade);
        createItemPanel(pnItemGrade, itemGrades);
        pnLeftTop.add(pnItemGrade);

        createButton(btStudent);
        pnLeftTop.add(btStudent);

        createButton(btTeacher);
        pnLeftTop.add(btTeacher);

        //Financial
        createButton(btFinancial);
        pnLeftTop.add(btFinancial);

        //Training
        createButton(btTraining);
        pnLeftTop.add(btTraining);
        btHomePage.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/homeNoBg.png").getPath()));
        btCourse.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/courseNoBg.png").getPath()));
        btGrade.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/gradeNoBg.png").getPath()));
        btStudent.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/studentNoBg.png").getPath()));
        btTeacher.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/teacherNoBg.png").getPath()));
        btFinancial.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/financialNoBg.png").getPath()));
        btTraining.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/trainingnoBg.png").getPath()));
        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(new Color(0, 102, 153));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
    }

    private void initPnLeftComponentsSelectedBtStudent() {
        pnLeftTop = new JPanel();
        pnLeftTop.setLayout(gridLayout);
        pnLeftTop.setBackground(defaultBackground);
        pnLeftTop.setPreferredSize(new Dimension(220, 300));
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        btHomePage = new JButton("Home Page");
        btGrade = new JButton("Grade management");
        btCourse = new JButton("Course management");
        btStudent = new JButton("Student management");
        btTeacher = new JButton("Teacher management");
        btFinancial = new JButton("Financial management");
        btTraining = new JButton("Training management");
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        createButton(btCourse);
        pnLeftTop.add(btCourse);

        createButton(btGrade);
        pnLeftTop.add(btGrade);

        createButton(btStudent);
        pnLeftTop.add(btStudent);
        pnItemStudent = new JPanel();
        pnItemStudent.setLayout(gridLayoutPanelItemStudent);
        createItemPanel(pnItemStudent, itemStudents);
        pnLeftTop.add(pnItemStudent);

        createButton(btTeacher);
        pnLeftTop.add(btTeacher);

        //Financial
        createButton(btFinancial);
        pnLeftTop.add(btFinancial);

        //Training
        createButton(btTraining);
        pnLeftTop.add(btTraining);
        btHomePage.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/homeNoBg.png").getPath()));
        btCourse.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/courseNoBg.png").getPath()));
        btGrade.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/gradeNoBg.png").getPath()));
        btStudent.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/studentNoBg.png").getPath()));
        btTeacher.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/teacherNoBg.png").getPath()));
        btFinancial.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/financialNoBg.png").getPath()));
        btTraining.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/trainingnoBg.png").getPath()));
        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(new Color(0, 102, 153));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
    }

    private void initPnLeftComponentsSelectedBtTeacher() {
        pnLeftTop = new JPanel();
        pnLeftTop.setLayout(gridLayout);
        pnLeftTop.setBackground(defaultBackground);
        pnLeftTop.setPreferredSize(new Dimension(220, 300));
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        btHomePage = new JButton("Home Page");
        btGrade = new JButton("Grade management");
        btCourse = new JButton("Course management");
        btStudent = new JButton("Student management");
        btTeacher = new JButton("Teacher management");
        btFinancial = new JButton("Financial management");
        btTraining = new JButton("Training management");
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        createButton(btCourse);
        pnLeftTop.add(btCourse);

        createButton(btGrade);
        pnLeftTop.add(btGrade);

        createButton(btStudent);
        pnLeftTop.add(btStudent);

        createButton(btTeacher);
        pnLeftTop.add(btTeacher);
        pnItemTeacher = new JPanel();
        pnItemTeacher.setLayout(gridLayoutPanelItemTeacher);
        createItemPanel(pnItemTeacher, itemTeachers);
        pnLeftTop.add(pnItemTeacher);

        //Financial
        createButton(btFinancial);
        pnLeftTop.add(btFinancial);

        //Training
        createButton(btTraining);
        pnLeftTop.add(btTraining);
        btHomePage.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/homeNoBg.png").getPath()));
        btCourse.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/courseNoBg.png").getPath()));
        btGrade.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/gradeNoBg.png").getPath()));
        btStudent.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/studentNoBg.png").getPath()));
        btTeacher.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/teacherNoBg.png").getPath()));
        btFinancial.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/financialNoBg.png").getPath()));
        btTraining.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/trainingnoBg.png").getPath()));
        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(new Color(0, 102, 153));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
    }

    private void initPnLeftComponentsSelectedBtFinancial() {
        pnLeftTop = new JPanel();
        pnLeftTop.setLayout(gridLayout);
        pnLeftTop.setBackground(defaultBackground);
        pnLeftTop.setPreferredSize(new Dimension(220, 300));
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        btHomePage = new JButton("Home Page");
        btGrade = new JButton("Grade management");
        btCourse = new JButton("Course management");
        btStudent = new JButton("Student management");
        btTeacher = new JButton("Teacher management");
        btFinancial = new JButton("Financial management");
        btTraining = new JButton("Training management");
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        createButton(btCourse);
        pnLeftTop.add(btCourse);

        createButton(btGrade);
        pnLeftTop.add(btGrade);

        createButton(btStudent);
        pnLeftTop.add(btStudent);

        createButton(btTeacher);
        pnLeftTop.add(btTeacher);

        //Financial
        createButton(btFinancial);
        pnLeftTop.add(btFinancial);

        pnItemFinancial = new JPanel();
        pnItemFinancial.setLayout(gridLayoutPanelItemFinancial);
        createItemPanel(pnItemFinancial, itemFinancials);
        pnLeftTop.add(pnItemFinancial);

        //Training
        createButton(btTraining);
        pnLeftTop.add(btTraining);
        btHomePage.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/homeNoBg.png").getPath()));
        btCourse.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/courseNoBg.png").getPath()));
        btGrade.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/gradeNoBg.png").getPath()));
        btStudent.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/studentNoBg.png").getPath()));
        btTeacher.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/teacherNoBg.png").getPath()));
        btFinancial.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/financialNoBg.png").getPath()));
        btTraining.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/trainingnoBg.png").getPath()));
        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(new Color(0, 102, 153));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
    }

    private void initPnLeftComponentsSelectedBtTraining() {
        pnLeftTop = new JPanel();
        pnLeftTop.setLayout(gridLayout);
        pnLeftTop.setBackground(defaultBackground);
        pnLeftTop.setPreferredSize(new Dimension(220, 300));
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        btHomePage = new JButton("Home Page");
        btGrade = new JButton("Grade management");
        btCourse = new JButton("Course management");
        btStudent = new JButton("Student management");
        btTeacher = new JButton("Teacher management");
        btFinancial = new JButton("Financial management");
        btTraining = new JButton("Training management");
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        createButton(btCourse);
        pnLeftTop.add(btCourse);

        createButton(btGrade);
        pnLeftTop.add(btGrade);

        createButton(btStudent);
        pnLeftTop.add(btStudent);

        createButton(btTeacher);
        pnLeftTop.add(btTeacher);

        //Financial
        createButton(btFinancial);
        pnLeftTop.add(btFinancial);

        //Training
        createButton(btTraining);
        pnLeftTop.add(btTraining);
        pnItemTraining = new JPanel();
        pnItemTraining.setLayout(gridLayoutPanelItemTraining);
        createItemPanel(pnItemTraining, itemTrainings);
        pnLeftTop.add(pnItemTraining);
        btHomePage.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/homeNoBg.png").getPath()));
        btCourse.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/courseNoBg.png").getPath()));
        btGrade.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/gradeNoBg.png").getPath()));
        btStudent.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/studentNoBg.png").getPath()));
        btTeacher.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/teacherNoBg.png").getPath()));
        btFinancial.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/financialNoBg.png").getPath()));
        btTraining.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/trainingnoBg.png").getPath()));
        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(new Color(0, 102, 153));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
    }

    private final void initPnLeftComponentsDefault() {
        pnLeftTop = new JPanel();
        pnLeftTop.setLayout(gridLayout);
        pnLeftTop.setBackground(defaultBackground);
        pnLeftTop.setPreferredSize(new Dimension(220, 300));
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        btHomePage = new JButton("Home Page");
        btGrade = new JButton("Grade management");
        btCourse = new JButton("Course management");
        btStudent = new JButton("Student management");
        btTeacher = new JButton("Teacher management");
        btFinancial = new JButton("Financial management");
        btTraining = new JButton("Training management");
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        createButton(btCourse);
        pnLeftTop.add(btCourse);

        createButton(btGrade);
        pnLeftTop.add(btGrade);

        createButton(btStudent);
        pnLeftTop.add(btStudent);

        createButton(btTeacher);
        pnLeftTop.add(btTeacher);

        //Financial
        createButton(btFinancial);
        pnLeftTop.add(btFinancial);

        //Training
        createButton(btTraining);
        pnLeftTop.add(btTraining);
        btHomePage.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/homeNoBg.png").getPath()));
        btCourse.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/courseNoBg.png").getPath()));
        btGrade.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/gradeNoBg.png").getPath()));
        btStudent.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/studentNoBg.png").getPath()));
        btTeacher.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/teacherNoBg.png").getPath()));
        btFinancial.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/financialNoBg.png").getPath()));
        btTraining.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/trainingnoBg.png").getPath()));
        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(new Color(0, 102, 153));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
    }

    private void createItemPanel(JPanel panel, JButton... buttons) {

        panel.setBackground(defaultPnItemBackground);
        panel.setBorder(defaultBorder);
        createItemsButton(buttons);
        addItemsOnPanel(panel, buttons);
    }

    private void createButton(JButton button) {
        button.setFocusPainted(false);
        button.setFont(pnLeftButtonsFont);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBackground(defaultBackground);
        button.setForeground(Color.WHITE);
    }

    private void initPnCenterComponents() {
        pnCenter = new JPanel();
        pnCenter.setLayout(cardLayout);

        pnHomepage = new HomepagePanel();
        pnGrade = new GradePanel();
        pnCourse = new CoursePanel();
        pnStudent = new StudentPanel();
        pnTeacher = new TeacherPanel();
        pnFinancial = new FinancialPanel();
        pnTraining = new TrainingPanel();

        pnCenter.add(pnHomepage, btHomePage.getText());
//        pnCenter.add(pnCourse, btCourse.getText());
//        pnCenter.add(pnGrade, btGrade.getText());
//        pnCenter.add(pnStudent, btStudent.getText());
//        pnCenter.add(pnTeacher, btTeacher.getText());
//        pnCenter.add(pnFinancial, btFinancial.getText());
//        pnCenter.add(pnTraining, btTraining.getText());

        splitPane.add(splitPanePnLeft, JSplitPane.LEFT);
        splitPane.add(pnCenter, JSplitPane.RIGHT);
        container.add(splitPane, BorderLayout.CENTER);

    }

    private void initEvents() {
        pnLeftTopButtonsEvents();
        btSettingEvents();
        btGmailEvents();

    }

    private void btGmailEvents() {

    }

    private void addItemsOnPanel(JPanel panel, JButton... buttons) {
        for (JButton button : buttons) {
            panel.add(button);
        }
    }

    private void createItemsButton(JButton... buttons) {
        for (JButton button : buttons) {
            button.setFocusPainted(false);
            button.setFont(pnLeftButtonsFont);
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            button.setBorder(pnLeftButtonHighLightBorder);
            button.setBackground(defaultItemBackground);
            button.setForeground(Color.WHITE);
        }
    }

    private void pnLeftTopButtonsEvents() {
        final Component[] components = pnLeftTop.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                final JButton button = (JButton) component;
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        String key = button.getText();
                        cardLayout.show(pnCenter, key);
                        disableBackgroundButtons(components);
                        button.setBackground(defaultItemBackground);

                        if (btHomePage.getText().equalsIgnoreCase(button.getText())) {
                            initPnLeftComponentsDefault();
                            pnCenter.removeAll();
                            pnCenter.add(pnHomepage);
                            initEvents();
                        } else {
                            //display and hint item of panelCourse
                            if (btCourse.getText().equalsIgnoreCase(button.getText())) {
                                if (!statusBtCourse) {
                                    disableBackgroundButtons(btCourse);
                                    initPnLeftComponentsSelectedBtCourse();
                                    initEvents();
                                    pnItemCourseEvents();
                                    statusBtCourse = !statusBtCourse;
                                } else {
                                    initPnLeftComponentsDefault();
                                    initEvents();
                                    statusBtCourse = !statusBtCourse;
                                }
                            } else {
                                //display and hint item of panelGrade
                                if (btGrade.getText().equalsIgnoreCase(button.getText())) {
                                    if (!statusBtGrade) {
                                        initPnLeftComponentsSelectedBtGrade();
                                        initEvents();
                                        pnItemGradeEvents();
                                        statusBtGrade = !statusBtGrade;
                                    } else {
                                        initPnLeftComponentsDefault();
                                        initEvents();
                                        statusBtGrade = !statusBtGrade;
                                    }
                                } else {
                                    //display and hint item of panelStudent
                                    if (btStudent.getText().equalsIgnoreCase(button.getText())) {
                                        if (!statusBtStudent) {
                                            initPnLeftComponentsSelectedBtStudent();
                                            initEvents();
                                            pnItemStudentEvents();
                                            statusBtStudent = !statusBtStudent;
                                        } else {
                                            initPnLeftComponentsDefault();
                                            initEvents();
                                            statusBtStudent = !statusBtStudent;
                                        }
                                    } else {
                                        //display and hint item of panelTeacher
                                        if (btTeacher.getText().equalsIgnoreCase(button.getText())) {
                                            if (!statusBtTeacher) {
                                                initPnLeftComponentsSelectedBtTeacher();
                                                initEvents();
                                                pnItemTeacherEvents();
                                                statusBtTeacher = !statusBtTeacher;
                                            } else {
                                                initPnLeftComponentsDefault();
                                                initEvents();
                                                statusBtTeacher = !statusBtTeacher;
                                            }
                                        } else {
                                            //display and hint item of panelFinancial
                                            if (btFinancial.getText().equalsIgnoreCase(button.getText())) {
                                                if (!statusBtFinancial) {
                                                    initPnLeftComponentsSelectedBtFinancial();
                                                    initEvents();
                                                    pnItemFinicialEvents();
                                                    statusBtFinancial = !statusBtFinancial;
                                                } else {
                                                    initPnLeftComponentsDefault();
                                                    initEvents();
                                                    statusBtFinancial = !statusBtFinancial;
                                                }
                                            } else {
                                                //display and hint item of panelTraining
                                                if (btTraining.getText().equalsIgnoreCase(button.getText())) {
                                                    if (!statusBtTraining) {
                                                        initPnLeftComponentsSelectedBtTraining();
                                                        initEvents();
                                                        pnItemTrainingEvents();
                                                        statusBtTraining = !statusBtTraining;
                                                    } else {

                                                        initPnLeftComponentsDefault();
                                                        initEvents();
                                                        statusBtTraining = !statusBtTraining;
                                                    }
                                                }
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    private void disableBackgroundButtons(Component... components) {
        for (Component component : components) {
            if (component instanceof JButton) {
                final JButton button = (JButton) component;
                button.setBackground(defaultBackground);
            }
        }
    }

    private void btSettingEvents() {
        btSetting.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JFrame settingFrame = new SettingFrame((JFrame) SwingUtilities.getRoot(btSetting));
                settingFrame.setLocation(btSetting.getLocationOnScreen().getLocation());
                settingFrame.setVisible(true);
            }

        });
    }

    private void pnItemCourseEvents() {
        Component[] components = pnItemCourse.getComponents();
        for (Component component : components) {
            final JButton btItemPnCourse = (JButton) component;
            btItemPnCourse.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    //Admissions and Class arrangement
                    if (btItemPnCourse.getText().equalsIgnoreCase(itemCourses[0].getText())) {
                        pnCenter.removeAll();
                        pnCenter.revalidate();
                        EnrollmentGradePlacementPanel enrollmentGradePlacementPanel = new EnrollmentGradePlacementPanel();
                        pnCenter.add(enrollmentGradePlacementPanel);
                        enrollmentGradePlacementPanel.setVisible(true);
                    } else {
                        //show list courses
                        if (btItemPnCourse.getText().equalsIgnoreCase(itemCourses[1].getText())) {
                            pnCenter.removeAll();
                            pnCenter.revalidate();
                            CourseInformationPanel courseInformationPanel = new CourseInformationPanel();
                            pnCenter.add(courseInformationPanel);
                            courseInformationPanel.setVisible(true);
                        }
                    }
                }

                // thay doi background khi re chuot ra vao
                @Override
                public void mouseEntered(MouseEvent e) {
                    btItemPnCourse.setBackground(selectedItemBackground);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btItemPnCourse.setBackground(defaultItemBackground);
                }
            });
        }
    }

    private void pnItemGradeEvents() {
        Component[] components = pnItemGrade.getComponents();
        for (Component component : components) {
            final JButton btItemPnGrade = (JButton) component;
            btItemPnGrade.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    //List of grades
                    if (btItemPnGrade.getText().equalsIgnoreCase(itemGrades[0].getText())) {
                        pnCenter.removeAll();
                        pnCenter.revalidate();
                        GradeInformationPanel studentPanel = new GradeInformationPanel();
                        pnCenter.add(studentPanel);
                        studentPanel.setVisible(true);
                    } else {
                        //Grade division
                        if (btItemPnGrade.getText().equalsIgnoreCase(itemGrades[1].getText())) {
                            pnCenter.removeAll();
                            pnCenter.revalidate();
                            DivisionGradePanel divisionGradePanel = new DivisionGradePanel();
                            pnCenter.add(divisionGradePanel);
                            divisionGradePanel.setVisible(true);
                        }
                    }
                }

                // thay doi background khi re chuot ra vao
                @Override
                public void mouseEntered(MouseEvent e) {
                    btItemPnGrade.setBackground(selectedItemBackground);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btItemPnGrade.setBackground(defaultItemBackground);
                }
            });
        }
    }

    private void pnItemStudentEvents() {
        Component[] components = pnItemStudent.getComponents();
        for (Component component : components) {
            final JButton btItemPnStudent = (JButton) component;
            btItemPnStudent.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    //List students
                    if (btItemPnStudent.getText().equalsIgnoreCase(itemStudents[0].getText())) {
                        pnCenter.removeAll();
                        pnCenter.revalidate();
                    } else {
                        //Student results
                        if (btItemPnStudent.getText().equalsIgnoreCase(itemStudents[1].getText())) {
// ĐứcpnCenter.removeAll();
                            pnCenter.revalidate();
                        } else {
                            //List of students warned, reminded
                            if (btItemPnStudent.getText().equalsIgnoreCase(itemStudents[2].getText())) {
                                pnCenter.removeAll();
                                pnCenter.revalidate();
                            }
                        }
                    }
                }

                // thay doi background khi re chuot ra vao
                @Override
                public void mouseEntered(MouseEvent e) {
                    btItemPnStudent.setBackground(selectedItemBackground);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btItemPnStudent.setBackground(defaultItemBackground);
                }
            });
        }
    }

    private void pnItemTeacherEvents() {
        Component[] components = pnItemTeacher.getComponents();
        for (Component component : components) {
            final JButton btItemPnTeacher = (JButton) component;
            btItemPnTeacher.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    //List of teachers 
                    if (btItemPnTeacher.getText().equalsIgnoreCase(itemTeachers[0].getText())) {
//Đức
                    } else {
                        // Assess, reward and discipline lecturers
                        if (btItemPnTeacher.getText().equalsIgnoreCase(itemTeachers[1].getText())) {

                        } else {
                            ///Salary
                            if (btItemPnTeacher.getText().equalsIgnoreCase(itemTeachers[2].getText())) {

                            }
                        }
                    }
                }

                // thay doi background khi re chuot ra vao
                @Override
                public void mouseEntered(MouseEvent e) {
                    btItemPnTeacher.setBackground(selectedItemBackground);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btItemPnTeacher.setBackground(defaultItemBackground);
                }
            });
        }
    }

    private void pnItemFinicialEvents() {
        Component[] components = pnItemFinancial.getComponents();
        for (Component component : components) {
            final JButton btItemPnFinicial = (JButton) component;
            btItemPnFinicial.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    ///Student tuition management
                    if (btItemPnFinicial.getText().equalsIgnoreCase(itemFinancials[0].getText())) {

                    } else {
                        ///Central management of revenue and expenditure
                        if (btItemPnFinicial.getText().equalsIgnoreCase(itemFinancials[1].getText())) {

                        }
                    }
                }

                // thay doi background khi re chuot ra vao
                @Override
                public void mouseEntered(MouseEvent e) {
                    btItemPnFinicial.setBackground(selectedItemBackground);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btItemPnFinicial.setBackground(defaultItemBackground);
                }
            });
        }
    }

    private void pnItemTrainingEvents() {
        Component[] components = pnItemTraining.getComponents();
        for (Component component : components) {
            final JButton btItemPnTraining = (JButton) component;
            btItemPnTraining.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    //Plan for course
                    if (btItemPnTraining.getText().equalsIgnoreCase(itemTrainings[0].getText())) {

                    } else {
                        //Arrange lecturers, classrooms, class schedule
                        if (btItemPnTraining.getText().equalsIgnoreCase(itemTrainings[1].getText())) {

                        } else {
                            //Detailed plan for each course
                            if (btItemPnTraining.getText().equalsIgnoreCase(itemTrainings[2].getText())) {

                            }
                        }
                    }
                }

                // thay doi background khi re chuot ra vao
                @Override
                public void mouseEntered(MouseEvent e) {
                    btItemPnTraining.setBackground(selectedItemBackground);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btItemPnTraining.setBackground(defaultItemBackground);
                }
            });
        }
    }

    public static void main(String[] args) {
        TrainingCenterFrame eblm = new TrainingCenterFrame("Programming Training Center UI/UX");
        eblm.setVisible(true);
    }
}
