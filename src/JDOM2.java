//import java.io.*;

//import org.jdom2.*;
//import org.jdom2.input.SAXBuilder;
/*
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class JDOM2 {
	//private org.jdom2.Document document;
	private ArrayList<String> listeFinal = new ArrayList<String>();

	public JDOM2() {

	}

	public ArrayList<String> listePrenom(File repertoire) {

		listerRepertoire(repertoire);
		return listeFinal;
	}

	// Ajouter cette m�thodes � la classe JDOM2
	private void afficheALL(Element racine) {
		// On cr�e une List contenant tous les noeuds "etudiant" de l'Element
		// racine
		List listEtudiants = racine.getChildren("inventor");
		// On cr�e un Iterator sur notre liste
		Iterator i = listEtudiants.iterator();
		while (i.hasNext()) {
			// On recr�e l'Element courant � chaque tour de boucle afin de
			// pouvoir utiliser les m�thodes propres aux Element comme :
			// s�lectionner un n�ud fils, modifier du texte, etc...
			Element courant = (Element) i.next();
			// On affiche le nom de l��l�ment courant
			 String s= courant.getChild("addressbook")
						.getChild("first-name").getText();
             String[] part= s.split(" " );
             String[] part1= part[0].split("-" );
                listeFinal.add(part1[0].toLowerCase());
			System.out.println(part1[0].toLowerCase());
			
		}
	}

	private void listerRepertoire(File repertoire) {

		String[] listefichiers;

		int i;
		listefichiers = repertoire.list();
		for (i = 0; i < listefichiers.length; i++) {
			if (listefichiers[i].endsWith(".xml") == true) {

				// On cr�e une instance de SAXBuilder
				SAXBuilder sxb = new SAXBuilder();
				try {
					// On cr�e un nouveau document JDOM avec en argument le
					// fichier XML
					// Le parsing est termin� ;)
					document = sxb.build(new File(
							"C:\\Users\\Aymon\\Desktop\\Test\\"
									+ listefichiers[i]));
				} catch (Exception e) {
				}
				Element racine;

				// On initialise un nouvel �l�ment racine avec l'�l�ment racine
				// du document.
				try {
					racine = document.getRootElement();
					racine = racine.getChild("fr-bibliographic-data");
					racine = racine.getChild("parties");
					racine = racine.getChild("inventors");
					racine.getAttribute("inventors");
					afficheALL(racine);

				} catch (Exception e) {
				}
			}
		}

	}
}*/