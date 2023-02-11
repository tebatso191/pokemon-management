package za.co.standardbank.card.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import za.co.standardbank.card.model.User;
import za.co.standardbank.card.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Pokemon Management", description = "This is A Microservice For Pokemon Management.", version = "2.0"))
public class PokemonConfig {
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initialiseUsers() {
        List<User> users = Stream.of(
                new User(100L, "admin", "admin", "admin@gmail.com"),
                new User(102L, "tebatso", "password", "tebatso191@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }
}
