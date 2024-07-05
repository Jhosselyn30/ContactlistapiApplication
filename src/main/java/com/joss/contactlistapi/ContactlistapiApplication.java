package com.joss.contactlistapi;

import com.joss.contactlistapi.entity.Contact;
import com.joss.contactlistapi.repository.ContactRepository;
import lombok.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactlistapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository){
		return args -> {
			List<Contact> contacts = Arrays.asList(
					new Contact("Joss", "joss@gmail.com", LocalDateTime.now()),
					new Contact("Jhimy", "jhimy@gmail.com",LocalDateTime.now()),
					new Contact("Bonnie","bonnie@gmail.com",LocalDateTime.now()),
					new Contact("Kali", "kali@gmail.com",LocalDateTime.now()),
					new Contact("Lia", "lia@gmail.com",LocalDateTime.now())

			);
			contactRepository.saveAll(contacts);
		};

	}
}
