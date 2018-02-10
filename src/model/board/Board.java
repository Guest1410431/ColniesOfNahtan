package model.board;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JLayeredPane;

import common.GameEnums.ResourceTile;
import common.GameEnums.ResourceType;
import interfaces.GameConstants;
import interfaces.TileInterface;
import util.Matrix;

public class Board extends JLayeredPane implements GameConstants
{
	// TODO: Make linked list of resource tiles, scramble and pop to assign
	//     : List needs to be in accordance with num resource type given player number
	// PLAYERS | DESERT | WOOD | SHEEP | ORE | WHEAT | CLAY
	//     3-4 |   1	|	4  |   4   |  3  |   4   |   3  
	// 	   5-6 |   2	|	6  |   6   |  5  |   6   |   5  
	LinkedList<ResourceType>resources;
	// TODO: Same with the dice roll numbers
	// PLAYERS | 2 | 3 | 4 | 5 | 6 | 8 | 9 | 10 | 11 | 12
	//     3-4 | 1 | 2 | 2 | 2 | 2 | 2 | 2 | 2  | 2  | 1
	//     5-6 | 1 | 3 | 3 | 3 | 3 | 3 | 3 | 3  | 3  | 3
	private LinkedList<Integer>diceRolls;
	// TODO: Same with ports
	// PLAYERS | SHEEP(2:1) | WOOD(2:1) | CLAY(2:1) | ORE(2:1) | WHEAT(2:1) | ANYTHING(3:1)
	//     3-4 | 	  1 	|	  1		|     1 	|	  1    |	  1 	|	   4
	//     5-6 |      2		|     1 	| 	  1 	|	  1    | 	  1 	|      5
	private LinkedList<Port>ports;
	
	private Matrix<Tile> boardTiles;

	public Board(int boardWidth, int boardHeight)
	{
		boardTiles = new Matrix<Tile>();
		
		makeHexGrid(boardWidth+300, boardHeight+300, 5, 0);
	}

	private void makeHexGrid(int origin_x, int origin_y, int size, int padding)
	{
		double ang30 = Math.toRadians(30);
		double xOff = Math.cos(ang30) * ((TileInterface.TILE_SIZE.getWidth()) + padding);
		double yOff = Math.sin(ang30) * ((TileInterface.TILE_SIZE.getHeight()) + padding);
		int half = size / 2;

		for (int row = 0; row < size; row++)
		{
			int cols = size - Math.abs(row - half);

			for (int col = 0; col < cols; col++)
			{
				int x = (int) (origin_x + xOff * (col * 2 + 1 - cols));
				int y = (int) (origin_y + yOff * (row - half) * 3);

				Tile tile = new Tile(x, y);
				tile.setResourceTile(ResourceTile.values()[(int)(Math.random()*ResourceTile.values().length)]);
				tile.addMouseListener(TILE_LISTENER);
				boardTiles.add(row, col, tile);
			}
		}
	}

	public void render(Graphics g)
	{
		for (Tile tile : boardTiles.toList())
		{
			tile.render(g);
		}
	}
}









