package common;

public class GameEnums
{
	public enum ResourceType
	{
		WOOD("wood"), SHEEP("sheep"), IRON("iron"), WHEAT("wheat"), CLAY("clay");
		
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
}
