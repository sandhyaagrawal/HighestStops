package com.bus.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bus.Exception.BusLineNotFoundException;
import com.bus.services.BusLineService;



@RestController
@RequestMapping(value = "/")
public class BusLineController {

	@Autowired
	private BusLineService busLineService;
	
	private static final Logger log = LoggerFactory.getLogger(BusLineController.class);

	@RequestMapping(value = "/getBusLineWithHighestStops", method = RequestMethod.GET, headers = "Accept=text/plain")
	public String callLinesAPIandSaveAllLines() throws BusLineNotFoundException  {
		String busLineResponse=busLineService.getBusLineNumberHavingHighestStops();
		if (busLineResponse == null ){
			log.error("Service returned null response");
            throw new BusLineNotFoundException("Bus information not found");
    	}
		return  busLineResponse;
	
		
	

	}
}
