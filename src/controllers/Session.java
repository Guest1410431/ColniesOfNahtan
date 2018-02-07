package controllers;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import common.GameEnums.ResourceType;
import interfaces.GameConstants;
import model.Player;
import model.ResourceCard;
import view.PlayerPanel;
import view.BoardPanel;

public class Session extends JPanel implements GameConstants
{
	private PlayerPanel playerPanel;
	private BoardPanel boardPanel;

	public Session()
	{
		setBounds(0, 0, 800, 800);
		setBackground(Color.WHITE);

		Player bigTony = new Player("Big Tony");
		for(int i=0; i<55; i++)
		{
			ResourceCard card = new ResourceCard(ResourceType.WOOD);
			card.addMouseListener(CARD_LISTENER);
			bigTony.addCard(card);
		}
		playerPanel = new PlayerPanel(bigTony);

		boardPanel = new BoardPanel();

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
	}
}
