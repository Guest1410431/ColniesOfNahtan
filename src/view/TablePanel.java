package view;

import javax.swing.JPanel;

import interfaces.GameConstants;
import model.board.Board;

public class TablePanel extends JPanel implements GameConstants
{
	private JPanel table;
	
	private Board board;
	
	public TablePanel()
	{
		this.setOpaque(false);
	}
}
