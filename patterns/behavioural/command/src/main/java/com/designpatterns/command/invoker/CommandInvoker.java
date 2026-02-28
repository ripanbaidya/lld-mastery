package com.designpatterns.command.invoker;

import com.designpatterns.command.command.Command;

import java.util.Stack;

/**
 * Invoker
 */
public class CommandInvoker {

  private final Stack<Command> history = new Stack<>();

  public void executeCommand(Command command) {
    command.execute();
    history.push(command);
  }

  public void undoLastCommand() {
    if (!history.isEmpty()) {
      Command lastCommand = history.pop();
      lastCommand.undo();
    } else {
      System.out.println("No commands to undo");
    }
  }
}
