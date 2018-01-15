package view;

import javax.swing.JFrame;

import controllers.Server;
import controllers.Session;
import interfaces.GameConstants;

public class Window extends JFrame implements GameConstants
{
	private Session session;
	private Server server;

	public Window()
	{
		this.setSize(800, 800);
		server = new Server();
		CARD_LISTENER.setServer(server);
		BUTTON_LISTENER.setServer(server);

		session = server.getSession();
		add(session);
	}
}
