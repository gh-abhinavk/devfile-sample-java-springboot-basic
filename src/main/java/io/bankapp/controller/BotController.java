package io.bankapp.controller;

import com.google.cloud.dialogflow.v2.WebhookRequest;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BotController {

    @PostMapping("/bot")
    public String botResponse(@RequestBody WebhookRequest object) {

        System.out.println(object.toString());
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
