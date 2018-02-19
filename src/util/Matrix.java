package util;

import java.util.ArrayList;

public class Matrix<E>
{
	private ArrayList<MatrixNode<E>>matrix;
	
	public Matrix()
	{
		matrix = new ArrayList<MatrixNode<E>>();
	}
	public void add(int x, int y, E item)
	{
		matrix.add(new MatrixNode<E>(x, y, item));
	}
	public void set(int x, int y, E item)
	{
		if(get(x, y) == null)
		{
			add(x, y, item);
		}
		else
		{
			for(int i=0; i<matrix.size(); i++)
			{
				if(matrix.get(i).getX() == x && matrix.get(i).getY() == y)
				{
					matrix.set(i, new MatrixNode<E>(x, y, item));
				}
			}
		}
	}
	public E get(int x, int y)
	{
		for(MatrixNode<E> node : matrix)
		{
			if(node.getX() == x && node.getY() == y)
			{
				return node.getItem();
			}
		}
		return null;
	}
	public ArrayList<E> toList()
	{
		ArrayList<E>list = new ArrayList<E>();
		
		for(MatrixNode<E> node : matrix)
		{
			list.add(node.getItem());
		}		
		return list;
	}
	public int size()
	{
		return matrix.size();
	}
}
