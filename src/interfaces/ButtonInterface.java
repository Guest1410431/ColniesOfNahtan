package interfaces;

import java.awt.Dimension;

public interface ButtonInterface
{
	int WIDTH = 48;
	int HEIGHT = 48;

	Dimension SMALL = new Dimension(WIDTH, HEIGHT);
	Dimension MEDIUM = new Dimension(WIDTH * 2, HEIGHT * 2);
	Dimension BIG = new Dimension(WIDTH * 3, HEIGHT * 3);

	// Default tile size
	Dimension BUTTON_SIZE = MEDIUM;
}
