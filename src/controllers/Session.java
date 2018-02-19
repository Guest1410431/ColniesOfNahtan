package controllers;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import common.GameEnums.GameMode;
import common.GameEnums.ResourceType;
import gui.Menu;
import interfaces.GameConstants;
import model.Card;
import model.Player;
import model.ResourceCard;
import view.PlayerPanel;
import view.BoardPanel;

public class Session extends JPanel implements GameConstants
{
	private GameMode gameMode;

	private Menu menu;
	private PlayerPanel playerPanel;
	private BoardPanel boardPanel;

	public Session(GameMode gameMode)
	{
		setBounds(0, 0, 800, 1000);
		setBackground(Color.WHITE);

		this.gameMode = gameMode;

		updateGameState();
	}

	private void updateGameState()
	{
		this.removeAll();
		
		switch (gameMode)
		{
		case MENU:
			Menu menu = new Menu();
			GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap().addComponent(menu, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE).addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(menu, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE).addContainerGap())
			);
			setLayout(groupLayout);

			break;
		case GAME:
			Player bigTony = new Player("Big Tony");

			for (int i = 0; i < ResourceType.values().length; i++)
			{
				Card card = new ResourceCard(ResourceType.values()[i]);
				card.addMouseListener(CARD_LISTENER);
				bigTony.addCard(card);
			}
			boardPanel = new BoardPanel();
			boardPanel.setBounds(5, 5, 772, 575);
			boardPanel.initBoard();

			playerPanel = new PlayerPanel(bigTony);
			playerPanel.setBounds(5, 580, 772, 175);

			this.setBorder(new EmptyBorder(5, 5, 5, 5));

			GroupLayout layout = new GroupLayout(this);
			layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
					.addComponent(boardPanel, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
					.addComponent(playerPanel, GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE));
			layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
							.addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 575, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(playerPanel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)));
			this.setLayout(layout);
			break;
		case GAME_OVER:

			break;
		}
	}
	public void setGameMode(GameMode gameMode)
	{
		this.gameMode = gameMode;
		
		updateGameState();
	}
}
