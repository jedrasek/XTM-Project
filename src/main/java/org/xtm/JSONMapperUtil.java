package org.xtm;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.xtm.exception.ProjectException;
import org.xtm.model.WikipediaQuery;
import org.xtm.model.WikipediaSearch;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONMapperUtil {

	public static WikipediaSearch getWikipediaSearchFromJSONContent(String jsonSearchContent) throws ProjectException {
		JSONObject jsonResponse = new JSONObject(new JSONTokener(jsonSearchContent));
		
		JSONObject jsonObject = jsonResponse.getJSONObject("query");
		
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		WikipediaQuery query;
		try {
			query = objectMapper.readValue(jsonObject.toString(), WikipediaQuery.class);
		
		
		if(query.getWikipediaSearchList() != null && query.getWikipediaSearchList().size() == 10) {
			return query.getWikipediaSearchList().get(0);
		}
		
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
			throw new ProjectException(e.getMessage());
		}
		
		return null;
	}
	
	public static Map<String, Object> getMapClubInfo(String jsonSearchContent, Long pageId) {
		Map<String, Object> map = new HashMap<>();
		JSONObject jsonResponse = new JSONObject(new JSONTokener(jsonSearchContent));
		
		JSONObject jsonObject = jsonResponse.getJSONObject("query").getJSONObject("pages").getJSONObject(pageId.toString());
		
		map.put("canonicalurl", jsonObject.get("canonicalurl"));
		map.put("title", jsonObject.get("title"));
		map.put("fullurl", jsonObject.get("fullurl"));
		map.put("pagelanguage", jsonObject.get("pagelanguage"));
		
		
		return map;
	}
		
}
