import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class ClientSignUp extends JFrame
{
    JLabel Title, UserName,Password,Page1,Name,Gender,DOB,Email,PanNumber,City, Income,State;
    JTextField jtUserName,jtName,jtEmail,jtIncome,jtCity,jtPanNumber,jtState;
    JPasswordField password;
    JRadioButton Male,Female,Other;
    JComboBox day,month,year;

    JButton Submit,Update,Close;
    Font font = new Font("Verdana",Font.BOLD,30);

    Font font_label = new Font("Times New Roman",Font.BOLD,25);

    Font font_label11 = new Font("Times New Roman",Font.BOLD,15);

    Font font_label1 = new Font("Times New Roman",Font.BOLD,20);


    ClientSignUp()
    {
        setTitle("Sign Up Page");
        setLocation(100, 30);
        getContentPane().setBackground(new Color(255, 204, 229));


        ImageIcon i2 = new ImageIcon("D:\\JAVA PROJECT\\CreditCardApprovalSystemProject\\src\\icons\\logo.png");
        setIconImage(i2.getImage());

        Title = new JLabel("APPLICATION FORM");
        Title.setFont(font);
        Title.setBounds(480,5,500,50);
        add(Title);



        Page1 = new JLabel("Page 1: Personal Details ");
        Page1.setFont(font_label);
        Page1.setBounds(520,45,400,40);
        add(Page1);

        UserName = new JLabel("UserName");
        UserName.setFont(font_label1);
        UserName.setBounds(450,100,120,30);
        add(UserName);

        jtUserName = new JTextField();
        jtUserName.setBounds(650,100,300,30);
        add(jtUserName);

        Password = new JLabel("Password");
        Password.setFont(font_label1);
        Password.setBounds(450,150,120,30);
        add(Password);

        password = new JPasswordField();
        password.setBounds(650,150,300,30);
        add(password);

        Name = new JLabel("Name");
        Name.setFont(font_label1);
        Name.setBounds(450,200,120,30);
        add(Name);

        jtName = new JTextField();
        jtName.setBounds(650,200,300,30);
        add(jtName);

        Gender = new JLabel("Gender");
        Gender.setFont(font_label1);
        Gender.setBounds(450,250,120,30);
        add(Gender);

        Male=new JRadioButton("Male");
        Male.setFont(font_label11);
        Male.setBounds(650,250,80,30);
        add(Male);

        Female=new JRadioButton("Female");
        Female.setBounds(740,250,80,30);
        Female.setFont(font_label11);
        add(Female);

        Other=new JRadioButton("Other");
        Other.setBounds(830,250,80,30);
        Other.setFont(font_label11);
        add(Other);

        ButtonGroup b1 =new ButtonGroup();
        b1.add(Male);
        b1.add(Female);
        b1.add(Other);

        DOB = new JLabel("Date of Birth");
        DOB.setFont(font_label1);
        DOB.setBounds(450,300,120,30);
        add(DOB);

        String days[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String months[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String years[]={"2023","2022","2021","2020","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000","1999","1998","1997","1996","1995","1994","1993","1992","1991","1990"};


        day=new JComboBox(days);
        month=new JComboBox(months);
        year=new JComboBox(years);


        day.setBounds(650,300,90,30);
        month.setBounds(750,300,90,30);
        year.setBounds(850,300,90,30);

        add(day);
        add(month);
        add(year);

        Email = new JLabel("Email");
        Email.setFont(font_label1);
        Email.setBounds(450,350,120,30);
        add(Email);

        jtEmail = new JTextField();
        jtEmail.setBounds(650,350,300,30);
        add(jtEmail);

        PanNumber = new JLabel("PAN Number");
        PanNumber.setBounds(450,400,120,30);
        PanNumber.setFont(font_label1);
        setFont(font_label);
        add(PanNumber);

        jtPanNumber = new JTextField();
        jtPanNumber.setBounds(650,400,300,30);
        add(jtPanNumber);

        City = new JLabel("City");
        City.setFont(font_label1);
        City.setBounds(450,450,120,30);
        add(City);

        jtCity = new JTextField();
        jtCity.setBounds(650,450,300,30);
        add(jtCity);


        Income = new JLabel("Income");
        Income.setFont(font_label1);
        Income.setBounds(450,500,120,30);
        add(Income);

        jtIncome = new JTextField();
        jtIncome.setBounds(650,500,300,30);
        add(jtIncome);

        State = new JLabel("State");
        State.setFont(font_label1);
        State.setBounds(450,550,120,30);
        add(State);

        jtState = new JTextField();
        jtState.setBounds(650,550,300,30);
        add(jtState);


        Close = new JButton("Close");
        Close.setBounds(650,600,100,40);
        Close.setFont(font_label1);
        add(Close);


        Submit = new JButton("Submit");
        Submit.setFont(font_label1);
        Submit.setBounds(760,600,100,40);
        add(Submit);

        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtUserName.getText().isEmpty() || new String(password.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(ClientSignUp.this, "Please enter both username and password");
                } else if (jtName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(ClientSignUp.this, "Please enter your Name");
                } else if (jtUserName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(ClientSignUp.this, "Please enter your Username");
                } else if (new String(password.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(ClientSignUp.this, "Please enter your Password");
                } else if (jtEmail.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(ClientSignUp.this, "Please enter your Email");
                } else if (jtPanNumber.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(ClientSignUp.this, "Please enter your PAN Number");
                } else if (jtCity.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(ClientSignUp.this, "Please enter your City");
                } else if (jtIncome.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(ClientSignUp.this, "Please enter your Income");
                } else if (jtState.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(ClientSignUp.this, "Please enter your State");
                } else {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/creditcardapprovalsystem", "Java", "Pass@123");

                        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO UserInfo (UserName, Password, Name, Gender, DOB, Email, pan_number, City, Income, State, Date, Time) VALUES(?,?,?,?,?,?,?,?,?,?,NOW(),NOW())");

                        pstmt.setString(1, jtUserName.getText());
                        pstmt.setString(2, new String(password.getPassword()));
                        pstmt.setString(3, jtName.getText());
                        pstmt.setString(4, Male.isSelected() ? "Male" : (Female.isSelected() ? "Female" : "Other"));
                        pstmt.setString(5, day.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem());
                        pstmt.setString(6, jtEmail.getText());
                        pstmt.setString(7, jtPanNumber.getText());
                        pstmt.setString(8, jtCity.getText());
                        pstmt.setString(9, jtIncome.getText());
                        pstmt.setString(10, jtState.getText());



                        int rowsAffected = pstmt.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(ClientSignUp.this, "Data submitted successfully.");
                            new ClientLogin();
                        } else {
                            JOptionPane.showMessageDialog(ClientSignUp.this, "Failed to submit data.");
                        }

                        // Optionally close the connection
                        conn.close();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(ClientSignUp.this, "Error submitting data. Check the console for details.");
                    }
                }
            }
        });

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
//                        conn.close();
//                    } catch (Exception e1) {
//                        e1.printStackTrace();
//                        JOptionPane.showMessageDialog(SignUp.this, "Error updating data. Check the console for details.");
//                    }
//                }
//            }
//        });


        setLayout(null);
        setSize(1300,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public static void main(String[] args) {
        new ClientSignUp();
    }
}
