package model.board;

import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.JLayeredPane;

import common.GameEnums.ResourceTile;
import interfaces.GameConstants;
import interfaces.TileInterface;
import util.Matrix;

public class Board extends JLayeredPane implements GameConstants
{
	// TODO: Make linked list of resource tiles, scramble and pop to assign
	//     : List needs to be in accordance with num resource type given player number
	LinkedList<ResourceTile>resources;
	private LinkedList<Integer>diceRolls;	
	private LinkedList<Port>ports;
	
	private Matrix<Tile> boardTiles;

	public Board(int boardWidth, int boardHeight)
	{
		boardTiles = new Matrix<Tile>();
		
		setResources(4);
		setDiceRolls(4);
		setPorts(4);
		
		makeHexGrid(boardWidth+300, boardHeight+300, 5, 0);
	}

	private void makeHexGrid(int origin_x, int origin_y, int size, int padding)
	{
		double angle_30 = Math.toRadians(30);
		double xOffset = Math.cos(angle_30) * ((TileInterface.TILE_SIZE.getWidth()) + padding);
		double yOffset = Math.sin(angle_30) * ((TileInterface.TILE_SIZE.getHeight()) + padding);
		int half = size / 2;

		for (int row = 0; row < size; row++)
		{
			int column = size - Math.abs(row - half);

			for (int col = 0; col < column; col++)
			{
				int x = (int) (origin_x + xOffset * (col * 2 + 1 - column));
				int y = (int) (origin_y + yOffset * (row - half) * 3);

				Tile tile = new Tile(x, y);
				tile.setResourceTile(resources.pop());
				if(tile.getResourceTile() != ResourceTile.DESERT)
				{
					tile.setDice(diceRolls.pop());
				}				
				tile.addMouseListener(TILE_LISTENER);
				boardTiles.add(row, col, tile);
			}
		}
	}
	// PLAYERS | DESERT | WOOD | SHEEP | ORE | WHEAT | CLAY
	//     3-4 |   1	|	4  |   4   |  3  |   4   |   3  
	// 	   5-6 |   2	|	6  |   6   |  5  |   6   |   5  
	private void setResources(int playerNumber)
	{
		resources = new LinkedList<ResourceTile>();
		
		if(playerNumber <= 4)
		{
			resources.add(ResourceTile.DESERT);
			resources.add(ResourceTile.WOOD);
			resources.add(ResourceTile.WOOD);
			resources.add(ResourceTile.WOOD);
			resources.add(ResourceTile.WOOD);
			resources.add(ResourceTile.SHEEP);
			resources.add(ResourceTile.SHEEP);
			resources.add(ResourceTile.SHEEP);
			resources.add(ResourceTile.SHEEP);
			resources.add(ResourceTile.ORE);
			resources.add(ResourceTile.ORE);
			resources.add(ResourceTile.ORE);
			resources.add(ResourceTile.WHEAT);
			resources.add(ResourceTile.WHEAT);
			resources.add(ResourceTile.WHEAT);
			resources.add(ResourceTile.WHEAT);
			resources.add(ResourceTile.CLAY);
			resources.add(ResourceTile.CLAY);
			resources.add(ResourceTile.CLAY);
		}
		else
		{
			resources.add(ResourceTile.DESERT);
			resources.add(ResourceTile.WOOD);
			resources.add(ResourceTile.WOOD);
			resources.add(ResourceTile.WOOD);
			resources.add(ResourceTile.WOOD);
			resources.add(ResourceTile.WOOD);
			resources.add(ResourceTile.WOOD);
			resources.add(ResourceTile.SHEEP);
			resources.add(ResourceTile.SHEEP);
			resources.add(ResourceTile.SHEEP);
			resources.add(ResourceTile.SHEEP);
			resources.add(ResourceTile.SHEEP);
			resources.add(ResourceTile.SHEEP);
			resources.add(ResourceTile.ORE);
			resources.add(ResourceTile.ORE);
			resources.add(ResourceTile.ORE);
			resources.add(ResourceTile.ORE);
			resources.add(ResourceTile.ORE);
			resources.add(ResourceTile.WHEAT);
			resources.add(ResourceTile.WHEAT);
			resources.add(ResourceTile.WHEAT);
			resources.add(ResourceTile.WHEAT);
			resources.add(ResourceTile.WHEAT);
			resources.add(ResourceTile.WHEAT);
			resources.add(ResourceTile.CLAY);
			resources.add(ResourceTile.CLAY);
			resources.add(ResourceTile.CLAY);
			resources.add(ResourceTile.CLAY);
			resources.add(ResourceTile.CLAY);
		}
		for(int i=0; i<100; i++)
		{
			int a = (int)(Math.random()*resources.size());
			int b = (int)(Math.random()*resources.size());
			
			ResourceTile c = resources.get(a);
			resources.set(a, resources.get(b));
			resources.set(b, c);
		}
	}
	// PLAYERS | 2 | 3 | 4 | 5 | 6 | 8 | 9 | 10 | 11 | 12
	//     3-4 | 1 | 2 | 2 | 2 | 2 | 2 | 2 | 2  | 2  | 1
	//     5-6 | 2 | 3 | 3 | 3 | 3 | 3 | 3 | 3  | 3  | 2
	private void setDiceRolls(int playerNumber)
	{
		diceRolls = new LinkedList<Integer>();
		
		if(playerNumber <= 4)
		{
			diceRolls.add(2);
			diceRolls.add(3);
			diceRolls.add(3);
			diceRolls.add(4);
			diceRolls.add(4);
			diceRolls.add(5);
			diceRolls.add(5);
			diceRolls.add(6);
			diceRolls.add(6);
			diceRolls.add(8);
			diceRolls.add(8);
			diceRolls.add(9);
			diceRolls.add(9);
			diceRolls.add(10);
			diceRolls.add(10);
			diceRolls.add(11);
			diceRolls.add(11);
			diceRolls.add(12);			
		}
		else
		{
			diceRolls.add(2);
			diceRolls.add(2);
			diceRolls.add(3);
			diceRolls.add(3);
			diceRolls.add(3);
			diceRolls.add(4);
			diceRolls.add(4);
			diceRolls.add(4);
			diceRolls.add(5);
			diceRolls.add(5);
			diceRolls.add(5);
			diceRolls.add(6);
			diceRolls.add(6);
			diceRolls.add(6);
			diceRolls.add(8);
			diceRolls.add(8);
			diceRolls.add(8);
			diceRolls.add(9);
			diceRolls.add(9);
			diceRolls.add(9);
			diceRolls.add(10);
			diceRolls.add(10);
			diceRolls.add(10);
			diceRolls.add(11);
			diceRolls.add(11);
			diceRolls.add(11);
			diceRolls.add(12);
			diceRolls.add(12);
		}
		for(int i=0; i<100; i++)
		{
			int a = (int)(Math.random()*diceRolls.size());
			int b = (int)(Math.random()*diceRolls.size());
			
			int c = diceRolls.get(a);
			diceRolls.set(a, diceRolls.get(b));
			diceRolls.set(b, c);
		}
	}
	// TODO: Same with ports
	// PLAYERS | SHEEP(2:1) | WOOD(2:1) | CLAY(2:1) | ORE(2:1) | WHEAT(2:1) | ANYTHING(3:1)
	//     3-4 | 	  1 	|	  1		|     1 	|	  1    |	  1 	|	   4
	//     5-6 |      2		|     1 	| 	  1 	|	  1    | 	  1 	|      5
	private void setPorts(int playerNumber)
	{
		ports = new LinkedList<Port>();
		
		if(playerNumber <= 4)
		{
			
		}
		else
		{
			
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









