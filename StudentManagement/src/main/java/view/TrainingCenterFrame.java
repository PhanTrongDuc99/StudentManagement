/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import common.CardKey;
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
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import utils.ImageUtils;
import view.sub.CoursePanel;
import view.sub.GradePanel;
import view.sub.HomepagePanel;
import view.sub.StudentPanel;
import view.sub.TeacherPanel;

/**
 * private final BorderLayout borderLayout = new BorderLayout();
 *
 *
 * @author SMILE ^^
 */
public class TrainingCenterFrame extends JFrame {

    private final Container container = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();
    private final GridLayout gridLayout = new GridLayout(9, 0, 5, 5);
    private final GridLayout gridLayoutPanelItem = new GridLayout(3, 0, 5, 5);
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

    private JButton btHomePage;
    private JButton btGrade;
    private JButton btCourse;
    private JButton btStudent;
    private JButton btTeacher;

    private JPanel pnItemCourse;
    private JPanel pnItemGrade;
    private JPanel pnItemStudent;
    private JPanel pnItemTeacher;

    private JButton[] itemCourses = {new JButton("ItemCourse01"), new JButton("ItemCourse02"), new JButton("ItemCourse03")};
    private JButton[] itemGrades = {new JButton("ItemGrade01"), new JButton("ItemGrade02"), new JButton("ItemGrade03")};
    private JButton[] itemStudents = {new JButton("ItemStudent01"), new JButton("ItemStudent02"), new JButton("ItemStudent03")};
    private JButton[] itemTeachers = {new JButton("ItemTeacher01"), new JButton("ItemTeacher02"), new JButton("ItemTeacher03")};

    private boolean statusBtCourse = false;
    private boolean statusBtGrade = false;
    private boolean statusBtStudent = false;
    private boolean statusBtTeacher = false;

    private final Border defaultBorder = new JButton().getBorder();
    private final Border pnLeftButtonHighLightBorder = BorderFactory.createLineBorder(new Color(0, 0, 50), 1);

