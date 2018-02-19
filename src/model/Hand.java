package model;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

import javax.swing.JLayeredPane;

import common.GameEnums.ResourceType;

public class Hand extends JLayeredPane
{
	public Hand()
	{		
		this.setName("Hand");

		MouseHandler handler = new MouseHandler();
		this.addMouseListener(handler);
		this.addMouseMotionListener(handler);
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
		setCards();
	}
	public void setCards()
	{
		Point origin = new Point(0, 20);
		int offset = calculateOffset(this.getWidth(), this.getComponentCount());
		
		Component[] comps = this.getComponents();
		this.removeAll();
		Arrays.sort(comps);
		
		for(Component comp : comps)
		{
			comp.setBounds((int)(origin.getX()), (int)(origin.getY()), (int)(Card.CARD_SIZE.getWidth()), (int)(Card.CARD_SIZE.getHeight()));
			this.add(comp);
			this.moveToFront(comp);
			origin.x += offset;
		}
		repaint();
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
	class MouseHandler extends MouseAdapter
	{
		public void mouseMoved(MouseEvent e)
		{
			Hand hand = (Hand)e.getSource();
			
			for(Component card : hand.getComponents())
			{
				if(card.contains(e.getX(), e.getY()))
				{
					System.out.println("Card: " + card.getName() + " | " + hand.getLayer(card));
				}
			}
		}
	}
}
