package com.mindtree.traveltourism.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.traveltourism.entity.Customer;
import com.mindtree.traveltourism.entity.Travel;
import com.mindtree.traveltourism.exception.serviceexception.TravelTourismServiceException;

@Service
public interface TravelTourismService {

	public String registerCustomerDetails(Customer customer);

	public List<Customer> getAllCustomers();

	public String addTravellingDetails(int customerId, Travel travel) throws TravelTourismServiceException;

	public List<Travel> getAllSourcesByCustomer(int customerId);

	public List<Travel> getAllTravelDetailsForParticularSource(int travelId, int customerId);

	public Travel updateTravelData(int travelId);

	public void updateCustomerDetails(Travel travel1, String source, String destination, int distance);

}
