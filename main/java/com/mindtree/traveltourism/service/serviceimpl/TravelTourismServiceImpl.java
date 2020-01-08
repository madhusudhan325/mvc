package com.mindtree.traveltourism.service.serviceimpl;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.traveltourism.entity.Customer;
import com.mindtree.traveltourism.entity.Travel;
import com.mindtree.traveltourism.exception.serviceexception.DuplicateTravelDateFoundException;
import com.mindtree.traveltourism.repository.CustomerRepository;
import com.mindtree.traveltourism.repository.TravelRepository;
import com.mindtree.traveltourism.service.TravelTourismService;

@Service
public class TravelTourismServiceImpl implements TravelTourismService {

	@Autowired
	private TravelRepository travelRepository;
	@Autowired
	private CustomerRepository customerRepository;
	static Customer customer1 = new Customer();

	@Override
	public String registerCustomerDetails(Customer customer) {
		customerRepository.save(customer);
		return "inserted successfully!!!!!!";
	}

	@Override
	public List<Customer> getAllCustomers() {

		return customerRepository.findAll();
	}

	@Override
	public String addTravellingDetails(int customerId, Travel travel) throws DuplicateTravelDateFoundException {
		Customer customer = customerRepository.findById(customerId).get();
		List<Travel> travels = customer.getTravels();
		int age = customer.getAge();
		Date date = travel.getDateOfJourney();
		int price = 0;
		for (Travel travel2 : travels) {
			if (travel2.getDateOfJourney().equals(date)) {
				throw new DuplicateTravelDateFoundException(
						"already you have booked flight for same date please choose another date");
			}
		}
		if (age > 30 && age <= 50) {
			price = (int) (price + ((travel.getDistance()) * 10) * (0.05));
			travel.setTravelFare(price);
			travel.setCustomer(customer);
			travelRepository.save(travel);
		} else if (age > 50) {
			price = (int) (price + ((travel.getDistance()) * 10) * (0.1));
			travel.setTravelFare(price);
			travel.setCustomer(customer);
			travelRepository.save(travel);
		} else {
			price = (int) (price + ((travel.getDistance()) * 10));
			travel.setTravelFare(price);
			travel.setCustomer(customer);
			travelRepository.save(travel);
		}
		return "inserted and assigned succesfully!!!!!!!!!!!";

	}

	@Override
	public List<Travel> getAllSourcesByCustomer(int customerId) {

		Customer customer = customerRepository.findById(customerId).get();
		return customer.getTravels().stream().collect(Collectors.toList());
	}

	@Override
	public List<Travel> getAllTravelDetailsForParticularSource(int travelId, int customerId) {
		String source = travelRepository.findById(travelId).get().getSource();
		customer1 = customerRepository.findById(customerId).get();
		return customerRepository.findById(customerId).get().getTravels().stream()
				.filter(travel -> travel.getSource().equalsIgnoreCase(source)).collect(Collectors.toList());
	}

	@Override
	public Travel updateTravelData(int travelId) {

		return travelRepository.findById(travelId).get();
	}

	@Override
	public void updateCustomerDetails(Travel travel1, String source, String destination, int distance) {

		Customer customer = travel1.getCustomer();
		int age = customer.getAge();
		int price = 0;
		if (age > 30 && age <= 50) {
			price = (int) (price + ((travel1.getDistance()) * 10) * (0.05));
			travel1.setTravelFare(price);
			travel1.setSource(source);
			travel1.setDestination(destination);
			travel1.setDistance(distance);
			travelRepository.save(travel1);
		} else if (age > 50) {
			price = (int) (price + ((travel1.getDistance()) * 10) * (0.1));
			travel1.setTravelFare(price);
			travel1.setSource(source);
			travel1.setDestination(destination);
			travel1.setDistance(distance);
			travelRepository.save(travel1);
		} else {
			price = (int) (price + ((travel1.getDistance()) * 10));
			travel1.setTravelFare(price);
			travel1.setSource(source);
			travel1.setDestination(destination);
			travel1.setDistance(distance);
			travelRepository.save(travel1);
		}

	}

}
