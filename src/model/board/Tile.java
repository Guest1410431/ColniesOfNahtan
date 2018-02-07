package model.board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.TexturePaint;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import common.GameEnums;
import common.GameEnums.ResourceType;
import interfaces.GameConstants;
import interfaces.TileInterface;

// TODO: Consider if it is worth it making this a custom JPanel object
// 	   : rather than a custom object by itself.
public class Tile extends JPanel implements GameConstants, TileInterface
{
	private int xPos;
	private int yPos;
	private int radius;

	// Number on the Tile (2-12)
	private int diceRoll;

	private ResourceType resource;

	private BufferedImage tileImage;

	public Tile(int xPos, int yPos, int width)
	{
		this.xPos = xPos;
		this.yPos = yPos;

		radius = width;
	}

	public void setResourceType(ResourceType resource)
	{
		this.resource = resource;
		
		switch (resource)
		{
		case WOOD:
			tileImage = ASSETS.getTile_wood();
			break;
		case SHEEP:
			tileImage = ASSETS.getTile_sheep();
			break;
		case ORE:
			tileImage = ASSETS.getTile_ore();
			break;
		case WHEAT:
			tileImage = ASSETS.getTile_wheat();
			break;
		case CLAY:
			tileImage = ASSETS.getTile_clay();
			break;
		default:
			tileImage = ASSETS.getDefaultTexture();
		}
		this.setLocation(xPos, yPos);
		this.setSize(TILE_SIZE);
		
		this.addMouseListener(new MouseHandler());
	}

	public GameEnums.ResourceType getResourceType()
	{
		return resource;
	}

	public String toString()
	{
		return resource.name() + " | " + this.getX() + " | " + this.getY() + " | " + this.getWidth() + " | " + this.getHeight();
	}

	private Polygon calculatePolygon()
	{
		int[] xPoints = new int[6];
		int[] yPoints = new int[6];

		double angle;

		for (int i = 0; i < 6; i++)
		{
			angle = ((Math.PI / 3.0) * i);

			xPoints[i] = (int) (Math.round(xPos + Math.sin(angle) * radius));
			yPoints[i] = (int) (Math.round(yPos + Math.cos(angle) * radius));
		}
		return new Polygon(xPoints, yPoints, 6);
	}

	private void drawHexagon(Graphics g)
	{
		Polygon hexagon = calculatePolygon();

		Graphics2D g2 = (Graphics2D) g;

		TexturePaint texturePaint = new TexturePaint(tileImage, hexagon.getBounds2D());
		g2.setPaint(texturePaint);
		g2.fill(hexagon);

		g.setColor(Color.BLACK);
		g.drawPolygon(hexagon);
	}

	public void render(Graphics g)
	{
		drawHexagon(g);
		g.setColor(Color.RED);
		g.drawRect(getX()-(getWidth()/2)+(getWidth()/16), getY()-(getHeight()/2), getWidth()-(getWidth()/8), getHeight());
	}
	
	class MouseHandler extends MouseAdapter
	{
		public void mouseClicked(MouseEvent e)
		{
			System.out.println("Tile: " + resource.toString());
		}
		public void mousePressed(MouseEvent e)
		{
			
		}
		public void mouseReleased(MouseEvent e)
		{
			
		}
	}
}










