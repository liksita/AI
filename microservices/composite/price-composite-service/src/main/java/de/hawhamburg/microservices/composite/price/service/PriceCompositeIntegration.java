package de.hawhamburg.microservices.composite.price.service;

import de.hawhamburg.microservices.composite.price.util.ResponseHelper;
import de.hawhamburg.microservices.core.price.jpa.domain.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.callista.microservices.util.ServiceUtils;

import java.util.UUID;

/**
 * Created by Ole on 07.11.2015.
 */
@Service
public class PriceCompositeIntegration {

    @Autowired
    private ServiceUtils utils;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private RestTemplate restTemplate;

    //OF TODO add @HystrixCommand(fallbackMethod = "defaultPrice")
    public ResponseEntity<Price> getPrice(UUID flightID){
        //OF TODO use this later
//        URI uri = utils.getServiceUrl("price");
//        String url = uri.toString() + "/price/" + flightID;
//        String url = uri.toString() + "/price/" + flightID;

        //OF TODO remove this later!
        String urlToPriceService = "http://localhost:8080";
        String url =urlToPriceService + "/price/" + flightID;

        ResponseEntity<String> resultStr = restTemplate.getForEntity(url,String.class);
        Price price = ResponseHelper.response2Price(resultStr);
        return utils.createOkResponse(price);
    }

    public ResponseEntity<Price> defaultProduct(UUID flightId) {
        return utils.createResponse(null, HttpStatus.BAD_GATEWAY);
    }
}
