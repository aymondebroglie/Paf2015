
import java.io.*;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;


import java.util.List;
import java.util.Iterator;

public class JDOM2
{
   static org.jdom2.Document document;
   static Element racine;

   public static void main(String[] args)
   {
      //On crée une instance de SAXBuilder
      SAXBuilder sxb = new SAXBuilder();
      try
      {
         //On crée un nouveau document JDOM avec en argument le fichier XML
         //Le parsing est terminé ;)
         document = sxb.build(new File("D:\\PAF\\Git PAf\\src\\2706406.xml"));
      }
      catch(Exception e){}
      

      //On initialise un nouvel élément racine avec l'élément racine du document.
     racine = document.getRootElement();
     racine = racine.getChild("fr-bibliographic-data");
     racine = racine.getChild("parties");
     racine = racine.getChild("inventors");
     		
   

      //Méthode définie dans la partie 3.2. de cet article
      afficheALL();
   }
   
 //Ajouter cette méthodes à la classe JDOM2
   static void afficheALL()
   {
      //On crée une List contenant tous les noeuds "etudiant" de l'Element racine
      List listEtudiants = racine.getChildren("inventor");
      //On crée un Iterator sur notre liste
      Iterator i = listEtudiants.iterator();
      while(i.hasNext())
      {
         //On recrée l'Element courant à chaque tour de boucle afin de
         //pouvoir utiliser les méthodes propres aux Element comme :
         //sélectionner un nœud fils, modifier du texte, etc...
         Element courant = (Element)i.next();
         //On affiche le nom de l’élément courant
         System.out.println(courant.getChild("addressbook").getChild("first-name").getText());
      }
   }
}