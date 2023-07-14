package io.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.bankapp.model.Customer;
import io.bankapp.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountController accountController;

	@PostMapping("/customer")
	public void createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
		accountController.createAccount(customer.getAcctID(), 0, "Active");
	}

	@PostMapping("/allcustomer")
	public void createAllCustomer() {
		Customer customerAlex=new Customer(1234,"Alex","Pune","Maharashtra","India",9001,"pass1234");
		Customer customerMohan=new Customer(1235,"Mohan","Hyderabad","Telangana","India",9002,"pass1235");
		Customer customerGoogle=new Customer(1236,"Google","Delhi","Delhi","India",9003,"pass1236");
		Customer customerMicrosoft=new Customer(1237,"Microsoft","Chennai","Tamilnadu","India",9004,"pass1236");

		customerService.createCustomer(customerAlex);
		customerService.createCustomer(customerMohan);
		customerService.createCustomer(customerGoogle);
		customerService.createCustomer(customerMicrosoft);

		accountController.createAccount(customerAlex.getAcctID(), 50000, "Active");
		accountController.createAccount(customerMohan.getAcctID(), 150000, "Active");
		accountController.createAccount(customerGoogle.getAcctID(), 1250000, "Active");
		accountController.createAccount(customerMicrosoft.getAcctID(), 120000, "Active");


	}


	@GetMapping("/customer/{acctID}")
	public Customer getCustomerInfo(@PathVariable int acctID) {
		return customerService.getCustomerInfo(acctID);
	}

	@DeleteMapping("/customer/{acctID}")
	public void deleteCustomer(@PathVariable int acctID) {
		customerService.deleteCustomer(acctID);
	}

}
