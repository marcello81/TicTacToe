package de.pierry.tictactoe;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Game
{
	private static final Logger LOGGER = Logger.getLogger(TicTacToe.class.getName());

	private final Board board = new Board();
	private Player currentPlayer = Player.ONE;

	public void makeMove(int move)
	{
		board.setCell(move, currentPlayer);
	}

	public void switchCurrentPlayer()
	{
		currentPlayer = currentPlayer == Player.ONE ? Player.TWO : Player.ONE;
	}

	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}

	public boolean isValidMove(int move)
	{
		return board.isMoveInsideBoard(move) && board.isCellEmpty(move);
	}

	public boolean isRunning()
	{
		return currentPlayer.isWinner() == false && board.isFull() == false;
	}

	public void printBoard()
	{
		LOGGER.info(board.toString());
	}

	public void printResult()
	{
		StringBuilder message = new StringBuilder();
		message.append("Game over! ");
		if (currentPlayer.isWinner())
		{
			message.append("Player %s wins!");
			LOGGER.log(Level.INFO, message.toString(), currentPlayer);
		}
		else
		{
			message.append("Draw!");
			LOGGER.info(message.toString());
		}
	}
}
