package io.bankapp.controller;

import com.google.cloud.dialogflow.v2.WebhookRequest;
import com.google.gson.JsonObject;
import io.bankapp.WebDto;
import io.bankapp.model.Customer;
import io.bankapp.service.AccountService;
import io.bankapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;


    @PostMapping("/bot")
    public String botResponse(@RequestBody WebDto webDto) {

        System.out.println(webDto.toString());


        // Process the request and generate a response
        String fulfillmentText = processRequest( webDto);

        // Construct the webhook response
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("fulfillmentText", fulfillmentText);

        // Return the webhook response as JSON
        return jsonResponse.toString();
    }

    private  String processRequest(WebDto webDto) {
        // Implement your business logic here
        // You can access parameters from the request using jsonRequest.get("parameterName")

        // Generate a response based on the request
        if("Check Balance".equals(webDto.getIntentName())){
            Customer customer= customerService.getCustomerInfo(Integer.parseInt(webDto.getAccountNumber()));
            if(customer.getPan().equals(webDto.getPan())){
                int balance= accountService.getBalance(Integer.parseInt(webDto.getAccountNumber()));
                return  "Your balance is "+balance;
            }
        }
        return "This is the webhook response.";
    }
}
