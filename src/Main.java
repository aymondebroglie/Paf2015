import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.io.*;



public class Main {

	public static void main(String[] args) {
		
		double [][] donne= new double[3] [2];
		
			donne[0][0] = 0;
			donne[1][0] = 0.5;
			donne[2][0] = 2;
			donne[0][1] = 0.5;
			donne[1][1] = 0.25;
			donne[2][1] = 2.5;
			
			
		Kmeans moyenne = new Kmeans(donne,2 )	;
		moyenne.calculateClusters();
		ArrayList[] liste = moyenne.getClusters();
	
	
	//	LectureListe.lectureListe("data/stopword.txt");
		
	//	ArrayList<String> listeStop = LectureListe.lectureListe("data/stopword.txt");
	
		// Code pour la recherche
	//	ArrayList<String> list1; 
	// rech = new Recherche("fr-bibliographic-data","invention-title");
	//	list1 = rech.recherche();
	//	list1.removeAll(Collections.singleton(0));
	//	list1.removeAll(Collections.singleton(""));
	//	list1.removeAll(listeStop);
	//	for(int i =0 ; i <list1.size() ; i++){
	//		System.out.println(list1.get(i));
	//	}
	}
		
		/* Code pour les date */
		/*ArrayList<String> list2 = new ArrayList<String>();
		for (int i = 0; i <list1.size();i++){
			if(list1.get(i).substring(0,4) == "2014" );
			list2.add(list1.get(i));
		}
		
		for (int i = 0; i <list2.size();i++){
			list2.set(i,list1.get(i).substring(4,6));
		}
		*/
		
		/*Code pour les codes postaux */
		/*for (int i = 0; i <list1.size();i++){
			if(list1.get(i).length() > 2 )
			list1.set(i, list1.get(i).substring(0,2));*/
	//	}
//}
		/* Code pour les villes*/
	/*	System.out.println(list1.size());
		TabledeHachage table = new TabledeHachage();
		ArrayList<String> listeRegion = new ArrayList<String>();
		table.init();
		for (int i = 0; i <list1.size();i++){
			list1.set(i,"(" +list1.get(i) + ")");
			if(table.getRegion(list1.get(i)) != null){
			listeRegion.add(table.getRegion(list1.get(i)));
			}
		}
		
		System.out.println(listeRegion.size());*/
		
		
		
		
		/*ArrayList<SebVille> occurence = CalculOccurenceVille.calculOccurenceVille(listeRegion, 0);
		for (int j=0; j<occurence.size(); j++){
        	System.out.println(occurence.get(j).getNomVille());
		System.out.println(occurence.get(j).getPourcentage());
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

//	*/
		}

	

