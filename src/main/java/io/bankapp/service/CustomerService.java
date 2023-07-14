package io.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.bankapp.dao.CustomerRepository;
import io.bankapp.model.Customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Customer getCustomerInfo(int acctID) {
		return customerRepository.findById(acctID).orElse(null);
	}

	public List<Customer> getAllCustomer(){
		List<Customer> listCUstomer=new ArrayList<>();
		Iterable<Customer> iterable= customerRepository.findAll();
		Iterator<Customer> listIt = iterable.iterator();

		while (listIt.hasNext()){
			Customer c=listIt.next();
			listCUstomer.add(c);
		}
		return  listCUstomer;
	}

	public void deleteCustomer(int acctID) {
		customerRepository.deleteById(acctID);
	}

}
