
public class Resultat {
	
	private double pourcentageHomme;
	private double pourcentageFemme;
	private double pourcentageIndetermine;
	private double pourcentageMixte;
	
	public Resultat(double pourcentageHomme, double pourcentageFemme, double pourcentageIndetermine, double pourcentageMixte){
		
		this.pourcentageFemme = pourcentageFemme;
		this.pourcentageHomme = pourcentageHomme;
		this.pourcentageIndetermine = pourcentageIndetermine;
		this.pourcentageMixte = pourcentageMixte;
	}

	public final double getPourcentageHomme() {
		return pourcentageHomme;
	}

	public final void setPourcentageHomme(double pourcentageHomme) {
		this.pourcentageHomme = pourcentageHomme;
	}

	public final double getPourcentageFemme() {
		return pourcentageFemme;
	}
	
	public final double getPourcentageMixte() {
		return pourcentageMixte;
	}

	public final void setPourcentageFemme(double pourcentageFemme) {
		this.pourcentageFemme = pourcentageFemme;
	}

	public final double getPourcentageIndetermine() {
		return pourcentageIndetermine;
	}

	public final void setPourcentageIndetermine(double pourcentageIndetermine) {
		this.pourcentageIndetermine = pourcentageIndetermine;
	}
	
	public final void setPourcentageMixte(double pourcentageIndetermine) {
		this.pourcentageMixte = pourcentageIndetermine;
	}
}
