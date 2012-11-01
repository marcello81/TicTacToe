package de.pierry.tictactoe;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class TicTacToe
{
	private static final Logger LOGGER = Logger.getLogger(TicTacToe.class.getName());
	private static final Scanner IN = new Scanner(System.in);

	private TicTacToe()
	{
	}

	public static void main(String args[])
	{
		Game game = new Game();
		
		printWelcomeMessage();

		game.printBoard();

		while (true)
		{
			int move = askForNextMove(game);
			game.makeMove(move);

			game.printBoard();

			if (game.isRunning() == false)
			{
				break;
			}

			game.switchCurrentPlayer();
		}

		game.printResult();
	}

	private static void printWelcomeMessage()
	{
		LOGGER.info("Welcome to TicTacToe.");
	}

	private static int askForNextMove(Game game)
	{
		LOGGER.log(Level.INFO, "Player %s, it's your turn. Make your move: ", game.getCurrentPlayer());

		int move = getMoveFromPrompt();

		/* 1 */
		while (game.isValidMove(move) == false)
		{
			LOGGER.info("Illegal move, try again.");
			move = getMoveFromPrompt();
		}
		return move;
	}

	private static int getMoveFromPrompt()
	{
		while (IN.hasNextInt() == false)
		{
			LOGGER.info("Invalid number, re-enter: ");
			IN.next();
		}
		return IN.nextInt();
	}
}

/* FUSSNOTEN */

/*
 * (1) An diesen Stellen meckert Sonar, dass man die Booleschen Ausdruecke vereinfachen kann,
 * allerdings hat sich diese Schreibweise fuer mich in der Praxis als sehr vorteilhaft erwiesen, da
 * hierbei das Ausrufezeichen ( wie z.B. in "!game.isRunning()" ) nicht so einfach uebersehen werden
 * kann. (Bessere Lesbarkeit)
 */