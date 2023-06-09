package net.derviol;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame {
    public void CreateFrame(){
        JFrame jf = new JFrame();
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("img\\draw0.jpg");
        jf.setIconImage(img);
        jf.setTitle("人事管理系统");
        jf.setSize(800,600);
        JLabel WelcomeLabel = new JLabel("欢迎使用人事管理系统");
        Font font = new Font("仿宋", Font.PLAIN, 30);
        WelcomeLabel.setFont(font);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container c = jf.getContentPane();
        jf.setLayout(null);
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JPanel jp3 = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.GRAY, 1, false);

        jp1.setBorder(border);
        jp1.setForeground(Color.white);
        jp1.setLayout(null);

        jp2.setBorder(border);
        jp2.setLayout(null);

        // 创建根节点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("人事管理系统");
        // 创建一级子节点
        DefaultMutableTreeNode root1 = new DefaultMutableTreeNode("基本信息管理");
        DefaultMutableTreeNode root2 = new DefaultMutableTreeNode("人员调动管理");
        DefaultMutableTreeNode root3 = new DefaultMutableTreeNode("人员考核管理");
        DefaultMutableTreeNode root4 = new DefaultMutableTreeNode("劳资管理");
        // 创建二级子节点
        DefaultMutableTreeNode root11 = new DefaultMutableTreeNode("添加人员信息");
        DefaultMutableTreeNode root12 = new DefaultMutableTreeNode("修改人员信息");
        DefaultMutableTreeNode root13 = new DefaultMutableTreeNode("删除人员信息");
        DefaultMutableTreeNode root14 = new DefaultMutableTreeNode("查询人员信息");
        DefaultMutableTreeNode root15 = new DefaultMutableTreeNode("部门管理");

        DefaultMutableTreeNode root21 = new DefaultMutableTreeNode("人员调动");
        DefaultMutableTreeNode root22 = new DefaultMutableTreeNode("调动历史查询");

        DefaultMutableTreeNode root31 = new DefaultMutableTreeNode("人员考核");
        DefaultMutableTreeNode root32 = new DefaultMutableTreeNode("考核历史查询");

        DefaultMutableTreeNode root41 = new DefaultMutableTreeNode("劳资分配管理");
        DefaultMutableTreeNode root42 = new DefaultMutableTreeNode("劳资历史查询");
        // 根节点添加一级子节点
        root.add(root1);
        root.add(root2);
        root.add(root3);
        root.add(root4);
        // 一级子节点添加二级子节点
        root1.add(root11);
        root1.add(root12);
        root1.add(root13);
        root1.add(root14);
        root1.add(root15);

        root2.add(root21);
        root2.add(root22);

        root3.add(root31);
        root3.add(root32);

        root4.add(root41);
        root4.add(root42);


        JTree tree = new JTree(root);
        jp2.add(WelcomeLabel);
        jp1.setBounds(5,10,151,541);
        c.add(jp1);
        jp1.add(tree);
        tree.setBounds(1,1,149,539);
        jp2.setBounds(160,10,620,541);
        WelcomeLabel.setBounds(160,10,1000,100);
        c.add(jp2);

        jf.setVisible(true);
        jf.setResizable(false);

        /*查了好久，发现JTree对象有一个非常实用的的方法getPathForLocation()
        能够根据指定的坐标点来获取点击的那个结点在树中的逻辑路径TreePath对象。有
        了这个方法就不需要去手工判断点击的位置处是哪个对象了。获得了TreePath路径
        对象后，就可以使用它的getLastPathComponent()获取这棵树上这条路径上的最
        后一个组件了，还是强制转换成结点类型然后做操作就可以了。实际使用时，双击事
        件也往往只需要去捕获叶子结点的，只要和前面一样做一个isLeaf()判断就可以了，
        我这里没写。需要注意的是，对某些空白处双击时，还是属于在树上触发了双击事件，
        然而getPathForLocation()肯定获取不到路径了，返回的是一个null，在后面对
        这个对象的操作都必须包含在判断非null中才行，否则对null取成员方法显然是错误
        的。*/

        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if (e.getSource() == tree && e.getClickCount() == 2) {
                    TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
                    if (selPath != null){
                        //System.out.println(selPath);// 输出路径看一下
                        // 获取这个路径上的最后一个组件,也就是双击的地方
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) selPath.getLastPathComponent();
                        //System.out.println(node.toString());// 输出这个组件toString()的字符串看一下
                        if(node.toString() == "添加人员信息" || node.toString() == "修改人员信息" || node.toString() == "删除人员信息" || node.toString() == "查询人员信息" || node.toString() == "部门管理" || node.toString() == "人员调动" || node.toString() == "调动历史查询" || node.toString() == "人员考核" || node.toString() == "考核历史查询" || node.toString() == "劳资分配管理" || node.toString() == "劳资历史查询"){
                            CreateNewFrame cnf = new CreateNewFrame();
                            cnf.CreateNewFrame(node.toString());
                        }
                    }
                }
            }
        });
    }
}
