package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Assets
{
	private BufferedImage defaultTexture;

	private BufferedImage card_wood;
	private BufferedImage card_sheep;
	private BufferedImage card_ore;
	private BufferedImage card_wheat;
	private BufferedImage card_clay;

	private BufferedImage tile_wood;
	private BufferedImage tile_sheep;
	private BufferedImage tile_ore;
	private BufferedImage tile_wheat;
	private BufferedImage tile_clay;
	private BufferedImage tile_water;
	private BufferedImage tile_desert;

	public Assets()
	{
		loadImages();
	}

	private void loadImages()
	{
		defaultTexture = loadImage("res/defaultTexture.png");

		card_wood = loadImage("res/card/wood.png");
		card_sheep = loadImage("res/card/sheep.png");
		card_ore = loadImage("res/card/ore.png");
		card_wheat = loadImage("res/card/wheat.png");
		card_clay = loadImage("res/card/clay.png");

		tile_wood = loadImage("res/tile/wood.png");
		tile_sheep = loadImage("res/tile/sheep.png");
		tile_ore = loadImage("res/tile/ore.png");
		tile_wheat = loadImage("res/tile/wheat.png");
		tile_clay = loadImage("res/tile/clay.png");
		tile_water = loadImage("res/tile/water.png");
		tile_desert = loadImage("res/tile/desert.png");
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

	public BufferedImage getDefaultTexture()
	{
		return defaultTexture;
	}

	public BufferedImage getCard_wood()
	{
		return card_wood;
	}

	public BufferedImage getCard_sheep()
	{
		return card_sheep;
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

	public BufferedImage getTile_sheep()
	{
		return tile_sheep;
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
}
