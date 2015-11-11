package de.hawhamburg.microservices.composite.revenue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by unknown on 27.10.15.
 */
//SOF TODO enable client in live system
//@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan({"de.hawhamburg.microservices.composite.revenue", "se.callista.microservices.util","de.hawhamburg.microservices.composite.price"})
//@ComponentScan({"de.hawhamburg.microservices.composite.revenue", "se.callista.microservices.util"})
public class RevenueCompositeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RevenueCompositeServiceApplication.class,args);
    }
}
