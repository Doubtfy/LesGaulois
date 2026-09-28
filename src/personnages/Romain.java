package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified();
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0;
		int preForce = force;
		force = force - forceCoup;
		assert isInvariantVerified();
		if (force < 1) {
			parler("J'abandonne!!!");
		} else {
			parler("Aie!!!");
		}
		assert preForce > force;
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public static void main() {
		Romain minus = new Romain("Minus", 6);
	}

}
