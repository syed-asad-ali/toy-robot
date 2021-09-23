package com.robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A basic command line runner class
 * 
 *
 */
public class Runner {

	private BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

	private static final Integer MAX_X_GRID = 5;

	private static final Integer MAX_Y_GRID = 5;

	private final Commandeer commandeer;

	public static void main(String... args) {
		new Runner().run();
	}

	public Runner() {
		commandeer = new Commandeer(MAX_X_GRID, MAX_Y_GRID);
	}

	public void run() {
		boolean bRunning = true;
		while (bRunning) {
			try {
				System.out.flush();
				System.out.print("enter command (QUIT or EXIT to terminate ...) : ");
				System.out.flush();
				String command = readCommand();
				boolean bExit = command.equalsIgnoreCase("EXIT") || command.equalsIgnoreCase("QUIT");
				bRunning = !bExit;
				if (command.length() > 0 && bRunning) {
					executeCommand(command);
				}
			} catch (Exception e) {
				System.out.println();
				e.printStackTrace();
				System.out.println();
			}

		}
		// terminate
		System.exit(0);
	}

	private String readCommand() throws IOException {
		return inputReader.readLine().trim();
	}

	private void executeCommand(String command) {
		String[] commands = command.split(" ");

		String commandString = commands[0];
		String[] args = null;
		if (commands.length > 1)
			args = commands[1].split(",");

		commandeer.executeCommand(commandString, args);
		// optionally printing a pretty grid to see it visually!
		// uncomment to see grid printing
		// commandeer.printGrid();
	}

}
