package webStreaming;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class htmlCleaner {

	private Document webDoc;
	private DataModel dataModel;


	public htmlCleaner() {
		webDoc = null;
		dataModel = new DataModel();
		

	}

	/*
	 * private static String trim(String s, int width) { if (s.length() > width)
	 * return s.substring(0, width - 1) + "."; else return s; }
	 */
	public DataModel clean(String PageUrl) {
		try {

			Document document = Jsoup.connect(PageUrl).get();

			/*
			 * Elements links = document.select("a[href]"); Elements media =
			 * document.select("[src]"); Elements imports = document.select("link[href]");
			 * 
			 * for (Element link : links) { System.out.println(link.attr("abs:href") +
			 * trim(link.text(), 35)); }
			 * 
			 */
			webDoc = Jsoup.parse(document.html());
			dataModel.setTitle(webDoc.title());
			String temp = webDoc.text();

			temp = temp.replaceAll(",", " ");
			temp = temp.replaceAll("/n", " ");

			dataModel.setData(temp);

			return dataModel;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
}
