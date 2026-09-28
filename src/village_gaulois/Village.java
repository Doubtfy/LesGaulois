package village_gaulois;

import personnages.Gaulois;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private int nbVillageoisMax;
	private Gaulois chef;
	private Gaulois[] villageois;

	public Village(String nom, Gaulois chef, int nbVillageoisMax) {
		super();
		this.nom = nom;
		this.chef = chef;
		this.chef.setChef(true);
		this.chef.setVillage(this);
		this.nbVillageoisMax = nbVillageoisMax;
		villageois = new Gaulois[nbVillageoisMax];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageoisMax <= nbVillageois) {
			System.out.println("Le village est trop plein");
		}
		nbVillageois++;
		villageois[nbVillageois - 1] = gaulois;
		gaulois.setVillage(this);
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois <= 0 | numVillageois > nbVillageois) {
			System.out.println("Il n’y a pas autant d’habitants dans notre village !");
			return null;
		}
		return villageois[numVillageois - 1];
	}

	public void afficherVillageois() {
		System.out.println(
				"Dans le village \"" + nom + "\" du chef " + chef.getNom() + " vivent les légendaires gaulois:");
		for (int i = 0; i < villageois.length; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois != null) {
				System.out.println("- " + gaulois.getNom());
			}
		}
	}

	public static void main() {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", abraracourcix, 30);
		Gaulois asterix = new Gaulois("Astérix", 8);
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois douplepolemix = new Gaulois("Doublepolémix", 4);

		village.ajouterVillageois(asterix);
		village.ajouterVillageois(obelix);

		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);

		village.afficherVillageois();

		abraracourcix.sePresenter();
		asterix.sePresenter();
		douplepolemix.sePresenter();
	}

}
