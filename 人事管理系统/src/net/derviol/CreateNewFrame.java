package net.derviol;

import com.mysql.cj.util.StringUtils;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.List;

public class CreateNewFrame {
    static Connection con;
    static String sql;
    Font font1 = new Font(null,Font.PLAIN, 20);
    String[] op = {"添加人员信息","修改人员信息","删除人员信息","查询人员信息","部门管理","人员调动","调动历史查询", "人员考核","考核历史查询","劳资分配管理","劳资历史查询"};
    String[] aps = {"姓名","性别","出生年月","民族","地址","部门","薪酬","考核","其他"};
    String[] bps = {};
    public void CreateNewFrame(String name){
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1, false);
        JFrame fr = new JFrame();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("img\\draw2.jpg");
        fr.setIconImage(img);
        fr.setTitle(name);
        fr.setBounds(100,100,800,600);
        fr.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container c = fr.getContentPane();
        JPanel p = new JPanel();
        p.setLayout(null);

        MySqlConnect MSC = new MySqlConnect();
        con = MSC.Connect();
        int index = 0;
        for(int i=0; i < op.length ; i++){
            if(op[i] == name){
                index = i;
            }
        }
        switch (index) {
            case 0 :{
                CreateNewFrame CNW = new CreateNewFrame();
                JComboBox<String> comboBox_1=new JComboBox<>(CNW.getbumenrowdata());
                JTextField textField0 = new JTextField(16);JTextField textField1 = new JTextField(16);
                JTextField textField2 = new JTextField(16);JTextField textField3 = new JTextField(16);
                JTextField textField4 = new JTextField(16);JTextField textField5 = new JTextField(16);
                JTextField textField6 = new JTextField(16);JTextField textField7 = new JTextField(16);
                JTextField textField8 = new JTextField(16);JTextField textField9 = new JTextField(16);
                JLabel jl0 = new JLabel("编号");JLabel jl1 = new JLabel("姓名");JLabel jl2 = new JLabel("性别");JLabel jl3 = new JLabel("出生年月");
                JLabel jl4 = new JLabel("民族");JLabel jl5 = new JLabel("地址");JLabel jl6 = new JLabel("部门");JLabel jl7 = new JLabel("薪酬");
                JLabel jl8 = new JLabel("考核");JLabel jl9 = new JLabel("其他");
                JButton jb0 = new JButton("确定");JButton jb1 = new JButton("取消");JButton jb2 = new JButton("添加");
                Font font1 = new Font(null,Font.PLAIN, 20);
                jl0.setBounds(200,10,200,50);jl0.setFont(font1);textField0.setBounds(120,50,200,25);
                jl1.setBounds(500,10,200,50);jl1.setFont(font1);textField1.setBounds(420,50,200,25);
                jl2.setBounds(200,80,200,50);jl2.setFont(font1);textField2.setBounds(120,120,200,25);
                jl3.setBounds(480,80,200,50);jl3.setFont(font1);textField3.setBounds(420,120,200,25);
                jl4.setBounds(200,150,200,50);jl4.setFont(font1);textField4.setBounds(120,190,200,25);
                jl5.setBounds(500,150,200,50);jl5.setFont(font1);textField5.setBounds(420,190,200,25);
                jl6.setBounds(200,220,200,50);jl6.setFont(font1);textField6.setBounds(120,260,200,25);
                jl7.setBounds(500,220,200,50);jl7.setFont(font1);textField7.setBounds(420,260,200,25);
                jl8.setBounds(200,290,200,50);jl8.setFont(font1);textField8.setBounds(120,330,200,25);
                jl9.setBounds(500,290,200,50);jl9.setFont(font1);textField9.setBounds(420,330,200,25);
                jb2.setBounds(120,400,200,50);jb1.setBounds(420,400,200,50);
                p.add(jl0);p.add(jl1);p.add(jl2);p.add(jl3);p.add(jl4);p.add(jl5);p.add(jl6);p.add(jl7);p.add(jl8);p.add(jl9);
                p.add(textField0);p.add(textField1);p.add(textField2);p.add(textField3);p.add(textField4);p.add(textField5);
                p.add(textField6);p.add(textField7);p.add(textField8);p.add(textField9);p.add(jb2);p.add(jb1);
                c.add(p);
                jb1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        fr.dispose();
                    }
                });
                jb2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String num = textField0.getText();String name = textField1.getText();String sex = textField2.getText();
                        String birth = textField3.getText();String ethnic = textField4.getText();String address = textField5.getText();
                        String department = textField6.getText();;
                        String pay = textField7.getText();String assess = textField8.getText();
                        String other = textField9.getText();
                        sql = "INSERT INTO `人员信息表` VALUES (?,?,?,?,?,?,?,?,?,?)";
                        if((StringUtils.isNullOrEmpty(num)) || (StringUtils.isNullOrEmpty(name)) || (StringUtils.isNullOrEmpty(sex)) || (StringUtils.isNullOrEmpty(birth)) || (StringUtils.isNullOrEmpty(ethnic)) || (StringUtils.isNullOrEmpty(address)) || (StringUtils.isNullOrEmpty(department)) || (StringUtils.isNullOrEmpty(pay)) || (StringUtils.isNullOrEmpty(assess)) || (StringUtils.isNullOrEmpty(other))){
                            JDialog jds = new JDialog();
                            jds.setTitle("错误");
                            JLabel jl = new JLabel("输入有误");
                            JPanel jp = new JPanel();
                            JButton jbs = new JButton("确定");
                            jl.setFont(font1);
                            jp.add(jl);jp.add(jbs);
                            jds.add(jp);
                            jds.setVisible(true);
                            jds.setSize(100,100);
                            jds.setAlwaysOnTop(true);
                            jds.setModal(true);
                            jds.setLocationRelativeTo(null);
                            jbs.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    jds.dispose();
                                }
                            });
                        }else{
                            try {
                                PreparedStatement ps = con.prepareStatement(sql);
                                ps.setString(1,num);ps.setString(2,name);ps.setString(3,sex);ps.setString(4,birth);
                                ps.setString(5,ethnic);ps.setString(6,address);ps.setString(7,department);ps.setString(8,pay);
                                ps.setString(9,assess);ps.setString(10,other);
                                ps.executeUpdate();
                                JLabel jl = new JLabel("添加成功");
                                jl.setFont(font1);
                                JDialog jd = new JDialog();
                                JPanel jp = new JPanel();
                                jp.add(jb0);jp.add(jl);
                                jd.add(jp);
                                jd.setTitle("完成");
                                jd.setSize(100,100);
                                jd.setVisible(true);
                                jd.setAlwaysOnTop(true);
                                jd.setModal(true);
                                jd.setLocationRelativeTo(null);
                                jb0.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jd.dispose();
                                    }
                                });
                                jd.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowGainedFocus(WindowEvent e) {
                                    }
                                    @Override
                                    public void windowLostFocus(WindowEvent e) {
                                        jd.setVisible(false);
                                        jd.dispose();
                                    }
                                });
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                });
            }break;
            case 1 :{
                JTextField textField0 = new JTextField("不要修改部门");
                JLabel jl0 = new JLabel();
                jl0.setText("请输入编号进行修改：");
                Font font1 = new Font(null,Font.PLAIN, 20);
                jl0.setFont(font1);
                JPanel jp = new JPanel();
                textField0.setPreferredSize(new Dimension(200,30));
                JButton jbf = new JButton("确定");
                jbf.setBounds(340,300,100,50);
                jp.add(jl0);jp.add(textField0);jp.add(jbf);
                c.add(jp);
                fr.setSize(300,150);
                fr.setLocationRelativeTo(null);
                jbf.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String num = textField0.getText();
                        sql = "SELECT 编号 FROM 人员信息表";
                        Statement stmt;
                        try {
                            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet res = stmt.executeQuery(sql);
                            List<String> datelist = new ArrayList<>();
                            while(res.next()){
                                String columnValue = res.getString("编号");
                                datelist.add(columnValue);
                            }
                            if(datelist.indexOf(num) == -1){
                                JDialog jda = new JDialog();
                                jda.setTitle("错误");
                                JButton jb = new JButton("确定");
                                JLabel jl = new JLabel("输入有误");
                                JPanel jp = new JPanel();
                                jl.setFont(font1);
                                jp.add(jl);jp.add(jb);
                                jda.add(jp);
                                jda.setSize(100,100);
                                jda.setVisible(true);
                                jda.setAlwaysOnTop(true);
                                jda.setModal(true);
                                jda.setLocationRelativeTo(null);
                                jb.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jda.dispose();
                                    }
                                });
                                jda.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowGainedFocus(WindowEvent e) {
                                    }
                                    @Override
                                    public void windowLostFocus(WindowEvent e) {
                                        jda.setVisible(false);
                                        jda.dispose();
                                    }
                                });
                            }else{
                                JComboBox<String> comboBox_1=new JComboBox<>(aps);
                                JLabel jl0 = new JLabel("请选择要修改的条目");
                                JLabel jl1 = new JLabel("请输入更改后的内容");
                                jl0.setFont(font1);jl1.setFont(font1);
                                JPanel jp = new JPanel();
                                JDialog jd = new JDialog();
                                jd.setTitle("正在更改...");
                                JButton jb = new JButton("确定");
                                JTextField jt = new JTextField("");
                                jt.setPreferredSize(new Dimension(200,30));
                                jp.add(jl0);jp.add(comboBox_1);jp.add(jl1);jp.add(jt);jp.add(jb);
                                jd.add((jp));
                                jp.setLayout(null);
                                jl0.setBounds(10,10,200,100);
                                comboBox_1.setBounds(200,45,200,30);
                                jl1.setBounds(10,100,200,100);
                                jt.setBounds(200,140,200,30);
                                jb.setBounds(200,200,100,50);
                                jd.setSize(500,350);
                                jd.setVisible(true);
                                jd.setAlwaysOnTop(true);
                                jd.setModal(true);
                                jd.setLocationRelativeTo(null);
                                jd.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowGainedFocus(WindowEvent e) {
                                    }
                                    @Override
                                    public void windowLostFocus(WindowEvent e) {
                                        jd.setVisible(false);
                                        jd.dispose();
                                    }
                                });
                                jb.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String value = jt.getText();
                                        try {
                                            String title = (String) comboBox_1.getSelectedItem();
                                            String sql1 = "UPDATE `人事管理系统`.`人员信息表` SET "+title+" = "+"'"+value+"'  where 编号 = "+num+"";
                                            PreparedStatement stmt1 = con.prepareStatement(sql1,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                            stmt1.executeUpdate();
                                            JDialog jd = new JDialog();
                                            jd.setTitle("成功");
                                            JLabel lbl = new JLabel("修改成功");
                                            JButton jb = new JButton("确定");
                                            JPanel  jp = new JPanel();
                                            lbl.setFont(font1);
                                            jp.add(lbl);jp.add(jb);
                                            jd.add(jp);
                                            jd.setSize(100,100);
                                            jd.setVisible(true);
                                            jd.setAlwaysOnTop(true);
                                            jd.setModal(true);
                                            jd.setLocationRelativeTo(null);
                                            jd.addWindowListener(new WindowAdapter() {
                                                @Override
                                                public void windowGainedFocus(WindowEvent e) {
                                                }
                                                @Override
                                                public void windowLostFocus(WindowEvent e) {
                                                    jd.setVisible(false);
                                                    jd.dispose();
                                                }
                                            });
                                            jb.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    jd.dispose();
                                                }
                                            });
                                        } catch (SQLException throwables) {
                                            throwables.printStackTrace();
                                        }
                                    }
                                });
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                });
            }break;
            case 2 :{
                JTextField textField0 = new JTextField();
                JLabel jl0 = new JLabel();
                jl0.setText("请输入编号进行删除：");
                Font font1 = new Font(null,Font.PLAIN, 20);
                jl0.setFont(font1);
                JPanel jp = new JPanel();
                textField0.setPreferredSize(new Dimension(200,30));
                JButton jbf = new JButton("确定");
                jbf.setBounds(340,300,100,50);
                jp.add(jl0);jp.add(textField0);jp.add(jbf);
                c.add(jp);
                fr.setSize(300,150);
                fr.setLocationRelativeTo(null);
                jbf.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String num = textField0.getText();
                        sql = "SELECT 编号 FROM 人员信息表";
                        Statement stmt;
                        try {
                            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet res = stmt.executeQuery(sql);
                            ResultSetMetaData data = res.getMetaData();
                            List<String> datelist = new ArrayList<>();
                            while(res.next()){
                                String columnValue = res.getString("编号");
                                datelist.add(columnValue);
                            }
                            if(datelist.indexOf(num) == -1){
                                JDialog jd = new JDialog();
                                jd.setTitle("错误");
                                JLabel jl = new JLabel("输入有误");
                                jl.setFont(font1);
                                JButton jb = new JButton("确定");
                                JPanel jp = new JPanel();
                                jp.add(jl);jp.add(jb);
                                jd.add(jp);
                                jd.setSize(100,100);
                                jd.setVisible(true);
                                jd.setAlwaysOnTop(true);
                                jd.setModal(true);
                                jd.setLocationRelativeTo(null);
                                jd.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowGainedFocus(WindowEvent e) {
                                    }
                                    @Override
                                    public void windowLostFocus(WindowEvent e) {
                                        jd.setVisible(false);
                                        jd.dispose();
                                    }
                                });
                                jb.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jd.dispose();
                                    }
                                });
                            }else {
                                JDialog jd = new JDialog();
                                jd.setTitle("确认?");
                                JLabel jl = new JLabel("是否确认删除");
                                JButton jb0 = new JButton("确定");
                                JButton jb1 = new JButton("取消");
                                jl.setFont(font1);
                                JPanel jp = new JPanel();
                                jp.add(jl);jp.add(jb0);jp.add(jb1);
                                jd.add(jp);
                                jd.setSize(200,100);
                                jd.setVisible(true);
                                jd.setAlwaysOnTop(true);
                                jd.setModal(true);
                                jd.setLocationRelativeTo(null);
                                jd.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowGainedFocus(WindowEvent e) {
                                    }
                                    @Override
                                    public void windowLostFocus(WindowEvent e) {
                                        jd.setVisible(false);
                                        jd.dispose();
                                    }
                                });
                                jb0.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        Statement stmt1 = null;
                                        try {
                                            String sql1 = "DELETE FROM 人员信息表 WHERE 编号 = " + num + "";
                                            stmt1=con.prepareStatement(sql1);
                                            stmt1.executeUpdate(sql1);
                                            JDialog jd= new JDialog();
                                            jd.setTitle("删除成功");
                                            JLabel jl= new JLabel("删除完成！");
                                            jl.setFont(font1);
                                            JButton jb = new JButton("确定");
                                            JPanel jp = new JPanel();
                                            jp.add(jl);jp.add(jb);
                                            jd.add(jp);
                                            jd.setSize(100,100);
                                            jd.setVisible(true);
                                            jd.setAlwaysOnTop(true);
                                            jd.setModal(true);
                                            jd.setLocationRelativeTo(null);
                                            jd.addWindowListener(new WindowAdapter() {
                                                @Override
                                                public void windowGainedFocus(WindowEvent e) {
                                                }
                                                @Override
                                                public void windowLostFocus(WindowEvent e) {
                                                    jd.setVisible(false);
                                                    jd.dispose();
                                                }
                                            });
                                            jb.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    jd.dispose();
                                                }
                                            });
                                        } catch (SQLException throwables) {
                                            throwables.printStackTrace();
                                        }
                                    }
                                });
                                jb1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jd.dispose();
                                    }
                                });
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                });
            }break;
            case 3 :{
                JButton b = new JButton();
                b.setText("查询");
                JLabel jl = new JLabel();
                jl.setText("请输入编号或姓名查询");
                JLabel jl0 = new JLabel();JLabel jl1 = new JLabel();
                jl0.setText("编号：");jl1.setText("姓名：");
                JTextField textField0 = new JTextField(16);
                JTextField textField1 = new JTextField(16);
                textField0.setPreferredSize(new Dimension(200,30));
                textField1.setPreferredSize(new Dimension(200,30));
                p.add(jl);jl.setBounds(250,10,1000,50);
                Font font0 = new Font(null,Font.PLAIN, 30);
                Font font1 = new Font(null,Font.PLAIN, 20);
                jl.setFont(font0);
                p.add(jl0);p.add(textField0);
                jl0.setFont(font1);jl1.setFont(font1);
                jl0.setBounds(250,100,100,50);
                textField0.setBounds(300,114,200,30);
                jl1.setBounds(250,200,100,50);
                textField1.setBounds(300,214,200,30);
                b.setBounds(340,300,100,50);
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String number = textField0.getText();
                        String name = textField1.getText();
                        if(((StringUtils.isNullOrEmpty(number)) && (StringUtils.isNullOrEmpty(name)))){
                            JLabel jl = new JLabel();
                            jl.setText("请输入内容");
                            jl.setFont(font1);
                            JDialog jd = new JDialog();
                            jd.setTitle("错误");
                            JButton jb = new JButton();
                            jb.setText("确定");
                            JPanel jp = new JPanel();
                            jp.add(jb);jp.add(jl);
                            jd.add(jp);
                            jd.setSize(100,100);
                            jd.setVisible(true);
                            jd.setAlwaysOnTop(true);
                            jd.setModal(true);
                            jd.setLocationRelativeTo(null);
                            jb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    jd.dispose();
                                }
                            });
                            jd.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowGainedFocus(WindowEvent e) {
                                }
                                @Override
                                public void windowLostFocus(WindowEvent e) {
                                    jd.setVisible(false);
                                    jd.dispose();
                                }
                            });
                        }else if((!StringUtils.isNullOrEmpty(number)) && (!StringUtils.isNullOrEmpty(name))){
                            JLabel jl = new JLabel();
                            jl.setText("只能输入一个");
                            jl.setFont(font1);
                            JDialog jd = new JDialog();
                            jd.setTitle("错误");
                            JButton jb = new JButton();
                            jb.setText("确定");
                            JPanel jp = new JPanel();
                            jp.add(jb);jp.add(jl);
                            jd.add(jp);
                            jd.setSize(100,100);
                            jd.setVisible(true);
                            jd.setAlwaysOnTop(true);
                            jd.setModal(true);
                            jd.setLocationRelativeTo(null);
                            jb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    jd.dispose();
                                }
                            });
                            jd.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowGainedFocus(WindowEvent e) {
                                }
                                @Override
                                public void windowLostFocus(WindowEvent e) {
                                    jd.setVisible(false);
                                    jd.dispose();
                                }
                            });
                        }else if(number.equals("all")||name.equals("all")){
                            sql = "SELECT * FROM 人员信息表";
                            Vector rowData,columnNames;
                            Statement stmt = null;
                            try {
                                columnNames = new Vector();
                                stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                ResultSet res = stmt.executeQuery(sql);
                                columnNames.add("编号");columnNames.add("姓名");columnNames.add("性别");columnNames.add("出生年月");
                                columnNames.add("民族");columnNames.add("地址");columnNames.add("部门");columnNames.add("薪酬");
                                columnNames.add("考核");columnNames.add("其他");
                                rowData = new Vector();
                                while(res.next()){
                                    Vector v = new Vector();
                                    v.add(res.getString(1));
                                    v.add(res.getString(2));
                                    v.add(res.getString(3));
                                    v.add(res.getString(4));
                                    v.add(res.getString(5));
                                    v.add(res.getString(6));
                                    v.add(res.getString(7));
                                    v.add(res.getString(8));
                                    v.add(res.getString(9));
                                    v.add(res.getString(10));
                                    rowData.add(v);
                                }
                                JTable t = new JTable(rowData,columnNames);
                                JScrollPane scrollPane = new JScrollPane(t);
                                JPanel jp = new JPanel();
                                JDialog jd = new JDialog();
                                jd.setTitle("查询全部");
                                jd.setLayout(new BorderLayout());
                                jd.add(scrollPane,BorderLayout.CENTER);
                                jd.setSize(800,300);
                                jd.setVisible(true);
                                jd.setAlwaysOnTop(true);
                                jd.setModal(true);
                                jd.setLocationRelativeTo(null);
                                jd.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowGainedFocus(WindowEvent e) {
                                    }
                                    @Override
                                    public void windowLostFocus(WindowEvent e) {
                                        jd.setVisible(false);
                                        jd.dispose();
                                    }
                                });
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }else if (!StringUtils.isNullOrEmpty(number) && StringUtils.isNullOrEmpty(name)) {
                            sql = "SELECT * FROM 人员信息表 WHERE 编号 ='" + number + "'";
                            Statement stmt = null;
                            try {
                                stmt = con.createStatement();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            try {
                                ResultSet res = stmt.executeQuery(sql);
                                while (res.next()) {
                                    String snumber = res.getString("编号");
                                    //System.out.print(snumber);
                                    String sname = res.getString("姓名");
                                    //System.out.print(sname);
                                    String sex = res.getString("性别");
                                    //System.out.print(sex);
                                    String birth = res.getString("出生年月");
                                    //System.out.print(birth);
                                    String ethnic = res.getString("民族");
                                    //System.out.print(ethnic);
                                    String address = res.getString("地址");
                                    //System.out.print(address);
                                    String department = res.getString("部门");
                                    //System.out.print(department);
                                    String pay = res.getString("薪酬");
                                    //System.out.print(pay);
                                    String assess = res.getString("考核");
                                    //System.out.print(assess);
                                    String other = res.getString("其他");
                                    //System.out.print(other);
                                    JFrame f = new JFrame("查询编号成功");
                                    f.setBounds(200, 200, 800, 300);
                                    f.setLayout(new BorderLayout());
                                    String[] columnNames = new String[]{"编号", "姓名", "性别", "出生年月", "民族", "地址", "部门", "薪酬", "考核", "其他"};
                                    String[][] details = new String[][]{{snumber, sname, sex, birth, ethnic, address, department, pay, assess, other}};
                                    JTable t = new JTable(details, columnNames);
                                    JScrollPane sp = new JScrollPane(t);
                                    f.add(sp, BorderLayout.CENTER);
                                    f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                    f.setVisible(true);
                                }
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }else if (StringUtils.isNullOrEmpty(number) && !StringUtils.isNullOrEmpty(name)) {
                            sql = "SELECT * FROM 人员信息表 WHERE 姓名 ='" + name + "'";
                            Statement stmt = null;
                            try {
                                stmt = con.createStatement();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                            try {
                                ResultSet res = stmt.executeQuery(sql);
                                while (res.next()) {
                                    String snumber = res.getString("编号");
                                    //System.out.print(snumber);
                                    String sname = res.getString("姓名");
                                    //System.out.print(sname);
                                    String sex = res.getString("性别");
                                    //System.out.print(sex);
                                    String birth = res.getString("出生年月");
                                    //System.out.print(birth);
                                    String ethnic = res.getString("民族");
                                    //System.out.print(ethnic);
                                    String address = res.getString("地址");
                                    //System.out.print(address);
                                    String department = res.getString("部门");
                                    //System.out.print(department);
                                    String pay = res.getString("薪酬");
                                    //System.out.print(pay);
                                    String assess = res.getString("考核");
                                    //System.out.print(assess);
                                    String other = res.getString("其他");
                                    //System.out.print(other);
                                    JFrame f = new JFrame("查询名字成功");
                                    f.setBounds(200, 200, 800, 300);
                                    f.setLayout(new BorderLayout());
                                    String[] columnNames = new String[]{"编号", "姓名", "性别", "出生年月", "民族", "地址", "部门", "薪酬", "考核", "其他"};
                                    String[][] details = new String[][]{{snumber, sname, sex, birth, ethnic, address, department, pay, assess, other}};
                                    JTable t = new JTable(details, columnNames);
                                    JScrollPane sp = new JScrollPane(t);
                                    f.add(sp, BorderLayout.CENTER);
                                    f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                                    f.setVisible(true);
                                }
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                });
                p.add(b);
                p.add(jl1);p.add(textField1);
                c.add(p);
                p.setLayout(null);
            }break;
            case 4 :{
                JPanel jp = new JPanel();
                JLabel jl = new JLabel("请选择你要进行的操作");
                JButton jb0 = new JButton("增加部门");
                JButton jb1 = new JButton("修改部门");
                JButton jb2 = new JButton("删除部门");
                JButton jb3 = new JButton("查询部门");
                jl.setFont(font1);
                fr.setBounds(100,100,300,150);
                fr.setLocationRelativeTo(null);
                jp.add(jl);jp.add(jb0);jp.add(jb1);jp.add(jb2);jp.add(jb3);
                c.add(jp);
                jb0.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CreateNewFrame CNW = new CreateNewFrame();
                        CNW.getbumenrowdata();
                        JTextField jt0 = new JTextField();
                        JTextField jt1 = new JTextField();
                        jt0.setPreferredSize(new Dimension(250,30));
                        jt1.setPreferredSize(new Dimension(250,30));
                        JLabel jl0 = new JLabel("请输入编号");jl0.setFont(font1);
                        JLabel jl1 = new JLabel("请输入部门");jl1.setFont(font1);
                        JButton jb = new JButton("确定");
                        jb.setSize(100,50);
                        JPanel jp = new JPanel();
                        JFrame jf = new JFrame("添加部门");
                        jf.setResizable(false);
                        jp.add(jl0);jp.add(jt0);
                        jp.add(jl1);jp.add(jt1);
                        jp.add(jb);
                        jf.add(jp);
                        jf.setSize(300,300);
                        jf.setVisible(true);
                        jf.setLocationRelativeTo(null);
                        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        jb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                sql = "INSERT INTO `部门管理表` VALUES (?,?)";
                                try {
                                    String num = jt0.getText();String value = jt1.getText();
                                    PreparedStatement ps = con.prepareStatement(sql);
                                    ps.setString(1, num);
                                    ps.setString(2, value);
                                    ps.executeUpdate();
                                    JDialog jd = new JDialog();
                                    jd.setTitle("添加成功");
                                    JLabel jl = new JLabel("添加成功");
                                    jl.setFont(font1);
                                    JButton jb = new JButton("确定");
                                    JPanel jp = new JPanel();
                                    jp.add(jl);jp.add(jb);
                                    jd.add(jp);
                                    jd.setSize(100,100);
                                    jd.setVisible(true);
                                    jd.setAlwaysOnTop(true);
                                    jd.setModal(true);
                                    jd.setLocationRelativeTo(null);
                                    jd.addWindowListener(new WindowAdapter() {
                                        @Override
                                        public void windowGainedFocus(WindowEvent e) {
                                        }
                                        @Override
                                        public void windowLostFocus(WindowEvent e) {
                                            jd.setVisible(false);
                                            jd.dispose();
                                        }
                                    });
                                    jb.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            jd.dispose();
                                        }
                                    });
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            }
                        });
                    }
                });
                jb1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFrame jf = new JFrame("修改部门");
                        JLabel jl0 = new JLabel("请输入编号");
                        jl0.setFont(font1);
                        JLabel jl1 = new JLabel("请输入修改后的部门昵称");
                        jl1.setFont(font1);
                        JTextField jt0 = new JTextField();
                        JTextField jt1 = new JTextField();
                        jt0.setPreferredSize(new Dimension(250,30));
                        jt1.setPreferredSize(new Dimension(250,30));
                        JPanel jp = new JPanel();
                        JButton jb = new JButton("确定");
                        jp.add(jl0);jp.add(jt0);jp.add(jl1);jp.add(jt1);
                        jp.add(jb);
                        jf.add(jp);
                        jf.setSize(300,300);
                        jf.setVisible(true);
                        jf.setLocationRelativeTo(null);
                        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                        jb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String num = jt0.getText();
                                String value = jt1.getText();
                                sql = "UPDATE `人事管理系统`.`人员信息表` SET 部门 = "+"'"+value+"'  where 编号 = "+num+"";
                                try {
                                    PreparedStatement stmt1 = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                                    stmt1.executeUpdate();
                                    JDialog jd = new JDialog();
                                    jd.setTitle("成功");
                                    JLabel jl = new JLabel("修改成功");
                                    jl.setFont(font1);
                                    JButton jb = new JButton("确定");
                                    JPanel jp = new JPanel();
                                    jp.add(jl);jp.add(jb);
                                    jd.add(jp);
                                    jd.setSize(100,100);
                                    jd.setVisible(true);
                                    jd.setAlwaysOnTop(true);
                                    jd.setModal(true);
                                    jd.setLocationRelativeTo(null);
                                    jd.addWindowListener(new WindowAdapter() {
                                        @Override
                                        public void windowGainedFocus(WindowEvent e) {
                                        }
                                        @Override
                                        public void windowLostFocus(WindowEvent e) {
                                            jd.setVisible(false);
                                            jd.dispose();
                                        }
                                    });
                                    jb.addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            jd.dispose();
                                        }
                                    });
                                } catch (SQLException throwables) {
                                    throwables.printStackTrace();
                                }
                            }
                        });
                    }
                });
                jb2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JDialog jd = new JDialog();
                        JLabel jl = new JLabel("输入要删除的编号");
                        jl.setFont(font1);
                        JTextField jt = new JTextField();
                        jt.setPreferredSize(new Dimension(250,30));
                        JPanel jp = new JPanel();
                        JButton jb = new JButton("确定");
                        jp.add(jl);jp.add(jt);jp.add(jb);
                        jd.add(jp);
                        jd.setSize(300,150);
                        jd.setVisible(true);
                        jd.setAlwaysOnTop(true);
                        jd.setModal(true);
                        jd.setLocationRelativeTo(null);
                        jd.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowGainedFocus(WindowEvent e) {
                            }
                            @Override
                            public void windowLostFocus(WindowEvent e) {
                                jd.setVisible(false);
                                jd.dispose();
                            }
                        });
                        jb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JDialog jd = new JDialog();
                                jd.setTitle("确认删除？");
                                JLabel jl = new JLabel("确认删除？");
                                jl.setFont(font1);
                                JButton jb0 = new JButton("确定");
                                JButton jb1 = new JButton("取消");
                                JPanel jp = new JPanel();
                                jp.add(jl);jp.add(jb0);jp.add(jb1);
                                jd.add(jp);
                                jd.setSize(150,110);
                                jd.setVisible(true);
                                jd.setAlwaysOnTop(true);
                                jd.setModal(true);
                                jd.setLocationRelativeTo(null);
                                jd.addWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowGainedFocus(WindowEvent e) {
                                    }
                                    @Override
                                    public void windowLostFocus(WindowEvent e) {
                                        jd.setVisible(false);
                                        jd.dispose();
                                    }
                                });
                                jb0.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String num = jt.getText();
                                        sql = "DELETE FROM 部门管理表 WHERE 编号 = "+num+"";
                                        PreparedStatement stmt1 = null;
                                        try {
                                            stmt1 = con.prepareStatement(sql);
                                            stmt1.executeUpdate(sql);
                                            JDialog jd = new JDialog();
                                            jd.setTitle("成功");
                                            JLabel jl = new JLabel("删除成功");
                                            jl.setFont(font1);
                                            JButton jb = new JButton("确定");
                                            JPanel jp = new JPanel();
                                            jp.add(jl);jp.add(jb);
                                            jd.add(jp);
                                            jd.setSize(100,100);
                                            jd.setVisible(true);
                                            jd.setAlwaysOnTop(true);
                                            jd.setModal(true);
                                            jd.setLocationRelativeTo(null);
                                            jd.addWindowListener(new WindowAdapter() {
                                                @Override
                                                public void windowGainedFocus(WindowEvent e) {
                                                }
                                                @Override
                                                public void windowLostFocus(WindowEvent e) {
                                                    jd.setVisible(false);
                                                    jd.dispose();
                                                }
                                            });
                                            jb.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    jd.dispose();
                                                }
                                            });
                                        } catch (SQLException throwables) {
                                            throwables.printStackTrace();
                                        }
                                    }
                                });
                                jb1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jd.dispose();
                                    }
                                });
                            }
                        });
                    }
                });
                jb3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Vector rowData,columnNames;
                        String sqls = "SELECT * FROM `部门管理表`";
                        Statement stmt = null;
                        try {
                            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet res = stmt.executeQuery(sqls);
                            JDialog dl = new JDialog();
                            dl.setTitle("正在查询");
                            JPanel jp = new JPanel();
                            CreateNewFrame CNW = new CreateNewFrame();
                            columnNames = new Vector();
                            columnNames.add("编号");
                            columnNames.add("部门");
                            rowData = new Vector();
                            while(res.next()){
                                Vector v = new Vector();
                                v.add(res.getString(1));
                                v.add(res.getString(2));
                                rowData.add(v);
                            }
                            JTable t = new JTable(rowData,columnNames);
                            t.setFillsViewportHeight(true);
                            JScrollPane scrollPane = new JScrollPane(t);
                            jp.add(scrollPane);
                            dl.add(jp);
                            t.setEnabled(false);
                            dl.setSize(500,500);
                            dl.setVisible(true);
                            dl.setLocationRelativeTo(null);
                            dl.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowGainedFocus(WindowEvent e) {
                                }
                                @Override
                                public void windowLostFocus(WindowEvent e) {
                                    dl.setVisible(false);
                                    dl.dispose();
                                }
                            });
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                });
            }break;
            case 5 :{
                JLabel jl0 = new JLabel("请输入要调动的人的编号");
                jl0.setFont(font1);
                JTextField jt0 = new JTextField();
                jt0.setPreferredSize(new Dimension(250,30));
                JLabel jl1 = new JLabel("调动至(部门)");
                jl1.setFont(font1);
                JTextField jt1 = new JTextField();
                jt1.setPreferredSize(new Dimension(250,30));
                CreateNewFrame CNW = new CreateNewFrame();
                JButton jb = new JButton("确定");
                JPanel jp = new JPanel();
                jp.add(jl0);jp.add(jt0);jp.add(jl1);//jp.add(comboBox_1);
                jp.add(jt1);
                jp.add(jb);
                c.add(jp);
                fr.setSize(300,200);
                fr.setLocationRelativeTo(null);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String num = jt0.getText();
                        String value = jt1.getText();
                        String otype = null;
                        int changecount;
                        String changedata;
                        String sql1 = "SELECT 部门 FROM 人员信息表 WHERE 编号 = "+num+"";
                        String sql2 = "SELECT 原始信息 FROM 历史操作记录表 WHERE 人员编号 = "+num+"";
                        sql = "UPDATE `人事管理系统`.`人员信息表` SET 部门 = "+"'"+value+"'  where 编号 = "+num+"";
                        PreparedStatement stmt1 = null;
                        try {
                            PreparedStatement stmt = con.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            PreparedStatement stmt2 = con.prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            stmt1 = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet res = stmt.executeQuery();
                            ResultSet rs = stmt2.executeQuery();
                            while (res.next()) {
                                otype = res.getString(1);
                            }
                            rs.last();
                            changecount = Integer.parseInt(String.valueOf(rs.getRow())) + 1;
                            Date date = new Date();
                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                            changedata = formatter.format(date);
                            stmt1.executeUpdate();
                            String sql3 = "INSERT INTO `历史操作记录表` VALUES (?,?,?,?,?,?,?)";
                            PreparedStatement ps = con.prepareStatement(sql3);
                            CreateNewFrame CNW = new CreateNewFrame();
                            String nums = String.valueOf((CNW.getDiaoDongRowCount()+1));
                            String type = "调动部门";
                            ps.setString(1,nums);ps.setString(2,type);ps.setString(3,otype);ps.setString(4,value);
                            ps.setString(5, String.valueOf(changecount));ps.setString(6,changedata);ps.setString(7,num);
                            ps.executeUpdate();
                            JDialog jd = new JDialog();
                            jd.setTitle("成功");
                            JLabel lbl = new JLabel("调动成功");
                            JButton jb = new JButton("确定");
                            JPanel  jp = new JPanel();
                            lbl.setFont(font1);
                            jp.add(lbl);jp.add(jb);
                            jd.add(jp);
                            jd.setSize(100,100);
                            jd.setVisible(true);
                            jd.setAlwaysOnTop(true);
                            jd.setModal(true);
                            jd.setLocationRelativeTo(null);
                            jd.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowGainedFocus(WindowEvent e) {
                                }
                                @Override
                                public void windowLostFocus(WindowEvent e) {
                                    jd.setVisible(false);
                                    jd.dispose();
                                }
                            });
                            jb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    jd.dispose();
                                }
                            });
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                });
            }break;
            case 6 :{
                JLabel jl = new JLabel("输入人员编号进行查询");
                jl.setFont(font1);
                JTextField jt = new JTextField();
                jt.setPreferredSize(new Dimension(250,30));
                JButton jb = new JButton("确定");
                JPanel jp = new JPanel();
                jp.add(jl);jp.add(jt);jp.add(jb);
                c.add(jp);
                fr.setSize(300,200);
                fr.setLocationRelativeTo(null);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String num = jt.getText();
                        Vector rowData,columnNames;
                        sql = "SELECT * FROM 历史操作记录表 WHERE 人员编号 = "+num+" AND 操作类型 = ";
                        sql = "SELECT * FROM 历史操作记录表 WHERE 人员编号 = "+num+" AND 操作类型 = '调动部门'";
                        try {
                            columnNames = new Vector();
                            PreparedStatement stmt1 = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet res = stmt1.executeQuery(sql);
                            columnNames.add("流水编号");columnNames.add("操作类型");columnNames.add("原始信息");columnNames.add("更新信息");
                            columnNames.add("变更次数");columnNames.add("变更日期");columnNames.add("人员编号");
                            rowData = new Vector();
                            while(res.next()){
                                Vector v = new Vector();
                                v.add(res.getString(1));
                                v.add(res.getString(2));
                                v.add(res.getString(3));
                                v.add(res.getString(4));
                                v.add(res.getString(5));
                                v.add(res.getString(6));
                                v.add(res.getString(7));
                                rowData.add(v);
                            }
                            JTable t = new JTable(rowData,columnNames);
                            JScrollPane scrollPane = new JScrollPane(t);
                            JPanel jp = new JPanel();
                            JDialog jd = new JDialog();
                            jd.setTitle("调动历史查询");
                            jd.setLayout(new BorderLayout());
                            jd.add(scrollPane,BorderLayout.CENTER);
                            jd.setSize(800,300);
                            jd.setVisible(true);
                            jd.setAlwaysOnTop(true);
                            jd.setModal(true);
                            jd.setLocationRelativeTo(null);
                            jd.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowGainedFocus(WindowEvent e) {
                                }
                                @Override
                                public void windowLostFocus(WindowEvent e) {
                                    jd.setVisible(false);
                                    jd.dispose();
                                }
                            });
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                });
            }break;
            case 7 :{
                JLabel jl0 = new JLabel("请输入人员编号:");
                JLabel jl1 = new JLabel("请输入考核结果:");
                jl0.setFont(font1);jl1.setFont(font1);
                JTextField jt0 = new JTextField();
                JTextField jt1 = new JTextField();
                jt0.setPreferredSize(new Dimension(250,30));
                jt1.setPreferredSize(new Dimension(250,30));
                JButton jb = new JButton("确定");
                JPanel jp = new JPanel();
                jp.add(jl0);jp.add(jt0);jp.add(jl1);jp.add(jt1);jp.add(jb);
                c.add(jp);
                fr.setSize(300,200);
                fr.setLocationRelativeTo(null);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String num = jt0.getText();
                        String value = jt1.getText();
                        sql = "UPDATE `人事管理系统`.`人员信息表` SET 考核 = "+"'"+value + "' where 编号 = "+num+"";
                        String otype = null;
                        int changecount;
                        String changedata;
                        String sql1 = "SELECT 考核 FROM 人员信息表 WHERE 编号 = "+num+"";
                        String sql2 = "SELECT 原始信息 FROM 历史操作记录表 WHERE 人员编号 = "+num+"";
                        PreparedStatement stmt1 = null;
                        try {
                            PreparedStatement stmt = con.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            PreparedStatement stmt2 = con.prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            stmt1 = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet res = stmt.executeQuery();
                            ResultSet rs = stmt2.executeQuery();
                            while (res.next()) {
                                otype = res.getString(1);
                            }
                            rs.last();
                            changecount = Integer.parseInt(String.valueOf(rs.getRow())) + 1;
                            Date date = new Date();
                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                            changedata = formatter.format(date);
                            stmt1.executeUpdate();
                            String sql3 = "INSERT INTO `历史操作记录表` VALUES (?,?,?,?,?,?,?)";
                            PreparedStatement ps = con.prepareStatement(sql3);
                            CreateNewFrame CNW = new CreateNewFrame();
                            String nums = String.valueOf((CNW.getDiaoDongRowCount()+1));
                            String type = "记录考核";
                            ps.setString(1,nums);ps.setString(2,type);ps.setString(3,otype);ps.setString(4,value);
                            ps.setString(5, String.valueOf(changecount));ps.setString(6,changedata);ps.setString(7,num);
                            ps.executeUpdate();
                            JDialog jd = new JDialog();
                            jd.setTitle("成功");
                            JLabel lbl = new JLabel("记录成功");
                            JButton jb = new JButton("确定");
                            JPanel  jp = new JPanel();
                            lbl.setFont(font1);
                            jp.add(lbl);jp.add(jb);
                            jd.add(jp);
                            jd.setSize(100,100);
                            jd.setVisible(true);
                            jd.setAlwaysOnTop(true);
                            jd.setModal(true);
                            jd.setLocationRelativeTo(null);
                            jd.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowGainedFocus(WindowEvent e) {
                                }
                                @Override
                                public void windowLostFocus(WindowEvent e) {
                                    jd.setVisible(false);
                                    jd.dispose();
                                }
                            });
                            jb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    jd.dispose();
                                }
                            });
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                });
            }break;
            case 8 :{
                JLabel jl = new JLabel("输入人员编号进行查询");
                jl.setFont(font1);
                JTextField jt = new JTextField();
                jt.setPreferredSize(new Dimension(250,30));
                JButton jb = new JButton("确定");
                JPanel jp = new JPanel();
                jp.add(jl);jp.add(jt);jp.add(jb);
                c.add(jp);
                fr.setSize(300,200);
                fr.setLocationRelativeTo(null);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String num = jt.getText();
                        Vector rowData,columnNames;
                        sql = "SELECT * FROM 历史操作记录表 WHERE 人员编号 = "+num+" AND 操作类型 = '记录考核'";
                        try {
                            columnNames = new Vector();
                            PreparedStatement stmt1 = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet res = stmt1.executeQuery(sql);
                            columnNames.add("流水编号");columnNames.add("操作类型");columnNames.add("原始信息");columnNames.add("更新信息");
                            columnNames.add("变更次数");columnNames.add("变更日期");columnNames.add("人员编号");
                            rowData = new Vector();
                            while(res.next()){
                                Vector v = new Vector();
                                v.add(res.getString(1));
                                v.add(res.getString(2));
                                v.add(res.getString(3));
                                v.add(res.getString(4));
                                v.add(res.getString(5));
                                v.add(res.getString(6));
                                v.add(res.getString(7));
                                rowData.add(v);
                            }
                            JTable t = new JTable(rowData,columnNames);
                            JScrollPane scrollPane = new JScrollPane(t);
                            JPanel jp = new JPanel();
                            JDialog jd = new JDialog();
                            jd.setTitle("考核历史查询");
                            jd.setLayout(new BorderLayout());
                            jd.add(scrollPane,BorderLayout.CENTER);
                            jd.setSize(800,300);
                            jd.setVisible(true);
                            jd.setAlwaysOnTop(true);
                            jd.setModal(true);
                            jd.setLocationRelativeTo(null);
                            jd.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowGainedFocus(WindowEvent e) {
                                }
                                @Override
                                public void windowLostFocus(WindowEvent e) {
                                    jd.setVisible(false);
                                    jd.dispose();
                                }
                            });
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                });
            }break;
            case 9 :{
                JLabel jl0 = new JLabel("请输入人员编号:");
                JLabel jl1 = new JLabel("请输入劳资分配结果:");
                jl0.setFont(font1);jl1.setFont(font1);
                JTextField jt0 = new JTextField();
                JTextField jt1 = new JTextField();
                jt0.setPreferredSize(new Dimension(250,30));
                jt1.setPreferredSize(new Dimension(250,30));
                JButton jb = new JButton("确定");
                JPanel jp = new JPanel();
                jp.add(jl0);jp.add(jt0);jp.add(jl1);jp.add(jt1);jp.add(jb);
                c.add(jp);
                fr.setSize(300,200);
                fr.setLocationRelativeTo(null);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String num = jt0.getText();
                        String value = jt1.getText();
                        sql = "UPDATE `人事管理系统`.`人员信息表` SET 薪酬 = "+"'"+value + "' where 编号 = "+num+"";
                        String otype = null;
                        int changecount;
                        String changedata;
                        String sql1 = "SELECT 薪酬 FROM 人员信息表 WHERE 编号 = "+num+"";
                        String sql2 = "SELECT 原始信息 FROM 历史操作记录表 WHERE 人员编号 = "+num+"";
                        PreparedStatement stmt1 = null;
                        try {
                            PreparedStatement stmt = con.prepareStatement(sql1, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            PreparedStatement stmt2 = con.prepareStatement(sql2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            stmt1 = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet res = stmt.executeQuery();
                            ResultSet rs = stmt2.executeQuery();
                            while (res.next()) {
                                otype = res.getString(1);
                            }
                            rs.last();
                            changecount = Integer.parseInt(String.valueOf(rs.getRow())) + 1;
                            Date date = new Date();
                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                            changedata = formatter.format(date);
                            stmt1.executeUpdate();
                            String sql3 = "INSERT INTO `历史操作记录表` VALUES (?,?,?,?,?,?,?)";
                            PreparedStatement ps = con.prepareStatement(sql3);
                            CreateNewFrame CNW = new CreateNewFrame();
                            String nums = String.valueOf((CNW.getDiaoDongRowCount()+1));
                            String type = "记录劳资分配";
                            ps.setString(1,nums);ps.setString(2,type);ps.setString(3,otype);ps.setString(4,value);
                            ps.setString(5, String.valueOf(changecount));ps.setString(6,changedata);ps.setString(7,num);
                            ps.executeUpdate();
                            JDialog jd = new JDialog();
                            jd.setTitle("成功");
                            JLabel lbl = new JLabel("记录成功");
                            JButton jb = new JButton("确定");
                            JPanel  jp = new JPanel();
                            lbl.setFont(font1);
                            jp.add(lbl);jp.add(jb);
                            jd.add(jp);
                            jd.setSize(100,100);
                            jd.setVisible(true);
                            jd.setAlwaysOnTop(true);
                            jd.setModal(true);
                            jd.setLocationRelativeTo(null);
                            jd.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowGainedFocus(WindowEvent e) {
                                }
                                @Override
                                public void windowLostFocus(WindowEvent e) {
                                    jd.setVisible(false);
                                    jd.dispose();
                                }
                            });
                            jb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    jd.dispose();
                                }
                            });
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                });
            }break;
            case 10 :{
                JLabel jl = new JLabel("输入人员编号进行查询");
                jl.setFont(font1);
                JTextField jt = new JTextField();
                jt.setPreferredSize(new Dimension(250,30));
                JButton jb = new JButton("确定");
                JPanel jp = new JPanel();
                jp.add(jl);jp.add(jt);jp.add(jb);
                c.add(jp);
                fr.setSize(300,200);
                fr.setLocationRelativeTo(null);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String num = jt.getText();
                        Vector rowData,columnNames;
                        sql = "SELECT * FROM 历史操作记录表 WHERE 人员编号 = "+num+" AND 操作类型 = '记录劳资分配'";
                        try {
                            columnNames = new Vector();
                            PreparedStatement stmt1 = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                            ResultSet res = stmt1.executeQuery(sql);
                            columnNames.add("流水编号");columnNames.add("操作类型");columnNames.add("原始信息");columnNames.add("更新信息");
                            columnNames.add("变更次数");columnNames.add("变更日期");columnNames.add("人员编号");
                            rowData = new Vector();
                            while(res.next()){
                                Vector v = new Vector();
                                v.add(res.getString(1));
                                v.add(res.getString(2));
                                v.add(res.getString(3));
                                v.add(res.getString(4));
                                v.add(res.getString(5));
                                v.add(res.getString(6));
                                v.add(res.getString(7));
                                rowData.add(v);
                            }
                            JTable t = new JTable(rowData,columnNames);
                            JScrollPane scrollPane = new JScrollPane(t);
                            JPanel jp = new JPanel();
                            JDialog jd = new JDialog();
                            jd.setTitle("劳资历史查询");
                            jd.setLayout(new BorderLayout());
                            jd.add(scrollPane,BorderLayout.CENTER);
                            jd.setSize(800,300);
                            jd.setVisible(true);
                            jd.setAlwaysOnTop(true);
                            jd.setModal(true);
                            jd.setLocationRelativeTo(null);
                            jd.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowGainedFocus(WindowEvent e) {
                                }
                                @Override
                                public void windowLostFocus(WindowEvent e) {
                                    jd.setVisible(false);
                                    jd.dispose();
                                }
                            });
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                });
            }break;
            default :{
            }
        }
        fr.setVisible(true);
        fr.setResizable(false);
    }
    public Vector getbumenrowdata(){
        Vector rowData = new Vector();
        String sqls = "SELECT 部门 FROM `部门管理表`";
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet res = stmt.executeQuery(sqls);
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getString(1));
                rowData.add(v);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowData;
    }
    public int getDiaoDongRowCount(){
        int rowcount = 0;
        String sqls = "SELECT * FROM `历史操作记录表`";
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet res = stmt.executeQuery(sqls);
            res.last();
            rowcount = Integer.parseInt(String.valueOf(res.getRow()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowcount;
    }
}