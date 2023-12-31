import java.io.Console;
import java.util.*;

public class customer {
    protected String username;
    protected String msgrecu="";

    public String getMsgrecu() {
        return msgrecu;
    }

    public void setMsgrecu(String msgrecu) {
        this.msgrecu = msgrecu;
    }

    protected  String mdp;


    protected Vector <product> whishList =new Vector<>();

    public Vector<product> getCart() {
        return cart;
    }

    public void print_wishlist(){
        if (whishList.size()==0)
        {System.out.print("empty");}
        for (int i=0;i<whishList.size();i++){
            System.out.print(whishList.get(i).getNom()+" ");
        }
    }
    public void print_cart(){
        if (cart.size()==0)
        {System.out.print("empty");}
        for (int i=0;i<cart.size();i++){
            System.out.print(cart.get(i).getNom()+" ");
        }
    }

    public int removeFromWishlist( String productName) {
        Iterator<product> iterator = whishList.iterator();int test=0;
          while (iterator.hasNext()) {
            product product = iterator.next();
            if (product.getNom().toLowerCase().equals(productName.toLowerCase())) {
                iterator.remove();
                System.out.println("product removed  : " + productName);
            test=1;}
        }
  if(test==0){ System.out.println("product not found :(");}return(test);}
    public  int removeFromcart( String productName) {
        Iterator<product> iterator = cart.iterator();int test=0;
        while (iterator.hasNext()) {
            product product = iterator.next();
            if (product.getNom().toLowerCase().equals(productName.toLowerCase())) {
                iterator.remove();
                System.out.println("product removed  : " + productName);
                test=1;
            }
        }if(test==0){ System.out.println("product not found :(");}return(test);
    }
    public  void clearwishList(){
        whishList=new Vector<>();
        System.out.println("cleared successfully :)");
    }
    public  void clearcart(){
        cart=new Vector<>();
        System.out.println("cleared successfully :)");
    }
    protected Vector <product> cart =new Vector<>();

    public String getUsername() {
        return username;
    }

    public String getMdp() {
        return mdp;
    }

    public customer(String username, String mdp) {
        this.username = username;
        this.mdp = mdp;
    }
    public void addwishlist(product p){
        whishList.addElement(p);

    }
  /*  public void removewhishlist(String s,items it){
        product p=it.rechercher(s);
        whishList.
    }*/
    public void addcart(product p){
        if (p.getQuantite()>0){
        cart.addElement(p);
        System.out.println("added to cart successfully");}
        else
            System.out.println("product out of stock :( ");

    }

    public customer() {
        System.out.print("enter username :");
        Scanner scanner = new Scanner(System.in);
        username=scanner.nextLine();
        System.out.print("enter password :");
         scanner = new Scanner(System.in);
        mdp=scanner.nextLine();
    }

}
