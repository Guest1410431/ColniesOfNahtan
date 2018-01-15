package interfaces;

import common.GameEnums.GameMode;
import util.ButtonListener;
import util.CardListener;

public interface GameConstants
{
	GameMode GAME_MODE = GameMode.MENU;
	
	CardListener CARD_LISTENER = new CardListener();
	ButtonListener BUTTON_LISTENER = new ButtonListener();
}
