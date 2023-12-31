public class Order {
    customer c;
    product p;
    String date ;

    public Order(customer c, product p, String date) {
        this.c = c;
        this.p = p;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + c.getUsername()+
                ", product=" + p.getNom() +
                ", date='" + date + '\'' +
                '}';
    }
    public void afficher (){
        System.out.println(toString());
    }
}
