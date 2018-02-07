package util;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controllers.Server;
import model.board.Tile;

public class TileListener extends MouseAdapter
{
	Tile tile;
	
	public void mouseClicked(MouseEvent e)
	{
		super.mouseClicked(e);
		
		tile = (Tile)e.getSource();
		System.out.println("Tile: " + tile.toString());
	}

	public void setServer(Server server)
	{
		
	}
}
