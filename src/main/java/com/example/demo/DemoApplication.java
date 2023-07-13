package com.example.demo;

import com.google.gson.JsonObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@SpringBootApplication
public class DemoApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World! from personal";
    }

    @RequestMapping("/bot")
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

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
