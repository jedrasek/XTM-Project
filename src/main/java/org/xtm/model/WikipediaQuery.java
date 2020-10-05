package org.xtm.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WikipediaQuery {
	
	@JsonProperty("search")
	private List<WikipediaSearch> wikipediaSearchList;
	@JsonProperty("searchinfo")
	private WikipediaSearchInfo searchinfo;

	public List<WikipediaSearch> getWikipediaSearchList() {
		return wikipediaSearchList;
	}

	public void setWikipediaSearchList(List<WikipediaSearch> wikipediaSearchList) {
		this.wikipediaSearchList = wikipediaSearchList;
	}

	public WikipediaSearchInfo getSearchinfo() {
		return searchinfo;
	}

	public void setSearchinfo(WikipediaSearchInfo searchinfo) {
		this.searchinfo = searchinfo;
	}
	
	
}
