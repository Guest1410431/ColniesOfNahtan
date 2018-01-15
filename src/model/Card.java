package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import common.GameEnums;
import common.GameEnums.ResourceType;
import interfaces.CardInterface;
import interfaces.GameConstants;
import util.Assets;

public abstract class Card extends JPanel implements GameConstants, CardInterface
{	
	private ResourceType resource;
	
	private BufferedImage cardImage;
	
	public Card()
	{
		
	}

	public Card(ResourceType resource)
	{
		this.resource = resource;
		this.cardImage = Assets.loadImage("res/card/" + resource.toString() + ".png");

		this.setPreferredSize(CARD_SIZE);
		this.setBorder(BorderFactory.createEtchedBorder(WHEN_FOCUSED, Color.WHITE, Color.GRAY));

		this.addMouseListener(new MouseHandler());
	}

	public void setCardSize(Dimension dimension)
	{
		this.setPreferredSize(dimension);
	}

	public void setResourceType(ResourceType resource)
	{
		this.resource = resource;
	}

	public GameEnums.ResourceType getResourceType()
	{
		return resource;
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// Render here		
		g.setColor(Color.RED);
		g.drawRect(0, 0, (int)(CARD_SIZE.getWidth()), (int)(CARD_SIZE.getHeight()));
		g.drawImage(cardImage, 0, 0, (int)(CARD_SIZE.getWidth()), (int)(CARD_SIZE.getHeight()), null);
	}

	class MouseHandler extends MouseAdapter
	{
		public void mouseEntered(MouseEvent e)
		{
			setBorder(BorderFactory.createEtchedBorder(WHEN_FOCUSED, Color.BLACK, Color.GRAY));
			
		}
		public void mouseExited(MouseEvent e)
		{
			setBorder(BorderFactory.createEtchedBorder(WHEN_IN_FOCUSED_WINDOW, Color.WHITE, Color.GRAY));
		}
	}
}
