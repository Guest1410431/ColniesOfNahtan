package controllers;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import common.Game;
import interfaces.GameConstants;
import model.Deck;
import model.Player;
import view.PlayerPanel;
import view.TablePanel;

public class Session extends JPanel implements GameConstants
{
	private PlayerPanel playerPanel;
	private TablePanel tablePanel;
	
	private Game game;
	
	private Deck deck;

	public Session(Game game)
	{
		this.game = game;
		deck = new Deck();
		
		setBounds(0, 0, 800, 800);
		setBackground(Color.WHITE);
		
		initPlayers();
		
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPanel gamePanel = new JPanel();
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addComponent(gamePanel, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
				.addComponent(playerPanel, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE));
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(gamePanel, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(playerPanel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)));
		this.setLayout(layout);
	}

	private void initPlayers()
	{
		Player bob = new Player("Bob");
		
		for(int i=0; i<6; i++)
		{
			bob.addCard(deck.getCard());
		}
		playerPanel = new PlayerPanel(bob);
	}
}











