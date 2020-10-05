package org.xtm;

import org.springframework.web.util.UriComponentsBuilder;

public class WikipediaURL extends UriComponentsBuilder {	
	
	

	public static final class WikipediaURLSearchBuilder {
		// https://en.wikipedia.org/w/api.phpaction=query&list=search&format=json&srsearch=%22Liverpool%22&srlimit=10
		
		private String wikipediaUrlApi = "https://en.wikipedia.org/w/api.php";
		public UriComponentsBuilder build() {
			UriComponentsBuilder wikipediaURLBuilder = UriComponentsBuilder.fromHttpUrl(wikipediaUrlApi);
			wikipediaURLBuilder.queryParam("format", "json");
			wikipediaURLBuilder.queryParam("action", "query");
			wikipediaURLBuilder.queryParam("list", "search");			
			
			return wikipediaURLBuilder;
			
		}
		
	}
	

	public static final class WikipediaURLPageIdBuilder {
		// "https://en.wikipedia.org/w/api.php?action=query&prop=info&pageids=18119&inprop=url&format=json"
		private String wikipediaUrlApi = "https://en.wikipedia.org/w/api.php";
		
		public UriComponentsBuilder build() {
			UriComponentsBuilder wikipediaURLBuilder = UriComponentsBuilder.fromHttpUrl(wikipediaUrlApi);
			wikipediaURLBuilder.queryParam("format", "json");
			wikipediaURLBuilder.queryParam("action", "query");
			wikipediaURLBuilder.queryParam("prop", "info");			
			wikipediaURLBuilder.queryParam("inprop", "url");
			return wikipediaURLBuilder;
			
		}
		
	}

}
