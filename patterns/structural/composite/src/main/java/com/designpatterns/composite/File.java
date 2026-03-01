package com.designpatterns.composite;

/**
 * Leaf
 */
public class File implements FileSystemItem {
  private final int size;
  private final String name;

  public File(String name, int size) {
    this.name = name;
    this.size = size;
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public void printStructure(String indent) {
    System.out.println(indent + "- " + name + " (" + size + " KB)");
  }

  @Override
  public void delete() {
    System.out.println("File Deleted: " + name);
  }
}
