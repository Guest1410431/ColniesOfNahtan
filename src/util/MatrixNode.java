package util;

public class MatrixNode<T>
{
	private int x;
	private int y;

	private T item;

	public MatrixNode(int x, int y, T item)
	{
		super();
		this.x = x;
		this.y = y;
		this.item = item;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	public T getItem()
	{
		return item;
	}
}
