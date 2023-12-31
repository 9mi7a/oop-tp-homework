package tp2;

public class mallardduck extends duck 
{ public mallardduck() {
	flyingb=new ifly1();
	quackingb=new iquack1();}
    public void fly()
    {flyingb.fly();}
    public void quack()
    {quackingb.quack();}
	public void display(){System.out.println("im a mallardduck");}

}
