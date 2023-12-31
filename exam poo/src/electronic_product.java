 class electronic_product extends product {


     public electronic_product() {
        categorie ="electronic";
     }

     public electronic_product(String desc, float prix, String nom, int quantite) {
         super(desc, prix, nom, quantite);
         categorie ="electronic";
     }

     public String getCategorie() {
        return categorie;}
        public void description(){
        System.out.print("this is a ");
        System.out.println(categorie+" product and it is a :");
        System.out.println(desc);

    }
}
