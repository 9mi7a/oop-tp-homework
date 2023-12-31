package tp2;

public class redheadduck extends duck  {
	public redheadduck() {
		flyingb=new ifly2();
		quackingb=new iquack2();}
	    public void fly()
	    {flyingb.fly();}
	    public void quack()
	    {quackingb.quack();}
	public void display()
	{System.out.println("im a redhead duck");}

}
