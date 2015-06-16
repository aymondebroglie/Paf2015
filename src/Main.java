import java.util.ArrayList;

import java.io.*;



public class Main {

	public static void main(String[] args) {
		File repertoire = new File("C:\\Users\\Aymon\\Desktop\\Test\\");
		ArrayList<String> list1; 
		JDOM2 jdom = new JDOM2();
		list1 =jdom.listePrenom(repertoire);
		
		
		//code pour la base de donnée
		ListePrenom listeprenom = new ListePrenom();
		listeprenom.initTextFile("data/Prenoms.txt");
		
		ArrayList<Prenom> list = listeprenom.getListePrenom();
	
		int s = list.size();
		
		/*for( int i = 0; i < s; i++){
			System.out.println("prenom = "+list.get(i).getPrenom()+", genre = "+list.get(i).getGenre()+"");
		}*/
		
		/*ArrayList<String> list1 = new ArrayList<String>();
		list1.add("seaghdh"); //h
		list1.add("jaffe"); //f
		list1.add("ezar"); //h
		list1.add("maximilienne"); //f
		list1.add("pipi");
		//list1.add("caca");*/
		
		Resultat resultat = listeprenom.getStat(list1);
		//System.out.println(list.get(200).getPrenom());
		System.out.println("m = "+resultat.getPourcentageHomme()+", f = "+resultat.getPourcentageFemme()+", u = "+resultat.getPourcentageIndetermine()+"");
	}

}
