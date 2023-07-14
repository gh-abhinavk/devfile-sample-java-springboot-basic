package io.bankapp;

import com.google.gson.JsonObject;
import io.bankapp.controller.AccountController;
import io.bankapp.model.Customer;
import io.bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 
 * @author Ankit Patel
 *
 */

@SpringBootApplication
public class BankAppApplication {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountController accountController;


	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		createDummyData();
	}


	private  void createDummyData(){
		Customer customerAlex=new Customer(123456,"Alex","Pune","Maharashtra","India",9001,"pass1234","4040");
		Customer customerMohan=new Customer(654321,"Mohan","Hyderabad","Telangana","India",9002,"pass1235","5050");
		Customer customerGoogle=new Customer(420420,"Google","Delhi","Delhi","India",9003,"pass1236","6060");
		Customer customerMicrosoft=new Customer(501501,"Microsoft","Chennai","Tamilnadu","India",9004,"pass1237","8080");

		customerService.createCustomer(customerAlex);
		customerService.createCustomer(customerMohan);
		customerService.createCustomer(customerGoogle);
		customerService.createCustomer(customerMicrosoft);

		accountController.createAccount(customerAlex.getAcctID(), 50000, "Active");
		accountController.createAccount(customerMohan.getAcctID(), 150000, "Active");
		accountController.createAccount(customerGoogle.getAcctID(), 1250000, "Active");
		accountController.createAccount(customerMicrosoft.getAcctID(), 120000, "Active");
		accountController.createAccount(customerAlex.getAcctID(), 50000, "Active");
		accountController.withdrawAmount(123456,1000);
		accountController.transferAmount(501501,420420,2000);

		System.out.printf("getdata:"+accountController.getAccountInfo(123456));

	}



}
