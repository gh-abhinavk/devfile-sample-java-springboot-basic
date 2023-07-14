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
		Customer customerAlex=new Customer(1234,"Alex","Pune","Maharashtra","India",9001,"pass1234");
		Customer customerMohan=new Customer(1235,"Mohan","Hyderabad","Telangana","India",9002,"pass1235");
		Customer customerGoogle=new Customer(1236,"Google","Delhi","Delhi","India",9003,"pass1236");
		Customer customerMicrosoft=new Customer(1237,"Microsoft","Chennai","Tamilnadu","India",9004,"pass1237");

		customerService.createCustomer(customerAlex);
		customerService.createCustomer(customerMohan);
		customerService.createCustomer(customerGoogle);
		customerService.createCustomer(customerMicrosoft);

		accountController.createAccount(customerAlex.getAcctID(), 50000, "Active");
		accountController.createAccount(customerMohan.getAcctID(), 150000, "Active");
		accountController.createAccount(customerGoogle.getAcctID(), 1250000, "Active");
		accountController.createAccount(customerMicrosoft.getAcctID(), 120000, "Active");

		System.out.printf("getdata:"+accountController.getAccountInfo(1237));

	}

	@PostMapping("/bot")
	public String botResponse() {

		// Process the request and generate a response
		String fulfillmentText = processRequest();

		// Construct the webhook response
		JsonObject jsonResponse = new JsonObject();
		jsonResponse.addProperty("fulfillmentText", fulfillmentText);

		// Return the webhook response as JSON
		return jsonResponse.toString();
	}

	private static String processRequest() {
		// Implement your business logic here
		// You can access parameters from the request using jsonRequest.get("parameterName")

		// Generate a response based on the request

		return "This is the webhook response.";
	}

}
