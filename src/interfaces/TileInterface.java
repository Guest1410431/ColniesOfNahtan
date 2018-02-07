package interfaces;

import java.awt.Dimension;

import common.GameEnums.ResourceType;

public interface TileInterface
{
	int WIDTH = 64;
	int HEIGHT = 64;

	Dimension SMALL = new Dimension(WIDTH, HEIGHT);
	Dimension MEDIUM = new Dimension(WIDTH * 2, HEIGHT * 2);
	Dimension BIG = new Dimension(WIDTH * 3, HEIGHT * 3);

	// Default tile size
	Dimension TILE_SIZE = MEDIUM;

	// Sets the resource type of the tile
	void setResourceType(ResourceType resource);
	ResourceType getResourceType();
}
