import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
// cette class contient lensemble des "user name et mot de passe "

public class data {

    protected Map<String, String> mc = new HashMap<>();
    protected Map<String, customer> customerMap = new HashMap<>();
    protected Map<String,customer> msgs=new ConcurrentHashMap<>();
    public void addmsg(String s,customer c)
    {msgs.put(s,c);}
    public void repondre_msg() {
       for (Map.Entry<String, customer> entry : msgs.entrySet()) {
            String key = entry.getKey();
            customer customer = entry.getValue();

            // Utilisez la méthode getNom() pour obtenir le nom du client
            String customerName = customer.getUsername();

            // Affichez les informations souhaitées
            System.out.println('{'+key + " } de la part de " + customerName);
            System.out.println("write ur response here or write skip ");
            Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            if (!s.equals("skip")) {
                customer.setMsgrecu(s);
                msgs.remove(key);}
        }
    }
    protected Map<String, String> ma = new HashMap<>();
    public void ajouter(String nom,String mdp){
        if (mc.containsKey(nom)==true){
            System.out.println("this user name is already taken !!!");
        }
        else {
            mc.put(nom, mdp);
            customerMap.put(nom,new customer(nom,mdp)) ;
        }
    }
    public void ajouter_admin(String nom,String mdp){
        if (ma.containsKey(nom)==true){
            System.out.println("this user name is already taken !!!!!!");
        }
        else
            ma.put(nom,mdp);
    }
    public boolean login(customer c){
        if (mc.containsKey(c.getUsername())==true){
            if ((mc.get(c.getUsername())).equals(c.getMdp()))
                return(true);
        }
            return(false);
    }
    public customer login(String nom){
        return(customerMap.get(nom));
    }
    public boolean login(admin c){
        if (ma.containsKey(c.getUsername())==true){
            if ((ma.get(c.getUsername())).equals(c.getMdp()))
                return(true);
        }
        return(false);
    }


}
