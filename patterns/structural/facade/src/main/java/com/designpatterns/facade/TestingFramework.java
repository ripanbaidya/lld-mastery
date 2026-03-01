package com.designpatterns.facade;

/**
 * Testing framework
 * Executes unit and integration tests. Could also include E2E, mutation testing,
 * or security scans in real-world setups.
 */
class TestingFramework {
  /**
   * Run unit test
   */
  public boolean runUnitTests() {
    System.out.println("Testing: Running unit tests...");
    simulateDelay(1500);
    System.out.println("Testing: Unit tests passed.");
    return true;
  }

  /**
   * Run integration test
   */
  public boolean runIntegrationTests() {
    System.out.println("Testing: Running integration tests...");
    simulateDelay(3000);
    System.out.println("Testing: Integration tests passed.");
    return true;
  }

  private void simulateDelay(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}