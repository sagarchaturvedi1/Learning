package org.anaphora;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NewsFetcher {
	
	public static Map<String,String> getNews(String url) throws IOException {
		Map<String,String> news = new HashMap<String, String>();
		Document document = Jsoup.connect(url).get();
		Elements title = document.getElementsByClass(AnaphoraResolverMain.properties.getProperty("titleClass"));
		Elements text = document.getElementsByClass(AnaphoraResolverMain.properties.getProperty("textClass"));
		news.put("Title", title.text().trim());
		news.put("Post", text.text().trim());
		return news;
	}


}
