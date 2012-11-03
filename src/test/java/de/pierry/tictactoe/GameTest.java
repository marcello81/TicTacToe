package de.pierry.tictactoe;

import junit.framework.TestCase;

public class GameTest extends TestCase
{
	public void testSwitchCurrentPlayer()
	{
		Game game = new Game();

		Player startingPlayer = game.getCurrentPlayer();

		game.switchCurrentPlayer();

		assertTrue(startingPlayer != game.getCurrentPlayer());
		assertTrue((game.getCurrentPlayer() == Player.ONE && game.getCurrentPlayer() != Player.TWO)
				|| (game.getCurrentPlayer() != Player.ONE && game.getCurrentPlayer() == Player.TWO));
	}

	public void testIsValidMove()
	{
		Game game = new Game();

		assertFalse(game.isValidMove(10));
		assertFalse(game.isValidMove(-1));
		assertFalse(game.isValidMove(0));

		assertTrue(game.isValidMove(1));
		
		game.makeMove(1);
		assertFalse(game.isValidMove(1));
	}
}
