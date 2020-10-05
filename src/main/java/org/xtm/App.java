package org.xtm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;

import org.springframework.web.util.UriComponentsBuilder;

import org.xtm.model.WikipediaSearch;




/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		UriComponentsBuilder wikipediaURLSearch = new WikipediaURL.WikipediaURLSearchBuilder().build();

		UriComponentsBuilder wikipediaURLPageId = new WikipediaURL.WikipediaURLPageIdBuilder().build();
		// System.out.println("ENTER football club name: ");
		// String readLine = in.readLine();
		//wikipediaURLSearch.queryParam("srsearch", String.format("\"%s\"", readLine));
		wikipediaURLSearch.queryParam("srsearch", String.format("\"%s\"", "Liverpool"));

		try {
			URL urlSearch = new URL(wikipediaURLSearch.toUriString());
			String jsonSearchContent = getContentFromURL(urlSearch);

			if (jsonSearchContent != null && !jsonSearchContent.isEmpty()) {
				WikipediaSearch wikipediaSearch = JSONMapperUtil.getWikipediaSearchFromJSONContent(jsonSearchContent);
				if (wikipediaSearch != null) {

					Long pageid = wikipediaSearch.getPageid();
					URL urlPageId = new URL(wikipediaURLPageId.queryParam("pageids", pageid).toUriString());
					String contentFromURL = getContentFromURL(urlPageId);
					Map<String, Object> mapClubInfo = JSONMapperUtil.getMapClubInfo(contentFromURL, pageid);
					System.out.println(mapClubInfo);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static HttpURLConnection prepareHttpURLConnection(URL url) throws IOException {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		return conn;
	}
	
	public static String readUrlInputStream(InputStream inputStream) {
		StringBuilder sb = new StringBuilder();
		Scanner scanner = null;
		try{
			scanner = new Scanner(inputStream);
			while (scanner.hasNext()) {
				sb.append(scanner.nextLine());
			}	
			
		} finally {
			scanner.close();			
		}
		
		return sb.toString();
	}
	
	public static String getContentFromURL(URL url) throws IOException {
		HttpURLConnection httpconnection = null;
		try{ 
			
			httpconnection = prepareHttpURLConnection(url);
			
			int responsecode = httpconnection.getResponseCode();
			//System.out.println("Response code is: " + responsecode);
			
			if (responsecode != 200)
				throw new RuntimeException("HttpResponseCode: " + responsecode);
			else {
				return readUrlInputStream(url.openStream());	
			}			
		} finally {
			if(httpconnection != null) {
				httpconnection.disconnect();
			}
		}
	}
}
