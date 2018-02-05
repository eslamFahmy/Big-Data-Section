package retrofit;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import webStreaming.DataModel;
import webStreaming.FileRead;
import webStreaming.htmlCleaner;

public class api {

	private FileRead fileRead = new FileRead();;

	public int Search() {

		Elements links;
		
		
		try {

			if (Config.search == null && Config.search.length() <= 0) {
				return -1;
			}

			if (Config.optmizationSearch != null && Config.optmizationSearch.length() > 0) {
				Config.search = Config.search + Config.optmizationSearch;
			}

			links = Jsoup.connect(Config.google + URLEncoder.encode(Config.search, Config.charset))
					.userAgent(Config.userAgent).get().select(".g>.r>a");

			for (Element link : links) {
				
				String url = link.absUrl("href"); // Google returns URLs in format
													// "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
				url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

				if (!url.startsWith("http")) {
					continue; // Ads/news/etc.
				}

				// System.out.println("Title: " + title);
				// System.out.println("URL: " + url);

				htmlCleaner cleaner = new htmlCleaner();
				DataModel dataModel = cleaner.clean(url);

				if (dataModel == null)
					continue;

				fileRead.writeData(url, dataModel.getData());

			}

			return 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
