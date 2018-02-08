package model;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLayeredPane;

import common.GameEnums.ResourceType;

public class Hand extends JLayeredPane
{
	public Hand()
	{		
		this.addMouseListener(new MouseHandler());
	}
	public void addCard(Card card)
	{
		this.add(card);
	}
	public void removeCard(ResourceType resourceType)
	{
		for(Component card : this.getComponents())
		{
			if(card.getName().equals(resourceType.name()))
			{
				this.remove(card);
				return;
			}
		}
		System.out.println("Insufficient Resources");
	}
	class MouseHandler extends MouseAdapter
	{
		public void mouseEntered(MouseEvent e)
		{
			
		}
		public void mouseExited(MouseEvent e)
		{
			
		}
	}
}
