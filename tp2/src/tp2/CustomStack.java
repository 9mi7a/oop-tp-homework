package tp2;
import java.util.*;

public class CustomStack {
	protected int c;
	protected int[]t;
	int i;
	public CustomStack(int n)
	{c=n;
	i=0;
	t=new int[c];}
	public void addelement(int val)
	{if (i<c)
		{t[i]=val;i++;}
	else
		System.out.print("stack is full!!!");
	
		}
	public void removeelement()
	{i--;}
	public int lastinstack()
	{
		if (i!=0)
			return(t[i-1]);
		else 
			System.out.print("stack est vide");
			return(0);
	}
}
