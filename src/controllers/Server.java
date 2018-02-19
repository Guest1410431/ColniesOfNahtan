package controllers;

import common.GameEnums.GameMode;
import interfaces.GameConstants;

public class Server implements GameConstants
{
	private GameMode gameMode;
	
	private Session session;
	
	public Server()
	{
		gameMode = GameMode.MENU;
		session = new Session(gameMode);
		// Run Game
	}
	public Session getSession()
	{
		return this.session;
	}
}
