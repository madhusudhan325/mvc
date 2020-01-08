package com.mindtree.traveltourism.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.traveltourism.entity.Travel;
import com.mindtree.traveltourism.service.TravelTourismService;

@RestController
@RequestMapping("/rest")
public class AppRestController {

	@Autowired
	private TravelTourismService tourismService;

	@RequestMapping("/loadSourcesByCustomer/{customerId}")
	public List<Travel> getPlacesByCusotmerId(@PathVariable int customerId) {

		List<Travel> result = tourismService.getAllSourcesByCustomer(customerId);
		return result;
	}
}
