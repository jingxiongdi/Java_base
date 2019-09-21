package musicplayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import javazoom.jl.player.Player;

public class MusicPlayer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createUI();
	}

	private static void createUI() {
		// TODO Auto-generated method stub
		// 1. 创建一个顶层容器（窗口）
        final JFrame jf = new JFrame("JXD音乐播放器（JAVA版）");          // 创建窗口
        jf.setSize(500, 500);                       // 设置窗口大小
        jf.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）
        // 2. 创建中间容器（面板容器）
        final JPanel panel = new JPanel();                // 创建面板容器，使用默认的布局管理器
        // 3. 创建一个基本组件（按钮），并添加到 面板容器 中
        JButton btn = new JButton("选择文件");
        panel.add(btn);
        // 4. 把 面板容器 作为窗口的内容面板 设置到 窗口
        jf.setContentPane(panel);
        // 5. 显示窗口，前面创建的信息都在内存中，通过 jf.setVisible(true) 把内存中的窗口显示在屏幕上。
        jf.setVisible(true);
        
        
        //btn的监听点击事件
        btn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//创建一个文件选择器
				JFileChooser fd = new JFileChooser();
				fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//文件夹模式
		    	fd.showOpenDialog(null);
		    	File f = fd.getSelectedFile();
		    	if(f != null){
		    		//jf.dispose();//让窗体消失
		    		
		    		final ArrayList mp3List = new ArrayList();
		    		f.listFiles(new FileFilter() {
						
						public boolean accept(File file) {
							// TODO Auto-generated method stub
							if(file.getName().endsWith(".mp3")){
								mp3List.add(file);
						//		System.out.println("歌曲名称为："+file.getName());
							}
							return false;
						}
					});
		    		
		    		JOptionPane.showMessageDialog(panel, "一共扫描到"+mp3List.size()+"首歌曲！", "扫描文件夹",JOptionPane.WARNING_MESSAGE); //提示消息
		    		
		    		 DefaultListModel listModel1 =  new DefaultListModel();
		    		 for(int i=0;i<mp3List.size();i++){
		    			 File mp3File = (File) mp3List.get(i);
		    			 listModel1.addElement(mp3File.getName());
		    		 }
		    		 
		    		 JList jList1 = new JList(listModel1);
		    		
		    		 JScrollPane js = new JScrollPane(jList1);
		    		 //js.setBounds(50, 150, 800, 800);
		    		
		    		 panel.add(js);
		    		// panel.revalidate();
		    		 jf.setContentPane(panel);
		    	        // 5. 显示窗口，前面创建的信息都在内存中，通过 jf.setVisible(true) 把内存中的窗口显示在屏幕上。
		    	     jf.setVisible(true);
		    	     
		    	     jList1.addListSelectionListener(new ListSelectionListener(){

						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
							System.out.println("============ "+e.getLastIndex()+"  "+e.getValueIsAdjusting());
							if(e.getValueIsAdjusting()){
								 FileInputStream fis;
								try {
									fis = new FileInputStream((File) mp3List.get(e.getLastIndex()));
									 BufferedInputStream stream=new BufferedInputStream(fis);
								        Player player=new Player(stream);
								        player.play();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							       
						
							}
							
						}
		    	    	 
		    	     });
		    	}
			}
		});
        
        
	}

}
