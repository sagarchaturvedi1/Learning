package org.anaphora;

import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class StanfordNLPAdaptor {
	
	private static StanfordCoreNLP pipeline = null;
	
	
	public static StanfordCoreNLP getPipeline() {
		if(null==pipeline) {
			Properties props = new Properties();
	        props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
	        props.put("dcoref.score", true);
	        pipeline = new StanfordCoreNLP(props);
		}
		return pipeline;
	}

}
