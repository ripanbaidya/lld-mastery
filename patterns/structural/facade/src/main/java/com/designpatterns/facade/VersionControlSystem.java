package com.designpatterns.facade;

/**
 * Version Control System
 * Handles interaction with Git or another VCS. Responsible for fetching the latest code.
 */
class VersionControlSystem {

  /**
   * Pull latest changes from the given branch
   *
   * @param branch branch from where we want to pull the changes
   */
  public void pullLatestChanges(String branch) {
    System.out.println("VCS: Pulling latest changes from '" + branch + "'...");
    simulateDelay();
    System.out.println("VCS: Pull complete.");
  }

  private void simulateDelay() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}