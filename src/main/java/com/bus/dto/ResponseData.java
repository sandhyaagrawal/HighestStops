package com.bus.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData {
	 @JsonProperty("Version")
	public String version;
	 @JsonProperty("Type")
	public String type;
	 @JsonProperty("Result")
	public ArrayList<Result> resultList;
	
	public ResponseData() {
		
	}
	
	public ResponseData(String version, String type, ArrayList<Result> resultList) {
		super();
		this.version = version;
		this.type = type;
		this.resultList = resultList;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Result> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<Result> resultList) {
		this.resultList = resultList;
	}
	
	

}
