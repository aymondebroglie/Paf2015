

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
 
public class Recherche {
        static int i=1;
        static int j=0;
        
        private String noeudPere;
        private String noeudFils;
        ArrayList<String> resultat= new ArrayList<String>();

        
        
        public Recherche(String noeudPere, String noeudFils){
        	this.noeudPere = noeudPere;
        	this.noeudFils = noeudFils;
        }
        
        
        public ArrayList<String> recherche() {

                try {
                         
                		File repertoire= new File("C:\\Users\\Aymon\\Desktop\\Test\\");
                   
                        String[] listefichiers = repertoire.list();
                        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                        for (int k=0; k<listefichiers.length;k++)
                       {
                        	j=0;
                        	 if(listefichiers[k].endsWith(".xml")==true)
                        	 {             
                        File fXmlFile = new File("C:\\Users\\Aymon\\Desktop\\Test\\"+listefichiers[k]);
                        Document doc = dBuilder.parse(fXmlFile);
                        
                        doc.getDocumentElement().normalize();
                        NodeList nList = doc.getElementsByTagName(noeudPere);
                        
                        for (int temp = 0; temp < nList.getLength(); temp++) {
                                 
                                Node nNode = nList.item(temp);
                 
                               
                 
                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                        
                                        Element eElement = (Element) nNode;
                                        if (eElement.getElementsByTagName(noeudFils).item(0)!=null){
                                                i=1;
                                        }
                                        while (i>0){
                                                
                                        
                                      String s=eElement.getElementsByTagName(noeudFils).item(j).getTextContent();
                                    /* String[] part= s.split(" " );
                                        resultat.add(part[0].toLowerCase());*/
                                        resultat.add(s.toLowerCase());
                                        j++;
                                        
                                        
                                        
                                        if (eElement.getElementsByTagName(noeudFils).item(j)==null)
                                        {
                                                i=-1;
                                        }
                                        }
                                }
                        }
                        }
                        }
                        
                       // for (int j=0; j<resultat.size(); j++)
                        	//System.out.println(resultat.get(j));
                       
                        } catch (Exception e) {
                        e.printStackTrace();
                    }
				return resultat;
                  }
        
                 
        }
                
        
        
      


