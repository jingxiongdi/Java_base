//package webmagictest;
//
//import java.awt.Container;
//import java.awt.Frame;
//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.net.URL;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import org.apache.commons.io.IOUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.bianqi.song.music.wangyi.Song163;
//
//public class MainGui {
//	public static void main(String[] args) {
//		new MainFrame("解析+下载网易音乐");
//    }
//}
//class MainFrame extends JFrame{
// 
//    private static final long serialVersionUID = -5115488791553705781L;
//    JDialog jDialog = null;
//    JMenuBar mb = null;
//    JMenu m = null;
//    JMenu m1 = null;
//    JMenuItem closeItem = null;
//    JMenuItem aboutItem = null;
//    JMenuItem useItem = null;
//    JLabel lbl1 = null;
//    JLabel lbl2 = null;
//    JLabel bll3 = null;
//    JTextField txt = null;
//    JTextField txt2 = null;
//    JButton btn1 = null;
//    JButton btn2 = null;
//    ImageIcon img = null;
//    JLabel imgLabel = null;
//    Container contain = null;
//    Frame frame = this;
//    public MainFrame(String title) {
//        this.init(title);
//    }
//     
//    public void init(String title){
//        Toolkit t = Toolkit.getDefaultToolkit();
//        Image i = t.getImage("title.png");
//        this.setIconImage(i);
//        this.setVisible(true);
//        this.setLocation(400, 200);
//        this.setSize(850, 120);
//        this.setTitle(title);
//        this.setResizable(false);
//        mb =new JMenuBar();//创建菜单栏
//        m = new JMenu("开始");//创建“文件”菜单    
//        m1 = new JMenu("关于");
//        closeItem = new JMenuItem("退出");//创建“退出"菜单项
// 
//        closeItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int showConfirmDialog = JOptionPane.showConfirmDialog(frame, "你确定退出?", "退出", 
//
//JOptionPane.YES_NO_OPTION); 
//                if(showConfirmDialog != 1){
//                    System.exit(0);
//                }
//            }
//        });
//         
//        aboutItem =new JMenuItem("关于");
//        aboutItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(frame, "      开发者软件BQ", "关于", 
//
//JOptionPane.INFORMATION_MESSAGE); 
//            }
//        });
//         
//        useItem = new JMenuItem("使用说明");
//        useItem.addActionListener(new ActionListener() {
//             
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(frame, "粘贴网易云音乐播放URL点击解析或者下载即可！比如播放
//
//url http://music.163.com/#/song?id=63650 ", "使用说明", JOptionPane.INFORMATION_MESSAGE);
//            }
//        });
//         
//        m.add(closeItem);//将“退出”菜单项添加到“文件”菜单上
//        m1.add(useItem);
//        m1.add(aboutItem);
//        mb.add(m);//将文件添加到菜单栏上
//        mb.add(m1);
//        this.setJMenuBar(mb);//将此窗体的菜单栏设置为指定的菜单栏。
//         
//        //网易
//        lbl1 = new JLabel("网易云播放页面URL:"); 
//        lbl1.setBounds(10, 11, 120, 30);
//        lbl2 = new JLabel("解析后的地址:"); 
//        lbl2.setBounds(380, 11, 120, 30);
//        txt = new JTextField(10); 
//        txt.setBounds(130,11, 240, 25);
//        txt2 = new JTextField(10);
//        txt2.setBounds(490, 11, 150, 25);
//        btn1 = new JButton("解析");
//        btn1.setBounds(680, 10, 60, 30);
//        btn2 = new JButton("下载");
//        btn2.setBounds(750, 10, 60, 30);
//         
//        //整个的背景图片
//        img = new ImageIcon("timg.jpg");  
//        imgLabel = new JLabel(img);  
//        this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));  
//        imgLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());  
//        contain = this.getContentPane();  
//        ((JPanel) contain).setOpaque(false);   
//        contain.setLayout(null);
//         
//        contain.add(txt);  
//        contain.add(txt2);
//        contain.add(lbl1);
//        contain.add(lbl2);  
//        contain.add(btn1);
//        contain.add(btn2);
//         
//        /**
//         *解析
//         */
//        btn1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String text = txt.getText();
//                if(StringUtils.isNotBlank(text)){
//                    try {
//                        String url = Song163.resolve(text);
//                        if(url.equals("xxoo")){
//                            JOptionPane.showMessageDialog(frame, "解析失败了!!你确定你的URL拷贝
//
//对了吗?", "握草", JOptionPane.ERROR_MESSAGE);
//                        }else{
//                            txt2.setText(url);
//                        }
//                    } catch (Exception e1) {
//                        JOptionPane.showMessageDialog(frame, "解析失败了!!你确定你的URL拷贝对了
//
//吗?", "握草", JOptionPane.ERROR_MESSAGE);
//                    }
//                }else{
//                    JOptionPane.showMessageDialog(frame, "            SB URL呢??", "握草", 
//
//JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        });
//         
//        //下载！
//        btn2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String text = txt.getText();
//                try {
//                    String url2 = Song163.resolve(text);
//                    if(StringUtils.isNotBlank(text) && !url2.equals("xxoo")){
//                        JFileChooser jfc = new JFileChooser();
//                        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//                        jfc.showDialog(new JLabel(), "选择目录");
//                        File file=jfc.getSelectedFile();
//                        String dir = file.getAbsolutePath();
//                        // 开通IO流下载
//                        try {
//                            String url = Song163.resolve(text);
//                            InputStream openStream = new URL(url).openStream();
//                            File file1 = new File(dir+Song163.songTitle(text)+".mp3");
//                            if(!file1.exists()){
//                                file1.createNewFile();
//                            }
//                            FileOutputStream output = new FileOutputStream(file1);
//                            IOUtils.copy(openStream, output);
//                            if(file1.length() > 0){
//                                JOptionPane.showMessageDialog(frame, "下载成功!", "恭喜", 
//
//JOptionPane.INFORMATION_MESSAGE);
//                            }
//                        } catch (Exception e1) {
//                            e1.printStackTrace();
//                            JOptionPane.showMessageDialog(frame, "居然下载失败了 可能是C盘没有
//
//写权限或者是网络存在问题或者是你拷贝错了URL", "握草", JOptionPane.ERROR_MESSAGE);
//                        }
//                    }else{
//                        JOptionPane.showMessageDialog(frame, "URL没有输入或者你的URL输入有问题!", "
//
//握草", JOptionPane.ERROR_MESSAGE);
//                    }
//                } catch (Exception e2) {
//                      JOptionPane.showMessageDialog(frame, "你确定你的URL拷贝对了吗?", "握草", 
//
//JOptionPane.ERROR_MESSAGE);
//                }
//            }
//        });
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//        this.setVisible(true); 
//    }
//}
