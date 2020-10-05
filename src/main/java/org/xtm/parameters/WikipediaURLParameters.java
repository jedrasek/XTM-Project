package org.xtm.parameters;

public enum WikipediaURLParameters {
	
	FORMAT("format"),
	ACTION("action"),
	LIST("list"),
	SRSSEARCH("srcsearch");
	
	String name;
	
	WikipediaURLParameters(String name) {
		this.name = name;
	}

}
