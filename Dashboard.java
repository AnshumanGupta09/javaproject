/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app_pack;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author 2004d
 */
public class Dashboard extends javax.swing.JFrame {
    
    
    InputStream ips;
    String state_selected;
    String DOB = "";
    int Year_DOB = 0;
    String check_admission = "";
    String city_selected;
    PreparedStatement stm;
    Connection con;
    static ResultSet data;
    String registration = "";

    public Dashboard() {
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/college_mgt";
        String user = "root";
        String password = "0000";
        con = DriverManager.getConnection(url,user,password);
//        String q1 = "select * from data1";
//        sm = (PreparedStatement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Cannot connect to the database.\n Please ask the developer to take care of this bug.","ERROR", JOptionPane.ERROR_MESSAGE);
            //dispose();
            System.out.println(e);
            System.exit(0);
        }
        initComponents();   
        setIconImage();
        //regisLabel.setText("Registration Id = 202391" );
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    public Dashboard(String regis) 
    {
        this.registration = regis;
        
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/college_mgt";
        String user = "root";
        String password = "0000";
        con = DriverManager.getConnection(url,user,password);
        
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Cannot connect to the database.\n Please ask the developer to take care of this bug.","ERROR", JOptionPane.ERROR_MESSAGE);
            //dispose();
            System.out.println(e);
            System.exit(0);
        }
        initComponents();
        setIconImage();
        verify_admission();
        regisLabel.setText("Registration Id = " + registration);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void setIconImage() 
    {   
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("a1.png")));        
    }
    
    void verify_admission()
    {
        try
        {       
        
        String q1 = "select fillform from signup where referid = " + registration;
        stm = con.prepareStatement(q1);
        data = stm.executeQuery();
        while(data.next())
        {
            check_admission = data.getString(1);
        }
        if(check_admission.equals("false"))
        {
            tabPane.setEnabledAt(7,false);
        }
        else{
            tabPane.setEnabledAt(1,false);
            get_data();
        }
                
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error while checking admission.","ERROR", JOptionPane.ERROR_MESSAGE);
            //dispose();
            System.out.println(e);
            System.exit(0);
        }
    }
    private void get_data()
    {
        String sql = "select course , photo ,applicant_name, mom_name , dad_name , phone1, phone2, email, adhar , gender,address , pincode,city,state from student_data where regisid = " + registration;
        try{
        stm = con.prepareStatement(sql);
        data = stm.executeQuery(sql);
        byte b[] = null;

     
        while(data.next())
            {
                course_area.setText(data.getString(1));
                b= data.getBytes(2);
                ImageIcon image = new ImageIcon(b);
                Image im = image.getImage();
                Image myimg = im.getScaledInstance(photo_area.getWidth(), photo_area.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(myimg);
                photo_area.setIcon(icon);
               // photo_area.setIcon(new ImageIcon (Toolkit.getDefaultToolkit().createImage(b)));
                name_area.setText(data.getString(3));
                mom_name_area.setText(data.getString(4));
                dad_name_area.setText(data.getString(5));
                phone_area.setText(data.getString(6) + " , " + data.getString(7));
                email_area.setText(data.getString(8));
                adahr_area.setText(data.getString(9));
                gender_area.setText(data.getString(10));
                address_area.setText(data.getString(11 )+ ", "  + data.getString(13)  + " , " + data.getString(12) +" ," +   data.getString(14));

            }
        }
        catch (Exception e)
        {
            System.out.println(e);
            dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel65 = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        events = new javax.swing.JButton();
        sports = new javax.swing.JButton();
        placements = new javax.swing.JButton();
        gallery = new javax.swing.JButton();
        about = new javax.swing.JButton();
        result = new javax.swing.JButton();
        panelmain = new javax.swing.JPanel();
        tabPane = new javax.swing.JTabbedPane();
        welcome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        admissionPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addP = new javax.swing.JPanel();
        p1 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        regisLabel = new javax.swing.JLabel();
        p2 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        course = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        stuName = new javax.swing.JTextField();
        momName = new javax.swing.JTextField();
        dadName = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        phone1 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        imglabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dob = new com.toedter.calendar.JDateChooser();
        p3 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        phone2 = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        adhar = new javax.swing.JTextField();
        gender = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        state = new javax.swing.JComboBox<>();
        city = new javax.swing.JComboBox<>();
        p4 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        address1 = new javax.swing.JTextField();
        city1 = new javax.swing.JTextField();
        pin1 = new javax.swing.JTextField();
        state1 = new javax.swing.JTextField();
        address2 = new javax.swing.JTextField();
        city2 = new javax.swing.JTextField();
        pin2 = new javax.swing.JTextField();
        state2 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        submit = new javax.swing.JButton();
        p5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        grad = new javax.swing.JComboBox<>();
        rollG = new javax.swing.JTextField();
        perG = new javax.swing.JTextField();
        roll12 = new javax.swing.JTextField();
        roll10 = new javax.swing.JTextField();
        sch10 = new javax.swing.JTextField();
        sch12 = new javax.swing.JTextField();
        schG = new javax.swing.JTextField();
        om10 = new javax.swing.JTextField();
        om12 = new javax.swing.JTextField();
        omG = new javax.swing.JTextField();
        tm10 = new javax.swing.JTextField();
        tm12 = new javax.swing.JTextField();
        tmG = new javax.swing.JTextField();
        y10 = new javax.swing.JTextField();
        y12 = new javax.swing.JTextField();
        yG = new javax.swing.JTextField();
        per10 = new javax.swing.JTextField();
        per12 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        resoursePanel = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        sport3 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea22 = new javax.swing.JTextArea();
        jTextArea23 = new javax.swing.JTextArea();
        jTextArea24 = new javax.swing.JTextArea();
        eventPanel = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        sport1 = new javax.swing.JPanel();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jTextArea17 = new javax.swing.JTextArea();
        jTextArea18 = new javax.swing.JTextArea();
        jTextArea19 = new javax.swing.JTextArea();
        jTextArea20 = new javax.swing.JTextArea();
        Sportpanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sport = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jTextArea10 = new javax.swing.JTextArea();
        jTextArea11 = new javax.swing.JTextArea();
        jTextArea12 = new javax.swing.JTextArea();
        jTextArea9 = new javax.swing.JTextArea();
        placePanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        sport2 = new javax.swing.JPanel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jTextArea13 = new javax.swing.JTextArea();
        jTextArea14 = new javax.swing.JTextArea();
        jTextArea15 = new javax.swing.JTextArea();
        jTextArea16 = new javax.swing.JTextArea();
        clgimg = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        clgimg1 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        addedPanel = new javax.swing.JPanel();
        form2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        mom_name_area = new javax.swing.JTextField();
        dad_name_area = new javax.swing.JTextField();
        name_area = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        email_area = new javax.swing.JTextField();
        adahr_area = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        gender_area = new javax.swing.JTextField();
        phone_area = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        photo_area = new javax.swing.JLabel();
        course_area = new javax.swing.JTextField();
        address_area = new javax.swing.JTextField();

        jLabel65.setText("jLabel65");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPanel.setBackground(new java.awt.Color(153, 255, 153));
        menuPanel.setPreferredSize(new java.awt.Dimension(130, 2000));
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        events.setIcon(new javax.swing.ImageIcon("D:\\college_mgt\\app_icons\\student_icons\\events.png")); // NOI18N
        events.setToolTipText("Event");
        events.setPreferredSize(new java.awt.Dimension(76, 76));
        events.setRequestFocusEnabled(false);
        events.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventsActionPerformed(evt);
            }
        });
        menuPanel.add(events, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 390, -1, -1));

        sports.setIcon(new javax.swing.ImageIcon("D:\\college_mgt\\app_icons\\student_icons\\running.png")); // NOI18N
        sports.setToolTipText("Sports");
        sports.setPreferredSize(new java.awt.Dimension(76, 76));
        sports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sportsActionPerformed(evt);
            }
        });
        menuPanel.add(sports, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 550, 79, -1));

        placements.setIcon(new javax.swing.ImageIcon("D:\\college_mgt\\app_icons\\student_icons\\placement.png")); // NOI18N
        placements.setToolTipText("Placements");
        placements.setPreferredSize(new java.awt.Dimension(76, 76));
        placements.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placementsActionPerformed(evt);
            }
        });
        menuPanel.add(placements, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 710, -1, -1));

        gallery.setIcon(new javax.swing.ImageIcon("D:\\college_mgt\\app_icons\\student_icons\\gallery.png")); // NOI18N
        gallery.setToolTipText("College Galary");
        gallery.setPreferredSize(new java.awt.Dimension(76, 76));
        gallery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                galleryActionPerformed(evt);
            }
        });
        menuPanel.add(gallery, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 870, -1, -1));

        about.setIcon(new javax.swing.ImageIcon("D:\\college_mgt\\app_icons\\teacher_menu\\graduate.png")); // NOI18N
        about.setToolTipText("About Me");
        about.setPreferredSize(new java.awt.Dimension(76, 76));
        about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutMouseExited(evt);
            }
        });
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        menuPanel.add(about, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 70, -1, -1));

        result.setIcon(new javax.swing.ImageIcon("D:\\college_mgt\\app_icons\\teacher_menu\\result.png")); // NOI18N
        result.setToolTipText("Resources");
        result.setPreferredSize(new java.awt.Dimension(76, 76));
        result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultActionPerformed(evt);
            }
        });
        menuPanel.add(result, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 230, -1, -1));

        getContentPane().add(menuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 1009));

        panelmain.setBackground(new java.awt.Color(51, 255, 51));
        panelmain.setPreferredSize(new java.awt.Dimension(1800, 2000));
        panelmain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabPane.setBackground(new java.awt.Color(102, 102, 102));
        tabPane.setForeground(new java.awt.Color(255, 255, 255));
        tabPane.setPreferredSize(new java.awt.Dimension(1600, 2000));

        welcome.setBackground(new java.awt.Color(255, 255, 255));
        welcome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_pack/image.png"))); // NOI18N
        welcome.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, 900, 900));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app_pack/front_1.png"))); // NOI18N
        jLabel2.setOpaque(true);
        welcome.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 210, 710, 670));

        tabPane.addTab("tab0", welcome);

        admissionPanel.setBackground(new java.awt.Color(255, 255, 255));
        admissionPanel.setPreferredSize(new java.awt.Dimension(1920, 900));
        admissionPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 204));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1740, 990));

        addP.setBackground(new java.awt.Color(255, 255, 255));
        addP.setPreferredSize(new java.awt.Dimension(1735, 1540));
        addP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        p1.setBackground(new java.awt.Color(255, 255, 255));
        p1.setPreferredSize(new java.awt.Dimension(1409, 300));
        p1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setBackground(new java.awt.Color(204, 204, 204));
        jLabel66.setFont(new java.awt.Font("Times New Roman", 1, 45)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("International Institute Of Professional Paradigm");
        jLabel66.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        p1.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 1174, -1));

        jLabel70.setBackground(new java.awt.Color(153, 255, 255));
        jLabel70.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Online Registration Form");
        p1.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 269, -1));
        p1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 0, 138, 172));

        regisLabel.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        regisLabel.setText("Registration Id  = ");
        p1.add(regisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 40, 360, 50));

        addP.add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 9, 1610, 178));

        p2.setBackground(new java.awt.Color(255, 204, 204));
        p2.setOpaque(false);
        p2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel71.setText("    Course");
        jLabel71.setAlignmentY(2.0F);
        jLabel71.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel71.setOpaque(true);
        p2.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 6, 151, 34));

        course.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        course.setMaximumRowCount(10);
        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----NONE-----", "BCA", "BBA", "BSc", "BCom", "BA", "B Tech", "MCA", "MBA", "MSc", "M Com", "MTech" }));
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        p2.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 8, 430, 34));

        jLabel72.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel72.setText("  Applicant Name");
        jLabel72.setOpaque(true);
        p2.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 62, 151, 34));

        jLabel73.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel73.setText("   Mother's Name");
        jLabel73.setOpaque(true);
        p2.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 117, 151, 30));

        jLabel74.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel74.setText("   Father's Name");
        jLabel74.setOpaque(true);
        p2.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 151, 34));

        stuName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        stuName.setToolTipText("name of applicant.");
        stuName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                stuNameFocusGained(evt);
            }
        });
        stuName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stuNameKeyReleased(evt);
            }
        });
        p2.add(stuName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 430, 34));

        momName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        momName.setToolTipText("name of applicant's mother.");
        momName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                momNameKeyReleased(evt);
            }
        });
        p2.add(momName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 430, 34));

        dadName.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dadName.setToolTipText("name of applicant's father.");
        dadName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dadNameActionPerformed(evt);
            }
        });
        dadName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dadNameKeyReleased(evt);
            }
        });
        p2.add(dadName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 430, 34));

        jLabel75.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel75.setText("   Contact Info");
        jLabel75.setOpaque(true);
        p2.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 151, 34));

        phone1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        phone1.setToolTipText("10 digit phone number.");
        phone1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone1ActionPerformed(evt);
            }
        });
        phone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phone1KeyPressed(evt);
            }
        });
        p2.add(phone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 430, 34));

        jLabel76.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel76.setText("    D.O.B.");
        jLabel76.setAlignmentY(2.0F);
        jLabel76.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel76.setOpaque(true);
        jLabel76.setRequestFocusEnabled(false);
        p2.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 225, 151, 34));

        imglabel.setBackground(new java.awt.Color(255, 255, 255));
        imglabel.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        imglabel.setForeground(new java.awt.Color(255, 0, 51));
        imglabel.setText("Upload your passport photo.");
        imglabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imglabel.setOpaque(true);
        imglabel.setPreferredSize(new java.awt.Dimension(150, 180));
        imglabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imglabelMouseClicked(evt);
            }
        });
        p2.add(imglabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 240, 290));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        p2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 290, 140, 40));
        p2.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 430, 30));

        addP.add(p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 205, 1352, 337));

        p3.setBackground(new java.awt.Color(204, 204, 255));
        p3.setOpaque(false);
        p3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel77.setBackground(new java.awt.Color(255, 204, 255));
        jLabel77.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel77.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel77.setText("Personal Details");
        p3.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 830, -1));

        jLabel78.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel78.setText("  Contact Info");
        jLabel78.setOpaque(true);
        p3.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 54, 138, 38));

        jLabel79.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel79.setText("  Email Id");
        jLabel79.setOpaque(true);
        p3.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 131, 138, 38));

        jLabel80.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel80.setText("  Aadhar Number");
        jLabel80.setOpaque(true);
        p3.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 203, 138, 44));

        jLabel81.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel81.setText("   State");
        jLabel81.setOpaque(true);
        jLabel81.setPreferredSize(new java.awt.Dimension(94, 44));
        p3.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 131, 136, 38));

        phone2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        phone2.setToolTipText("10 digit phone number.");
        phone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phone2KeyPressed(evt);
            }
        });
        p3.add(phone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 55, 338, 45));

        email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        email.setToolTipText("enter email id.");
        p3.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 132, 338, 45));

        adhar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        adhar.setToolTipText("enter 12  digit adhar number.");
        adhar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adharKeyPressed(evt);
            }
        });
        p3.add(adhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 203, 338, 45));

        gender.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----NONE-----", "Male", "Female", "Other" }));
        gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderActionPerformed(evt);
            }
        });
        p3.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 54, 345, 45));

        jLabel82.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel82.setText("  Gender");
        jLabel82.setOpaque(true);
        jLabel82.setPreferredSize(new java.awt.Dimension(94, 44));
        p3.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 54, 138, 38));

        jLabel83.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel83.setText("   City");
        jLabel83.setOpaque(true);
        jLabel83.setPreferredSize(new java.awt.Dimension(94, 44));
        p3.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 203, 136, 38));

        state.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        state.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----NONE-----", "Andhra_Pradesh", "Arunachal_Pradesh", "Assam", "Bihar", "Chhattisgarh", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal_Pradesh", "Jammu_Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya_Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha", "Puducherry", "Punjab", "Rajasthan", "Sikkim", "Tamil_Nadu", "Telangana", "Tripura", "Uttar_Pradesh", "Uttarakhand", "West_Bengal" }));
        state.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stateActionPerformed(evt);
            }
        });
        p3.add(state, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 131, 345, 45));

        city.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        city.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----NONE-----", "Male", "Female", "Other" }));
        city.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cityActionPerformed(evt);
            }
        });
        p3.add(city, new org.netbeans.lib.awtextra.AbsoluteConstraints(919, 203, 345, 45));

        addP.add(p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 554, 1352, 264));

        p4.setBackground(new java.awt.Color(153, 255, 204));
        p4.setOpaque(false);
        p4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel84.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel84.setText("   Address");
        jLabel84.setOpaque(true);
        p4.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 73, 138, 38));

        jLabel85.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel85.setText("  City");
        jLabel85.setOpaque(true);
        p4.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 132, 138, 32));

        jLabel86.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel86.setText("   Pin Code");
        jLabel86.setOpaque(true);
        p4.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 186, 138, 38));

        jLabel87.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel87.setText("   State");
        jLabel87.setOpaque(true);
        p4.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 243, 136, 38));

        jLabel88.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel88.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel88.setText("   Address");
        jLabel88.setOpaque(true);
        p4.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 73, 136, 38));

        jLabel89.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel89.setText("   City");
        jLabel89.setOpaque(true);
        p4.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 132, 136, 32));

        jLabel90.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel90.setText("   Pin Code");
        jLabel90.setOpaque(true);
        p4.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 186, 136, 38));

        jLabel91.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N
        jLabel91.setText("   State");
        jLabel91.setOpaque(true);
        p4.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 243, 138, 38));

        address1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        address1.setToolTipText("Your resident address.");
        address1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address1ActionPerformed(evt);
            }
        });
        p4.add(address1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 74, 338, 38));

        city1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        city1.setToolTipText("City name.");
        city1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                city1ActionPerformed(evt);
            }
        });
        p4.add(city1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 130, 338, 38));

        pin1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pin1.setToolTipText("Pin code.");
        pin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pin1ActionPerformed(evt);
            }
        });
        pin1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pin1KeyPressed(evt);
            }
        });
        p4.add(pin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 187, 338, 38));

        state1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        state1.setToolTipText("State name.");
        state1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                state1ActionPerformed(evt);
            }
        });
        p4.add(state1, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 240, 338, 38));

        address2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        address2.setToolTipText("Your resident address.");
        address2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address2ActionPerformed(evt);
            }
        });
        p4.add(address2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 74, 342, 38));

        city2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        city2.setToolTipText("City name.");
        city2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                city2ActionPerformed(evt);
            }
        });
        p4.add(city2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 130, 342, 38));

        pin2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        pin2.setToolTipText("Pin code.");
        pin2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pin2ActionPerformed(evt);
            }
        });
        pin2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pin2KeyPressed(evt);
            }
        });
        p4.add(pin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 187, 342, 38));

        state2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        state2.setToolTipText("State name.");
        state2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                state2ActionPerformed(evt);
            }
        });
        p4.add(state2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 244, 342, 38));

        jLabel92.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel92.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel92.setText("Local Address");
        jLabel92.setRequestFocusEnabled(false);
        p4.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 3, 680, 40));

        jLabel93.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel93.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel93.setText("Permanent Address");
        p4.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(673, 3, 673, 40));

        jCheckBox1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jCheckBox1.setText("Copy local address.");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        p4.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 10, 150, 30));

        addP.add(p4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 830, 1341, 317));

        submit.setBackground(new java.awt.Color(51, 204, 0));
        submit.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        submit.setForeground(new java.awt.Color(255, 255, 255));
        submit.setText("Submit");
        submit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        submit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        addP.add(submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 1470, 184, 56));

        p5.setBackground(new java.awt.Color(255, 255, 255));
        p5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("     High School");
        jLabel5.setOpaque(true);
        p5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 114, 140, 37));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("     Intermediate");
        jLabel6.setOpaque(true);
        p5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 167, 140, 37));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("     Graduation");
        jLabel7.setOpaque(true);
        p5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 216, 140, 37));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("     Qualification");
        jLabel8.setOpaque(true);
        p5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 63, 140, 37));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("  Total Marks");
        jLabel9.setOpaque(true);
        p5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 120, 37));

        jLabel94.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel94.setText("   Roll Number");
        jLabel94.setOpaque(true);
        p5.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 134, 37));

        jLabel95.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel95.setText("   College Name");
        jLabel95.setOpaque(true);
        p5.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 134, 37));

        jLabel96.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel96.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel96.setText("Percent/CGP");
        jLabel96.setOpaque(true);
        p5.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 60, 130, 37));

        jLabel97.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel97.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel97.setText("Obtained Marks");
        jLabel97.setOpaque(true);
        p5.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 140, 37));

        jLabel98.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("Year of passing.");
        jLabel98.setOpaque(true);
        p5.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 60, 140, 37));

        jLabel99.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel99.setText("  Course");
        jLabel99.setOpaque(true);
        p5.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 100, 37));

        jLabel100.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel100.setText("      10");
        jLabel100.setOpaque(true);
        p5.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 114, 100, 37));

        jLabel101.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel101.setText("      12");
        jLabel101.setOpaque(true);
        p5.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 167, 100, 37));

        grad.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        grad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "BCA", "BBA", "BSc", "B Com", "BA (Maths)", "B Tech" }));
        p5.add(grad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 216, 100, 37));

        rollG.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        rollG.setToolTipText("10th roll number.");
        p5.add(rollG, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 216, 134, 37));

        perG.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        perG.setToolTipText("10th roll number.");
        perG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                perGFocusGained(evt);
            }
        });
        perG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perGMouseClicked(evt);
            }
        });
        perG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perGActionPerformed(evt);
            }
        });
        p5.add(perG, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 216, 134, 37));
        perG.setEditable(false);

        roll12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        roll12.setToolTipText("10th roll number.");
        p5.add(roll12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 167, 134, 37));

        roll10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        roll10.setToolTipText("10th roll number.");
        p5.add(roll10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 114, 134, 37));

        sch10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sch10.setToolTipText("10th roll number.");
        p5.add(sch10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 114, 134, 37));

        sch12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        sch12.setToolTipText("10th roll number.");
        p5.add(sch12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 167, 134, 37));

        schG.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        schG.setToolTipText("10th roll number.");
        p5.add(schG, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 216, 134, 37));

        om10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        om10.setToolTipText("10th roll number.");
        om10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                om10KeyPressed(evt);
            }
        });
        p5.add(om10, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 114, 140, 37));

        om12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        om12.setToolTipText("10th roll number.");
        om12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                om12KeyPressed(evt);
            }
        });
        p5.add(om12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 167, 140, 37));

        omG.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        omG.setToolTipText("10th roll number.");
        omG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                omGKeyPressed(evt);
            }
        });
        p5.add(omG, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 216, 140, 37));

        tm10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tm10.setToolTipText("10th roll number.");
        tm10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tm10KeyPressed(evt);
            }
        });
        p5.add(tm10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 114, 120, 37));

        tm12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tm12.setToolTipText("10th roll number.");
        tm12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tm12KeyPressed(evt);
            }
        });
        p5.add(tm12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 167, 120, 37));

        tmG.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        tmG.setToolTipText("10th roll number.");
        tmG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tmGKeyPressed(evt);
            }
        });
        p5.add(tmG, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 216, 120, 37));

        y10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        y10.setToolTipText("10th roll number.");
        y10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                y10KeyPressed(evt);
            }
        });
        p5.add(y10, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 114, 140, 37));

        y12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        y12.setToolTipText("10th roll number.");
        y12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                y12KeyPressed(evt);
            }
        });
        p5.add(y12, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 167, 140, 37));

        yG.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        yG.setToolTipText("10th roll number.");
        yG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                yGKeyPressed(evt);
            }
        });
        p5.add(yG, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 216, 140, 37));

        per10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        per10.setToolTipText("10th roll number.");
        per10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                per10FocusGained(evt);
            }
        });
        per10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                per10MouseClicked(evt);
            }
        });
        p5.add(per10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 114, 134, 37));
        per10.setEditable(false);

        per12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        per12.setToolTipText("10th roll number.");
        per12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                per12FocusGained(evt);
            }
        });
        per12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                per12MouseClicked(evt);
            }
        });
        p5.add(per12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 167, 134, 37));
        per12.setEditable(false);

        jLabel102.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("Qualification");
        p5.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 450, 35));

        addP.add(p5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 1174, 1317, 264));

        jScrollPane1.setViewportView(addP);

        admissionPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 1680, 1010));
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);

        tabPane.addTab("tab1", admissionPanel);

        resoursePanel.setBackground(new java.awt.Color(255, 204, 255));
        resoursePanel.setPreferredSize(new java.awt.Dimension(1920, 900));
        resoursePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane12.setBorder(null);
        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane12.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane12.setPreferredSize(new java.awt.Dimension(1690, 1010));

        sport3.setBackground(new java.awt.Color(255, 204, 255));
        sport3.setPreferredSize(new java.awt.Dimension(1768, 1927));
        sport3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel108.setText("Resourse News 1");
        sport3.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 204, 34));

        jLabel109.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel109.setText("Resourse News  2");
        sport3.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 513, 209, 33));

        jLabel110.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel110.setText("Resourse News  3");
        sport3.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 930, 175, 33));

        jLabel111.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel111.setText("Resourse News  4");
        sport3.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 1346, 178, 33));

        jLabel112.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel112.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel112.setText("We will notify you for for further Resourses......");
        sport3.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 1797, 1168, 36));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Your Data 2");
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea1.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport3.add(jTextArea1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 572, 1090, 352));
        jTextArea1.setEditable(false);

        jTextArea22.setColumns(20);
        jTextArea22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea22.setLineWrap(true);
        jTextArea22.setRows(5);
        jTextArea22.setText(" Your Data 3");
        jTextArea22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea22.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea22.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport3.add(jTextArea22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 970, 1090, 351));
        jTextArea1.setEditable(false);

        jTextArea23.setColumns(20);
        jTextArea23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea23.setLineWrap(true);
        jTextArea23.setRows(5);
        jTextArea23.setText("Your Data 4");
        jTextArea23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea23.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea23.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport3.add(jTextArea23, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 1391, 1090, 351));
        jTextArea1.setEditable(false);

        jTextArea24.setColumns(20);
        jTextArea24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea24.setLineWrap(true);
        jTextArea24.setRows(5);
        jTextArea24.setText("Your Data 1");
        jTextArea24.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea24.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea24.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport3.add(jTextArea24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1090, 351));
        jTextArea1.setEditable(false);

        jScrollPane12.setViewportView(sport3);

        resoursePanel.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 1680, 1010));
        jScrollPane12.getVerticalScrollBar().setUnitIncrement(20);

        tabPane.addTab("tab9", resoursePanel);

        eventPanel.setBackground(new java.awt.Color(153, 255, 204));
        eventPanel.setPreferredSize(new java.awt.Dimension(1920, 900));
        eventPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane11.setBorder(null);
        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane11.setPreferredSize(new java.awt.Dimension(1690, 1010));

        sport1.setBackground(new java.awt.Color(153, 255, 204));
        sport1.setPreferredSize(new java.awt.Dimension(1768, 1927));
        sport1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel103.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel103.setText("Event News 1");
        sport1.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 204, 34));

        jLabel104.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel104.setText("Event News  2");
        sport1.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 513, 209, 33));

        jLabel105.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel105.setText("Event News  3");
        sport1.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 930, 175, 33));

        jLabel106.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel106.setText("Event News  4");
        sport1.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 1346, 178, 33));

        jLabel107.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel107.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel107.setText("We will notify you for for further News abouts Events......");
        sport1.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 1797, 1168, 36));

        jTextArea17.setColumns(20);
        jTextArea17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea17.setLineWrap(true);
        jTextArea17.setRows(5);
        jTextArea17.setText("Your Data 2");
        jTextArea17.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea17.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea17.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport1.add(jTextArea17, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 572, 1090, 352));
        jTextArea1.setEditable(false);

        jTextArea18.setColumns(20);
        jTextArea18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea18.setLineWrap(true);
        jTextArea18.setRows(5);
        jTextArea18.setText(" Your Data 3");
        jTextArea18.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea18.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea18.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport1.add(jTextArea18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 970, 1090, 351));
        jTextArea1.setEditable(false);

        jTextArea19.setColumns(20);
        jTextArea19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea19.setLineWrap(true);
        jTextArea19.setRows(5);
        jTextArea19.setText("Your Data 4");
        jTextArea19.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea19.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea19.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport1.add(jTextArea19, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 1391, 1090, 351));
        jTextArea1.setEditable(false);

        jTextArea20.setColumns(20);
        jTextArea20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea20.setLineWrap(true);
        jTextArea20.setRows(5);
        jTextArea20.setText("Your Data 1");
        jTextArea20.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea20.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea20.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport1.add(jTextArea20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1090, 351));
        jTextArea1.setEditable(false);

        jScrollPane11.setViewportView(sport1);

        eventPanel.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 1680, 1010));
        jScrollPane11.getVerticalScrollBar().setUnitIncrement(20);

        tabPane.addTab("tab9", eventPanel);

        Sportpanel.setBackground(new java.awt.Color(91, 228, 159));
        Sportpanel.setPreferredSize(new java.awt.Dimension(1920, 900));
        Sportpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(1690, 1010));

        sport.setBackground(new java.awt.Color(91, 228, 159));
        sport.setPreferredSize(new java.awt.Dimension(1768, 1927));
        sport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel51.setText("Sports News 1");
        sport.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 204, 34));

        jLabel52.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel52.setText("Sports News  2");
        sport.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 513, 209, 33));

        jLabel53.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel53.setText("Sports News  3");
        sport.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 930, 175, 33));

        jLabel54.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel54.setText("Sports News  4");
        sport.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 1346, 178, 33));

        jLabel55.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("We will notify you for for further News abouts sports events......");
        sport.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 1797, 1168, 36));

        jTextArea10.setColumns(20);
        jTextArea10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea10.setLineWrap(true);
        jTextArea10.setRows(5);
        jTextArea10.setText("Your Data 2");
        jTextArea10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea10.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport.add(jTextArea10, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 572, 1090, 352));
        jTextArea1.setEditable(false);

        jTextArea11.setColumns(20);
        jTextArea11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea11.setLineWrap(true);
        jTextArea11.setRows(5);
        jTextArea11.setText(" Your Data 3");
        jTextArea11.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea11.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea11.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport.add(jTextArea11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 970, 1090, 351));
        jTextArea1.setEditable(false);

        jTextArea12.setColumns(20);
        jTextArea12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea12.setLineWrap(true);
        jTextArea12.setRows(5);
        jTextArea12.setText("Your Data 4");
        jTextArea12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea12.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea12.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport.add(jTextArea12, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 1391, 1090, 351));
        jTextArea1.setEditable(false);

        jTextArea9.setColumns(20);
        jTextArea9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea9.setLineWrap(true);
        jTextArea9.setRows(5);
        jTextArea9.setText("Your Data 1");
        jTextArea9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea9.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea9.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport.add(jTextArea9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1090, 351));
        jTextArea1.setEditable(false);

        jScrollPane2.setViewportView(sport);

        Sportpanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 1680, 1010));
        jScrollPane2.getAccessibleContext().setAccessibleName("");
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(20);

        tabPane.addTab("tab9", Sportpanel);

        placePanel.setBackground(new java.awt.Color(204, 204, 255));
        placePanel.setPreferredSize(new java.awt.Dimension(1920, 900));
        placePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane7.setBorder(null);
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane7.setPreferredSize(new java.awt.Dimension(1690, 1010));

        sport2.setBackground(new java.awt.Color(204, 204, 255));
        sport2.setPreferredSize(new java.awt.Dimension(1768, 1927));
        sport2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel56.setText("Placement News 1");
        sport2.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 204, 34));

        jLabel57.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel57.setText("Placement News  2");
        sport2.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 513, 209, 33));

        jLabel58.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel58.setText("Placement News  3");
        sport2.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 930, 175, 33));

        jLabel59.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel59.setText("Placement News  4");
        sport2.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 1346, 178, 33));

        jLabel60.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("We will notify you for for further News abouts Placement news......");
        sport2.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 1797, 1168, 36));

        jTextArea13.setColumns(20);
        jTextArea13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea13.setLineWrap(true);
        jTextArea13.setRows(5);
        jTextArea13.setText("Your Data 2");
        jTextArea13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea13.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea13.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport2.add(jTextArea13, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 572, 1090, 352));
        jTextArea1.setEditable(false);

        jTextArea14.setColumns(20);
        jTextArea14.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea14.setLineWrap(true);
        jTextArea14.setRows(5);
        jTextArea14.setText(" Your Data 3");
        jTextArea14.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea14.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea14.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport2.add(jTextArea14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 970, 1090, 351));
        jTextArea1.setEditable(false);

        jTextArea15.setColumns(20);
        jTextArea15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea15.setLineWrap(true);
        jTextArea15.setRows(5);
        jTextArea15.setText("Your Data 4");
        jTextArea15.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea15.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea15.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport2.add(jTextArea15, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 1391, 1090, 351));
        jTextArea1.setEditable(false);

        jTextArea16.setColumns(20);
        jTextArea16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextArea16.setLineWrap(true);
        jTextArea16.setRows(5);
        jTextArea16.setText("Your Data 1");
        jTextArea16.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea16.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextArea16.setMargin(new java.awt.Insets(20, 10, 20, 10));
        sport2.add(jTextArea16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1090, 351));
        jTextArea1.setEditable(false);

        jScrollPane7.setViewportView(sport2);

        placePanel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 1680, 1010));
        jScrollPane7.getVerticalScrollBar().setUnitIncrement(30);

        tabPane.addTab("tab9", placePanel);

        clgimg.setBackground(new java.awt.Color(183, 219, 255));
        clgimg.setPreferredSize(new java.awt.Dimension(1768, 1927));
        clgimg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        clgimg1.setBackground(new java.awt.Color(183, 219, 255));
        clgimg1.setPreferredSize(new java.awt.Dimension(1735, 1927));
        clgimg1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel113.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel113.setText("College Image 1");
        clgimg1.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 72, 204, 34));

        jLabel114.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel114.setText("College Image  2");
        clgimg1.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 500, 209, 33));

        jLabel115.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel115.setText("College Image  3");
        clgimg1.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 917, 175, 33));

        jLabel116.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel116.setText("College Image  4");
        clgimg1.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 1369, 178, 33));

        jLabel11.setOpaque(true);
        clgimg1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 575, 1300, 330));

        jLabel117.setOpaque(true);
        clgimg1.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 118, 1300, 330));

        jLabel118.setOpaque(true);
        clgimg1.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 1490, 1300, 330));

        jLabel119.setOpaque(true);
        clgimg1.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 987, 1300, 330));

        jScrollPane3.setViewportView(clgimg1);

        clgimg.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 1680, 1010));
        jScrollPane3.getVerticalScrollBar().setUnitIncrement(20);

        tabPane.addTab("tab7", clgimg);

        addedPanel.setBackground(new java.awt.Color(204, 204, 204));
        addedPanel.setMaximumSize(new java.awt.Dimension(1550, 1010));
        addedPanel.setPreferredSize(new java.awt.Dimension(1550, 1010));
        addedPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        form2.setBackground(new java.awt.Color(204, 204, 204));
        form2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        form2.setMaximumSize(new java.awt.Dimension(1550, 1010));
        form2.setMinimumSize(new java.awt.Dimension(1550, 1010));
        form2.setPreferredSize(new java.awt.Dimension(1550, 1010));
        form2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 55)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("International Institute Of Professional Paradigm");
        form2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 1390, 89));
        form2.add(mom_name_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 350, 34));
        form2.add(dad_name_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 350, 34));

        name_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_areaActionPerformed(evt);
            }
        });
        form2.add(name_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 350, 34));

        jLabel13.setBackground(new java.awt.Color(204, 204, 255));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel13.setText("    Course");
        jLabel13.setAlignmentY(2.0F);
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        form2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 201, 34));

        jLabel14.setBackground(new java.awt.Color(204, 204, 255));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel14.setText("  Applicant Name");
        form2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 34));

        jLabel15.setBackground(new java.awt.Color(204, 204, 255));
        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel15.setText("   Mother's Name");
        form2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 201, 37));

        jLabel16.setBackground(new java.awt.Color(204, 204, 255));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel16.setText("   Father's Name");
        form2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 201, 34));

        jLabel17.setBackground(new java.awt.Color(204, 204, 255));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel17.setText("   Contact Info");
        form2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 201, 34));

        jLabel18.setBackground(new java.awt.Color(153, 153, 153));
        jLabel18.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Personal Details");
        form2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 570, 210, -1));

        jLabel20.setBackground(new java.awt.Color(255, 255, 153));
        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel20.setText("  Email Id");
        form2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 680, 214, 44));

        jLabel21.setBackground(new java.awt.Color(255, 255, 153));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel21.setText("  Aadhar Number");
        form2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 760, 214, 44));

        email_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_areaActionPerformed(evt);
            }
        });
        form2.add(email_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 680, 350, 34));
        email_area.getAccessibleContext().setAccessibleName("");

        adahr_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adahr_areaActionPerformed(evt);
            }
        });
        form2.add(adahr_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 770, 350, 34));

        jLabel22.setBackground(new java.awt.Color(255, 255, 153));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel22.setText("  Gender");
        form2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 680, 156, 44));

        jLabel31.setBackground(new java.awt.Color(255, 255, 102));
        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 28)); // NOI18N
        jLabel31.setText("   Address");
        form2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 780, 160, 38));

        gender_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gender_areaActionPerformed(evt);
            }
        });
        form2.add(gender_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 690, 350, 34));

        phone_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phone_areaActionPerformed(evt);
            }
        });
        form2.add(phone_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 450, 350, 34));

        jButton9.setBackground(new java.awt.Color(102, 102, 102));
        jButton9.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Back");
        jButton9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        form2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 880, 184, 56));

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setOpaque(true);
        form2.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 1475, 2));

        jLabel41.setBackground(new java.awt.Color(0, 0, 0));
        jLabel41.setOpaque(true);
        form2.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 270, 3));

        photo_area.setBackground(new java.awt.Color(102, 255, 204));
        photo_area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102), 5));
        photo_area.setOpaque(true);
        form2.add(photo_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(1027, 170, 290, 330));

        course_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_areaActionPerformed(evt);
            }
        });
        form2.add(course_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 350, 34));

        address_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                address_areaActionPerformed(evt);
            }
        });
        form2.add(address_area, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 770, 350, 34));
        address_area.getAccessibleContext().setAccessibleName("");

        addedPanel.add(form2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        tabPane.addTab("tab9", addedPanel);

        panelmain.add(tabPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -35, 1790, 2379));

        getContentPane().add(panelmain, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eventsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventsActionPerformed
        // TODO add your handling code here:
        panelmain.setBackground(new Color(255,255,204));
        tabPane.setSelectedIndex(3);
    }//GEN-LAST:event_eventsActionPerformed

    private void sportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sportsActionPerformed
        // TODO add your handling code here:
        panelmain.setBackground(new Color(91,228,159));
        tabPane.setSelectedIndex(4);
    }//GEN-LAST:event_sportsActionPerformed

    private void placementsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placementsActionPerformed
        // TODO add your handling code here:\
        panelmain.setBackground(new Color(255,226,5));
        tabPane.setSelectedIndex(5);
        // jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_placementsActionPerformed

    private void galleryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_galleryActionPerformed
        // TODO add your handling code here:
        panelmain.setBackground(new Color(183,219,255));
        tabPane.setSelectedIndex(6);
    }//GEN-LAST:event_galleryActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        verify_admission();
        if(check_admission.equals("false"))
        {
            tabPane.setSelectedIndex(1);
        }
        else{
            tabPane.setSelectedIndex(7);
//            tabPane.setSelectedIndex(7);
        }
    }//GEN-LAST:event_aboutActionPerformed

    private void aboutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseEntered

    }//GEN-LAST:event_aboutMouseEntered

    private void aboutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_aboutMouseExited

    private void resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultActionPerformed
        // TODO add your handling code here:
       tabPane.setSelectedIndex(2);
    }//GEN-LAST:event_resultActionPerformed

    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseActionPerformed

    private void stuNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stuNameKeyReleased
        // TODO add your handling code here:
        int pos = stuName.getCaretPosition();
        stuName.setText(stuName.getText().toUpperCase());
        stuName.setCaretPosition(pos);
    }//GEN-LAST:event_stuNameKeyReleased

    private void momNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_momNameKeyReleased
        // TODO add your handling code here:
        int pos = momName.getCaretPosition();
        momName.setText(momName.getText().toUpperCase());
        momName.setCaretPosition(pos);
    }//GEN-LAST:event_momNameKeyReleased

    private void dadNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dadNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dadNameActionPerformed

    private void dadNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dadNameKeyReleased
        // TODO add your handling code here:
        int pos = dadName.getCaretPosition();
        dadName.setText(dadName.getText().toUpperCase());
        dadName.setCaretPosition(pos);
    }//GEN-LAST:event_dadNameKeyReleased

    private void phone1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone1ActionPerformed

    private void phone1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phone1KeyPressed
        // TODO add your handling code here:
        String str = phone1.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                phone1.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() < 10){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                phone1.setText(phone1.getText() + "" + evt.getKeyChar());
            }
        }
        phone1.setEditable(false);
    }//GEN-LAST:event_phone1KeyPressed

    private void imglabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imglabelMouseClicked
        // TODO add your handling code here:
        //System.out.println("Upload");
        JFileChooser browse_img = new JFileChooser();
        browse_img.showOpenDialog(null);
        File file = browse_img.getSelectedFile();
        if(file == null){
            return;
        }
        String path = file.getAbsoluteFile().toString();
        if(path.equals("")){
            return;
        }
        try
        {
            BufferedImage buffer = ImageIO.read(new File(path));
            Image img = buffer.getScaledInstance(imglabel.getWidth(), imglabel.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            ips = new FileInputStream(new File(path));
            imglabel.setIcon(icon);
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(this,"Error in loading image","Alert",JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_imglabelMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser browse_img = new JFileChooser();
        browse_img.showOpenDialog(null);
        File file = browse_img.getSelectedFile();
        if(file == null){
            return;
        }
        String path = file.getAbsoluteFile().toString();
        if(path.equals("")){
            return;
        }
        try
        {
            BufferedImage buffer = ImageIO.read(new File(path));
            Image img = buffer.getScaledInstance(imglabel.getWidth(), imglabel.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            ips = new FileInputStream(new File(path));
            imglabel.setIcon(icon);
        }
        catch(Exception e)
        {
            JOptionPane.showConfirmDialog(this,"Error in loading image","Alert",JOptionPane.OK_OPTION);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void phone2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phone2KeyPressed
        // TODO add your handling code here:
        String str = phone2.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                phone2.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() < 10){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                phone2.setText(phone2.getText() + "" + evt.getKeyChar());
            }
        }
        phone2.setEditable(false);
    }//GEN-LAST:event_phone2KeyPressed

    private void adharKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adharKeyPressed
        // TODO add your handling code here:
        String str = adhar.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                adhar.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() < 12){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                adhar.setText(adhar.getText() + "" + evt.getKeyChar());
            }
        }
        adhar.setEditable(false);
    }//GEN-LAST:event_adharKeyPressed

    private void genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderActionPerformed

    private void stateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stateActionPerformed
        // TODO add your handling code here:
        state_selected = state.getSelectedItem().toString();
        state1.setText(state_selected);
        state2.setText(state_selected);
        city.removeAllItems();
        city.addItem("----NONE-----");
        String sql = "select " + state_selected + " from indian_state";
        try
        {
            stm = con.prepareStatement(sql);
            data = stm.executeQuery();
            while(data.next())
            {
                if(!data.getString(1).equals(""))
                {
                    city.addItem(data.getString(1));
                }
            }

        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(this,"Error in data base connection.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_stateActionPerformed

    private void cityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cityActionPerformed
        // TODO add your handling code here:\
        Object obj = city.getSelectedItem();
        if(obj == null){
            return;
        }
        city_selected = obj.toString();
        if(!(city_selected.equals("----NONE-----" ))){
            city1.setText(city_selected);
            city2.setText(city_selected);
        }

    }//GEN-LAST:event_cityActionPerformed

    private void address1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address1ActionPerformed

    private void city1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_city1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_city1ActionPerformed

    private void pin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pin1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pin1ActionPerformed

    private void pin1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pin1KeyPressed
        // TODO add your handling code here:
        String str = pin1.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                pin1.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() < 6){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                pin1.setText(pin1.getText() + "" + evt.getKeyChar());
            }
        }
        pin1.setEditable(false);
    }//GEN-LAST:event_pin1KeyPressed

    private void state1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_state1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_state1ActionPerformed

    private void address2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address2ActionPerformed

    private void city2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_city2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_city2ActionPerformed

    private void pin2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pin2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pin2ActionPerformed

    private void pin2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pin2KeyPressed
        // TODO add your handling code here:
        String str = pin2.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                pin2.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() < 6){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                pin2.setText(pin2.getText() + "" + evt.getKeyChar());
            }
        }
        pin2.setEditable(false);
    }//GEN-LAST:event_pin2KeyPressed

    private void state2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_state2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_state2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(jCheckBox1.isSelected())
        {
            address2.setText(address1.getText());
            pin2.setText(pin1.getText());
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        
        boolean output = check_empty();

        if(output)
        {
            int respond = JOptionPane.showConfirmDialog(this,"Do you want to continue?\n Remember if submitted you cannot edit it furthermore","Alert",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(respond == JOptionPane.YES_OPTION)
            {
                submit_data();
                JOptionPane.showMessageDialog(this, "Thank you for your response.");
                tabPane.setSelectedIndex(0);
//                dispose();
            }
        }
    }//GEN-LAST:event_submitActionPerformed
    private void submit_data()
    {
        try 
        {
            String sql = "insert into student_data(course , photo ,applicant_name,mom_name ,dad_name ,  dob ,phone1,phone2,email,adhar,gender,state,city "
                    + " ,pincode ,address, roll_10 ,year_10, percnet_10, roll_12, year_12,percnet_12, roll_grad , year_grad , percnetgrad,grad,regisid) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            stm = con.prepareStatement(sql);
            stm.setString(1,course.getSelectedItem().toString());
            stm.setBlob(2,ips);
            stm.setString(3,stuName.getText());
            stm.setString(4,momName.getText());
            stm.setString(5,dadName.getText());
            stm.setString(6,DOB);
            stm.setString(7,phone1.getText());
            stm.setString(8,phone2.getText());
            stm.setString(9,email.getText());
            stm.setString(10,adhar.getText());
            stm.setString(11,gender.getSelectedItem().toString());
            stm.setString(12,state_selected);
            stm.setString(13,city_selected);
            stm.setString(14,pin1.getText());
            stm.setString(15,address1.getText());
            stm.setString(16,roll10.getText());
            stm.setString(17,y10.getText());
            stm.setString(18,per10.getText());
            stm.setString(19,roll12.getText());
            stm.setString(20,y12.getText());
            stm.setString(21,per12.getText());
            if(grad.getSelectedItem().toString().equals("NONE"))
            {
                if(rollG.getText().equals("") && yG.getText().equals("") && perG.getText().equals(""))
                {
                    stm.setString(22,null);
                    stm.setString(23,null);
                    stm.setString(24,null);
                    stm.setString(25, null);
                }           
            }
            else
            {
                stm.setString(22,rollG.getText());
                stm.setString(23,yG.getText());
                stm.setString(24,perG.getText());
                stm.setString(25, grad.getSelectedItem().toString());
            }
            stm.setString(26,registration);
            stm.execute();
            sql = "update signup set fillform = 'true' where referid = '" + registration  +"';";
            stm = con.prepareStatement(sql);
            stm.execute();
        }
        catch (Exception e) 
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(this,"Error in uploading data.","Error",JOptionPane.ERROR_MESSAGE);    
        }
        
    }
    private boolean chkTbl()
    {
        if(roll10.getText().equals("") || y10.getText().equals("") || per10.getText().equals("") || sch10.getText().equals("") || om10.getText().equals("") || tm10.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Qualification fiels cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        int om;
        om = Integer.parseInt(y10.getText());
        if(om < Year_DOB)
        {
            JOptionPane.showMessageDialog(this,"Invalid passing year of HighSchool.","Error",JOptionPane.ERROR_MESSAGE);
            return false;            
        }
        if(Integer.parseInt(om10.getText()) > Integer.parseInt(tm10.getText()))
        {
            JOptionPane.showMessageDialog(this,"Invalid marks provided.","Error",JOptionPane.ERROR_MESSAGE);
            return false;            
        }
        if(roll12.getText().equals("") || y12.getText().equals("") || per12.getText().equals("") || sch12.getText().equals("") || om12.getText().equals("") || tm12.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this,"Qualification fiels cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        om = Integer.parseInt(om12.getText());
        if(om < Year_DOB)
        {
            JOptionPane.showMessageDialog(this,"Invalid passing year of Intermediate..","Error",JOptionPane.ERROR_MESSAGE);
            return false;            
        }
        
        if(Integer.parseInt(om12.getText()) > Integer.parseInt(tm12.getText()))
        {
            JOptionPane.showMessageDialog(this,"Invalid marks provided.","Error",JOptionPane.ERROR_MESSAGE);
            return false;            
        }
        if(grad.getSelectedItem().equals("NONE"))
        {
            if(rollG.getText().equals("") && yG.getText().equals("") && perG.getText().equals("") && schG.getText().equals("")&& omG.getText().equals("") && tmG.getText().equals("")){
                if(Integer.parseInt(y10.getText()) > Integer.parseInt(y12.getText()))
                {
                    JOptionPane.showMessageDialog(this,"Invalid passing year provided for highschool and intermediate.","Error",JOptionPane.ERROR_MESSAGE);
                    return false;

                }
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Qualification fiels cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }else
        {
            if(!(rollG.getText().equals("") && yG.getText().equals("") && perG.getText().equals("") && schG.getText().equals("")&& omG.getText().equals("") && tmG.getText().equals("")))
            {
                om = Integer.parseInt(yG.getText());
                if(om < Year_DOB)
                {
                    JOptionPane.showMessageDialog(this,"Invalid passing year of Graduation..","Error",JOptionPane.ERROR_MESSAGE);
                    return false;

                }
                if(Integer.parseInt(y12.getText()) > Integer.parseInt(yG.getText()))
                {
                    JOptionPane.showMessageDialog(this,"Invalid passing year provided fro graduation.","Error",JOptionPane.ERROR_MESSAGE);
                    return false;

                }
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Qualification fiels cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
    }
 
    private  boolean check_empty()
    {
        
        if(ips == null)
        {
            JOptionPane.showMessageDialog(this,"Upload your image.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(stuName.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Student Name cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }       
           
        if(momName.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Mother's Name cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(dadName.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Father's Name cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(dob == null)
        {
            return  false;
        }
        else{
            DOB = (dob.getDate().getDate() +" : " +  dob.getDate().getMonth() +" : " + dob.getCalendar().getWeekYear());
        }
        if("".equals(DOB)){
            JOptionPane.showMessageDialog(this,"Date of birth cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }             
        if(phone1.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Contact Info cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }        
        if(phone2.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Contact Info cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }       
        if(phone1.getText().length() < 10 || phone2.getText().length() < 10)
        {
            JOptionPane.showMessageDialog(this,"Invalid phone number.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(email.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Email cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(adhar.getText().equals("")){
            JOptionPane.showMessageDialog(this,"Adhar Number cannot be empty.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(adhar.getText().length() < 12)
        {
            JOptionPane.showMessageDialog(this,"Invalid  adhar number.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(gender.getSelectedItem().equals("----NONE-----")){
            JOptionPane.showMessageDialog(this,"Gender cannot be NONE.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(state.getSelectedItem().equals("----NONE-----")){
            JOptionPane.showMessageDialog(this,"Gender cannot be NONE.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(city.getSelectedItem().equals("----NONE-----")){
            JOptionPane.showMessageDialog(this,"Gender cannot be NONE.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(address1.getText().equals("----NONE-----")|| address2.getText().equals("----NONE-----")){
            JOptionPane.showMessageDialog(this,"Address cannot be NONE.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!address1.getText().equals(address2.getText())){
            JOptionPane.showMessageDialog(this,"Provided address are not same.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(pin1.getText().equals("----NONE-----")|| pin2.getText().equals("----NONE-----")){
            JOptionPane.showMessageDialog(this,"Gender cannot be NONE.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!pin1.getText().equals(pin2.getText())){
            JOptionPane.showMessageDialog(this,"Provided Pin code are not same.","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }        
        return chkTbl();
    }
   
    private void perGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perGMouseClicked
        // TODO add your handling code here:
        if(omG.getText().length() > 0 && tmG.getText().length() > 0)
        {
            double om = Double.parseDouble(omG.getText());
            double tm = Double.parseDouble(tmG.getText());
            if(om <= tm)
            {
                perG.setText("" + (om*100)/tm);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Invalid data of Graduation.","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
        if(yG.getText().length() > 0){
            int om;
            om = Integer.parseInt(yG.getText());
            if(om < Year_DOB)
            {
                JOptionPane.showMessageDialog(this,"Invalid passing year of Graduation.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_perGMouseClicked

    private void perGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_perGActionPerformed

    private void om10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_om10KeyPressed
        // TODO add your handling code here:
        String str = om10.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                om10.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() < 3){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                om10.setText(om10.getText() + "" + evt.getKeyChar());
            }
        }
        om10.setEditable(false);
    }//GEN-LAST:event_om10KeyPressed

    private void om12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_om12KeyPressed
        // TODO add your handling code here:
        String str = om12.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                om12.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() < 3){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                om12.setText(om12.getText() + "" + evt.getKeyChar());
            }
        }
        om12.setEditable(false);
    }//GEN-LAST:event_om12KeyPressed

    private void omGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_omGKeyPressed
        // TODO add your handling code here:
        String str = omG.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                omG.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() < 3){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                omG.setText(omG.getText() + "" + evt.getKeyChar());
            }
        }
        omG.setEditable(false);
    }//GEN-LAST:event_omGKeyPressed

    private void tm10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tm10KeyPressed
        // TODO add your handling code here:
        String str = tm10.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                tm10.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() < 3){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                tm10.setText(tm10.getText() + "" + evt.getKeyChar());
            }
        }
        tm10.setEditable(false);
    }//GEN-LAST:event_tm10KeyPressed

    private void tm12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tm12KeyPressed
        // TODO add your handling code here:
        String str = tm12.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                tm12.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() < 3){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                tm12.setText(tm12.getText() + "" + evt.getKeyChar());
            }
        }
        tm12.setEditable(false);
    }//GEN-LAST:event_tm12KeyPressed

    private void tmGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tmGKeyPressed
        // TODO add your handling code here:
        String str = tmG.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                tmG.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() < 3){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                tmG.setText(tmG.getText() + "" + evt.getKeyChar());
            }
        }
        tmG.setEditable(false);
    }//GEN-LAST:event_tmGKeyPressed

    private void y10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_y10KeyPressed
        // TODO add your handling code here:
        String str = y10.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                y10.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() <4 ){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                y10.setText(y10.getText() + "" + evt.getKeyChar());
            }
        }
        y10.setEditable(false);
    }//GEN-LAST:event_y10KeyPressed

    private void y12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_y12KeyPressed
        // TODO add your handling code here:
        String str = y12.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                y12.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() <4 ){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                y12.setText(y12.getText() + "" + evt.getKeyChar());
            }
        }
        y12.setEditable(false);
    }//GEN-LAST:event_y12KeyPressed

    private void yGKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_yGKeyPressed
        // TODO add your handling code here:
        String str = yG.getText();
        if(evt.getExtendedKeyCode() == KeyEvent.VK_DELETE ||  evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if(str.length() > 0)
            {
                yG.setText(str.substring(0,str.length()-1));
            }
        }

        if(str.length() <4 ){
            if(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')
            {
                // phone1.setEditable(true);
                yG.setText(yG.getText() + "" + evt.getKeyChar());
            }
        }
        yG.setEditable(false);
    }//GEN-LAST:event_yGKeyPressed

    private void per10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_per10MouseClicked
        // TODO add your handling code here:
        if(om10.getText().length() > 0 && tm10.getText().length() > 0)
        {
            double om = Double.parseDouble(om10.getText());
            double tm = Double.parseDouble(tm10.getText());
            if(om <= tm)
            {
                per10.setText("" + (om*100)/tm);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Invalid data of HighSchool.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(y10.getText().length() > 0){
            int om;
            om = Integer.parseInt(y10.getText());
            if(om < Year_DOB)
            {
                JOptionPane.showMessageDialog(this,"Invalid passing year of HighSchool.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_per10MouseClicked

    private void per12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_per12MouseClicked
        // TODO add your handling code here:
        if(om12.getText().length() > 0 && tm12.getText().length() > 0)
        {
            double om = Double.parseDouble(om12.getText());
            double tm = Double.parseDouble(tm12.getText());
            if(om <= tm)
            {
                per12.setText("" + (om*100)/tm);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Invalid data of Intermediate.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(y12.getText().length() > 0){
            int om;
            om = Integer.parseInt(y12.getText());
            if(om < Year_DOB)
            {
                JOptionPane.showMessageDialog(this,"Invalid passing year of Intermediate.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_per12MouseClicked

    private void stuNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_stuNameFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_stuNameFocusGained

    private void per10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_per10FocusGained
        // TODO add your handling code here:
        if(om10.getText().length() > 0 && tm10.getText().length() > 0)
        {
            double om = Double.parseDouble(om10.getText());
            double tm = Double.parseDouble(tm10.getText());
            if(om <= tm)
            {
                per10.setText("" + (om*100)/tm);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Invalid data of HighSchool.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(y10.getText().length() > 0){
            int om;
            om = Integer.parseInt(y10.getText());
            if(om < Year_DOB)
            {
                JOptionPane.showMessageDialog(this,"Invalid passing year of HighSchool.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_per10FocusGained

    private void per12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_per12FocusGained
        // TODO add your handling code here:
        if(om12.getText().length() > 0 && tm12.getText().length() > 0)
        {
            double om = Double.parseDouble(om12.getText());
            double tm = Double.parseDouble(tm12.getText());
            if(om <= tm)
            {
                per12.setText("" + (om*100)/tm);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Invalid data of Intermediate.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(y12.getText().length() > 0){
            int om;
            om = Integer.parseInt(y12.getText());
            if(om < Year_DOB)
            {
                JOptionPane.showMessageDialog(this,"Invalid passing year of Intermediate.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_per12FocusGained

    private void perGFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_perGFocusGained
        // TODO add your handling code here:
         if(omG.getText().length() > 0 && tmG.getText().length() > 0)
        {
            double om = Double.parseDouble(omG.getText());
            double tm = Double.parseDouble(tmG.getText());
            if(om <= tm)
            {
                perG.setText("" + (om*100)/tm);
            }
            else
            {
                JOptionPane.showMessageDialog(this,"Invalid data of Graduation.","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
        if(yG.getText().length() > 0){
            int om;
            om = Integer.parseInt(yG.getText());
            if(om < Year_DOB)
            {
                JOptionPane.showMessageDialog(this,"Invalid passing year of Graduation.","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_perGFocusGained

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void phone_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phone_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phone_areaActionPerformed

    private void gender_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gender_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gender_areaActionPerformed

    private void adahr_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adahr_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adahr_areaActionPerformed

    private void email_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_areaActionPerformed

    private void name_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_name_areaActionPerformed

    private void course_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_course_areaActionPerformed

    private void address_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_address_areaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_address_areaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Sportpanel;
    private javax.swing.JButton about;
    private javax.swing.JTextField adahr_area;
    private javax.swing.JPanel addP;
    private javax.swing.JPanel addedPanel;
    private javax.swing.JTextField address1;
    private javax.swing.JTextField address2;
    private javax.swing.JTextField address_area;
    private javax.swing.JTextField adhar;
    private javax.swing.JPanel admissionPanel;
    private javax.swing.JComboBox<String> city;
    private javax.swing.JTextField city1;
    private javax.swing.JTextField city2;
    private javax.swing.JPanel clgimg;
    private javax.swing.JPanel clgimg1;
    private javax.swing.JComboBox<String> course;
    private javax.swing.JTextField course_area;
    private javax.swing.JTextField dadName;
    private javax.swing.JTextField dad_name_area;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField email;
    private javax.swing.JTextField email_area;
    private javax.swing.JPanel eventPanel;
    private javax.swing.JButton events;
    private javax.swing.JPanel form2;
    private javax.swing.JButton gallery;
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JTextField gender_area;
    private javax.swing.JComboBox<String> grad;
    private javax.swing.JLabel imglabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea10;
    private javax.swing.JTextArea jTextArea11;
    private javax.swing.JTextArea jTextArea12;
    private javax.swing.JTextArea jTextArea13;
    private javax.swing.JTextArea jTextArea14;
    private javax.swing.JTextArea jTextArea15;
    private javax.swing.JTextArea jTextArea16;
    private javax.swing.JTextArea jTextArea17;
    private javax.swing.JTextArea jTextArea18;
    private javax.swing.JTextArea jTextArea19;
    private javax.swing.JTextArea jTextArea20;
    private javax.swing.JTextArea jTextArea22;
    private javax.swing.JTextArea jTextArea23;
    private javax.swing.JTextArea jTextArea24;
    private javax.swing.JTextArea jTextArea9;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JTextField momName;
    private javax.swing.JTextField mom_name_area;
    private javax.swing.JTextField name_area;
    private javax.swing.JTextField om10;
    private javax.swing.JTextField om12;
    private javax.swing.JTextField omG;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel p5;
    private javax.swing.JPanel panelmain;
    private javax.swing.JTextField per10;
    private javax.swing.JTextField per12;
    private javax.swing.JTextField perG;
    private javax.swing.JTextField phone1;
    private javax.swing.JTextField phone2;
    private javax.swing.JTextField phone_area;
    private javax.swing.JLabel photo_area;
    private javax.swing.JTextField pin1;
    private javax.swing.JTextField pin2;
    private javax.swing.JPanel placePanel;
    private javax.swing.JButton placements;
    private javax.swing.JLabel regisLabel;
    private javax.swing.JPanel resoursePanel;
    private javax.swing.JButton result;
    private javax.swing.JTextField roll10;
    private javax.swing.JTextField roll12;
    private javax.swing.JTextField rollG;
    private javax.swing.JTextField sch10;
    private javax.swing.JTextField sch12;
    private javax.swing.JTextField schG;
    private javax.swing.JPanel sport;
    private javax.swing.JPanel sport1;
    private javax.swing.JPanel sport2;
    private javax.swing.JPanel sport3;
    private javax.swing.JButton sports;
    private javax.swing.JComboBox<String> state;
    private javax.swing.JTextField state1;
    private javax.swing.JTextField state2;
    private javax.swing.JTextField stuName;
    private javax.swing.JButton submit;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JTextField tm10;
    private javax.swing.JTextField tm12;
    private javax.swing.JTextField tmG;
    private javax.swing.JPanel welcome;
    private javax.swing.JTextField y10;
    private javax.swing.JTextField y12;
    private javax.swing.JTextField yG;
    // End of variables declaration//GEN-END:variables
}
