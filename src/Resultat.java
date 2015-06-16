
public class Resultat {
	
	private double pourcentageHomme;
	private double pourcentageFemme;
	private double pourcentageIndetermine;
	private double pourcentageMixte;
	private double normaliseHomme;
	private double normaliseFemme;
	
	public Resultat(double pourcentageHomme, double pourcentageFemme, double pourcentageIndetermine, double pourcentageMixte){
		
		this.pourcentageFemme = pourcentageFemme;
		this.pourcentageHomme = pourcentageHomme;
		this.pourcentageIndetermine = pourcentageIndetermine;
		this.pourcentageMixte = pourcentageMixte;
		this.normaliseHomme = 0;
		this.normaliseFemme = 0;
	}
	
	public void calculNormalise(){
		normaliseHomme = (pourcentageHomme + pourcentageHomme*pourcentageMixte)*(100 - pourcentageIndetermine)/100;
		normaliseFemme = (pourcentageFemme + pourcentageFemme*pourcentageMixte)*(100 - pourcentageIndetermine)/100;
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
	
	public final double getNormaliseHomme() {
		return normaliseHomme;
	}
	
	public final double getNormaliseFemme() {
		return normaliseFemme;
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
