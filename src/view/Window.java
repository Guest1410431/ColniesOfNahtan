package view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import controllers.Server;
import controllers.Session;
import interfaces.GameConstants;

public class Window extends JFrame implements GameConstants
{
	private final int WIDTH = 1000;
	private final int HEIGHT = 800;

	private Session session;
	private Server server;

	public Window()
	{
		setSize(WIDTH, HEIGHT);
		server = new Server();
		CARD_LISTENER.setServer(server);
		BUTTON_LISTENER.setServer(server);
		TILE_LISTENER.setServer(server);

		session = server.getSession();
		add(session);

		addKeyListener(new KeyListener()
		{
			public void keyTyped(KeyEvent e)
			{

			}

			public void keyReleased(KeyEvent e)
			{

			}

			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					System.exit(0);
				}
			}
		});
		setResizable(true);
		setLocationRelativeTo(null);
		setIconImage(ASSETS.getTile_desert());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
