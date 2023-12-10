import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionPage extends JFrame
{
    Font fo = new Font("Times New Roman", Font.ITALIC, 50);

    Font fo2 = new Font("Times New Roman", Font.PLAIN, 23);
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
    JLabel label =new JLabel(i1);
    InstructionPage()
    {

        setTitle("Instruction Page");
        setLocation(150, 30);
        getContentPane().setBackground(new Color(255, 204, 229));
        ImageIcon i2 = new ImageIcon("D:\\JAVA PROJECT\\CreditCardApprovalSystemProject\\src\\icons\\logo.png");
        setIconImage(i2.getImage());


        JLabel wl = new JLabel("Welcome ");
        wl.setBounds(580, 10, 300, 50);
        wl.setFont(fo);
        add(wl);

        JLabel inst = new JLabel("");
        inst.setText(
                "<html>" +
                        "       1. The age of the client must be 18+." +"<br>"+"<br>"+
                        "       2. The client must enter a valid PAN card number." + "<br>"+"<br>" +
                        "       3. The monthly Income of the client must be greater than 40000." + "<br>"+ "<br>" +
                        "       4. Make sure you clicked on submit button to successfully complete the Application process." + "<br>"+"<br>"+
                        "       5. Once your application details are approved by the client then you are eligible for making transaction." + "<br>"+"<br>" +
                        "       6. Enter only valid details while filling the application form."+"</html>"
        );
        inst.setFont(fo2);
        inst.setBounds(20, 55, 950, 450);
        add(inst);

        JButton next = new JButton("Next");
        next.setFont(fo2);
        next.setBackground(new Color(128,0,128));
        next.setForeground(Color.WHITE);
        next.setBounds(850, 500, 80, 25);
        add(next);

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientSignUp();
                dispose();
            }
        });

        setLayout(null);
        setSize(1300,700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new InstructionPage();
    }
}
