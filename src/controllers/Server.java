package controllers;

import common.Game;
import common.GameEnums.GameMode;
import interfaces.GameConstants;

public class Server implements GameConstants
{	
	private GameMode gameMode;
	
	private Game game;
	
	private Session session;
	
	public Server()
	{
		gameMode = GameMode.MENU;
		
		game = new Game(gameMode);
		session = new Session(game);
	}

	public Session getSession()
	{
		return this.session;
	}
}
