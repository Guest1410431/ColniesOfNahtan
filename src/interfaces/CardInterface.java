package interfaces;

import java.awt.Dimension;

import common.GameEnums.ResourceType;

public interface CardInterface{
	
	int WIDTH = 42;
	int HEIGHT = 65;
	
	Dimension SMALL = new Dimension(WIDTH,HEIGHT);
	Dimension MEDIUM = new Dimension(WIDTH*2,HEIGHT*2);
	Dimension BIG = new Dimension(WIDTH*3,HEIGHT*3);	
	
	//Default card size
	Dimension CARD_SIZE = MEDIUM;
	
	// Sets the resource type of the card
	void setResourceType(ResourceType resource);
	ResourceType getResourceType();
}
