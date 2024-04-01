package iut;

public class Humain {
	
	private String nom;
	private String prenom;
	private int age;

	public Humain (String nom, String prenom, int age) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
	}
	
	public void details() {
		toString();
	}

	@Override
	public String toString() {
		return "Nom: " + nom + ", Prenom: " + prenom + ", Age: " + age; 
	}
	
	public void manger() {
		
	}
	
	public void boire() {
		
	}
	
	public void  ami(Humain autreHumain) {
		System.out.println(nom + " est ami avec" + autreHumain.nom);
	}
	
}
