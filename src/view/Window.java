package view;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
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
		setSize(800, 800);
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
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					System.exit(0);
				}
			}
		});
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(ASSETS.getTile_desert());
	}
}
