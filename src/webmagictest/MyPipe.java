package webmagictest;

import java.util.Map;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class MyPipe implements Pipeline{

	public void process(ResultItems arg0, Task arg1) {
		// TODO Auto-generated method stub
		System.out.println(arg0.getAll());
		
	}

}
