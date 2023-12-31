public class makeup_product  extends product {


    public makeup_product() {
        categorie ="makeup";
    }

    public makeup_product(String desc, float prix, String nom, int quantite) {
        super(desc, prix, nom, quantite);
        categorie ="makeup";
    }

    public String getCategorie() {
        return categorie;}
    public void description(){
        System.out.print("this is a ");
        System.out.println(categorie+" product and it is a :");
        System.out.println(desc);

    }
}

