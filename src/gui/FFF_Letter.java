package gui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import interfaces.GameConstants;

public class FFF_Letter extends LetterImage implements GameConstants
{
	private final int SPACE_SIZE = 5;
	private int width;
	private int height;

	private BufferedImage letterImage;

	private static ArrayList<BufferedImage> letterImages;

	public FFF_Letter(char letter)
	{
		letterImages = ASSETS.getFFF_Font_Letters();
		letterImage = null;

		if (letter >= 65 && letter <= 90)
		{
			letterImage = letterImages.get(letter - 65);
		}
		else if (letter >= 97 && letter <= 122)
		{
			letterImage = letterImages.get(letter - 97);
		}
		else if (letter >= 48 && letter <= 57)
		{
			letterImage = letterImages.get(letter - 48 + 26);
		}
		else
		{
			switch (letter)
			{
			case (46):
				letterImage = letterImages.get(36);
				break;
			case (39):
				letterImage = letterImages.get(37);
				break;
			case (47):
				letterImage = letterImages.get(38);
				break;
			case (63):
				letterImage = letterImages.get(39);
				break;
			case (33):
				letterImage = letterImages.get(40);
				break;
			case (44):
				letterImage = letterImages.get(41);
				break;
			case(' '):
				letterImage = new BufferedImage(SPACE_SIZE, 1, BufferedImage.TYPE_INT_ARGB);
				break;
			default:
				letterImage = new BufferedImage(SPACE_SIZE, 1, BufferedImage.TYPE_INT_ARGB);
				System.out.println("Error: Invalid Character: " + letter);
			}
		}
		width = letterImage.getWidth();
		height = letterImage.getHeight();
	}

	public BufferedImage getImage()
	{
		return letterImage;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
}
