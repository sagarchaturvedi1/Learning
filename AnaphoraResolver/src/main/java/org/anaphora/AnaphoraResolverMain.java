package org.anaphora;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.google.common.collect.HashBasedTable;

import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefChain.CorefMention;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

public class AnaphoraResolverMain {

	public static Properties properties = new Properties();
	private static int serialNumber = 0;
	private static List<String> results = new ArrayList<String>();

	static {
		try {
			properties.load(new FileReader("config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		String url = properties.getProperty("NewsURL");
		//Map<String, String> news = NewsFetcher.getNews(url);
		
		 Map<String,String> news = new HashMap<String, String>();
		 news.put("Title",
		 "Bernie Sanders Again Links Low Wages With Immigration");
		 news.put("Post",
		"Senator Bernie Sanders addressed the hot-button topic of immigration for the second day in a row on Thursday, saying at a Hispanic Chamber of Commerce event that lower wages were tethered to an influx of immigrants. Bernie Sanders Again Links Low Wages With Immigration. ");

		for (String key : news.keySet()) {
			generateCoref(url, key, news.get(key));
		}

		CsvFileWriter.writeCsvFile(results);
	}

	private static void generateCoref(String url, String key, String value) {

		StanfordCoreNLP pipeline = StanfordNLPAdaptor.getPipeline();
		HashBasedTable<Integer, String, String> hbt = HashBasedTable.create();

		Annotation document = new Annotation(value);
		pipeline.annotate(document);

		// This is the coreference link graph
		Map<Integer, CorefChain> graph = document
				.get(CorefChainAnnotation.class);
		
		List<CoreMap> sentences = document.get(SentencesAnnotation.class);

		for (Integer clusterId : graph.keySet()) {

			CorefChain corefChain = graph.get(clusterId);

			List<CorefMention> cm = corefChain.getMentionsInTextualOrder();

			for (int i = 0; i < cm.size(); i++) {
				if (cm.get(i).animacy.toString().equals("ANIMATE")) {
					CorefMention corefMention = cm.get(i);
					for (int j = 0; j < cm.size(); j++) {
						if (cm.get(j).animacy.toString().equals("ANIMATE")) {
							CorefMention corefMention1 = cm.get(j);
							hbt.put(corefMention1.sentNum,
									corefMention.mentionSpan,
									corefMention1.mentionSpan);
						}
					}
				}
			}

		}

		for (int i = 1; i <= sentences.size(); i++) {
			serialNumber++;
			String sentence = sentences.get(i - 1).toString();
			Map<String, String> pairs = hbt.row(i);

			CorefRow corefRow = new CorefRow(serialNumber, url, sentence, key,
					new Pairs(pairs));
			results.add(corefRow.toString());
		}
	}

}
