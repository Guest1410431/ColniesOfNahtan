package common;

public class GameEnums
{
	public enum ResourceType
	{
		WOOD("wood"), WOOL("wool"), ORE("ore"), WHEAT("wheat"), CLAY("clay");
		
		private String path;
		
		private ResourceType(String path)
		{
			this.path = path;
		}
		public String toString()
		{
			return path;
		}
	}
	public enum BuildingType
	{
		NONE("none"), SETTLEMENT("settlement"), CITY("city"), ROAD("road"), PORT("port");
		
		private String path;
		
		private BuildingType(String path)
		{
			this.path = path;
		}
		public String toString()
		{
			return path;
		}
	}
	public enum GameMode
	{
		MENU(1), GAME(2), GAME_OVER(3);
		
		private int value;
		
		private GameMode(int value)
		{
			this.value = value;
		}
		public int getValue()
		{
			return value;
		}
	}
	public enum ResourceTile
	{
		WOOD("wood"), WOOL("wool"), ORE("ore"), WHEAT("wheat"), CLAY("clay"), WATER("water"), DESERT("desert");
		
		private String path;
		
		private ResourceTile(String path)
		{
			this.path = path;
		}
		public String toString()
		{
			return path;
		}
	}
	public enum MenuState
	{
		MAIN(0, "main"), GAME(1, "game"), SETTINGS(2, "settings"), PLAYER(3, "player");
		
		private int menuState;
		private String menuName;
		
		private MenuState(int menuState, String menuName)
		{
			this.menuState = menuState;
			this.menuName = menuName;
		}
		public String toString()
		{
			return menuName;
		}
	}
}
