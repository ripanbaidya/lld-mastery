package com.designpatterns.builder;

/**
 * Classic Builder Pattern
 */
public class Post {

  // Private fields
  private String title;
  private String context;
  private String category;

  // Constructor
  private Post(Builder builder) {
    this.title = builder.title;
    this.context = builder.context;
    this.category = builder.category;
  }

  // Getters
  public String getTitle() {
    return title;
  }

  public String getContext() {
    return context;
  }

  public String getCategory() {
    return category;
  }

  @Override
  public String toString() {
    return "Post{" +
        "title='" + title + '\'' +
        ", context='" + context + '\'' +
        ", category='" + category + '\'' +
        '}';
  }

  // Builder pattern
  public static class Builder {

    private String title;
    private String context;
    private String category;

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder context(String context) {
      this.context = context;
      return this;
    }

    public Builder category(String category) {
      this.category = category;
      return this;
    }

    public Post build() {
      return new Post(this);
    }
  }
}
