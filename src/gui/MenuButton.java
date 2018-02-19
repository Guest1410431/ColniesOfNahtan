package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import common.GameEnums.ResourceTile;
import interfaces.ButtonInterface;
import interfaces.GameConstants;

public class MenuButton extends JPanel implements ButtonInterface, GameConstants
{
	private String name;
	
	private int xPos;
	private int yPos;
	private Dimension radius;
	
	private BufferedImage tileImage;

	public MenuButton(int xPos, int yPos)
	{
		this.xPos = xPos;
		this.yPos = yPos;

		radius = BUTTON_SIZE;
		tileImage = ASSETS.getTile_water();
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public void setResource(ResourceTile resource)
	{
		switch(resource)
		{
		case CLAY:
			tileImage = ASSETS.getTile_clay();
			break;
		case DESERT:
			tileImage = ASSETS.getTile_desert();
			break;
		case ORE:
			tileImage = ASSETS.getTile_ore();
			break;
		case WATER:
			tileImage = ASSETS.getTile_water();
			break;
		case WHEAT:
			tileImage = ASSETS.getTile_wheat();
			break;
		case WOOD:
			tileImage = ASSETS.getTile_wood();
			break;
		case WOOL:
			tileImage = ASSETS.getTile_wool();
			break;
		default:
			System.out.println("Resource: " + resource.name());
			tileImage = ASSETS.getDefaultTexture();
		}
	}
	
	private Polygon calculatePolygon()
	{
		int[] xPoints = new int[6];
		int[] yPoints = new int[6];

		double angle;

		for (int i = 0; i < 6; i++)
		{
			angle = ((Math.PI / 3.0) * i);

			xPoints[i] = (int) (Math.round(xPos + Math.sin(angle) * radius.getWidth()));
			yPoints[i] = (int) (Math.round(yPos + Math.cos(angle) * radius.getHeight()));
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
	}
}
