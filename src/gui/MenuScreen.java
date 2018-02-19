package gui;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class MenuScreen extends JPanel
{
	private ArrayList<MenuTitle>titles;
	private ArrayList<MenuButton> buttons;
	
	public MenuScreen()
	{
		titles = new ArrayList<MenuTitle>();
		buttons = new ArrayList<MenuButton>();
	}
	public void addButton(MenuButton button)
	{
		buttons.add(button);
	}
	public void addTitle(MenuTitle title)
	{
		titles.add(title);
	}
	public ArrayList<MenuTitle> getTitles()
	{
		return titles;
	}
	public ArrayList<MenuButton> getButtons()
	{
		return buttons;
	}
	public void render(Graphics g)
	{
		for(MenuButton button : buttons)
		{
			button.render(g);
		}
		for(MenuTitle title : titles)
		{
			title.render(g);
		}
	}
}









