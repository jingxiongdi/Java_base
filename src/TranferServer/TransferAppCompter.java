package TranferServer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class TransferAppCompter {
	private static JFrame jf ;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createCompterUI();
	}

	private static void createCompterUI() {
		// TODO Auto-generated method stub
		jf = new JFrame("景兄弟wifi快传（JAVA版）V1.0"); // 创建窗口
		jf.setSize(500, 400); // 设置窗口大小
		jf.setLocationRelativeTo(null); // 把窗口位置设置到屏幕中心
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）

		// 2. 创建中间容器（面板容器）
		final JPanel panel = new JPanel(); // 创建面板容器，使用默认的布局管理器
		panel.setLayout(null);

		JButton btnEnterClient = new JButton("进入客户端");
		btnEnterClient.setBounds(140, 50, 200, 80);
		panel.add(btnEnterClient);
		btnEnterClient.addActionListener(clientClickListener);

		JButton btnEnterServer = new JButton("进入服务器");
		btnEnterServer.setBounds(140, 180, 200, 80);
		panel.add(btnEnterServer);
		btnEnterServer.addActionListener(serverClickListener);

		jf.setContentPane(panel);
		// 5. 显示窗口，前面创建的信息都在内存中，通过 jf.setVisible(true) 把内存中的窗口显示在屏幕上。
		jf.setVisible(true);
	}
	
	private static ActionListener clientClickListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("client btn clicked...");
			jf.dispose();//销毁主界面
			ClientUI.createClientUI();//进入客户端界面
		}
	};
	
	private static ActionListener serverClickListener = new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("server btn clicked...");
			jf.dispose();//销毁主界面
			MainUI.createUI();//进入服务器界面
		}
	};

}
