
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
 
public class Pren {
        static int i=1;
        static int j=0;

        public static void main(String[] args) {
                // TODO Auto-generated method stub
        	
        	ArrayList<String> listePrenom= new ArrayList<String>();

                try {
                         
                		File repertoire= new File("C:/Users/Mehdi/Desktop/Brev");
                   
                        String[] listefichiers = repertoire.list();
                        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                        for (int k=0; k<listefichiers.length/1000;k++)
                       {
                        	j=0;
                        	 if(listefichiers[k].endsWith(".xml")==true)
                        	 {             
                        File fXmlFile = new File("C:/Users/Mehdi/Desktop/Brev/"+listefichiers[k]);
                        Document doc = dBuilder.parse(fXmlFile);
                        
                        doc.getDocumentElement().normalize();
                        NodeList nList = doc.getElementsByTagName("inventors");
                        
                        for (int temp = 0; temp < nList.getLength(); temp++) {
                                 
                                Node nNode = nList.item(temp);
                 
                               
                 
                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                                        
                                        Element eElement = (Element) nNode;
                                        if (eElement.getElementsByTagName("first-name").item(0)!=null){
                                                i=1;
                                        }
                                        while (i>0){
                                                
                                        
                                      String s=eElement.getElementsByTagName("first-name").item(j).getTextContent();
                                     String[] part= s.split(" " );
                                        listePrenom.add(part[0].toLowerCase());
                                        j++;
                                        
                                        
                                        
                                        if (eElement.getElementsByTagName("first-name").item(j)==null)
                                        {
                                                i=-1;
                                        }
                                        }
                                }
                        }
                        }
                        }
                        
                        for (int j=0; j<listePrenom.size(); j++)
                        	System.out.println(listePrenom.get(j));
                       
                        } catch (Exception e) {
                        e.printStackTrace();
                    }
                  }
                 
        }
                
        
        
      
