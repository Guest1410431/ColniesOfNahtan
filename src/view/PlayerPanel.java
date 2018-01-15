package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Card;
import model.Player;
import interfaces.GameConstants;

public class PlayerPanel extends JPanel implements GameConstants
{
	private Player player;

	private Box cardPanel;
	private Box controlPanel;
	private JLayeredPane cardHolder;

	// TODO: Replace with own button
	private JButton build;
	private JButton roll;
	private JLabel playerName;
	private ButtonHandler buttonHandler;

	public PlayerPanel(Player player)
	{
		this.player = player;

		cardPanel = Box.createHorizontalBox();
		cardHolder = new JLayeredPane();
		cardHolder.setPreferredSize(new Dimension(600, 175));

		setCards();
		setControlPanel();

		cardPanel.add(cardHolder);
		cardPanel.add(Box.createHorizontalStrut(40));
		cardPanel.add(controlPanel);
		add(cardPanel);

		buttonHandler = new ButtonHandler();
		build.addActionListener(BUTTON_LISTENER);
		build.addActionListener(buttonHandler);

		roll.addActionListener(BUTTON_LISTENER);
		roll.addActionListener(buttonHandler);
	}

	private void setCards()
	{
		cardHolder.removeAll();

		System.out.println("Card Hold: " + cardHolder.getWidth() + " | Player Hand: " + player.getHand().size());
		Point origin = getPoint(cardHolder.getWidth(), player.getHand().size());
		int offset = calculateOffset(cardHolder.getWidth(), player.getHand().size());

		for (int i = 0; i < player.getHand().size(); i++)
		{
			Card card = player.getHand().get(i);
			card.setBounds(origin.x, origin.y, card.CARD_SIZE.width, card.CARD_SIZE.height);
			cardHolder.add(card, i);
			cardHolder.moveToFront(card);
			origin.x += offset;
		}
		repaint();
	}

	private void setControlPanel()
	{
		build = new JButton("Build");
		roll = new JButton("Roll");
		playerName = new JLabel(player.getName());

		// style
		build.setBackground(new Color(79, 129, 189));
		build.setFont(new Font("Arial", Font.BOLD, 20));
		build.setFocusable(false);

		roll.setBackground(new Color(149, 55, 53));
		roll.setFont(new Font("Arial", Font.BOLD, 20));
		roll.setFocusable(false);

		playerName.setForeground(Color.WHITE);
		playerName.setFont(new Font("Arial", Font.BOLD, 15));

		controlPanel = Box.createVerticalBox();
		controlPanel.add(playerName);
		controlPanel.add(build);
		controlPanel.add(Box.createVerticalStrut(15));
		controlPanel.add(roll);
	}

	private int calculateOffset(int width, int totalCards)
	{
		int offset = 80;

		if (totalCards <= 8)
		{
			return offset;
		}
		else
		{
			return (int) ((width - 100) / (totalCards - 1));
		}
	}

	private Point getPoint(int width, int totalCards)
	{
		Point p = new Point(0, 20);
		if (totalCards >= 8)
		{
			return p;
		}
		else
		{
			p.x = (width - calculateOffset(width, totalCards) * totalCards) / 2;
			return p;
		}
	}

	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (player.isTurn())
			{
				if (e.getSource() == build)
				{
					System.out.println("Build");
				}
				else if (e.getSource() == roll)
				{
					System.out.println("Roll");
				}
			}
		}
	}
}
