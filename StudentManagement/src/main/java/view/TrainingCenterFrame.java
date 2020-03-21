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
    private final GridLayout gridLayout = new GridLayout(6, 0, 60, 4);
    private final GridLayout gridLayoutHomepage = new GridLayout(3, 0, 60, 4);
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

    private JButton itemHomepage01;
    private JButton itemHomepage02;
    private JButton itemHomepage03;

    private JPanel panelHomepage;
    private boolean status = false;

    private final Border defaultBorder = new JButton().getBorder();
    private final Border pnLeftButtonHighLightBorder = BorderFactory.createLineBorder(Color.WHITE, 1);
    private final Border pnLeftEmptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
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
        initPnLeftComponents();
        initPnCenterComponents();

    }

    private void initPnTopComponents() {
        pnTop = new JPanel();
        pnTop.setBackground(new Color(0, 102, 204));
        pnTop.setPreferredSize(new Dimension(0, 100));
        container.add(pnTop, BorderLayout.NORTH);
    }

    private void initPnLeftComponents() {
        pnLeftTop = new JPanel();
        pnLeftTop.setLayout(gridLayout);
        pnLeftTop.setBackground(new Color(0, 0, 51));
        pnLeftTop.setPreferredSize(new Dimension(220, 300));
        pnLeftTop.setBorder(pnLeftEmptyBorder);
        splitPanePnLeft.add(pnLeftTop, JSplitPane.TOP);

        btHomePage = new JButton();
        btHomePage.setFocusPainted(false);
        btHomePage.setFont(pnLeftButtonsFont);
        btHomePage.setText(CardKey.HOMEPAGE.name());
        btHomePage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btHomePage.setBorder(pnLeftButtonHighLightBorder);
        btHomePage.setBackground(new Color(0, 0, 51));
        btHomePage.setForeground(Color.WHITE);
        pnLeftTop.add(btHomePage);

        initPanelHomepageComponent();

        btCourse = new JButton();
        btCourse.setFocusPainted(false);
        btCourse.setFont(pnLeftButtonsFont);
        btCourse.setText(CardKey.COURSE.name());
        btCourse.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btCourse.setBackground(new Color(0, 0, 51));
        btCourse.setForeground(Color.WHITE);
        pnLeftTop.add(btCourse);

        btGrade = new JButton();
        btGrade.setFocusPainted(false);
        btGrade.setFont(pnLeftButtonsFont);
        btGrade.setText(CardKey.GRADE.name());
        btGrade.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btGrade.setBackground(new Color(0, 0, 51));
        btGrade.setForeground(Color.WHITE);
        pnLeftTop.add(btGrade);

        btStudent = new JButton();
        btStudent.setFocusPainted(false);
        btStudent.setFont(pnLeftButtonsFont);
        btStudent.setText(CardKey.STUDENT.name());
        btStudent.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btStudent.setBackground(new Color(0, 0, 51));
        btStudent.setForeground(Color.WHITE);
        pnLeftTop.add(btStudent);

        btTeacher = new JButton();
        btTeacher.setFocusPainted(false);
        btTeacher.setFont(pnLeftButtonsFont);
        btTeacher.setText(CardKey.TEACHER.name());
        btTeacher.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btTeacher.setBackground(new Color(0, 0, 51));
        btTeacher.setForeground(Color.WHITE);
        pnLeftTop.add(btTeacher);

        pnLeftBottom = new JPanel();
        pnLeftBottom.setBackground(new Color(0, 102, 153));
        splitPanePnLeft.add(pnLeftBottom, JSplitPane.BOTTOM);
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

    private void initPanelHomepageComponent() {
        panelHomepage = new JPanel();
        panelHomepage.setLayout(gridLayoutHomepage);
        panelHomepage.setBackground(new Color(0, 0, 51));
        itemHomepage01 = new JButton("ItemHomepage01");
        itemHomepage01.setFocusPainted(false);
        itemHomepage01.setFont(pnLeftButtonsFont);
        itemHomepage01.setCursor(new Cursor(Cursor.HAND_CURSOR));
        itemHomepage01.setBorder(pnLeftButtonHighLightBorder);
        itemHomepage01.setBackground(new Color(0, 0, 51));
        itemHomepage01.setForeground(Color.WHITE);

        itemHomepage02 = new JButton("ItemHomepage02");
        itemHomepage02.setFocusPainted(false);
        itemHomepage02.setFont(pnLeftButtonsFont);
        itemHomepage02.setCursor(new Cursor(Cursor.HAND_CURSOR));
        itemHomepage02.setBorder(pnLeftButtonHighLightBorder);
        itemHomepage02.setBackground(new Color(0, 0, 51));
        itemHomepage02.setForeground(Color.WHITE);

        itemHomepage03 = new JButton("ItemHomepage03");
        itemHomepage03.setFocusPainted(false);
        itemHomepage03.setFont(pnLeftButtonsFont);
        itemHomepage03.setCursor(new Cursor(Cursor.HAND_CURSOR));
        itemHomepage03.setBorder(pnLeftButtonHighLightBorder);
        itemHomepage03.setBackground(new Color(0, 0, 51));
        itemHomepage03.setForeground(Color.WHITE);

        panelHomepage.add(itemHomepage01);
        panelHomepage.add(itemHomepage02);
        panelHomepage.add(itemHomepage03);
        pnLeftTop.add(panelHomepage);
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
                        button.setBorder(pnLeftButtonHighLightBorder);
                        if ("HOMEPAGE".equalsIgnoreCase(button.getText())) {
                            if (!status) {
                                pnLeftTop.remove(panelHomepage);
                                status = !status;
                                System.out.println("Delete item");
                            } else {
                                pnLeftTop.revalidate();
                                initPnLeftComponents();
                                initEvents();
                                System.out.println("Show item");
                                status = !status;
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

    public static void main(String[] args) {
        TrainingCenterFrame eblm = new TrainingCenterFrame("Programming Training Center UI/UX");
        eblm.setVisible(true);
    }
}
