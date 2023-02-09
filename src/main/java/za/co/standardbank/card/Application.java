package za.co.standardbank.card;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@OpenAPIDefinition(info = @Info(title = "Pokemon Management", description = "This is A Microservice For Pokemon Management.", version = "2.0"))
public class Application extends SpringBootServletInitializer {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
