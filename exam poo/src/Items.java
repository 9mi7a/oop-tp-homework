import java.util.*;
public class Items {
    protected Map<String, Vector<product>> m = new HashMap<>();
    public void view_items() {
        int i=1;
        for (Map.Entry<String, Vector<product>> entry : m.entrySet()) {
            String key = entry.getKey();
            Vector<product> productList = entry.getValue();

            System.out.println("-------------category : " + key+"------------");

            for (product p : productList) {
                System.out.println("\n=============product "+i+"============|");
                p.afficher("|");
                i++;
            }
        }
    }

    protected void addproduct(product p){
        if (!m.containsKey(p.getCategorie())) {
            // If not present, create a new Vector and put it in the map
            m.put(p.getCategorie(), new Vector<>());
        }
        if (m.get(p.getCategorie()).contains(p))
           System.out.println("ce produit existe deja");
        else {
            m.get(p.getCategorie()).add(p);
           }
    }
     public List<product> rechercher(String nom) {
         List<product> searchResults = new ArrayList<>();
         for (Map.Entry<String, Vector<product>> entry : m.entrySet()) {
             String key = entry.getKey();
             Vector<product> v = entry.getValue();
             for (int i = 0; i < v.size(); i++) {
                 product c=v.get(i);
                 String s=c.getNom();
                 if ((s.toLowerCase().contains(nom.toLowerCase()))||
                 c.getCategorie().toLowerCase().contains(nom.toLowerCase()))
                     searchResults.add(c);
             }
                }
         return searchResults;
         }
    public void deleteProduct(product p) {
        String category = p.getCategorie();

        if (this.m.containsKey(category)) {
            Vector<product> productsInCategory = this.m.get(category);

            if (productsInCategory.contains(p)) {
                productsInCategory.remove(p);
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Product not found in the category.");
            }
        } else {
            System.out.println("Category not found.");
        }
    }

    public List<product> filterProductsByCategory(List<product> searchResults,String category) {
        // Filter products by category
        List<product> filteredProducts = new ArrayList<>();
        for (product product : searchResults) {
            if (product.getCategorie().equalsIgnoreCase(category)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

     }