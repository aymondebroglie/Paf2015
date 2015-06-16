
public class SebVille {
	
	
	
	private String nomVille;
	private double occurence;
	private double pourcentage;
	
	
	public SebVille(String nomVille, double occurence) {
		this.nomVille = nomVille;
		this.occurence = occurence;
		this.pourcentage = 0;
	}
	
	
	public final String getNomVille() {
		return nomVille;
	}
	public final void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public final double getPourcentage() {
		return pourcentage;
	}
	public final void setPourcentage(double pourcentage) {
		this.pourcentage = pourcentage;
	}


	public final double getOccurence() {
		return occurence;
	}


	public final void setOccurence(double occurence) {
		this.occurence = occurence;
	}
}
