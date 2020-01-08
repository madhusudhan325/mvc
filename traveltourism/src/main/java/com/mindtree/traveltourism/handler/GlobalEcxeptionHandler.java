package com.mindtree.traveltourism.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mindtree.traveltourism.exception.TravelTourismAppException;

@ControllerAdvice
public class GlobalEcxeptionHandler {
	@ExceptionHandler
	public String exceptinHandlerPage(TravelTourismAppException t, Model model) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", t.getMessage());
		response.put("httpStatus", HttpStatus.BAD_REQUEST);
		response.put("timestamp", new Date());
		model.addAttribute("error", response);
		return "error";

	}

}
