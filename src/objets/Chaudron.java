package objets;

public class Chaudron {
	private int quantitePotion = 0;
	private int forcePotion = 0;

	public boolean resterPotion() {
		if (quantitePotion < 1) {
			return false;
		} else {
			return true;
		}
	}

	public void remplirChaudron(int quantite, int forcePotion) {
		this.forcePotion = forcePotion;
		this.quantitePotion = quantite;
	}

	public int prendreLouche() {
		if (quantitePotion < 1) {
			forcePotion = 0;
			return forcePotion;
		}
		quantitePotion -= 1;
		return forcePotion;
	}
}
