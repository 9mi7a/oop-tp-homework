import java.util.Scanner;

public class admin {
    protected String username;
    protected  String mdp;
    public String getUsername() {
        return username;
    }

    public String getMdp() {
        return mdp;
    }

    public admin(String username, String mdp) {
        this.username = username;
        this.mdp = mdp;
    }

    public admin() {
        System.out.print("donner le nom d utilisateur :");
        Scanner scanner = new Scanner(System.in);
        username=scanner.nextLine();
        System.out.print("donner le mot de passe :");
        scanner = new Scanner(System.in);
        mdp=scanner.nextLine();
    }

}
