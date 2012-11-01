package de.pierry.tictactoe;

import junit.framework.TestCase;

import org.junit.Assert;

public class BoardTest extends TestCase
{
	public void testIsMoveInsideBoard()
	{
		Board board = new Board();

		for (int i = 1; i <= Board.CELL_COUNT; i++)
		{
			Assert.assertTrue(board.isMoveInsideBoard(i));
		}

		Assert.assertFalse(board.isMoveInsideBoard(0));
		Assert.assertFalse(board.isMoveInsideBoard(Board.CELL_COUNT + 1));
	}

	public void testCellIsEmpty()
	{
		Board board = new Board();

		for (int i = 1; i <= Board.CELL_COUNT; i++)
		{
			Assert.assertTrue(board.isCellEmpty(i));
		}
	}

	public void testIsFull()
	{
		Board board = new Board();

		for (int i = 1; i <= Board.CELL_COUNT; i++)
		{
			Assert.assertFalse(board.isFull());
			board.setCell(i, i % 2 == 0 ? Player.TWO : Player.ONE);
		}

		Assert.assertTrue(board.isFull());
	}

}
