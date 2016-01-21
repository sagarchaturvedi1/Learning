package org.anaphora;

import org.apache.commons.lang3.StringEscapeUtils;

public class CorefRow {
	
	private int serialNumber;
	private String url;
	private String sentence;
	private String location;
	private Pairs pairs;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSentence() {
		return sentence;
	}
	public void setSentence(String sentence) {
		this.sentence = sentence;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public CorefRow(int serialNumber, String url, String sentence,
			String location, Pairs pairs) {
		super();
		this.serialNumber = serialNumber;
		this.url = url;
		this.sentence = sentence;
		this.location = location;
		this.pairs = pairs;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
    	result.append(serialNumber).append(",").append(url).append(",").append(StringEscapeUtils.escapeCsv(sentence)).
    		append(",").append(location).append(",").append(pairs);
		return result.toString();
	}
	
	

}
