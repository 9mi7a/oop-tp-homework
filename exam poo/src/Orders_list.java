import java.util.Vector;

public class Orders_list {
    Vector<Order> v=new Vector<>();
    public void addOrder(Order x){
        v.addElement(x);
    }
    public void print(){
        System.out.println("these are the orders :");
        if (v.size()==0)
            System.out.println("empty");
        for (int i=0;i<v.size();i++){
            v.get(i).afficher();
        }
    }
}
