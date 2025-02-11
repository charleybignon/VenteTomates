package modele;

public enum Couleur {

	BLEU ("Bleu"), VERT("Vert"), ROUGE("Rouge"), ORANGE("Orange"), JAUNE("Jaune"), NOIR("Noir"), MULTICOLORE("Multicolore");
	private final String denomination;

	private Couleur(String denomination) {
		this.denomination  = denomination;
	}

	public String getDenomination() {
		return this.denomination;
	}
	
	public static Couleur getCouleur(String denomination) {
		for (Couleur c : Couleur.values()) {
			if (c.getDenomination().equals(denomination)) {
				return c;
			}
		}
		return null;
	}

}
