package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyFileUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		copyFile("D:\\360安全浏览器下载\\EditPlus3_ha.zip","D:\\360安全浏览器下载\\ee.zip");
	}
	
	private static void copyFile(final String srcPath,final String targetPath){
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(new Runnable() {
			
			public void run() {
				// TODO Auto-generated method stub
				FileInputStream fis = null;
				FileOutputStream fos = null;
				
				FileChannel in = null;
				FileChannel out = null;
				
				try {
					fis = new FileInputStream(new File(srcPath));
					File targetFile = new File(targetPath);
					if(!targetFile.exists()){
						targetFile.createNewFile();
					}
					fos = new FileOutputStream(targetFile);
					
					in = fis.getChannel();
					out = fos.getChannel();
					
					out.transferFrom(in, 0, in.size());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					
					try {
						fis.close();
						fos.close();
						in.close();
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		
	}

}
