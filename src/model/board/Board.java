package model.board;

import java.awt.Graphics;

import javax.swing.JLayeredPane;

import common.GameEnums.ResourceType;
import interfaces.GameConstants;
import util.Matrix;

public class Board extends JLayeredPane implements GameConstants
{
	private Matrix<Tile> boardTiles;

	public Board(int boardWidth, int boardHeight)
	{
		boardTiles = new Matrix<Tile>();
		
		makeHexGrid(boardWidth+300, boardHeight+300, 5, 64, 0);
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

				Tile tile = new Tile(x, y, radius);
				tile.setResourceType(ResourceType.values()[(int)(Math.random()*5)]);
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









