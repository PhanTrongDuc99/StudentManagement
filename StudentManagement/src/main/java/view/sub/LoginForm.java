/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.sub;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import service.AdminService;
import service.AdminServiceImpl;
import utils.ImageUtils;
import view.TrainingCenterFrame;

/**
 *
 * @author SMILE ^^
 */
public class LoginForm extends JFrame {

    private static final String APP_TITLE = "LOGIN FORM";
    private static final int APP_WIDTH = 850;
    private static final int APP_HEIGHT = 540;
    private static final String PATH_IMAGE_BG = "/images/LoginBg.PNG";

    private final Container container = getContentPane();
    private JLabel lbBg;

    private JLabel lbLogin;

    private JLabel lbAccount;

    private JLabel lbUsername;

    private JLabel lbPassword;

    private JTextField tfUsername;

    private JPasswordField tfPassword;

    private JButton btLogin;

    private final TrainingCenterFrame trainingCenterFrame = new TrainingCenterFrame("Programming Training Center UI/UX");

    public LoginForm(String title) {
        super(title);
        initComponents();
        initEvents();
    }

    public static void main(String[] args) {
        LoginForm ex02 = new LoginForm(APP_TITLE);
        ex02.setVisible(true);

    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(APP_WIDTH, APP_HEIGHT);
        setIconImage(ImageUtils.load(getClass().getResource("/images/logo.png").getPath()));
        setLocationRelativeTo(null);
        setResizable(false);

        lbBg = new JLabel(ImageUtils.loadImageIcon(getClass().getResource(PATH_IMAGE_BG).getPath(), 850, 540));
        container.add(lbBg);

        lbLogin = new JLabel("PROGRAMMING TRAINING CENTER");
        lbLogin.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        lbLogin.setForeground(Color.WHITE);
        lbLogin.setBounds(20, 50, (int) lbLogin.getPreferredSize().getWidth(), (int) lbLogin.getPreferredSize().getHeight());
        lbBg.add(lbLogin);

        lbAccount = new JLabel(ImageUtils.loadImageIcon(getClass().getResource("/images/account.png").getPath(), 100, 100));
        lbAccount.setForeground(Color.WHITE);
        lbAccount.setBounds(180, 120, 100, 100);
        lbBg.add(lbAccount);

        lbUsername = new JLabel("Username: ");
        lbUsername.setForeground(Color.WHITE);
        lbUsername.setBounds(20, 255, (int) lbUsername.getPreferredSize().getWidth(), (int) lbUsername.getPreferredSize().getHeight());
        lbBg.add(lbUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(100, 250, 250, 35);
        focusOnTextField();
        tfUsername.grabFocus();
        tfUsername.requestFocusInWindow();
        lbBg.add(tfUsername);

        lbPassword = new JLabel("Password: ");
        lbPassword.setForeground(Color.WHITE);
        lbPassword.setBounds(20, 325, (int) lbPassword.getPreferredSize().getWidth(), (int) lbPassword.getPreferredSize().getHeight());
        lbBg.add(lbPassword);

        tfPassword = new JPasswordField();
        tfPassword.setBounds(100, 320, 250, 35);
        lbBg.add(tfPassword);

        btLogin = new JButton("Login");
        btLogin.setFocusPainted(false);
        btLogin.setForeground(Color.BLUE);
        btLogin.setBackground(Color.LIGHT_GRAY);
        btLogin.setBounds(100, 400, 250, 35);
        lbBg.add(btLogin);
    }

    private void initEvents() {
        btLoginEvents();

    }

    private void btLoginEvents() {
        btLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (checkInput()) {
                    if (checkAdmin()) {
                        JOptionPane.showMessageDialog(null, "Login successful!");
                        setVisible(false);
                        trainingCenterFrame.setVisible(true);
                    } else {
                        System.out.println(tfPassword.getText());
                        JOptionPane.showMessageDialog(null, "Incorrect login username or password!\nPlease input again!");
                        tfUsername.requestFocusInWindow();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please complete all information!");
                    tfUsername.requestFocusInWindow();
                }
            }
        });
    }

    private boolean checkInput() {
        return !(tfUsername.getText().isEmpty() || tfPassword.getText().isEmpty());
    }

    private boolean checkAdmin() {
        AdminService adminService = new AdminServiceImpl();
        return adminService.getAdmin(tfUsername.getText(), tfPassword.getText()) != null;
    }

    private void focusOnTextField() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                tfUsername.requestFocus();
            }
        });
    }
}
