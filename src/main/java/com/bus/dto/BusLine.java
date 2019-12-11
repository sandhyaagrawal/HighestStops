package com.bus.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class BusLine{
 @JsonProperty("StatusCode")
public int statusCode;
 @JsonProperty("Message")
 public String message;
 @JsonProperty("ExecutionTime")
 public int executionTime;
 @JsonProperty("ResponseData")
public ResponseData responseData;


public BusLine() {
	
}


public BusLine(int statusCode, String message, int executionTime, ResponseData responseData) {
	super();
	this.statusCode = statusCode;
	this.message = message;
	this.executionTime = executionTime;
	this.responseData = responseData;
}


public int getStatusCode() {
	return statusCode;
}


public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}


public String getMessage() {
	return message;
}


public void setMessage(String message) {
	this.message = message;
}


public int getExecutionTime() {
	return executionTime;
}

public void setExecutionTime(int executionTime) {
	this.executionTime = executionTime;
}


public ResponseData getResponseData() {
	return responseData;
}


public void setResponseData(ResponseData responseData) {
	this.responseData = responseData;
}


}
