package com.designpatterns.builder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuilderApplication {

  public static void main(String[] args) {
    // SpringApplication.run(BuilderApplication.class, args);

    // Example of Class Builder Pattern
    Post post1 = new Post.Builder()
        .title("Builder Pattern")
        .context("Type of Creational design pattern that provides a step-by-step approach to constructing complex objects")
        .category("Creational Design Patterns")
        .build();

    System.out.println(post1);

    // Example of Generic Builder Pattern

    GenericPost post2 = GenericBuilder.of(GenericPost::new)
        .with(GenericPost::setText, "Singleton Pattern")
        .with(GenericPost::setTitle, "Ensure a class has only one instance and provide global access to it")
        .with(GenericPost::setCategory, "Creational Design Patterns")
        .build();

    System.out.println(post2);
  }

}
