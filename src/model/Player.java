package model;

import java.util.ArrayList;

public class Player
{
	private boolean isTurn;
	
	private int points;
	
	private String name;
	
	private ArrayList<Card>hand;
	
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
		hand = new ArrayList<Card>();
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
		hand.add(card);
	}
	public void removeCard(int index)
	{
		hand.remove(index);
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
	public ArrayList<Card> getHand()
	{
		return hand;
	}
}


















