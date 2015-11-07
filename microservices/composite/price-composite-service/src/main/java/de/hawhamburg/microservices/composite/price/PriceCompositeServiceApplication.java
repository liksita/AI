package de.hawhamburg.microservices.composite.price;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by unknown on 27.10.15.
 */
//SOF TODO enable client in live system
//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"de.hawhamburg.microservices.composite.price", "se.callista.microservices.util"})
public class PriceCompositeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceCompositeServiceApplication.class,args);
    }
}
