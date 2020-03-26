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
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import utils.ImageUtils;
import view.sub.CoursePanel;
import view.sub.EnrollmentGradePlacementPanel;
import view.sub.FinancialPanel;
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
    private final GridLayout gridLayoutPanelItemGrade = new GridLayout(3, 0, 5, 5);
    private final GridLayout gridLayoutPanelItemStudent = new GridLayout(3, 0, 5, 5);
    private final GridLayout gridLayoutPanelItemTeacher = new GridLayout(4, 0, 2, 5);
    private final GridLayout gridLayoutPanelItemFinancial = new GridLayout(2, 0, 5, 5);
    private final GridLayout gridLayoutPanelItemTraining = new GridLayout(3, 0, 5, 5);
    private final CardLayout cardLayout = new CardLayout();
    private final JSplitPane splitPane = new JSplitPane();
    private final JSplitPane splitPanePnLeft = new JSplitPane();

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

    private JButton[] itemCourses = {new JButton("Admissions and Class arrangement"), new JButton("List of courses")};
    private JButton[] itemGrades = {new JButton("List of grades"), new JButton("Grade division"), new JButton("Storage of reserved students")};
    private JButton[] itemStudents = {new JButton("List of students"), new JButton("Study results"), new JButton("List of students warned, reminded")};
    private JButton[] itemTeachers = {new JButton("List of teachers"), new JButton("Recruitment lecturers"), new JButton("Assess, reward and discipline lecturers"), new JButton("Salary")};
    private JButton[] itemFinancials = {new JButton("Student tuition management"), new JButton("Central management of revenue and expenditure")};
    private JButton[] itemTrainings = {new JButton("Plan for the new courses"), new JButton("Arrange lecturers, classrooms, class schedule"), new JButton("Detailed plan for each course")};

    private boolean statusBtCourse = false;
    private boolean statusBtGrade = false;
    private boolean statusBtStudent = false;
    private boolean statusBtTeacher = false;
    private boolean statusBtFinancial = false;
    private boolean statusBtTraining = false;

    private Map< JPanel, JButton> homepageMap = new HashMap<>();
    private Map< JPanel, JButton> courseMap = new HashMap<>();
    private Map< JPanel, JButton> gradeMap = new HashMap<>();
    private Map< JPanel, JButton> studentMap = new HashMap<>();
    private Map< JPanel, JButton> teacherMap = new HashMap<>();
    private Map< JPanel, JButton> finalcialMap = new HashMap<>();
    private Map< JPanel, JButton> trainingMap = new HashMap<>();

    private final Border defaultBorder = new JButton().getBorder();
    private final Border pnLeftButtonHighLightBorder = BorderFactory.createLineBorder(new Color(0, 0, 50), 1);

    //private final Color selectedItemBackground = new Color(0, 0, 90);
    private final Color defaultBackground = new Color(0, 0, 50);
    private final Color defaultItemBackground = new Color(0, 0, 80);

    private JLabel lbAccount;
    private JLabel lbWelcome;
    private JLabel lbAdmin;

    private JButton btSetting;
    private JButton btAlarm;

    private final Font pnLeftButtonsFont = new Font("Tahoma", Font.BOLD, 18);

    public TrainingCenterFrame(String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1080, 700);
        setLocationRelativeTo(null);
        setIconImage(ImageUtils.load(getClass().getResource("/images/logo.png").getPath()));
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
        pnTop.setBackground(new Color(0, 102, 204));
        pnTop.setPreferredSize(new Dimension(0, 100));
        pnTop.setLayout(null);

        lbAccount = new JLabel(ImageUtils.loadImageIcon(getClass().getResource("/images/account.png").getPath(), 50, 50));
        lbAccount.setBounds(100, 20, 50, 50);
        pnTop.add(lbAccount);

        lbWelcome = new JLabel("Welcome");
        lbWelcome.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        lbWelcome.setForeground(Color.WHITE);
        lbWelcome.setBounds(10, 20, (int) lbWelcome.getPreferredSize().getWidth(), (int) lbWelcome.getPreferredSize().getHeight());
        pnTop.add(lbWelcome);

        lbAdmin = new JLabel("Admin");
        lbAdmin.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        lbAdmin.setForeground(Color.WHITE);
        lbAdmin.setBounds(20, 45, (int) lbAdmin.getPreferredSize().getWidth(), (int) lbAdmin.getPreferredSize().getHeight());
        pnTop.add(lbAdmin);

        btAlarm = new JButton();
        btAlarm.setBackground(Color.WHITE);
        btAlarm.setFocusPainted(false);
        btAlarm.setBounds(180, 15, 35, 35);
        btAlarm.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/alarm.png").getPath(), 30, 30));
        pnTop.add(btAlarm);

        btSetting = new JButton();
        btSetting.setBackground(Color.WHITE);
        btSetting.setFocusPainted(false);
        btSetting.setBounds(180, 60, 35, 35);
        btSetting.setIcon(ImageUtils.loadImageIcon(getClass().getResource("/images/setting.png").getPath(), 30, 30));
        pnTop.add(btSetting);

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

        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(new Color(0, 102, 153));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
    }

    private void initPnLeftComponentsDefault() {
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

        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(new Color(0, 102, 153));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
    }

    private void createItemPanel(JPanel panel, JButton... buttons) {

        panel.setBackground(defaultBackground);
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
        pnCenter.add(pnCourse, btCourse.getText());
        pnCenter.add(pnGrade, btGrade.getText());
        pnCenter.add(pnStudent, btStudent.getText());
        pnCenter.add(pnTeacher, btTeacher.getText());
        pnCenter.add(pnFinancial, btFinancial.getText());
        pnCenter.add(pnTraining, btTraining.getText());

        splitPane.add(splitPanePnLeft, JSplitPane.LEFT);
        splitPane.add(pnCenter, JSplitPane.RIGHT);
        container.add(splitPane, BorderLayout.CENTER);

    }

    private void initEvents() {
        pnLeftTopButtonsEvents();
        btSettingEvents();

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

                        //display and hint item of panelHomepage
                        if (btHomePage.getText().equalsIgnoreCase(button.getText())) {
                            initPnLeftComponentsDefault();
                            initEvents();
                        }
                        //display and hint item of panelCourse
                        if (btCourse.getText().equalsIgnoreCase(button.getText())) {
                            if (!statusBtCourse) {
                                System.out.println("Show");
                                gridLayoutPanelItemCourse.setRows(3);
                                disableBackgroundButtons(btCourse);
                                initPnLeftComponentsSelectedBtCourse();
                                Component[] components = pnItemCourse.getComponents();
                                for (Component component : components) {
                                    final JButton btItemPnCourse = (JButton) component;
                                    btItemPnCourse.addMouseListener(new MouseAdapter() {
                                        @Override
                                        public void mousePressed(MouseEvent e) {
                                            if (btItemPnCourse.getText().equalsIgnoreCase(itemCourses[0].getText())) {
                                                System.out.println("Tuyen sinh va xep lop");
                                                EnrollmentGradePlacementPanel enrollmentGradePlacementPanel = new EnrollmentGradePlacementPanel();
                                                pnCenter.add(enrollmentGradePlacementPanel);
                                                enrollmentGradePlacementPanel.setVisible(true);
                                            }
                                        }
                                    });
                                }
                                initEvents();
                                statusBtCourse = !statusBtCourse;
                            } else {

                                initPnLeftComponentsDefault();
                                initEvents();
                                System.out.println("Hint");
                                statusBtCourse = !statusBtCourse;
                            }
                        }
                        //display and hint item of panelGrade
                        if (btGrade.getText().equalsIgnoreCase(button.getText())) {
                            if (!statusBtGrade) {
                                initPnLeftComponentsSelectedBtGrade();
                                initEvents();
                                statusBtGrade = !statusBtGrade;
                            } else {
                                initPnLeftComponentsDefault();
                                initEvents();
                                statusBtGrade = !statusBtGrade;
                            }
                        }
                        //display and hint item of panelStudent
                        if (btStudent.getText().equalsIgnoreCase(button.getText())) {
                            if (!statusBtStudent) {
                                initPnLeftComponentsSelectedBtStudent();
                                initEvents();
                                statusBtStudent = !statusBtStudent;
                            } else {
                                initPnLeftComponentsDefault();
                                initEvents();
                                statusBtStudent = !statusBtStudent;
                            }
                        }
                        //display and hint item of panelTeacher
                        if (btTeacher.getText().equalsIgnoreCase(button.getText())) {
                            if (!statusBtTeacher) {
                                initPnLeftComponentsSelectedBtTeacher();
                                initEvents();
                                statusBtTeacher = !statusBtTeacher;
                            } else {
                                initPnLeftComponentsDefault();
                                initEvents();
                                statusBtTeacher = !statusBtTeacher;
                            }
                        }

                        //display and hint item of panelFinancial
                        if (btFinancial.getText().equalsIgnoreCase(button.getText())) {
                            if (!statusBtFinancial) {
                                System.out.println("Show");
                                gridLayoutPanelItemFinancial.setRows(3);
                                initPnLeftComponentsSelectedBtFinancial();
                                initEvents();
                                statusBtFinancial = !statusBtFinancial;
                            } else {
                                initPnLeftComponentsDefault();
                                initEvents();
                                System.out.println("Hint");
                                statusBtFinancial = !statusBtFinancial;
                            }
                        }
                        //display and hint item of panelTraining
                        if (btTraining.getText().equalsIgnoreCase(button.getText())) {
                            if (!statusBtTraining) {
                                System.out.println("Show" + button.getText());
                                initPnLeftComponentsSelectedBtTraining();
                                initEvents();
                                statusBtTraining = !statusBtTraining;
                            } else {

                                initPnLeftComponentsDefault();
                                initEvents();
                                System.out.println("Hint");
                                statusBtTraining = !statusBtTraining;
                            }
                        }
                    }
                });
            }
        }
    }

    private void disableHighLightButtons(Component... components) {
        for (Component component : components) {
            if (component instanceof JButton) {
                final JButton button = (JButton) component;
                button.setBorder(defaultBorder);
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
                JFrame settingFrame = new SettingFrame();
                settingFrame.setLocation(btSetting.getLocationOnScreen().getLocation());
                settingFrame.setVisible(true);
            }

        });
    }

    public static void main(String[] args) {
        TrainingCenterFrame eblm = new TrainingCenterFrame("Programming Training Center UI/UX");
        eblm.setVisible(true);
    }
}
