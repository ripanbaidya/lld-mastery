package com.designpatterns.builder;

// Classic Builder Pattern
public class GenericPost {

  // Private fields

  private String title;
  private String text;
  private String category;

  // Getters & Setters

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "Post{" +
        "title='" + title + '\'' +
        ", text='" + text + '\'' +
        ", category='" + category + '\'' +
        '}';
  }
}
