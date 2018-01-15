package model;

import java.util.LinkedList;

import common.GameEnums;
import interfaces.GameConstants;

public class Deck implements GameConstants
{
	private LinkedList<Card>deck;
	
	public Deck()
	{
		deck = new LinkedList<Card>();
	
		for(int i=0; i<50; i++)
		{
			for(int h=0; h<GameEnums.ResourceType.values().length; h++)
			{
				Card card = new ResourceCard(GameEnums.ResourceType.values()[h]);
				card.addMouseListener(CARD_LISTENER);
				deck.add(card);
			}
		}
	}
	public Card getCard()
	{
		return deck.get((int)(Math.random()*deck.size()));
	}
}
