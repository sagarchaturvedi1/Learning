package org.anaphora;

import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;

public class Pairs {
	
	private Map<String, String> words;

	
	public Map<String, String> getWords() {
		return words;
	}

	public void setWords(Map<String, String> words) {
		this.words = words;
	}

	@Override
	public String toString() {
		StringBuilder pairs = new StringBuilder();
		if(null != words && !words.isEmpty()) {
			for (String key : words.keySet()) {
				pairs.append("(").append(key).append(",").append(words.get(key)).append(")").append(",");
			}
		}
		return StringEscapeUtils.escapeCsv(pairs.toString());
		
	}

	public Pairs(Map<String,String> words) {
		super();
		this.words = words;
	}

}
