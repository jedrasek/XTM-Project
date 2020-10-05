package org.xtm.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WikipediaSearch {
	
	@JsonProperty("ns")
	private int ns;
	@JsonProperty("title")
	private String title;
	@JsonProperty("pageid")
	private Long pageid;
	@JsonProperty("size")
	private Long size;
	@JsonProperty("wordcount")
	private Long wordcount;
	@JsonProperty("snippet")
	private String snippet;
	@JsonProperty("timestamp")
	private Timestamp timestamp;
	
	
	public int getNs() {
		return ns;
	}
	public void setNs(int ns) {
		this.ns = ns;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPageid() {
		return pageid;
	}
	public void setPageid(Long pageid) {
		this.pageid = pageid;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public Long getWordcount() {
		return wordcount;
	}
	public void setWordcount(Long wordcount) {
		this.wordcount = wordcount;
	}
	public String getSnippet() {
		return snippet;
	}
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	

}
