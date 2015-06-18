import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//classe qui represent une liste d'IDTF

public class ListeIDTF {
	
	private ArrayList<IDTF> liste;
	
	
	
	public ArrayList<IDTF> getListe() {
		return liste;
	}

	//ajouter une IDTF a la liste
	public void addIDTF(IDTF idtf) {
		liste.add(idtf);
	}

	//trier la liste par Tf-idf croissant
	
	public void trier(){
		//List<IDTF> list= liste;
		Collections.sort(liste);
		//liste=new ArrayList<IDTF>(list);
	}
	
	public ListeIDTF(ArrayList<IDTF> liste) {
		this.liste= liste;
	}
	
	
	public ListeIDTF() {
		// TODO Auto-generated constructor stub
		liste=new ArrayList<IDTF>();
	}

	//calcule la distance minimale entre deux IDTF
	public double distanceMinimale() {
		double resultat=0;
		int taille=liste.size();
		ListeIDTF ListeTriee=new ListeIDTF(this.liste);
		ListeTriee.trier();
		ArrayList<IDTF> listeTriee=ListeTriee.getListe();
		for (int i=1; i<taille;i++) {
			if (listeTriee.get(i).getIdtf()-listeTriee.get(i-1).getIdtf() > resultat)
				resultat=listeTriee.get(i).getIdtf()-listeTriee.get(i-1).getIdtf();
		}
		return resultat;
	}
	
	
}
