package util;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controllers.Server;
import model.Card;
import model.Hand;

public class CardListener extends MouseAdapter
{
	Card card;

	public void mouseEntered(MouseEvent e)
	{
		super.mouseEntered(e);
		
		card = (Card) e.getSource();
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
		// TODO: When a card gets clicked, add to a list in the hand class
		//		 so that those cards can be used for trade/building
		super.mouseClicked(e);
		
		card = (Card)e.getSource();
		
		Hand hand = (Hand) card.getParent();
		//hand.remove(card);
	}
	public void setServer(Server server)
	{
		
	}
}
