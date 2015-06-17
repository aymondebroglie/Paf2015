import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.io.*;



public class Main {

	public static void main(String[] args) {
		ArrayList<String> list1; 
		Recherche rech = new Recherche("fr-patent-document","city");
		list1 = rech.recherche();
		/*String c = list1.get(10);
		list1.removeAll(Collections.singleton(c));*/
		System.out.println(list1.size());
		ArrayList<SebVille> occurence = CalculOccurenceVille.calculOccurenceVille(list1, 0);
		for (int j=0; j<occurence.size(); j++){
        	System.out.println(occurence.get(j).getNomVille());
		System.out.println(occurence.get(j).getPourcentage());
		}
		/*for(int j = 0; j < list1.size(); j++){
			System.out.println(list1.get(j));
		}*/
		
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
