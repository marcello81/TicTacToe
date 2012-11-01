package de.pierry.tictactoe;

public enum Player
{
	ONE('x'), TWO('o');

	private char marker;
	private boolean isWinner = false;

	private Player(char marker)
	{
		this.marker = marker;
	}

	public char getMarker()
	{
		return marker;
	}

	public boolean isWinner()
	{
		return this.isWinner;
	}

	public void setWinner(boolean isWinner)
	{
		this.isWinner = isWinner;
	}
}
