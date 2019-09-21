package TranferServer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ClientUI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createClientUI();
	}

	public static void createClientUI() {
		// TODO Auto-generated method stub
		
		final JFrame jf = new JFrame("景兄弟wifi快传客户端（JAVA版）V1.0"); // 创建窗口
		jf.setSize(500, 400); // 设置窗口大小
		jf.setLocationRelativeTo(null); // 把窗口位置设置到屏幕中心
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）
		


		// 2. 创建中间容器（面板容器）
		final JPanel panel = new JPanel(); // 创建面板容器，使用默认的布局管理器
		panel.setLayout(null);
		
		JLabel hintLabel = new JLabel("请输入ip:");
		hintLabel.setBounds(0,5,80,30);
        panel.add(hintLabel);
		
        JTextField jtf = new JTextField(10);
        jtf.setBounds(90, 5, 100, 30);
        panel.add(jtf);

		JButton btnEnterClient = new JButton("连接服务器");
		btnEnterClient.setBounds(200, 5, 100, 30);
		panel.add(btnEnterClient);
		btnEnterClient.addActionListener(connectionActionListener);

		jf.setContentPane(panel);
		// 5. 显示窗口，前面创建的信息都在内存中，通过 jf.setVisible(true) 把内存中的窗口显示在屏幕上。
		jf.setVisible(true);
	}
	
	static ActionListener connectionActionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("btnEnterClient clicked");
			
		}
	};

}
