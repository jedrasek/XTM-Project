package org.xtm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WikipediaSearchInfo {
	
	@JsonProperty("totalhits")
	private Long totalhits;

	public Long getTotalhits() {
		return totalhits;
	}

	public void setTotalhits(Long totalhits) {
		this.totalhits = totalhits;
	}
	
}
