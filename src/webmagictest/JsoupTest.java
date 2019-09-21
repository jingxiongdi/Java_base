package webmagictest;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class JsoupTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = Jsoup.connect("http://blog.csdn.net/qq_30581017");

        try {
            Document document = connection.timeout(100000).get();

            //包含所有列表的文章
            Elements elements = document.getElementsByClass("list").first().children();
            for (Element element : elements) {
              //link_title下元素所有的元素
               Elements list_item = element.getElementsByClass("link_title").first().children();

                for (Element elementEach : list_item) {

                        String path = elementEach.attr("href");

                        String text = elementEach.html();

                    System.out.println(path + " -> " + text);
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

	}

}
