package bj.highfiveuniversity.ecommerce;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bj.highfiveuniversity.ecommerce.models.User;
import bj.highfiveuniversity.ecommerce.repository.UserRepository;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

public CommandLineRunner demo(UserRepository userRepository){
	return (args) ->{
		User johndoe = User.builder()
		.email("johndoe@gamil")
		.username("johndoe")
		.password("1234")
		.createdAt(LocalDateTime.now())
		.updatedAt(LocalDateTime.now())
		.build();
		// User john= new User(null,"john","john@naza","yofam",LocalDateTime.now(),LocalDateTime.now());
		userRepository.save(johndoe);
	};
}

}
