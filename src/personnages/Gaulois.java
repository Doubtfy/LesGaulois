package personnages;

import village_gaulois.Village;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	private Village village = null;
	private boolean isChef = false;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup((force * effetPotion) / 3);
		if (effetPotion > 1) {
			effetPotion -= 1;
		}
	}

	public boolean isChef() {
		return isChef;
	}

	public void setChef(boolean isChef) {
		this.isChef = isChef;
	}

	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void sePresenter() {
		System.out.print("Le Gaulois " + nom + " : \"Bonjour, je m'appelle " + nom + ".");
		if (village != null) {
			if (isChef()) {
				System.out.print(" Je suis le chef du ");
			} else {
				System.out.print(" J'habite le ");
			}
			System.out.print("village : " + village.getNom() + ".\"");
		} else {
			System.out.print(" Je voyage de villages en villages.\"");
		}
		System.out.print("\n");
	}
}
