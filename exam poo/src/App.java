import java.util.*;
//ajouter orders lil menu ta3 customer
//nrodha kol bil ang
public class App {
    protected Map<String, customer> msgs = new HashMap<>();

    private static void displayProducts(List<product> products) {
        int i = 1;
        for (product p : products) {
            System.out.println("\n============= Product " + i + "==============");
            p.afficher("🌟");
            i++;
        }
    }

    private static PaymentStrategy choosePaymentStrategy() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter credit card number: ");
                String cardNumber = scanner.next();
                System.out.print("Enter expiry date: ");
                String expiryDate = scanner.next();
                System.out.print("Enter CVV: ");
                String cvv = scanner.next();
                return new CreditCardPayment(cardNumber, expiryDate, cvv);
            case 2:
                System.out.print("Enter PayPal email: ");
                String email = scanner.next();
                return new PayPalPayment(email);
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }

    public static void home_menu() {
        System.out.println("==== 🌟 Kmiha Shopping App 🌟 ====");
        System.out.println("0. See all products");
        System.out.println("1. Find a Product");
        System.out.println("2. View Wishlist");
        System.out.println("3. View Cart");
        System.out.println("4. Contact Support Team");
        System.out.println("5. Exit");

        System.out.print("Choose an option (0-5): ");
    }

    public static void product_menu() {
        System.out.println("==== 🛍️ Product Menu 🛍️ ====");
        System.out.println("1. Add to Wishlist");
        System.out.println("2. Add Product to Cart");
        System.out.println("3. Go Back");

        System.out.print("Choose an option (1-3): ");
    }

    public static void wishlist_menu(customer a) {
        System.out.println("==== ❤️ Wishlist Menu ❤️ ====");
        System.out.print("{ ");
        a.print_wishlist();
        System.out.println("}");
        System.out.println("1. Remove Product from Wishlist");
        System.out.println("2. Clear Wishlist");
        System.out.println("3. Go Back");

        System.out.print("Choose an option (1-3): ");
    }

    public static void cart_menu(customer a) {
        System.out.println("==== 🛒 Cart Menu 🛒 ====");
        System.out.print("{ ");
        a.print_cart();
        System.out.println("}");
        System.out.println("1. Remove Product from Cart");
        System.out.println("2. Clear Cart");
        System.out.println("3. Place Order");
        System.out.println("4. Go Back");

        System.out.print("Choose an option (1-4): ");
    }

    public static void admin_menu() {
        System.out.println("===== 🌟 Admin Menu 🌟 =====");
        System.out.println("1. Add Product");
        System.out.println("2. Remove Product");
        System.out.println("3. View Products");
        System.out.println("4. Update Products");
        System.out.println("5. Respond to Messages");
        System.out.println("6. View orders");
        System.out.println("7. Exit");
    }

    private static void print(String message) {
        System.out.println(message);
    }

    public  void menu() {
        System.out.println("Hello welcome to kmiha's shop \npls choose an option <3");
        data v = new data();
        v.ajouter_admin("admin", "admin");
        v.ajouter("amir", "123amir");
        v.ajouter("hsan", "888");
        v.ajouter("slim", "sgmiha");

        Items it = new Items();
        it.addproduct(new electronic_product("Exceptional machine! \nAMOLED screen <3 \ni9 12th gen CPU", 9999, "PC Lenovo", 200));
        it.addproduct(new electronic_product("Amazing phone! \nHigh-quality speakers <3 \nAvailable in many colors <3", 2000, "iPhone 15", 1));
        it.addproduct(new electronic_product("Apple's home theater \n2-year warranty \nSlim design, very stylish", 1800, "iPhone 14", 1));
        it.addproduct(new makeup_product("Red color\nLuxury item", 100, "Dior Gloss", 500));
        it.addproduct(new makeup_product("palette mizyena \nLuxury item from chanel", 50, "ishadow palette", 10));
        it.addproduct(new electronic_product("compact design ", 2500, "mac", 1));

        Orders_list ordersList = new Orders_list();

        while (true) {
            System.out.print("0. Register\n1. Login ");
            Scanner scanner = new Scanner(System.in);
            int ch1 = scanner.nextInt();

            if (ch1 == 0) {
                System.out.print("Enter username: ");
                Scanner scanner1 = new Scanner(System.in);
                String username = scanner1.nextLine();
                System.out.print("Enter password: ");
                scanner = new Scanner(System.in);
                String password = scanner.nextLine();
                v.ajouter(username, password);
            }

            if (ch1 == 1) {
                customer a = new customer();
                if (v.login(a)) {
                    a = v.login(a.getUsername());
                    System.out.println("Login");
                    String msg = a.getMsgrecu();

                    if (!msg.equals("")) {
                        System.out.println("The response for your last comment is:\n" + msg);
                    }

                    int logout = 0;

                    while (logout == 0) {
                        home_menu();
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 0:
                            //  viewProducts();
                            it.view_items();
                            break;
                            case 1:
                                product rech = null;
                                System.out.println("What are you looking for?");
                                Scanner sc = new Scanner(System.in);
                                String name = scanner.nextLine();
                                List<product> searchResults = it.rechercher(name);

                                if (!searchResults.isEmpty()) {
                                    System.out.println("Search results:");
                                    displayProducts(searchResults);

                                    System.out.println("\nOptions:");
                                    System.out.println("1. Choose product");
                                    System.out.println("2. Filter by category");
                                    System.out.println("3. Exit");

                                    System.out.print("Choose an option: ");
                                    int option = scanner.nextInt();

                                    switch (option) {
                                        case 2:
                                            System.out.print("Enter category to filter: ");
                                            String category = scanner.next();
                                            List<product> filteredResults = it.filterProductsByCategory(searchResults, category);

                                            if (!filteredResults.isEmpty()) {
                                                System.out.println("Filtered results:");
                                                displayProducts(filteredResults);
                                                System.out.println("Choose the product number");
                                                int num = scanner.nextInt();
                                                rech = filteredResults.get(num - 1);
                                            } else {
                                                System.out.println("No products found in the selected category.");
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Exiting...");
                                            break;
                                        case 1:
                                            System.out.println("enter the product number \n(its written above it like '==== product 1===)'");
                                            int num = scanner.nextInt();
                                            rech = searchResults.get(num - 1);
                                            break;
                                        default:
                                            System.out.println("Invalid option. Exiting...");
                                    }
                                } else {
                                    System.out.println("No products found matching the search criteria.");
                                }

                                if (rech == null) {
                                    break;
                                }

                                rech.afficher("");
                                int x = 0;
                                product_menu();

                                while (x == 0) {
                                    int o = scanner.nextInt();

                                    switch (o) {
                                        case 1:
                                            a.addwishlist(rech);
                                            System.out.println("Added to wishlist successfully! ❤️");
                                            break;
                                        case 2:
                                            a.addcart(rech);
                                            break;
                                        case 3:
                                            x = 1;
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please choose a valid option. 🚫");
                                    }
                                }

                                break;
                            case 2:
                                int t = 0;

                                while (t == 0) {
                                    wishlist_menu(a);
                                    Scanner b = new Scanner(System.in);
                                    int k = b.nextInt();

                                    switch (k) {
                                        case 1:
                                            int test=0;

                                            while (test==0){
                                            System.out.println("write the name of the product");
                                            String productToRemove = scanner.nextLine();
                                             test=a.removeFromWishlist(productToRemove);}
                                            break;
                                        case 2:
                                            a.clearwishList();
                                            break;
                                        case 3:
                                            t = 1;
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please choose a valid option. 🚫");
                                    }
                                }
                                break;
                            case 3:
                                int te = 0;

                                while (te == 0) {
                                    cart_menu(a);
                                    Scanner b = new Scanner(System.in);
                                    int k = b.nextInt();

                                    switch (k) {
                                        case 1:int test=0;

                                            while (test==0){
                                                System.out.println("write the name of the product");
                                                String productToRemove = scanner.nextLine();
                                                test=a.removeFromcart(productToRemove);}
                                            break;

                                        case 2:
                                            a.clearcart();
                                            break;
                                        case 3:
                                            Vector<product> tab = a.getCart();
                                            float total = 0;

                                            for (int i = 0; i < tab.size(); i++) {
                                                total += tab.get(i).getPrix();
                                            }
                                            if (total==0){
                                                System.out.println("cart is empty!");
                                                break;}

                                            System.out.println("The total = " + total);
                                            System.out.println("Would you like to confirm your order?");
                                            Scanner sc1 = new Scanner(System.in);
                                            String s = sc1.nextLine();

                                            if (s.equals("yes")) {
                                                PaymentStrategy paymentStrategy = choosePaymentStrategy();
                                                PaymentContext paymentContext = new PaymentContext(paymentStrategy);

                                                boolean paymentSuccessful = paymentContext.processPayment(total);

                                                if (paymentSuccessful) {
                                                    System.out.println("Order placed successfully. Thank you! ❤️");

                                                    for (int i = 0; i < tab.size(); i++) {
                                                        Order order = new Order(a, tab.get(i), "le 03/01/2024");
                                                        tab.get(i).setQuantite(tab.get(i).getQuantite() - 1);
                                                        ordersList.addOrder(order);
                                                    }

                                                    a.clearcart();
                                                } else {
                                                    System.out.println("Order not placed due to payment failure. Please try again. ❌");
                                                }
                                                break;
                                            } else {
                                                break;
                                            }
                                        case 4:
                                            te = 1;
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please choose a valid option. 🚫");
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Write your message down here, and you will get a response as soon as possible ❤️");
                                Scanner sc2 = new Scanner(System.in);
                                String s = sc2.nextLine();
                                v.addmsg(s, a);
                                System.out.println("Thank you for your help! We will respond to you as soon as possible 😊");
                                break;
                            case 5:
                                System.out.println("Thank you! You will be missed! 😢");
                                logout = 1;
                                break;
                            default:
                                System.out.println("Invalid choice. Please choose a valid option. 🚫");
                        }
                    }
                } else {
                    admin ad = new admin(a.getUsername(), a.getMdp());

                    if (v.login(ad)) {
                        System.out.println("Welcome admin! 😎");
                        int logout2 = 0;

                        while (logout2 == 0) {
                            admin_menu();
                            Scanner sc2 = new Scanner(System.in);
                            int ch3 = sc2.nextInt();

                            switch (ch3) {
                                case 1:
                                    Scanner sc4 = new Scanner(System.in);
                                    System.out.println("0. Add an Electronic Product\n1. Add a Makeup Product");
                                    int xx = sc4.nextInt();

                                    System.out.print("Enter product description: ");
                                    Scanner sc5 = new Scanner(System.in);
                                    String description = sc5.nextLine();
                                    System.out.print("Enter product price: ");
                                    Scanner sc6 = new Scanner(System.in);
                                    float price = sc6.nextFloat();
                                    Scanner sc7 = new Scanner(System.in);
                                    System.out.print("Enter product name: ");
                                    String name = sc7.nextLine();
                                    System.out.print("Enter product quantity: ");
                                    Scanner sc8 = new Scanner(System.in);
                                    int quantity = sc8.nextInt();

                                    product newProduct;

                                    if (xx == 0) {
                                        newProduct = new electronic_product(description, price, name, quantity);
                                    } else {
                                        newProduct = new makeup_product(description, price, name, quantity);
                                    }

                                    it.addproduct(newProduct);
                                    break;
                                case 2:
                                    product rech = null;
                                    System.out.println("What are you looking for?");
                                    Scanner sc = new Scanner(System.in);
                                    String name1 = sc.nextLine();
                                    List<product> searchResults2 = it.rechercher(name1);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
                            if (!searchResults2.isEmpty()) {
                                System.out.println("Search results:");
                                displayProducts(searchResults2);

                                // Filtering options
                                System.out.println("\n options:");
                                System.out.println("1. Choose product");
                                System.out.println("2. Filter by category");
                                System.out.println("3. Exit");

                                System.out.print("Choose an option: ");
                                int option = scanner.nextInt();

                                switch (option) {
                                    case 2:
                                        System.out.print("Enter category to filter: ");
                                        String category = scanner.next();
                                        List<product> filteredResults = it.filterProductsByCategory(searchResults2,category);

                                        if (!filteredResults.isEmpty()) {
                                            System.out.println("Filtered results:");
                                            displayProducts(filteredResults);
                                            System.out.println("choose the product number");
                                            int num = scanner.nextInt();
                                            rech=filteredResults.get(num-1);
                                        } else {
                                            System.out.println("No products found in the selected category.");
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Exiting...");
                                        break;
                                    case 1:
                                        System.out.println("choose the product number");
                                        int num = scanner.nextInt();
                                        rech=searchResults2.get(num-1);break;
                                    default:
                                        System.out.println("Invalid option. Exiting...");
                                }
                            } else {
                                System.out.println("No products found matching the search criteria.");
                            }
                            if (rech==null){
                                break;
                            }
                            rech.afficher("");
                            it.deleteProduct(rech);

                            break;
                        case 3:
                          //  viewProducts();
                            it.view_items();
                            break;
                        case 4:
                            //update a product
                            product rech1=null;
                            System.out.println("what are you looking for ?");
                            Scanner sc10 = new Scanner(System.in);
                            String nom1 =sc10.nextLine();
                            List<product> searchResults21 = it.rechercher(nom1);

                            if (!searchResults21.isEmpty()) {
                                System.out.println("Search results:");
                                displayProducts(searchResults21);

                                // Filtering options
                                System.out.println("\n options:");
                                System.out.println("1. Choose product");
                                System.out.println("2. Filter by category");
                                System.out.println("3. Exit");

                                System.out.print("Choose an option: ");
                                int option = scanner.nextInt();

                                switch (option) {
                                    case 2:
                                        System.out.print("Enter category to filter: ");
                                        String category = scanner.next();
                                        List<product> filteredResults = it.filterProductsByCategory(searchResults21,category);

                                        if (!filteredResults.isEmpty()) {
                                            System.out.println("Filtered results:");
                                            displayProducts(filteredResults);
                                            System.out.println("choose the product number");
                                            int num = scanner.nextInt();
                                            rech1=filteredResults.get(num-1);
                                        } else {
                                            System.out.println("No products found in the selected category.");
                                        }
                                        System.out.println("product updated successfully :-)");
                                        break;
                                    case 3:
                                        System.out.println("Exiting...");
                                        break;
                                    case 1:
                                        System.out.println("choose the product number");
                                        int num = scanner.nextInt();
                                        rech1=searchResults21.get(num-1);break;
                                    default:
                                        System.out.println("Invalid option. Exiting...");
                                }
                            } else {
                                System.out.println("No products found matching the search criteria.");
                            }
                            if (rech1==null){
                                break;
                            }
                            rech1.afficher("");
                            int ab=0;
                            while (ab==0){
                            System.out.println("what whould u like to update");
                            System.out.println("1. name");
                            System.out.println("2. description");
                            System.out.println("3. price");
                            System.out.println("4. quantity");
                            System.out.println("5. go back");
                            Scanner sc9=new Scanner(System.in);
                            int ch5=sc9.nextInt();
                            switch(ch5){
                                case 1: //modifier le nom
                                    Scanner nv=new Scanner(System.in);
                                    String nvnom=nv.nextLine();
                                    rech1.setNom(nvnom);
                                    break;
                                case 2://modifier la description
                                    Scanner nv2=new Scanner(System.in);
                                    String nvdesc=nv2.nextLine();
                                    rech1.setDesc(nvdesc);
                                    break;
                                case 3:
                                    Scanner nv3=new Scanner(System.in);
                                    float nvprix=nv3.nextFloat();
                                    rech1.setPrix(nvprix);
                                    break;
                                case 4:
                                    Scanner nv4=new Scanner(System.in);
                                    int nvquantite=nv4.nextInt();
                                    rech1.setQuantite(nvquantite);
                                    break;
                                case 5:
                                    ab=1;
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please choose a valid option.");

                            }}

                            break;
                        case 5: //voir la boit de lettre
                            v.repondre_msg();break;
                        case 6:// see orders
                            ordersList.print();
                            break;

                        case 7:
                            System.out.println("Exiting Admin Menu. Goodbye!");
                            logout2=1;break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    }
                    }}else
                          print("wrong username or password");

            }}

        }
    }}
    //}}