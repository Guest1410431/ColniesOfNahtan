package common;

import common.GameEnums.GameMode;
import model.Player;

public class Game
{
	private GameMode gameMode;
	
	private Player[]players;
	
	public Game(GameMode gameMode)
	{
		this.gameMode = gameMode;
	}

	public Player[] getPlayers()
	{
		return players;
	}
}
