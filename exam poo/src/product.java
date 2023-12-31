import java.util.*;

public abstract class product {
    public product(String desc, float prix, String nom, int quantite) {
        this.desc = desc;
        this.prix = prix;
        this.nom = nom;
        this.quantite = quantite;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "product{ " +
                "     nom=" + nom + "\n" +
                "categorie=" + categorie + "\n" +
                "prix=" + prix +"\n"+
                "desc=" + desc + "\n" +
                "quantite=" + quantite +
                " }";
    }

    public void afficher (String k){
        System.out.println(toString()+k);
    }

    protected String categorie;
     String desc;
     public abstract String getCategorie();
    protected float prix;
    protected String nom;
    protected int quantite;

    public product() {
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public abstract void description();

}
