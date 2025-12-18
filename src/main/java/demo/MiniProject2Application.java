package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(MiniProject2Application.class, args);
		System.out.println("Port running on 8075.");
	}

}
