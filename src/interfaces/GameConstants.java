package interfaces;

import common.GameEnums.GameMode;
import util.Assets;
import util.ButtonListener;
import util.CardListener;
import util.KeyboardListener;
import util.TileListener;

public interface GameConstants
{
	GameMode GAME_MODE = GameMode.MENU;
	
	Assets ASSETS = new Assets();
	CardListener CARD_LISTENER = new CardListener();
	TileListener TILE_LISTENER = new TileListener();
	ButtonListener BUTTON_LISTENER = new ButtonListener();
	KeyboardListener KEY_LISTENER = new KeyboardListener();
}
