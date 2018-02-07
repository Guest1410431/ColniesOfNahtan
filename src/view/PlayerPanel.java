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
import javax.swing.JPanel;

import common.GameEnums.ResourceType;
import model.Card;
import model.Hand;
import model.Player;
import model.ResourceCard;
import interfaces.GameConstants;

public class PlayerPanel extends JPanel implements GameConstants
{
	private Player player;

	private Box cardPanel;
	private Box controlPanel;
	
	private Hand cardHolder;

	// TODO: Replace with own GUI buttons
	private JButton build;
	private JButton roll;
	private JLabel playerName;
	private ButtonHandler buttonHandler;

	public PlayerPanel(Player player)
	{
		this.player = player;

		cardPanel = Box.createHorizontalBox();
		cardHolder = new Hand();
		cardHolder.setPreferredSize(new Dimension(600, 200));
		cardHolder.setSize(600, 200);

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

		Point origin = new Point(0, 20);
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
		build = new JButton("Add");
		roll = new JButton("Remove");
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
		controlPanel.addKeyListener(KEY_LISTENER);
	}

	private int calculateOffset(int width, int totalCards)
	{
		int offset = 75;

		if (totalCards <= 8)
		{
			return offset;
		}
		else
		{
			return (int) ((width - 150) / (totalCards - 1));
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
					Card card = new ResourceCard(ResourceType.values()[(int) (Math.random() * 5)]);
					card.addMouseListener(CARD_LISTENER);
					addCard(card);
				}
				else if (e.getSource() == roll)
				{
					removeCard(ResourceType.WOOD);
				}
			}
		}
	}

	public void addCard(Card card)
	{
		player.addCard(card);
		setCards();
	}

	public void removeCard(ResourceType resourceType)
	{
		if (player.getHand().size() > 0)
		{
			for (int i = 0; i < player.getHand().size(); i++)
			{
				if (player.getHand().get(i).getResourceType() == resourceType)
				{
					removeCard(i);
					return;
				}
			}
			System.out.println("Insufficient Resources");
		}
	}

	private void removeCard(int index)
	{
		if (player.getHand().size() > 0)
		{
			player.removeCard(index);
			setCards();
		}
	}
}
