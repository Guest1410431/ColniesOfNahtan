package gui;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import interfaces.GameConstants;

public class SoSo_Letter extends LetterImage implements GameConstants
{
	private final int SPACE_SIZE = 5;
	private int width;
	private int height;

	private BufferedImage letterImage;

	private static ArrayList<BufferedImage> letterImages;

	public SoSo_Letter(char letter)
	{
		letterImages = ASSETS.getSoSo_Font_Letters();
		letterImage = null;

		if (letter >= 65 && letter <= 90)
		{
			letterImage = letterImages.get(letter - 65);
		}
		else if (letter >= 97 && letter <= 122)
		{
			letterImage = letterImages.get(letter - 97 + 26);
		}
		else if (letter == ' ')
		{
			letterImage = new BufferedImage(SPACE_SIZE, 1, BufferedImage.TYPE_INT_ARGB);
		}
		else
		{
			switch(letter)
			{
			case(39):
				letterImage = letterImages.get(52);
				break;
			default:
				System.out.println("Error: Invalid Character: " + letter + " | " + (int)(letter));
				letterImage = new BufferedImage(SPACE_SIZE, 1, BufferedImage.TYPE_INT_ARGB);
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