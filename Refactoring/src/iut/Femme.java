package iut;

public class Femme extends Humain {

    public Femme(String nom, String prenom, int age) {
        super(nom, prenom, age);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        Homme homme = new Homme("John", "Chris", 25); 
        Femme femme = new Femme("Marie", "Angela", 30); 
        homme.ami(femme); 
    }
}
