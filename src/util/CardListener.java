package util;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controllers.Server;
import model.Card;

public class CardListener extends MouseAdapter
{
	Card card;

	public void mouseEntered(MouseEvent e)
	{
		super.mouseEntered(e);
		
		card = (Card) e.getSource();
		System.out.println("X: " + card.getX() + " | Y: " + card.getY());
		card.setLocation(new Point((int)card.getLocation().getX(), (int)card.getLocation().getY()-20));
	}
	public void mouseExited(MouseEvent e)
	{
		super.mouseExited(e);
		
		card = (Card) e.getSource();
		card.setLocation(new Point((int)card.getLocation().getX(), (int)card.getLocation().getY()+20));
	}
	public void mouseReleased(MouseEvent e)
	{

	}
	public void mouseClicked(MouseEvent e)
	{
		
	}
	public void setServer(Server server)
	{
		
	}
}
