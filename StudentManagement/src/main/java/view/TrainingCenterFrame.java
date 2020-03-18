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

/**
 * private final BorderLayout borderLayout = new BorderLayout();
 *
 *
 * @author SMILE ^^
 */
public class TrainingCenterFrame extends JFrame {

    private final Container container = getContentPane();
    private final BorderLayout borderLayout = new BorderLayout();
    private final GridLayout gridLayout = new GridLayout(4, 0, 5, 5);
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

    private JButton btHomePage;
    private JButton btGrade;
    private JButton btCourse;

    private final Border defaultBorder = new JButton().getBorder();
    private final Border pnLeftButtonHighLightBorder = BorderFactory.createLineBorder(Color.RED, 5);
    private final Border pnLeftEmptyBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

    public TrainingCenterFrame(String title) {
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1080, 700);
        setLocationRelativeTo(null);
        setIconImage(ImageUtils.load("E:\\StudentManagement\\StudentManagement\\src\\main\\java\\images\\logo.png"));
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

        final Font pnLeftButtonsFont = new Font("Tahoma", Font.BOLD, 18);

        btHomePage = new JButton();
        btHomePage.setFocusPainted(false);
        btHomePage.setFont(pnLeftButtonsFont);
        btHomePage.setText(CardKey.HOMEPAGE.name());
        btHomePage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btHomePage.setBorder(pnLeftButtonHighLightBorder);
        pnLeftTop.add(btHomePage);

        btCourse = new JButton();
        btCourse.setFocusPainted(false);
        btCourse.setFont(pnLeftButtonsFont);
        btCourse.setText(CardKey.COURSE.name());
        btCourse.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnLeftTop.add(btCourse);

        btGrade = new JButton();
        btGrade.setFocusPainted(false);
        btGrade.setFont(pnLeftButtonsFont);
        btGrade.setText(CardKey.GRADE.name());
        btGrade.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pnLeftTop.add(btGrade);

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
        pnCenter.add(pnHomepage, btHomePage.getText());
        pnCenter.add(pnCourse, btCourse.getText());
        pnCenter.add(pnGrade, btGrade.getText());

        splitPane.add(splitPanePnLeft, JSplitPane.LEFT);
        splitPane.add(pnCenter, JSplitPane.RIGHT);

        container.add(splitPane, BorderLayout.CENTER);

    }

    private void initEvents() {
        pnLeftTopButtonsEvents();
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
