package gui;

import javax.swing.JPanel;

import common.GameEnums.ResourceTile;
import interfaces.ButtonInterface;
import interfaces.GameConstants;
import util.Matrix;

import java.awt.Color;
import java.awt.Graphics;

public class Menu extends JPanel implements GameConstants, ButtonInterface
{
	private MenuScreen currentMenu;
	private MenuScreen mainMenu;
	private MenuScreen gameMenu;
	private MenuScreen playerMenu;
	private MenuScreen settingMenu;
	
	private Matrix<MenuButton> hexMatrix;
	
	public Menu()
	{
		currentMenu = new MenuScreen();
		hexMatrix = new Matrix<MenuButton>();
		
		makeHexGrid(500, 400, 7, (int)(BUTTON_SIZE.getWidth()), 0);
		initMenus();
		
		setBackground(new Color(214, 137, 16));
		setBounds(0, 0, 800, 1000);
		
		setCurrentMenu(mainMenu);
	}
	private void makeHexGrid(int origin_x, int origin_y, int size, int radius, int padding)
	{
		double ang30 = Math.toRadians(30);
		double xOff = Math.cos(ang30) * (radius + padding);
		double yOff = Math.sin(ang30) * (radius + padding);
		int half = size / 2;

		for (int row = 0; row < size; row++)
		{
			int cols = size - Math.abs(row - half);

			for (int col = 0; col < cols; col++)
			{
				int x = (int) (origin_x + xOff * (col * 2 + 1 - cols));
				int y = (int) (origin_y + yOff * (row - half) * 3);

				MenuButton button = new MenuButton(x, y);
				button.addMouseListener(BUTTON_LISTENER);
				button.setResource(ResourceTile.values()[(int)(Math.random()*ResourceTile.values().length)]);
				hexMatrix.add(row, col, button);
			}
		}
	}
	private void initMenus()
	{
		mainMenu = new MenuScreen();
		mainMenu.addTitle(new MenuTitle("Col'nies    of", 50, 100));
		mainMenu.addTitle(new MenuTitle("Nah'tan", 250, 270));
		mainMenu.addButton(hexMatrix.get(0, 0));
		mainMenu.addButton(hexMatrix.get(0, 1));
		mainMenu.addButton(hexMatrix.get(0, 2));
		mainMenu.addButton(hexMatrix.get(0, 3));
		mainMenu.addButton(hexMatrix.get(1, 0));
		mainMenu.addButton(hexMatrix.get(1, 1));
		mainMenu.addButton(hexMatrix.get(1, 2));
		mainMenu.addButton(hexMatrix.get(1, 3));
		mainMenu.addButton(hexMatrix.get(1, 4));
		mainMenu.addButton(hexMatrix.get(2, 0));
		mainMenu.addButton(hexMatrix.get(2, 1));
		mainMenu.addButton(hexMatrix.get(2, 2));
		mainMenu.addButton(hexMatrix.get(2, 3));
		mainMenu.addButton(hexMatrix.get(2, 4));
		mainMenu.addButton(hexMatrix.get(2, 5));
		mainMenu.addButton(hexMatrix.get(3, 0));
		mainMenu.addButton(hexMatrix.get(3, 1));
		mainMenu.addButton(hexMatrix.get(3, 2));
		mainMenu.addButton(hexMatrix.get(3, 3));
		mainMenu.addButton(hexMatrix.get(3, 4));
		mainMenu.addButton(hexMatrix.get(3, 5));
		mainMenu.addButton(hexMatrix.get(3, 6));
		mainMenu.addButton(hexMatrix.get(4, 0));
		mainMenu.addButton(hexMatrix.get(4, 1));
		mainMenu.addButton(hexMatrix.get(4, 2));
		mainMenu.addButton(hexMatrix.get(4, 3));
		mainMenu.addButton(hexMatrix.get(4, 4));
		mainMenu.addButton(hexMatrix.get(4, 5));
		mainMenu.addButton(hexMatrix.get(5, 0));
		mainMenu.addButton(hexMatrix.get(5, 1));
		mainMenu.addButton(hexMatrix.get(5, 2));
		mainMenu.addButton(hexMatrix.get(5, 3));
		mainMenu.addButton(hexMatrix.get(5, 4));
		mainMenu.addButton(hexMatrix.get(6, 0));
		mainMenu.addButton(hexMatrix.get(6, 1));
		mainMenu.addButton(hexMatrix.get(6, 2));
	}
	private void setCurrentMenu(MenuScreen menu)
	{
		currentMenu.removeAll();
		
		for(MenuButton button : menu.getButtons())
		{
			currentMenu.addButton(button);
		}
		for(MenuTitle title : menu.getTitles())
		{
			currentMenu.addTitle(title);
		}
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// Render here
		currentMenu.render(g);
	}
}
