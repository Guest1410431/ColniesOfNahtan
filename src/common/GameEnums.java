package common;

public class GameEnums
{
	public enum ResourceType
	{
		WOOD("wood"), SHEEP("sheep"), ORE("ore"), WHEAT("wheat"), CLAY("clay");
		
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
		WOOD("wood"), SHEEP("sheep"), ORE("ore"), WHEAT("wheat"), CLAY("clay"), WATER("water"), DESERT("desert");
		
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
}
