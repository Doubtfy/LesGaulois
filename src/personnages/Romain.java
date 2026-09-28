package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

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

	public void sEquiper(Equipement equipement) {
		System.out.print("Le soldat " + this.nom + " ");
		switch (nbEquipement) {
		case 1:
			if (equipement == this.equipements[0]) {
				System.out.print("possède déjà un " + equipement + ".\n");
			} else {
				equipeDansCase(equipement);
			}
			break;
		case 2:
			System.out.print("est déjà bien protégé !\n");
			break;
		default:
			equipeDansCase(equipement);
			break;
		}
	}

	private void equipeDansCase(Equipement equipement) {
		this.equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.print("s'equipe avec un " + equipement + ".\n");
	}

	public static void main() {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}

}
