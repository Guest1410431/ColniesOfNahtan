package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.GameEnums.ResourceType;
import model.Card;
import model.Player;
import model.ResourceCard;
import interfaces.GameConstants;

public class PlayerPanel extends JPanel implements GameConstants
{
	private Player player;

	private Box cardPanel;
	private Box controlPanel;

	// TODO: Replace with own GUI buttons
	private JButton build;
	private JButton roll;
	private JLabel playerName;
	private ButtonHandler buttonHandler;

	public PlayerPanel(Player player)
	{
		this.player = player;

		cardPanel = Box.createHorizontalBox();

		setCards();
		setControlPanel();

		cardPanel.add(player.getHand());
		cardPanel.add(Box.createHorizontalStrut(40));
		cardPanel.add(controlPanel);
		add(cardPanel);

		buttonHandler = new ButtonHandler();
		build.addMouseListener(BUTTON_LISTENER);
		build.addActionListener(buttonHandler);

		roll.addMouseListener(BUTTON_LISTENER);
		roll.addActionListener(buttonHandler);
		
		repaint();
	}

	private void setCards()
	{
		player.setCards();
		
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
		player.removeCard(resourceType);
		setCards();
	}
}
