package com.designpatterns.facade;

/**
 * Build System
 * Compiles the codebase, creates an artifact (like a .jar), and returns its location.
 */
class BuildSystem {

  /**
   * Compile the project
   */
  public boolean compileProject() {
    System.out.println("BuildSystem: Compiling project...");
    simulateDelay();
    System.out.println("BuildSystem: Build successful.");
    return true;
  }

  /**
   * Get the artifact
   */
  public String getArtifactPath() {
    String path = "target/application-1.0.jar";
    System.out.println("BuildSystem: Artifact located at " + path);
    return path;
  }

  private void simulateDelay() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}