package com.mindtree.traveltourism.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.traveltourism.entity.Customer;
import com.mindtree.traveltourism.entity.Travel;
import com.mindtree.traveltourism.exception.TravelTourismAppException;
import com.mindtree.traveltourism.service.TravelTourismService;

@Controller
public class TravelTourismAppController {
	@Autowired
	private TravelTourismService travelTourismService;
	static Travel travel1 = new Travel();

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/form")
	public String index1() {
		return "customer";
	}

	@RequestMapping("/addCustomer")
	public String addCustomerDetails(@ModelAttribute("customer") Customer customer, Model model) {

		model.addAttribute("message", travelTourismService.registerCustomerDetails(customer));

		return "message";
	}

	@GetMapping("/form1")
	public String index1(Model model) {
		List<Customer> customers = travelTourismService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "travel";
	}

	@RequestMapping("/addtravelData")
	public String addTravellingDetails(@RequestParam("customerId") int customerId,
			@ModelAttribute("travel") Travel travel, Model model) throws TravelTourismAppException {
		model.addAttribute("customers", travelTourismService.getAllCustomers());
		model.addAttribute("message", travelTourismService.addTravellingDetails(customerId, travel));
		return "message";
	}

	@GetMapping("/form2")
	public String index2(Model model) {
		List<Customer> customers = travelTourismService.getAllCustomers();
		model.addAttribute("customers", customers);
		return "view";
	}

	@GetMapping("/getdata")
	public String getAllSourceDetails(@RequestParam("travelStatus") int travelId,
			@RequestParam("customerStatus") int customerId, Model model) {
		List<Customer> customers = travelTourismService.getAllCustomers();
		model.addAttribute("customers", customers);
		List<Travel> travels = travelTourismService.getAllTravelDetailsForParticularSource(travelId, customerId);
		model.addAttribute("travels", travels);
		return "view";

	}

	@GetMapping("/update/{travelId}")
	public String updatTravelDetails(Model model, @PathVariable int travelId) {
		Travel travel = travelTourismService.updateTravelData(travelId);
		travel1 = travel;
		model.addAttribute("travel", travel);
		return "update";
	}

	@RequestMapping("/updatedestination")
	public String updateDestinationAndSourceAndDistance(@RequestParam("source") String source,
			@RequestParam("destination") String destination, @RequestParam("distance") int distance) {
		travelTourismService.updateCustomerDetails(travel1, source, destination, distance);
		return "index";
	}

}
