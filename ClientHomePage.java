import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ClientHomePage extends JFrame
{

    JTabbedPane tabbedPane;
    JPanel p1,p2, p3,p4,p5,sidePanel;
    JButton b1,b2,b3,b4, JbTransaction;
    Font fo = new Font("Times New Roman", Font.PLAIN, 25);
    Font fo1 = new Font("Times New Roman", Font.BOLD, 18);

    Font fo2 = new Font("SansSerif", Font.PLAIN, 25);
    Font fo3 = new Font("Arial", Font.PLAIN, 25);
    // or
    Font fo4 = new Font("Tahoma", Font.BOLD, 25);
    // or
    Font fo5 = new Font("Helvetica", Font.BOLD, 25);



    JLabel userID,name,gender,email,city,state, JlTransAmount, JlPlace;

    JLabel jluserID,jlname,jlGender,jlEmail,jlCity,jlState,jlStatus;
    JTextField JtTransAmount, JtPlace;
    JButton Update;
    public static int cid;
    String uname,ugender,uemail,ucity,ustate, ustatus;
    int ucid;
    ClientHomePage(int id) {
        setTitle("Client Home Page");
        setLocation(100, 30);

        ImageIcon i2 = new ImageIcon("D:\\JAVA PROJECT\\CreditCardApprovalSystemProject\\src\\icons\\logo.png");
        setIconImage(i2.getImage());

        System.out.println(id);
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(255, 204, 229));

        p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(255, 204, 229));

        p3 = new JPanel();
        p3.setLayout(null);
        p3.setBackground(new Color(238, 232, 170));

        p4 = new JPanel();
        p4.setLayout(null);
        p4.setBackground(new Color(238, 232, 170));

        p5 = new JPanel();
        p5.setLayout(null);
        p5.setBackground(new Color(238, 232, 170));

        sidePanel = new JPanel();
        sidePanel.setLayout(null);
        sidePanel.setBackground(Color.CYAN);
        sidePanel.setBounds(0, 0, 400, 700);
        sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        add(sidePanel);


        userID = new JLabel("User ID : ");
        userID.setBounds(100, 200, 150, 40);
        userID.setFont(fo3);
        sidePanel.add(userID);

        jluserID = new JLabel(Integer.toString(id));
        jluserID.setBounds(220, 197, 100, 40);
        jluserID.setFont(fo2);
        sidePanel.add(jluserID);

        JLabel img = new JLabel();
        img.setIcon(new ImageIcon("D:\\JAVA PROJECT\\CreditCardApprovalSystemProject\\src\\icons\\Teacher.png"));
        img.setBounds(380, 50, 200, 100);
        p1.add(img);

        JLabel img1 = new JLabel();
        img1.setIcon(new ImageIcon("D:\\JAVA PROJECT\\CreditCardApprovalSystemProject\\src\\icons\\Teacher.png"));
        img1.setBounds(120, 50, 200, 100);
        sidePanel.add(img1);

        name = new JLabel("Name : ");
        name.setBounds(310, 200, 150, 30);
        name.setFont(fo3);
        p1.add(name);

        jlname = new JLabel(uname);
        jlname.setBounds(440,200,300,30);
        jlname.setFont(fo2);
        p1.add(jlname);

        gender = new JLabel("Gender : ");
        gender.setBounds(310, 240, 150, 30);
        gender.setFont(fo3);
        p1.add(gender);

        jlGender =new JLabel(ugender);
        jlGender.setBounds(440,240,200,30);
        jlGender.setFont(fo2);
        p1.add(jlGender);

        email = new JLabel("Email : ");
        email.setFont(fo3);
        email.setBounds(310, 280, 150, 30);
        p1.add(email);

        jlEmail = new JLabel(uemail);
        jlEmail.setBounds(440,280,250,30);
        jlEmail.setFont(fo2);
        p1.add(jlEmail);

        city = new JLabel("City : ");
        city.setBounds(310, 320, 150, 30);
        city.setFont(fo3);
        p1.add(city);

        jlCity = new JLabel(ucity);
        jlCity.setBounds(440,320,200,30);
        jlCity.setFont(fo2);
        p1.add(jlCity);

        state = new JLabel("State : ");
        state.setFont(fo3);
        state.setBounds(310, 360, 150, 30);
        p1.add(state);

        jlState = new JLabel(ustate);
        jlState.setBounds(440,360,200,30);
        jlState.setFont(fo2);
        p1.add(jlState);

        JlTransAmount = new JLabel("Amount :");
        JlTransAmount.setBounds(240,200,200,30);
        JlTransAmount.setFont(fo2);
        p2.add(JlTransAmount);
        JlTransAmount.setVisible(false);

        JlPlace = new JLabel("Place: ");
        JlPlace.setBounds(240,250,200,30);
        JlPlace.setFont(fo2);
        p2.add(JlPlace);
        JlPlace.setVisible(false);

        JtTransAmount =new JTextField();
        JtTransAmount.setBounds(350,200,150,30);
        JtTransAmount.setFont(fo2);
        p2.add(JtTransAmount);
        JtTransAmount.setVisible(false);

        JtPlace = new JTextField();
        JtPlace.setBounds(350,250,150,30);
        JtPlace.setFont(fo2);
        p2.add(JtPlace);
        JtPlace.setVisible(false);

        JbTransaction = new JButton("Make Transaction");
        JbTransaction.setBounds(250,320,150,30);
        p2.add(JbTransaction);
        JbTransaction.setVisible(false);



