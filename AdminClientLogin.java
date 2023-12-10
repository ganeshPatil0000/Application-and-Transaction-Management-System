import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminClientLogin extends JFrame
{
    JButton adminLogin,ClientLogin;
    Font font = new Font("Verdana",Font.BOLD,25);

    JLabel Title;
    AdminClientLogin()
    {
        setTitle("Admin Client Login");
        setLocation(150, 30);
        getContentPane().setBackground(new Color(255, 204, 229));
        ImageIcon i2 = new ImageIcon("D:\\JAVA PROJECT\\CreditCardApprovalSystemProject\\src\\icons\\logo.png");
        setIconImage(i2.getImage());


        Title =new JLabel("Welcome to Login Page");
        Title.setBounds(500,50,500,50);
        Title.setFont(font);
        add(Title);


        adminLogin=new JButton("Admin Login");
        JLabel img1 = new JLabel();
        img1.setIcon(new ImageIcon("D:\\JAVA PROJECT\\CreditCardApprovalSystemProject\\src\\icons\\Teacher.png"));
        img1.setBounds(450, 180, 200, 100);
        add(img1);

        adminLogin.setBounds(430,320,150,40);
        add(adminLogin);



        ClientLogin = new JButton("Client Login");
        JLabel img2 = new JLabel();
        img2.setIcon(new ImageIcon("D:\\JAVA PROJECT\\CreditCardApprovalSystemProject\\src\\icons\\Teacher.png"));
        img2.setBounds(750, 180, 200, 100);
        add(img2);

        ClientLogin.setBounds(730,320,150,40);
        add(ClientLogin);

        adminLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminLogin();
            }
        });

        ClientLogin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientLogin();
            }
        });

        setLayout(null);
        setVisible(true);
        setSize(1300, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        AdminClientLogin a1 = new AdminClientLogin();
    }
}
