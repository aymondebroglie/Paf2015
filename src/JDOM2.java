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

	// Ajouter cette méthodes à la classe JDOM2
	private void afficheALL(Element racine) {
		// On crée une List contenant tous les noeuds "etudiant" de l'Element
		// racine
		List listEtudiants = racine.getChildren("inventor");
		// On crée un Iterator sur notre liste
		Iterator i = listEtudiants.iterator();
		while (i.hasNext()) {
			// On recrée l'Element courant à chaque tour de boucle afin de
			// pouvoir utiliser les méthodes propres aux Element comme :
			// sélectionner un nœud fils, modifier du texte, etc...
			Element courant = (Element) i.next();
			// On affiche le nom de l’élément courant
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

				// On crée une instance de SAXBuilder
				SAXBuilder sxb = new SAXBuilder();
				try {
					// On crée un nouveau document JDOM avec en argument le
					// fichier XML
					// Le parsing est terminé ;)
					document = sxb.build(new File(
							"C:\\Users\\Aymon\\Desktop\\Test\\"
									+ listefichiers[i]));
				} catch (Exception e) {
				}
				Element racine;

				// On initialise un nouvel élément racine avec l'élément racine
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