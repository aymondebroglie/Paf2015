import java.io.*;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class JDOM2 {
	static org.jdom2.Document document;
	static ArrayList<String> listeFinal;

	public static void listePrenom(File repertoire) {

	
		listerRepertoire(repertoire);

	}

	// Ajouter cette m�thodes � la classe JDOM2
	static void afficheALL(Element racine) {
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
			System.out.println(courant.getChild("addressbook")
					.getChild("first-name").getText());
			listeFinal.add(courant.getChild("addressbook")
					.getChild("first-name").getText());
		}
	}

	public static void listerRepertoire(File repertoire) {

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
}