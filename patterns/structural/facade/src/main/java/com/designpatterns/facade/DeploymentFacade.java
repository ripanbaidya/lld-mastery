package com.designpatterns.facade;

/*
 * Implementing Facade Design Pattern
 *
 * The Facade class — in our case, DeploymentFacade — serves as a single, unified
 * interface to a complex set of operations involved in application deployment.
 * Internally, it holds references to the core building blocks of the deployment
 * pipeline:
 *
 * - VersionControlSystem – Fetches the latest code from a Git branch
 * - BuildSystem – Compiles the code and generates the deployable artifact
 * - TestingFramework – Runs automated tests (unit, integration)
 * - DeploymentTarget – Transfers the artifact and activates it on the target server
 *
 * Rather than forcing the client to call each of these subsystems in the correct order,
 * the facade abstracts this coordination logic and offers a clean, high-level method
 * like deployApplication() that executes the full workflow.
 */
public class DeploymentFacade {
  // Subsystems
  private final VersionControlSystem vcs = new VersionControlSystem();
  private final BuildSystem buildSystem = new BuildSystem();
  private final TestingFramework testingFramework = new TestingFramework();
  private final DeploymentTarget deploymentTarget = new DeploymentTarget();

  /**
   * High level subSystemOperation
   */
  public boolean deployApplication(String branch, String serverAddress) {
    System.out.println("\nFACADE: --- Initiating FULL DEPLOYMENT for branch: "
        + branch + " to " + serverAddress + " ---");
    boolean success = true;

    try {
      // Pull latest changes
      vcs.pullLatestChanges(branch);

      // Compile the project
      if (!buildSystem.compileProject()) {
        System.err.println("FACADE: DEPLOYMENT FAILED - Build compilation failed.");
        return false;
      }

      // Get the artifact
      String artifactPath = buildSystem.getArtifactPath();

      // Run testing step by step
      if (!testingFramework.runUnitTests()) {
        System.err.println("FACADE: DEPLOYMENT FAILED - Unit tests failed.");
        return false;
      }

      if (!testingFramework.runIntegrationTests()) {
        System.err.println("FACADE: DEPLOYMENT FAILED - Integration tests failed.");
        return false;
      }

      // Transfer the artifact and activate new version
      deploymentTarget.transferArtifact(artifactPath, serverAddress);
      deploymentTarget.activateNewVersion(serverAddress);

      System.out.println("FACADE: APPLICATION DEPLOYED SUCCESSFULLY to " + serverAddress + "!");
    } catch (Exception e) {
      System.err.println("FACADE: DEPLOYMENT FAILED - An unexpected error occurred: " + e.getMessage());
      success = false;
    }

    return success;
  }
}