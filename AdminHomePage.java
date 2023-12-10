import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminHomePage extends JFrame
{

    JTabbedPane tabbedPane;
    JPanel p1,p2, p3,sidePanel;
    Font font = new Font("Verdana",Font.BOLD,25);

    JButton Jbpending, Jbapproved, Jbrejected, Jbproceed;
    JLabel JluserId,title1;

    JRadioButton Jrapprove, Jrrejected;
    JTextField JtClientId;
    Integer clientid;

    String status;
    AdminHomePage() throws SQLException, ClassNotFoundException {
        setTitle("Admin Home Page");
        setLocation(150, 30);

        ImageIcon i2 = new ImageIcon("D:\\JAVA PROJECT\\CreditCardApprovalSystemProject\\src\\icons\\logo.png");
        setIconImage(i2.getImage());

        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(255, 204, 229));

        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(255, 204, 229));

        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(new Color(238, 232, 170));

        sidePanel = new JPanel();
        sidePanel.setLayout(null);
        sidePanel.setBackground(Color.CYAN);
        sidePanel.setBounds(0, 0, 300, 700);
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(sidePanel);

        JLabel img1 = new JLabel();
        img1.setIcon(new ImageIcon("D:\\JAVA PROJECT\\CreditCardApprovalSystemProject\\src\\icons\\Teacher.png"));
        img1.setBounds(80, 50, 200, 100);
        sidePanel.add(img1);

        title1 = new JLabel("Welcome Admin");
        title1.setFont(font);
        title1.setBounds(30,150,250,100);
        sidePanel.add(title1);

        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(300, 0, 1000, 700);
        tabbedPane.add("Pending status", p1);
        tabbedPane.add("Approved status", p2);
        tabbedPane.add("Rejected status", p3);
        add(tabbedPane);

        Jbpending = new JButton("Pending");
        Jbpending.setBounds(430, 30, 160, 40);
        p1.add(Jbpending);

        Jbapproved = new JButton("Approved");
        Jbapproved.setBounds(430, 30, 150, 40);
        p2.add(Jbapproved);

        Jbrejected = new JButton("Rejected");
        Jbrejected.setBounds(430, 30, 150, 40);
        p3.add(Jbrejected);


        JluserId = new JLabel("Client ID:");
        JluserId .setBounds(10,400,80,30);
        p1.add(JluserId );

        JtClientId = new JTextField();
        JtClientId.setBounds(100,400,60,30);
        p1.add(JtClientId);

        Jrapprove=new JRadioButton("Approve");
        Jrapprove.setBounds(180,400,80,30);
        p1.add(Jrapprove);

        Jrrejected=new JRadioButton("Reject");
        Jrrejected.setBounds(280,400,80,30);
        p1.add(Jrrejected);

        Jbproceed = new JButton("Proceed");
        Jbproceed.setBounds(400,400,100,30);
        p1.add(Jbproceed);

        ButtonGroup b1 =new ButtonGroup();
        b1.add(Jrapprove);
        b1.add(Jrrejected);

        Jbpending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardapprovalsystem", "Java", "Pass@123");
                    String[][] rowData={{"User ID","Name","Gender", "DOB", "Email", "PAN", "CITY", "State","Income"}};
                    String[] ColName={"User ID","Name","Gender", "DOB", "Email", "PAN", "CITY", "State","Income"};
                    final DefaultTableModel model=new DefaultTableModel(rowData,ColName);
                    final JTable table=new JTable(model);
                    table.setBounds(10,100,680,300);
                    table.setRowHeight(20);
                    table.getColumnModel().getColumn(0).setPreferredWidth(60);
                    table.getColumnModel().getColumn(1).setPreferredWidth(60);
                    table.getColumnModel().getColumn(2).setPreferredWidth(60);
                    table.getColumnModel().getColumn(3).setPreferredWidth(60);
                    table.getColumnModel().getColumn(4).setPreferredWidth(60);
                    table.getColumnModel().getColumn(5).setPreferredWidth(60);
                    table.getColumnModel().getColumn(6).setPreferredWidth(60);
                    table.getColumnModel().getColumn(7).setPreferredWidth(60);
                    table.setOpaque(true);
                    JTableHeader header1 = table.getTableHeader();
                    header1.setOpaque(true);
                    header1.setBackground(Color.gray);
                    table.setBorder((BorderFactory.createLineBorder(Color.BLACK,1)));
                    ScrollPane s = new ScrollPane();
                    s.setBounds(32,100,900,200);
                    s.add(table);
                    p1.add(s);

                    PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from UserInfo where status = 'pending'");
                    ResultSet r = pst.executeQuery();

                    while (r.next())
                    {
                        String  UserID = String.valueOf(r.getInt("UserID"));
                        String Name =r.getString("Name");
                        String Gender = r.getString("Gender");
                        String DOB = r.getString("DOB");
                        String Email = r.getString("Email");
                        String pan_number = r.getString("pan_number");
                        String City = r.getString("City");
                        String State = r.getString("State");
                        String Income = String.valueOf(r.getInt("Income"));
                        String tbData[]={UserID,Name , Gender, DOB, Email, pan_number, City, State, Income};
                        model.addRow(tbData);
                    }

                }catch (Exception d)
                {
                    System.out.println(d);
                }
            }
        });

        Jbapproved.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardapprovalsystem", "Java", "Pass@123");
                    String[][] rowData={{"User ID","Name","Gender", "DOB", "Email", "PAN", "CITY", "State","Income"}};
                    String[] ColName={"User ID","Name","Gender", "DOB", "Email", "PAN", "CITY", "State","Income"};
                    final DefaultTableModel model=new DefaultTableModel(rowData,ColName);
                    final JTable table=new JTable(model);
                    table.setBounds(10,100,680,300);
                    table.setRowHeight(20);
                    table.getColumnModel().getColumn(0).setPreferredWidth(60);
                    table.getColumnModel().getColumn(1).setPreferredWidth(60);
                    table.getColumnModel().getColumn(2).setPreferredWidth(60);
                    table.getColumnModel().getColumn(3).setPreferredWidth(60);
                    table.getColumnModel().getColumn(4).setPreferredWidth(60);
                    table.getColumnModel().getColumn(5).setPreferredWidth(60);
                    table.getColumnModel().getColumn(6).setPreferredWidth(60);
                    table.getColumnModel().getColumn(7).setPreferredWidth(60);
                    table.setOpaque(true);
                    JTableHeader header1 = table.getTableHeader();
                    header1.setOpaque(true);
                    header1.setBackground(Color.gray);
                    table.setBorder((BorderFactory.createLineBorder(Color.BLACK,1)));
                    ScrollPane s = new ScrollPane();
                    s.setBounds(32,100,900,200);
                    s.add(table);
                    p2.add(s);

                    PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from UserInfo where status = 'approved'");
                    ResultSet r = pst.executeQuery();

                    while (r.next())
                    {
                        String  UserID = String.valueOf(r.getInt("UserID"));
                        String Name =r.getString("Name");
                        String Gender = r.getString("Gender");
                        String DOB = r.getString("DOB");
                        String Email = r.getString("Email");
                        String pan_number = r.getString("pan_number");
                        String City = r.getString("City");
                        String State = r.getString("State");
                        String Income = String.valueOf(r.getInt("Income"));
                        String tbData[]={UserID,Name , Gender, DOB, Email, pan_number, City, State, Income};
                        model.addRow(tbData);
                    }
                }catch (Exception d)
                {
                    System.out.println(d);
                }
            }
        });


        Jbrejected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardapprovalsystem", "Java", "Pass@123");
                    String[][] rowData={{"User ID","Name","Gender", "DOB", "Email", "PAN", "CITY", "State","Income"}};
                    String[] ColName={"User ID","Name","Gender", "DOB", "Email", "PAN", "CITY", "State","Income"};
                    final DefaultTableModel model=new DefaultTableModel(rowData,ColName);
                    final JTable table=new JTable(model);
                    table.setBounds(10,100,680,300);
                    table.setRowHeight(20);
                    table.getColumnModel().getColumn(0).setPreferredWidth(80);
                    table.getColumnModel().getColumn(1).setPreferredWidth(80);
                    table.getColumnModel().getColumn(2).setPreferredWidth(80);
                    table.getColumnModel().getColumn(3).setPreferredWidth(80);
                    table.getColumnModel().getColumn(4).setPreferredWidth(80);
                    table.getColumnModel().getColumn(5).setPreferredWidth(80);
                    table.getColumnModel().getColumn(6).setPreferredWidth(80);
                    table.getColumnModel().getColumn(7).setPreferredWidth(80);
                    table.setOpaque(true);
                    JTableHeader header1 = table.getTableHeader();
                    header1.setOpaque(true);
                    header1.setBackground(Color.gray);
                    table.setBorder((BorderFactory.createLineBorder(Color.BLACK,1)));
                    ScrollPane s = new ScrollPane();
                    s.setBounds(32,100,900,200);
                    s.add(table);
                    p3.add(s);

                    PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from UserInfo where status = 'rejected'");
                    ResultSet r = pst.executeQuery();

                    while (r.next())
                    {
                        String  UserID = String.valueOf(r.getInt("UserID"));
                        String Name =r.getString("Name");
                        String Gender = r.getString("Gender");
                        String DOB = r.getString("DOB");
                        String Email = r.getString("Email");
                        String pan_number = r.getString("pan_number");
                        String City = r.getString("City");
                        String State = r.getString("State");
                        String Income = String.valueOf(r.getInt("Income"));
                        String tbData[]={UserID,Name , Gender, DOB, Email, pan_number, City, State, Income};
                        model.addRow(tbData);
                    }
                }catch (Exception d)
                {
                    System.out.println(d);
                }
            }
        });

        Jbproceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                clientid = Integer.valueOf(JtClientId.getText());

                if (Jrapprove.isSelected())
                    status = "approved";
                else
                    status = "rejected";


                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardapprovalsystem", "Java", "Pass@123");

                    PreparedStatement pstmt = conn.prepareStatement(
                            "UPDATE UserInfo SET  status=? where userid = " + clientid +"");

                    pstmt.setString(1, status);

                    int rowsAffected = pstmt.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(AdminHomePage.this, "Data updated successfully.");
                        JtClientId.setText("");
                    } else {
                        JOptionPane.showMessageDialog(AdminHomePage.this, "Failed to update data.");
                    }

                    conn.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(AdminHomePage.this, "Error updating data. Check the console for details.");
                }

            }
        });



        setLayout(null);
        setVisible(true);
        setSize(1300, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AdminHomePage h1 = new AdminHomePage();
    }
}
