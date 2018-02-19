package gui;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MenuTitle extends JPanel
{
	private final int LETTER_SPACING = 1;
	private final int LETTER_SIZE = 2;

	private int xPos;
	private int yPos;

	private String menuTitle;

	private ArrayList<SoSo_Letter> letters;

	public MenuTitle(String menuTitle, int xPos, int yPos)
	{
		this.xPos = xPos;
		this.yPos = yPos;
		this.menuTitle = menuTitle;

		loadLetters();
	}

	// Parses the string menuTitle into images, letter by letter
	private void loadLetters()
	{
		char[] characters = menuTitle.toCharArray();

		letters = new ArrayList<SoSo_Letter>();

		for (int i = 0; i < characters.length; i++)
		{
			letters.add(new SoSo_Letter(characters[i]));
		}
	}

	public void render(Graphics g)
	{
		int spacing = 0;
		for (int i = 0; i < letters.size(); i++)
		{
			LetterImage fontLetter = letters.get(i);

			g.drawImage(fontLetter.getImage(), xPos + spacing, yPos, fontLetter.getWidth() * LETTER_SIZE,
					fontLetter.getHeight() * LETTER_SIZE, null);

			spacing += (fontLetter.getWidth() * LETTER_SIZE) + LETTER_SPACING;
		}
	}
}
