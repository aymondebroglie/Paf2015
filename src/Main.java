import java.util.ArrayList;

import java.io.*;



public class Main {

	public static void main(String[] args) {
		File repertoire = new File("C:\\Users\\Aymon\\Desktop\\Test\\");
		JDOM2.listePrenom(repertoire);
		
		
		//code pour la base de donn�e
		ListePrenom listeprenom = new ListePrenom();
		listeprenom.initTextFile("data/Prenoms.txt");
		
		ArrayList<Prenom> list = listeprenom.getListePrenom();
	
		int s = list.size();
		
		for( int i = 0; i < s; i++){
			System.out.println("prenom = "+list.get(i).getPrenom()+", genre = "+list.get(i).getGenre()+"");
		}
	}

}
