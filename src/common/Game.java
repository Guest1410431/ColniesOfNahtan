package common;

import common.GameEnums.GameMode;
import model.Deck;
import model.Player;

public class Game
{
	private GameMode gameMode;
	
	private Player[]players;

	private Deck deck;

	public Game(GameMode gameMode)
	{
		this.gameMode = gameMode;
		
		deck = new Deck();
	}

	public Player[] getPlayers()
	{
		return players;
	}
}
