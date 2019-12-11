package com.bus.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result{
	
	@JsonProperty("LineNumber")
	 public String lineNumber;
	
	@JsonProperty("DirectionCode")
	 public String directionCode;
	
	@JsonProperty("JourneyPatternPointNumber")
	public String journeyPatternPointNumber;
	
	@JsonProperty("LastModifiedUtcDateTime")
	public String lastModifiedUtcDateTime;
	
	@JsonProperty("ExistsFromDate")
	 public String existsFromDate;
	
	@JsonProperty("StopPointNumber")
	 public String stopPointNumber;
	
	@JsonProperty("StopPointName")
	 public String stopPointName;
	
	@JsonProperty("StopAreaNumber")
	 public String stopAreaNumber;
	
	@JsonProperty("LocationNorthingCoordinate")
	 public String locationNorthingCoordinate;
	
	@JsonProperty("LocationEastingCoordinate")
	 public String locationEastingCoordinate;
	
	@JsonProperty("ZoneShortName")
	 public String zoneShortName;
	
	@JsonProperty("StopAreaTypeCode")
	 public String stopAreaTypeCode;

	public Result() {
	
	}

	public Result(String lineNumber, String directionCode, String journeyPatternPointNumber,
			String lastModifiedUtcDateTime, String existsFromDate) {
		super();
		this.lineNumber = lineNumber;
		this.directionCode = directionCode;
		this.journeyPatternPointNumber = journeyPatternPointNumber;
		this.lastModifiedUtcDateTime = lastModifiedUtcDateTime;
		this.existsFromDate = existsFromDate;
	}

	public Result(String lastModifiedUtcDateTime, String existsFromDate, String stopPointNumber, String stopPointName,
			String stopAreaNumber, String locationNorthingCoordinate, String locationEastingCoordinate,
			String zoneShortName, String stopAreaTypeCode) {
		super();
		this.lastModifiedUtcDateTime = lastModifiedUtcDateTime;
		this.existsFromDate = existsFromDate;
		this.stopPointNumber = stopPointNumber;
		this.stopPointName = stopPointName;
		this.stopAreaNumber = stopAreaNumber;
		this.locationNorthingCoordinate = locationNorthingCoordinate;
		this.locationEastingCoordinate = locationEastingCoordinate;
		this.zoneShortName = zoneShortName;
		this.stopAreaTypeCode = stopAreaTypeCode;
	}

	public String getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getDirectionCode() {
		return directionCode;
	}

	public void setDirectionCode(String directionCode) {
		this.directionCode = directionCode;
	}

	public String getJourneyPatternPointNumber() {
		return journeyPatternPointNumber;
	}

	public void setJourneyPatternPointNumber(String journeyPatternPointNumber) {
		this.journeyPatternPointNumber = journeyPatternPointNumber;
	}

	public String getLastModifiedUtcDateTime() {
		return lastModifiedUtcDateTime;
	}

	public void setLastModifiedUtcDateTime(String lastModifiedUtcDateTime) {
		this.lastModifiedUtcDateTime = lastModifiedUtcDateTime;
	}

	public String getExistsFromDate() {
		return existsFromDate;
	}

	public void setExistsFromDate(String existsFromDate) {
		this.existsFromDate = existsFromDate;
	}

	public String getStopPointNumber() {
		return stopPointNumber;
	}

	public void setStopPointNumber(String stopPointNumber) {
		this.stopPointNumber = stopPointNumber;
	}

	public String getStopPointName() {
		return stopPointName;
	}

	public void setStopPointName(String stopPointName) {
		this.stopPointName = stopPointName;
	}

	public String getStopAreaNumber() {
		return stopAreaNumber;
	}

	public void setStopAreaNumber(String stopAreaNumber) {
		this.stopAreaNumber = stopAreaNumber;
	}

	public String getLocationNorthingCoordinate() {
		return locationNorthingCoordinate;
	}

	public void setLocationNorthingCoordinate(String locationNorthingCoordinate) {
		this.locationNorthingCoordinate = locationNorthingCoordinate;
	}

	public String getLocationEastingCoordinate() {
		return locationEastingCoordinate;
	}

	public void setLocationEastingCoordinate(String locationEastingCoordinate) {
		this.locationEastingCoordinate = locationEastingCoordinate;
	}

	public String getZoneShortName() {
		return zoneShortName;
	}

	public void setZoneShortName(String zoneShortName) {
		this.zoneShortName = zoneShortName;
	}

	public String getStopAreaTypeCode() {
		return stopAreaTypeCode;
	}

	public void setStopAreaTypeCode(String stopAreaTypeCode) {
		this.stopAreaTypeCode = stopAreaTypeCode;
	}
	





}
