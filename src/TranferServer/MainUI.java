package TranferServer;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import TranferServer.TestSocket.SocketTast;

public class MainUI {
	private static Socket clientSocket = null;
	private static StringBuilder sBuilder = new StringBuilder(); 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createUI();
	}

	public static void createUI() {
		// TODO Auto-generated method stub
		// 1. 创建一个顶层容器（窗口）
        final JFrame jf = new JFrame("景兄弟wifi快传服务端（JAVA版）");          // 创建窗口
        jf.setSize(500, 400);                       // 设置窗口大小
        jf.setLocationRelativeTo(null);             // 把窗口位置设置到屏幕中心
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）
        
        // 2. 创建中间容器（面板容器）
        final JPanel panel = new JPanel();                // 创建面板容器，使用默认的布局管理器
        panel.setLayout(null);
        // 3. 创建一个基本组件（按钮），并添加到 面板容器 中
        final JTextField jtf = new JTextField(10);
        jtf.setBounds(0, 0, 100, 30);
        panel.add(jtf);
        
        JButton btn = new JButton("发送给客户端");
        btn.setBounds(110, 0, 130, 30);
        panel.add(btn);
        
        JButton btnFile = new JButton("小文件发送");
        btnFile.setBounds(250,0, 100,30);
        btnFile.addActionListener(sendFileListener);
        panel.add(btnFile);
        // 4. 把 面板容器 作为窗口的内容面板 设置到 窗口
       
        JTextArea jta = new JTextArea(10,30);
        jta.setBounds(5, 50, 400, 400);
        panel.add(jta);
        
        jf.setContentPane(panel);
        // 5. 显示窗口，前面创建的信息都在内存中，通过 jf.setVisible(true) 把内存中的窗口显示在屏幕上。
        jf.setVisible(true);
        btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				String msg = jtf.getText();
				System.out.println("====="+msg);
				if(msg!=null){
					TestSocket.sendMsgToClient(msg);
					FileUtils.writeServerRecord(msg);
					jtf.setText("");
				}
			}
		});
        startServer();
        
       
	}
	
	static ActionListener sendFileListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("发送文件");
			 JFileChooser jfc=new JFileChooser();  
		     jfc.setFileSelectionMode(JFileChooser.FILES_ONLY );  
		     jfc.showDialog(new JLabel(), "选择");
		     final File selectedFile = jfc.getSelectedFile();
		     System.out.println(selectedFile.getAbsolutePath());
		     new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try{
						byte[] data = FileUtils.toByteArray(selectedFile.getAbsolutePath());
						TestSocket.sendMsgToClient("start tranfer small file");
						TestSocket.sendSmallFileToClient(data);
					//	TestSocket.sendMsgToClient("end tranfer small file");
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}).start();
		}
	};

	private static void startServer() {
		// TODO Auto-generated method stub
		 //启动socket服务
	       try{
	           final ServerSocket server = new ServerSocket(8888);
	           System.out.println("服务器已经启动" + server);
	           while(true){
	               // 服务器接收到链接进来的客户端
	        	   clientSocket = server.accept();
	        	   FileUtils.writeServerRecord("有客户端链接进来" + clientSocket);
	               System.out.println("有客户端链接进来" + clientSocket);
	               new Thread(new SocketTast(clientSocket)).start();
	           }
	       }catch (IOException e){
	           e.printStackTrace();
	       }
	}

}
