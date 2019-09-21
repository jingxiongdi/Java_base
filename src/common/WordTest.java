package common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;

public class WordTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
//			InputStream is = new FileInputStream("C:\\Users\\tangjing\\Desktop\\test.doc"); 
//			HWPFDocument doc = new HWPFDocument(is); 
//			Range range = (Range) doc.getRange(); 
//			System.out.println(range.text());
//			range.insertAfter("aaaaawwwwwwwwwwwwwwwqqqqqqqqqqqzzzzzzzzzzsssssssssssaaaaaaaaaaaaffffff"+"\n");//在文件末尾插入String
//			System.out.println("=======================================");
//			System.out.println(range.text());
//			OutputStream os = new FileOutputStream("C:\\Users\\tangjing\\Desktop\\testcopy.doc"); 
//			doc.write(os); 
//			is.close(); 
//			os.close(); 
			
			
			 //新建一个文档
//		      XWPFDocument doc = new XWPFDocument();
//		      //创建一个段落
//		      XWPFParagraph para = doc.createParagraph();
//		     
//		      //一个XWPFRun代表具有相同属性的一个区域。
//		      XWPFRun run = para.createRun();
//		      run.setBold(true); //加粗
//		      run.setText("加粗的内容");
//		      run = para.createRun();
//		      run.setColor("FF0000");
//		      run.setText("红色的字。");
//		      OutputStream os = new FileOutputStream("D:\\simpleWrite.docx");
//		      //把doc输出到输出流
//		      doc.write(os);
//		      this.close(os);

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
