package com.designpatterns.facade;

/**
 * Deployment Target
 * Handles artifact delivery to the server and version activation.
 */
class DeploymentTarget {
  /**
   * Transfer the artifact
   */
  public void transferArtifact(String artifactPath, String server) {
    System.out.println("Deployment: Transferring " + artifactPath + " to " + server + "...");
    simulateDelay(1000);
    System.out.println("Deployment: Transfer complete.");
  }

  /**
   * Activate the new version
   */
  public void activateNewVersion(String server) {
    System.out.println("Deployment: Activating new version on " + server + "...");
    simulateDelay(500);
    System.out.println("Deployment: Now live on " + server + "!");
  }

  private void simulateDelay(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}