//        b2 = new JButton("Transaction");
//        b2.setBounds(230, 30, 160, 40);
//        p2.add(b2);



        Update=new JButton("Update");
        Update.setBounds(300,500,100,40);
        p5.add(Update);


        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(400, 0, 900, 700);
        tabbedPane.add("Profile", p1);
        tabbedPane.add("Transaction", p2);
        tabbedPane.add("Check Status", p4);
        tabbedPane.add("History", p3);
        tabbedPane.add("Update", p5);
        add(tabbedPane);



        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardapprovalsystem", "Java", "Pass@123");
            PreparedStatement pst = con.prepareStatement("SELECT name,gender,email,city,state FROM UserInfo where userID="+(id)+"");
//            pst.setInt(1,id);
            ResultSet r = pst.executeQuery();

            if (r.next()) {
                uname = r.getString("name");
                ugender = r.getString("gender");
                uemail = r.getString("email");
                ucity = r.getString("city");
                ustate = r.getString("state");

                jlname.setText(uname);
                jlGender.setText(ugender);
                jlEmail.setText(uemail);
                jlCity.setText(ucity);
                jlState.setText(ustate);
            }

//            System.out.println("Rows affected are : "+r);

            con.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

//        Update.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (jtUserName.getText().isEmpty() || new String(password.getPassword()).isEmpty()) {
//                    JOptionPane.showMessageDialog(SignUp.this, "Please enter both username and password");
//                } else if (jtName.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(SignUp.this, "Please enter your Name");
//                } else if (jtUserName.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(SignUp.this, "Please enter your Username");
//                } else if (new String(password.getPassword()).isEmpty()) {
//                    JOptionPane.showMessageDialog(SignUp.this, "Please enter your Password");
//                } else if (jtEmail.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(SignUp.this, "Please enter your Email");
//                } else if (jtPanNumber.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(SignUp.this, "Please enter your PAN Number");
//                } else if (jtCity.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(SignUp.this, "Please enter your City");
//                } else if (jtIncome.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(SignUp.this, "Please enter your Income");
//                } else if (jtState.getText().isEmpty()) {
//                    JOptionPane.showMessageDialog(SignUp.this, "Please enter your State");
//                } else {
//                    try {
//                        Class.forName("com.mysql.cj.jdbc.Driver");
//                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardapprovalsystem", "Java", "Pass@123");
//
//                        PreparedStatement pstmt = conn.prepareStatement(
//                                "UPDATE UserInfo SET username=?, password=?, name=?, gender=?, dob=?, email=?, pan_number=?, city=?, income=?, state=? where userid=?");
//
//                        pstmt.setString(1, jtUserName.getText());
//                        pstmt.setString(2, new String(password.getPassword()));
//                        pstmt.setString(3, jtName.getText());
//                        pstmt.setString(4, Male.isSelected() ? "Male" : (Female.isSelected() ? "Female" : "Other"));
//                        pstmt.setString(5, day.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem());
//                        pstmt.setString(6, jtEmail.getText());
//                        pstmt.setString(7, jtPanNumber.getText());
//                        pstmt.setString(8, jtCity.getText());
//                        pstmt.setString(9, jtIncome.getText());
//                        pstmt.setString(10, jtState.getText());
//
//                        int rowsAffected = pstmt.executeUpdate();
//
//                        if (rowsAffected > 0) {
//                            JOptionPane.showMessageDialog(SignUp.this, "Data updated successfully.");
//                        } else {
//                            JOptionPane.showMessageDialog(SignUp.this, "Failed to update data.");
//                        }
//
//                        // Optionally close the connection
//                        conn.close();
//                    } catch (Exception e1) {
//                        e1.printStackTrace();
//                        JOptionPane.showMessageDialog(SignUp.this, "Error updating data. Check the console for details.");
//                    }
//                }
//            }
//        });



        b2 = new JButton("Transaction");
        b2.setBounds(230, 30, 160, 40);
        p2.add(b2);

        b3 = new JButton("Show History");
        b3.setBounds(230, 30, 150, 40);
        p3.add(b3);

        b4 = new JButton("Show Status");
        b4.setBounds(230, 30, 150, 40);
        p4.add(b4);


        //Transaction Working

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardapprovalsystem", "Java", "Pass@123");
                    PreparedStatement pst = con.prepareStatement("SELECT  status FROM UserInfo where userID="+(id)+"");
