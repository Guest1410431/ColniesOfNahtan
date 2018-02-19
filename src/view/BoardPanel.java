package view;

import java.awt.Graphics;

import javax.swing.JPanel;

import interfaces.GameConstants;
import model.board.Board;

public class BoardPanel extends JPanel implements GameConstants
{
	private Board board;
	
	public BoardPanel()
	{
		
	}
	public void initBoard()
	{
		board = new Board(this.getWidth(), this.getHeight());
	}
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		// Render here
		board.render(g);
	}
}
