package com.example.company;

import com.example.company.board.BoardService;
import com.example.company.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class CompanyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(CompanyApplication.class, args);

		System.out.println("\nWszystkie beany");
		Arrays.stream(ctx.getBeanDefinitionNames())
				.sorted()
				.forEach(System.out::println);

		System.out.println("\nBeany typu Person");
		ctx.getBeansOfType(Person.class)
				.forEach((name, p) -> System.out.println(name + " -> " + p));

		System.out.println("\nZarząd");
		ctx.getBean(BoardService.class).printBoard();
	}
}