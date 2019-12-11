package com.bus.services;

import java.net.SocketTimeoutException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.bus.Exception.BusLineNotFoundException;
import com.bus.dto.BusLine;
import com.bus.dto.Result;

@Service
public class BusLineService {

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger log = LoggerFactory.getLogger(BusLineService.class);

	public BusLineService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(5000))
				.setReadTimeout(Duration.ofSeconds(5000)).build();
	}

	private static final String API_URL_BUSLINE = "https://api.sl.se/api2/linedata.json?key=29240f5332544957908632ae965b237d&model=jour&DefaultTransportModeCode=BUS";

	/*
	 * This method will call other private methods to get the busLineNumber which
	 * has highest stops
	 * 
	 * @param no argument
	 * 
	 * @return String that contains busLineNumber which has highest stop
	 * 
	 * @exception throws BusLineNotFoundException if busLine is returned as null
	 * 
	 * 
	 */
	public String getBusLineNumberHavingHighestStops() throws BusLineNotFoundException {

		BusLine busLine = getAPIReponse(API_URL_BUSLINE);
		if (busLine == null) {
			log.error("Bus Line Number not found");
			throw new BusLineNotFoundException();
		}
		List<String> listOfbusLineNumbers = getListOfBusLineNumbers(busLine);
		return getBusLineHavingHighestStops(listOfbusLineNumbers);

	}

	/*
	 * This Method will call the Tafik Lab's public API and return its response as a
	 * Java Object
	 * 
	 * @param url URL for API
	 * 
	 * @return BusLine a java object BusLine
	 * 
	 * @exception an I/O error occurred due time out.
	 */
	private BusLine getAPIReponse(String url) {
		BusLine busLine = new BusLine();
		try {
			busLine = restTemplate.getForObject(url, BusLine.class);
		} catch (ResourceAccessException e) {
			if (e.getCause() instanceof SocketTimeoutException)
				log.error("API Request timeout.");
			return null;
		}
		return busLine;

	}

	/*
	 * This method will collect all the lineNumber from the BusLine Object and
	 * return it as a list
	 * 
	 * @param busLine BusLine object returned by the API response
	 * 
	 * @return a list of all the lineNumber found in the BusLine Object.
	 */
	private List<String> getListOfBusLineNumbers(BusLine busLine) {
		if (busLine != null) {
			ArrayList<Result> resultList = busLine.getResponseData().getResultList();
			log.info("Collect only line numbers from the API response");
			return resultList.stream().map(r -> r.getLineNumber()).collect(Collectors.toList());
		}
		return null;
	}

	/*
	 * This method will find all the duplicate busLineNumber and it's count from the
	 * listOfAllBusLineNumbers It will put each distinct busLineNumber as a Key and
	 * count as a Value into a mapOfLineNumber<String, Integer> Then it will sort
	 * the Map based on value
	 * 
	 * @param listOfAllBusLineNumbers list of all the buslineNumber
	 * 
	 * @return String containing busLineNumber that has the highest value
	 */
	private String getBusLineHavingHighestStops(List<String> listOfAllBusLineNumbers) {
		Map<String, Integer> mapOfLineNumber = new HashMap<>();
		if (listOfAllBusLineNumbers != null) {
			log.info("Find count of a distinct line number");
			for (String lineNumber : listOfAllBusLineNumbers) {
				mapOfLineNumber.compute(lineNumber, (key, value) -> value == null ? 1 : value + 1);
			}
			Map.Entry<String, Integer> maxEntry = mapOfLineNumber.entrySet().stream().max(Map.Entry.comparingByValue())
					.get();
			return "Bus Line Number: " + maxEntry.getKey() + " has highest stops: " + maxEntry.getValue();
		}
		return "Could not get Bus Line Number";
	}

}