//            pst.setInt(1,id);

                    ResultSet r = pst.executeQuery();
                    if (r.next()) {

                        ustatus = r.getString("status");

                        if(ustatus.equals("approved"))
                        {
                            System.out.println("Yes");
                            JlPlace.setVisible(true);
                            JlTransAmount.setVisible(true);
                            JtPlace.setVisible(true);
                            JtTransAmount.setVisible(true);
                            JbTransaction.setVisible(true);
                        }
                        else
                            JOptionPane.showMessageDialog(null, "***You cant make Transaction****");
                    }
                    con.close();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardapprovalsystem", "Java", "Pass@123");
                    String[][] rowData={{"Transaction ID","Transaction Amount","Place", "Date", "Time"}};
                    String[] ColName={"Transaction ID","Transaction Amount","Place", "Date", "Time"};
                    final DefaultTableModel model=new DefaultTableModel(rowData,ColName);
                    final JTable table=new JTable(model);
                    table.setBounds(30,100,400,200);
                    table.setRowHeight(20);
                    table.getColumnModel().getColumn(0).setPreferredWidth(60);
                    table.getColumnModel().getColumn(1).setPreferredWidth(60);
                    table.getColumnModel().getColumn(3).setPreferredWidth(60);
                    table.getColumnModel().getColumn(4).setPreferredWidth(60);
                    table.setOpaque(true);
                    JTableHeader header1 = table.getTableHeader();
                    header1.setOpaque(true);
                    header1.setBackground(Color.gray);
                    table.setBorder((BorderFactory.createLineBorder(Color.BLACK,1)));
                    ScrollPane s = new ScrollPane();
                    s.setBounds(50,100,800,300);
                    s.add(table);
                    p3.add(s);

                    PreparedStatement pst= (PreparedStatement)con.prepareStatement("select * from TransactionInfo where userid = "+id+"");
                    ResultSet r = pst.executeQuery();

                    while (r.next())
                    {
                        String TransId = String.valueOf(r.getInt("TransId"));
                        String TransAmount = String.valueOf(r.getInt("TransAmount"));
                        String place = r.getString("place");
                        String Date =r.getString("Date");
                        String Time = r.getString("Time");
                        String tbData[]={TransId, TransAmount, place, Date, Time};
                        model.addRow(tbData);

                    }

                }catch (Exception d)
                {
                    System.out.println(d);
                }
            }
        });

        JbTransaction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardapprovalsystem", "Java", "Pass@123");
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO TransactionInfo (TransAmount, place, Date, Time, userid) VALUES(?,?, NOW(), NOW(), ?)");

                    pstmt.setString(1, JtTransAmount.getText());
                    pstmt.setString(2, JtPlace.getText());
                    pstmt.setString(3, String.valueOf(id));

                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(ClientHomePage.this, "***Transaction Successful***");
                        JtTransAmount.setText("");
                        JtPlace.setText("");
                    } else {
                        JOptionPane.showMessageDialog(ClientHomePage.this, "****Transaction Failed Try Again Later****");
                    }
                    conn.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(ClientHomePage.this, "****Transaction Failed Try Again Later****");
                }
            }
        });



        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardapprovalsystem", "Java", "Pass@123");
                    PreparedStatement pst = con.prepareStatement("SELECT  status FROM UserInfo where userID="+(id)+"");
                    jlStatus = new JLabel();
                    jlStatus.setBounds(230, 90, 150, 40);
                    jlStatus.setFont(fo2);
                    p4.add(jlStatus);
                    ResultSet r = pst.executeQuery();
                    if (r.next()) {

                        ustatus = r.getString("status");
                        jlStatus.setText(String.valueOf(ustatus));
                    }
                    con.close();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }
        });



        setLayout(null);
        setVisible(true);
        setSize(1300, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }



    public static void main(String[] args)
    {
        ClientHomePage h1 = new ClientHomePage(20);
    }
}
