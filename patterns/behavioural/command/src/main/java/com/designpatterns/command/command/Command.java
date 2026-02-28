package com.designpatterns.command.command;

/**
 * Command interface represents an executable action.
 * All concrete commands must implement execute and undo.
 */
public interface Command {

  /**
   * Execute the command logic
   */
  public void execute();

  /**
   * Reverts the command operation.
   */
  public void undo();
}
