package org.ticketbookingapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
          title = "Ticket Booking API",
           version = "1.0.0",
                description = "This is api for ticket booking"
        )

)

@SpringBootApplication
public class TicketbookingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketbookingApiApplication.class, args);
    }

}
