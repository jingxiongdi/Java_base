package TranferServer;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {
	private static SimpleDateFormat sdfFile = new SimpleDateFormat("yyyy_MM_dd");
	private static SimpleDateFormat sdfMsg = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
	
	
	public static void writeServerRecord(String s){
		File recordFolder = new File("src/TranferServer/record");
		if(!recordFolder.exists()){
			//创建历史记录文件夹
			recordFolder.mkdirs();
		}
		
		File recordFile = new File("src/TranferServer/record/"+sdfFile.format(new Date())+".txt");
		
		try {
			if(!recordFile.exists()){
				//如果日志文件不存在,则创建日志文件
				recordFile.createNewFile();
			}
			
			s = sdfMsg.format(new Date())+" "+s+"\n";
			FileOutputStream fos = new FileOutputStream(recordFile,true);
			fos.write(s.getBytes());
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 /**
     * 将文件转成字节数组
     * @param filePath
     * @return
     */
    public static byte[] toByteArray(String filePath){

        ByteArrayOutputStream bos=null;
        BufferedInputStream in = null;
        try {
            File f = new File(filePath);
            if(f.exists()){
                in = new BufferedInputStream(new FileInputStream(f));
                bos = new ByteArrayOutputStream((int) f.length());

                int buf_size = 1024;
                byte[] buffer = new byte[buf_size];
                int len = 0;
                while (-1 != (len = in.read(buffer, 0, buf_size))) {
                    bos.write(buffer, 0, len);
                }
                //return bos.toByteArray();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                bos.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
        return bos.toByteArray();
    }

}