    private final Color selectedItemBackround = new Color(0, 0, 90);
    private final Color defaultBackground = new Color(0, 0, 50);

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
        container.add(pnTop, BorderLayout.NORTH);
    }

    private void initPnLeftComponentsSelectedBtCourse() {
        pnLeftTop = new JPanel();
        pnLeftTop.setLayout(gridLayout);
        pnLeftTop.setBackground(defaultBackground);
        pnLeftTop.setPreferredSize(new Dimension(220, 300));
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        btHomePage = new JButton(CardKey.HOMEPAGE.name());
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        btCourse = new JButton(CardKey.COURSE.name());
        createButton(btCourse);
        pnLeftTop.add(btCourse);
        pnItemCourse = new JPanel();
        createItemPanel(pnItemCourse, itemCourses);
        pnLeftTop.add(pnItemCourse);

        btGrade = new JButton(CardKey.GRADE.name());
        createButton(btGrade);
        pnLeftTop.add(btGrade);

        btStudent = new JButton(CardKey.STUDENT.name());
        createButton(btStudent);
        pnLeftTop.add(btStudent);

        btTeacher = new JButton(CardKey.TEACHER.name());
        createButton(btTeacher);
        pnLeftTop.add(btTeacher);

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

        btHomePage = new JButton(CardKey.HOMEPAGE.name());
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        btCourse = new JButton(CardKey.COURSE.name());
        createButton(btCourse);
        pnLeftTop.add(btCourse);

        btGrade = new JButton(CardKey.GRADE.name());
        createButton(btGrade);
        pnLeftTop.add(btGrade);
        pnItemGrade = new JPanel();
        createItemPanel(pnItemGrade, itemGrades);
        pnLeftTop.add(pnItemCourse);

        btStudent = new JButton(CardKey.STUDENT.name());
        createButton(btStudent);
        pnLeftTop.add(btStudent);

        btTeacher = new JButton(CardKey.TEACHER.name());
        createButton(btTeacher);
        pnLeftTop.add(btTeacher);

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

        btHomePage = new JButton(CardKey.HOMEPAGE.name());
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        btCourse = new JButton(CardKey.COURSE.name());
        createButton(btCourse);
        pnLeftTop.add(btCourse);

        btGrade = new JButton(CardKey.GRADE.name());
        createButton(btGrade);
        pnLeftTop.add(btGrade);

        btStudent = new JButton(CardKey.STUDENT.name());
        createButton(btStudent);
        pnLeftTop.add(btStudent);
        pnItemStudent = new JPanel();
        createItemPanel(pnItemStudent, itemStudents);
        pnLeftTop.add(pnItemStudent);

        btTeacher = new JButton(CardKey.TEACHER.name());
        createButton(btTeacher);
        pnLeftTop.add(btTeacher);

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

        btHomePage = new JButton(CardKey.HOMEPAGE.name());
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        btCourse = new JButton(CardKey.COURSE.name());
        createButton(btCourse);
        pnLeftTop.add(btCourse);

        btGrade = new JButton(CardKey.GRADE.name());
        createButton(btGrade);
        pnLeftTop.add(btGrade);

        btStudent = new JButton(CardKey.STUDENT.name());
        createButton(btStudent);
        pnLeftTop.add(btStudent);

        btTeacher = new JButton(CardKey.TEACHER.name());
        createButton(btTeacher);
        pnLeftTop.add(btTeacher);
        pnItemTeacher = new JPanel();
        createItemPanel(pnItemTeacher, itemTeachers);
        pnLeftTop.add(pnItemTeacher);

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

        btHomePage = new JButton(CardKey.HOMEPAGE.name());
        createButton(btHomePage);
        pnLeftTop.add(btHomePage);

        btCourse = new JButton(CardKey.COURSE.name());
        createButton(btCourse);
        pnLeftTop.add(btCourse);

        btGrade = new JButton(CardKey.GRADE.name());
        createButton(btGrade);
        pnLeftTop.add(btGrade);

        btStudent = new JButton(CardKey.STUDENT.name());
        createButton(btStudent);
        pnLeftTop.add(btStudent);

        btTeacher = new JButton(CardKey.TEACHER.name());
        createButton(btTeacher);
        pnLeftTop.add(btTeacher);

        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(new Color(0, 102, 153));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
    }

    private void createItemPanel(JPanel panel, JButton... buttons) {
        panel.setLayout(gridLayoutPanelItem);
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

        pnCenter.add(pnHomepage, btHomePage.getText());
        pnCenter.add(pnCourse, btCourse.getText());
        pnCenter.add(pnGrade, btGrade.getText());
        pnCenter.add(pnStudent, btStudent.getText());
        pnCenter.add(pnTeacher, btTeacher.getText());

        splitPane.add(splitPanePnLeft, JSplitPane.LEFT);
        splitPane.add(pnCenter, JSplitPane.RIGHT);
        container.add(splitPane, BorderLayout.CENTER);

    }

    private void initEvents() {
        pnLeftTopButtonsEvents();
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
            button.setBackground(defaultBackground);
            button.setForeground(Color.WHITE);
            System.out.println("Button: " + button.getText());
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
                        disableHighLightButtons(components);
                        disableBackgroundButtons(components);
                        button.setBorder(pnLeftButtonHighLightBorder);
                        button.setBackground(selectedItemBackround);

                        //display and hint item of panelHomepage
                        if (btHomePage.getText().equalsIgnoreCase(button.getText())) {
                            // return homepage
                        }
                        //display and hint item of panelCourse
                        if (btCourse.getText().equalsIgnoreCase(button.getText())) {
                            if (!statusBtCourse) {
                                System.out.println("Show");
                                initPnLeftComponentsSelectedBtCourse();
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

    public static void main(String[] args) {
        TrainingCenterFrame eblm = new TrainingCenterFrame("Programming Training Center UI/UX");
        eblm.setVisible(true);
    }
}
