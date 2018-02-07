package model;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import common.GameEnums.ResourceType;

public class Hand extends JLayeredPane
{
	private ArrayList<Card>cards;
	
	public Hand()
	{
		cards = new ArrayList<Card>();
		
		this.addMouseListener(new MouseHandler());
	}
	public void addCard(Card card)
	{
		
	}
	public void removeCard(ResourceType resourceType)
	{
		
	}
	class MouseHandler extends MouseAdapter
	{
		public void mouseEntered(MouseEvent e)
		{
			System.out.println("Hello");
		}
		public void mouseExited(MouseEvent e)
		{
			
		}
	}
}
