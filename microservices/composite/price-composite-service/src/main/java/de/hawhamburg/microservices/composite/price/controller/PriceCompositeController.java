package de.hawhamburg.microservices.composite.price.controller;

import de.hawhamburg.microservices.composite.price.model.CalculatedPrice;
import de.hawhamburg.microservices.composite.price.service.PriceCompositeIntegration;
import de.hawhamburg.microservices.core.price.jpa.domain.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.callista.microservices.util.ServiceUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import java.util.UUID;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * Created by unknown on 27.10.15.
 */

@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@RestController
public class PriceCompositeController {
    @Autowired
    private PriceCompositeIntegration priceCompositeIntegration;

    @Autowired
    private ServiceUtils utils;

    @RequestMapping(value = "/price/{flightId}", method = RequestMethod.GET)
    public ResponseEntity<CalculatedPrice> getPrice(@PathVariable final UUID flightId){
        ResponseEntity<Price> priceResult = priceCompositeIntegration.getPrice(flightId);
        if(!priceResult.getStatusCode().is2xxSuccessful()){
            return utils.createResponse(null,priceResult.getStatusCode());
        }
        return utils.createOkResponse(new CalculatedPrice(priceResult.getBody()));
    }


    @RequestMapping(value = "/price", method = RequestMethod.POST)
    public ResponseEntity<CalculatedPrice> createPrice(@RequestBody final Price price){
        ResponseEntity<Price> priceResult = priceCompositeIntegration.createPrice(price);
        if(!priceResult.getStatusCode().is2xxSuccessful()){
            return utils.createResponse(null,priceResult.getStatusCode());
        }
        return utils.createOkResponse(new CalculatedPrice(priceResult.getBody()));
    }

    @RequestMapping(value = "/price", method = RequestMethod.DELETE)
    public ResponseEntity<CalculatedPrice> deletePrice(@RequestBody final Price price){
        ResponseEntity<Price> priceResult = priceCompositeIntegration.deletePrice(price);
        if(!priceResult.getStatusCode().is2xxSuccessful()){
            return utils.createResponse(null,priceResult.getStatusCode());
        }
        return utils.createOkResponse(new CalculatedPrice(priceResult.getBody()));
    }

    @RequestMapping(value = "/price", method = RequestMethod.PATCH)
    public ResponseEntity<CalculatedPrice> updatePrice(@RequestBody final Price price){
        ResponseEntity<Price> priceResult = priceCompositeIntegration.patchPrice(price);
        if(!priceResult.getStatusCode().is2xxSuccessful()){
            return utils.createResponse(null,priceResult.getStatusCode());
        }
        return utils.createOkResponse(new CalculatedPrice(priceResult.getBody()));
    }

    @RequestMapping(value = "/price", method = RequestMethod.PUT)
    public ResponseEntity<CalculatedPrice> update2Price(@RequestBody final Price price){
        ResponseEntity<Price> priceResult = priceCompositeIntegration.putPrice(price);
        if(!priceResult.getStatusCode().is2xxSuccessful()){
            return utils.createResponse(null,priceResult.getStatusCode());
        }
        return utils.createOkResponse(new CalculatedPrice(priceResult.getBody()));
    }
}
