package com.designpatterns.composite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CompositeApplication {
  public static void main(String[] args) {
    // SpringApplication.run(CompositeApplication.class, args);
    File file1 = new File("profile.jpg", 200);
    File file2 = new File("notes.txt", 500);

    Folder documents = new Folder("Documents");
    documents.addItem(file1);
    documents.addItem(file2);

    // print structure
    documents.printStructure("");

    // get total size
    System.out.println("total size: " + documents.getSize());
  }
}
