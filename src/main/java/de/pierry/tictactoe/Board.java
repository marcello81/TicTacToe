package de.pierry.tictactoe;

import java.util.Arrays;

public class Board
{
	private static final int EDGE_LENGTH = 3;
	public static final int CELL_COUNT = EDGE_LENGTH * EDGE_LENGTH;
	private static final char EMPTY_CELL = ' ';
	private static char[] cells = new char[CELL_COUNT];
	private static final int[][] WINNING_COMBINATIONS = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
															{ 2, 4, 6 } };

	public Board()
	{
		Arrays.fill(cells, EMPTY_CELL);
	}

	public boolean isMoveInsideBoard(int move)
	{
		return move > 0 && CELL_COUNT >= move;
	}

	public boolean isCellEmpty(int move)
	{
		return cells[move - 1] == EMPTY_CELL;
	}

	public void setCell(int move, Player player)
	{
		cells[move - 1] = player.getMarker();
		player.setWinner(isPlayerAWinner(player));
	}

	public boolean isFull()
	{
		for (char cell : cells)
		{
			if (cell == EMPTY_CELL)
			{
				return false;
			}
		}
		return true;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("\nBoard:\n");
		for (int cellNb = 1; cellNb <= CELL_COUNT; cellNb++)
		{
			char cell = cells[cellNb - 1];

			sb.append("[");
			sb.append(cell == EMPTY_CELL ? cellNb : cell + "");
			sb.append("]");
			if (cellNb % EDGE_LENGTH == 0)
			{
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	private boolean isPlayerAWinner(Player player)
	{
		outer: for (int[] winningCombination : WINNING_COMBINATIONS)
		{
			for (int cellNb : winningCombination)
			{
				if (cells[cellNb] != player.getMarker())
				{
					continue outer;
				}
			}
			return true;
		}
		return false;
	}
}
