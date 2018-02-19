package util;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import common.GameEnums.ResourceTile;
import common.GameEnums.ResourceType;

public class Assets
{
	private BufferedImage defaultTexture;

	private BufferedImage card_wood;
	private BufferedImage card_wool;
	private BufferedImage card_ore;
	private BufferedImage card_wheat;
	private BufferedImage card_clay;

	private BufferedImage tile_wood;
	private BufferedImage tile_wool;
	private BufferedImage tile_ore;
	private BufferedImage tile_wheat;
	private BufferedImage tile_clay;
	private BufferedImage tile_water;
	private BufferedImage tile_desert;

	private static ArrayList<BufferedImage> SoSo_Sheet = new ArrayList<BufferedImage>();
	private static ArrayList<BufferedImage> FFF_Sheet = new ArrayList<BufferedImage>();
	
	public Assets()
	{
		loadImages();
	}

	private void loadImages()
	{
		defaultTexture = loadImage("res/defaultTexture.png");

		card_wood = loadImage("res/card/" + ResourceType.WOOD.toString() + ".png");
		card_wool = loadImage("res/card/" + ResourceType.WOOL.toString() + ".png");
		card_ore = loadImage("res/card/" + ResourceType.ORE.toString() + ".png");
		card_wheat = loadImage("res/card/" + ResourceType.WHEAT.toString() + ".png");
		card_clay = loadImage("res/card/" + ResourceType.CLAY.toString() + ".png");

		tile_wood = loadImage("res/tile/" + ResourceTile.WOOD.toString() + ".png");
		tile_wool = loadImage("res/tile/" + ResourceTile.WOOL.toString() + ".png");
		tile_ore = loadImage("res/tile/" + ResourceTile.ORE.toString() + ".png");
		tile_wheat = loadImage("res/tile/" + ResourceTile.WHEAT.toString() + ".png");
		tile_clay = loadImage("res/tile/" + ResourceTile.CLAY.toString() + ".png");
		tile_water = loadImage("res/tile/" + ResourceTile.WATER.toString() + ".png");
		tile_desert = loadImage("res/tile/" + ResourceTile.DESERT.toString() + ".png");
		
		loadFFFFontArray();
		loadSoSoFontArray();
	}

	private static BufferedImage loadImage(String path)
	{
		BufferedImage image = null;

		try
		{
			image = ImageIO.read(new File(path));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return image;
	}
	private void loadSoSoFontArray()
	{
		BufferedImage fontSheet = loadImage("res/fonts/SoSo_Shady_Font.png");

		int x = 0;

		for (int i = 1; i < fontSheet.getWidth(); i++)
		{
			if (fontSheet.getRGB(i, 0) == Color.RED.getRGB())
			{
				SoSo_Sheet.add(fontSheet.getSubimage(x + 1, 0, i - x - 1, fontSheet.getHeight()));
				x = i;
			}
		}
	}

	private void loadFFFFontArray()
	{
		BufferedImage fontSheet = loadImage("res/fonts/FFF_Forward_Font.png");

		int x = 0;

		for (int i = 1; i < fontSheet.getWidth(); i++)
		{
			if (fontSheet.getRGB(i, 0) == Color.RED.getRGB())
			{
				FFF_Sheet.add(fontSheet.getSubimage(x + 1, 0, i - x - 1, fontSheet.getHeight()));
				x = i;
			}
		}
	}

	public BufferedImage getDefaultTexture()
	{
		return defaultTexture;
	}

	public BufferedImage getCard_wood()
	{
		return card_wood;
	}

	public BufferedImage getCard_wool()
	{
		return card_wool;
	}

	public BufferedImage getCard_ore()
	{
		return card_ore;
	}

	public BufferedImage getCard_wheat()
	{
		return card_wheat;
	}

	public BufferedImage getCard_clay()
	{
		return card_clay;
	}

	public BufferedImage getTile_wood()
	{
		return tile_wood;
	}

	public BufferedImage getTile_wool()
	{
		return tile_wool;
	}

	public BufferedImage getTile_ore()
	{
		return tile_ore;
	}

	public BufferedImage getTile_wheat()
	{
		return tile_wheat;
	}

	public BufferedImage getTile_clay()
	{
		return tile_clay;
	}

	public BufferedImage getTile_water()
	{
		return tile_water;
	}

	public BufferedImage getTile_desert()
	{
		return tile_desert;
	}
	
	public ArrayList<BufferedImage> getFFF_Font_Letters()
	{
		return FFF_Sheet;
	}

	public ArrayList<BufferedImage> getSoSo_Font_Letters()
	{
		return SoSo_Sheet;
	}
}
