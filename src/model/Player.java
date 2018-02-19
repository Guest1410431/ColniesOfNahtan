package model;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Arrays;

import common.GameEnums.ResourceType;

public class Player
{
	private boolean isTurn;
	
	private int points;
	
	private String name;
	
	private Hand hand;
	
	public Player()
	{
		init();
	}
	public Player(String name)
	{
		this.name = name;
		init();
	}
	private void init()
	{
		isTurn = true;
		points = 0;
		hand = new Hand();
		hand.setPreferredSize(new Dimension(600, 200));
		hand.setSize(600, 200);
	}
	public void setTurn(boolean isTurn)
	{
		this.isTurn = isTurn;
	}
	public void gainPoints(int points)
	{
		this.points += points;
	}
	public void addCard(Card card)
	{
		hand.addCard(card);
	}
	public void removeCard(ResourceType resourceType)
	{
		hand.removeCard(resourceType);
	}
	public boolean isTurn()
	{
		return isTurn;
	}
	public int getPoints()
	{
		return points;
	}
	public String getName()
	{
		return name;
	}
	public Hand getHand()
	{
		return hand;
	}
	public void setCards()
	{
		hand.setCards();
	}
}