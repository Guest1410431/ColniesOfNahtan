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
		switch(resource) {
		case WOOD : 
			setName(ResourceType.WOOD.name());
			cardImage = ASSETS.getCard_wood();
			break;
		case WOOL : 
			setName(ResourceType.WOOL.name());
			cardImage = ASSETS.getCard_wool();
			break;
		case ORE : 
			setName(ResourceType.ORE.name());
			cardImage = ASSETS.getCard_ore();
			break;
		case WHEAT : 
			setName(ResourceType.WHEAT.name());
			cardImage = ASSETS.getCard_wheat();
			break;
		case CLAY : 
			setName(ResourceType.CLAY.name());
			cardImage = ASSETS.getCard_clay();
			break;
		default:
			cardImage = ASSETS.getDefaultTexture();
		}

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
	public String toString()
	{
		return resource.name();
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// Render here
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
