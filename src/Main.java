import java.util.ArrayList;
import java.io.*;



public class Main {

	public static void main(String[] args) {
		ArrayList<String> list1; 
		Recherche rech = new Recherche("fr-patent-document","city");
		list1 = rech.recherche();
		ArrayList<SebVille> occurence = CalculOccurenceVille.calculOccurenceVille(list1);
		for (int j=0; j<occurence.size(); j++){
        	System.out.println(occurence.get(j).getNomVille());
		System.out.println(occurence.get(j).getPourcentage());
		}
		
		/*
		//code pour la base de donnée
		ListePrenom listeprenom = new ListePrenom();
		listeprenom.initTextFile("data/Prenoms.txt");
		
		ArrayList<Prenom> list = listeprenom.getListePrenom();
	
		int s = list.size();
		
		/*for( int i = 0; i < s; i++){
			System.out.println("prenom = "+list.get(i).getPrenom()+", genre = "+list.get(i).getGenre()+"");
		}
		
		
		
		
		Resultat resultat = listeprenom.getStat(list1);
		//System.out.println(list.get(200).getPrenom());
		System.out.println("m = "+resultat.getPourcentageHomme()+", f = "+resultat.getPourcentageFemme()+" u1 = " + resultat.getPourcentageMixte() +", u2 = "+resultat.getPourcentageIndetermine()+"");
	*/}

}
