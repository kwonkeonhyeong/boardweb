package org.example.boardweb;

import org.example.boardweb.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BoardwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardwebApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(BoardRepository repository) {
        return args -> {
            repository.findAll().forEach(System.out::println);
        };
    }
}
