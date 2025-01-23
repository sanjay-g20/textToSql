package com.texttosql.textToSql;

import com.texttosql.textToSql.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class TextToSqlApplication {

	@Autowired
	private UserRepository userRepository;
//	@PostConstruct
//	public void initUsers() {
//		List<User> users = Stream.of(
//				new User( "user1", "pwd1"), // Set `id` to null if it is auto-generated
//				new User("user2", "pwd2"),
//				new User("user3", "pwd3")
//		).collect(Collectors.toList());
//
//		userRepository.saveAll(users);
//	}

	public static void main(String[] args) {
		SpringApplication.run(TextToSqlApplication.class, args);
	}

}
