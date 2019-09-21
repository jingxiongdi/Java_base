package TranferServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSocket {
	private static OutputStream outputStream = null;

//   public static void main(String[] args){
//       //启动socket服务
//       try{
//           final ServerSocket server = new ServerSocket(8888);
//           System.out.println("服务器已经启动" + server);
//           while(true){
//               // 服务器接收到链接进来的客户端
//               Socket socket = server.accept();
//               System.out.println("有客户端链接进来" + socket);
//               new Thread(new SocketTast(socket)).start();
//           }
//       }catch (IOException e){
//           e.printStackTrace();
//       }
//
//   }

   static class SocketTast implements Runnable{

       private Socket socket;

       public SocketTast(Socket socket){
           this.socket = socket;
       }

       @Override
       public void run(){
           try {

               while (true) {
                   // 处理接收到的数据
                   // 获取输入流，打印客户端信息
                   InputStream inputStream = socket.getInputStream();
                   InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                   BufferedReader in = new BufferedReader(inputStreamReader);
                   String getinput = in.readLine();
                   if(getinput != null){
                	   FileUtils.writeServerRecord(getinput);
                       System.out.println(socket + ":" + getinput);
                       getinput = null;
                   }
                   if(outputStream==null){
                	   outputStream = socket.getOutputStream();
                	   FileUtils.writeServerRecord("欢迎光临景兄弟服务器");
                	   sendMsgToClient("欢迎光临景兄弟服务器");
                   }
           
                  
                   
               }
           }catch (IOException e){
               e.printStackTrace();
           }
       }
   }
   
   public static void sendMsgToClient(String msg){
	   try {
		outputStream.write(new String("服务器:"+msg+"\n").getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public static void sendSmallFileToClient(byte[] file){
	   try {
		outputStream.write(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
}

