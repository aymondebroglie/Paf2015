
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;



public class IDTF {
	
	  public static double tfCalculator(ArrayList<String> totalterms, String termToCheck) {
	        double count = 0;  //to count the overall occurrence of the term termToCheck
	        for (String s : totalterms) {
	            if (s.equalsIgnoreCase(termToCheck)) {
	                count++;
	            }
	        }
	        return count / totalterms.size();
	    }
	  
	  
	    /**
	     * Calculates idf of term termToCheck
	     * @param allTerms : all the terms of all the documents
	     * @param termToCheck
	     * @return idf(inverse document frequency) score
	     */
	    public static double idfCalculator(ArrayList<String[]> allTerms, String termToCheck) {
	        double count = 0;
	        for (String[] ss : allTerms) {
	            for (String s : ss) {
	                if (s.equalsIgnoreCase(termToCheck)) {
	                    count++;
	                    break;
	                }
	            }
	        }
	        return Math.log(allTerms.size() / count);
	    }
	    
	    
	
	  


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		

		
		ArrayList<String[]> listTitre = new ArrayList<String[]>();
		ArrayList<String> tout= new ArrayList<String>();
		
		try {
            
			File repertoire= new File("C:/Users/Mehdi/Desktop/Brev");
			 String[] listefichiers = repertoire.list();
            
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            for (int k=0; k<listefichiers.length/100;k++)
            {
            	 if(listefichiers[k].endsWith(".xml")==true)
            	 {             
            File fXmlFile = new File("C:/Users/Mehdi/Desktop/Brev/"+listefichiers[k]);
            Document doc = dBuilder.parse(fXmlFile);
            
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("fr-bibliographic-data");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                     
                    Node nNode = nList.item(temp);
     
                 //   System.out.println("\nCurrent Element :" + nNode.getNodeName());
     
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            
                            Element eElement = (Element) nNode;
                           
                                    
                            
                           String s= eElement.getElementsByTagName("invention-title").item(0).getTextContent();
                           String[] parts= s.split(" ");
                           listTitre.add(parts);
                           for (int k1=0; k1<parts.length; k1++) {
                        	   tout.add(parts[k1]);
                           }
                           
                        
                            
                    }
                    
                    

            }
            }
            	 }
            
           
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		//idfCalculator(, )
		String c=tout.get(0);
		tout.removeAll(Collections.singleton(c));
		//while(tout.remove(c));
		
		
		/*for(int l=0; l<tout.size(); l++)
		{
			//if (tout.get(l)!=c)
			System.out.println(tout.get(l));
			
			
		}
		*/
		
		
		double tfCalculator = idfCalculator(listTitre, "DISPOSITIF");
		System.out.println(tfCalculator);
		
      }
	
	
     
    
    


}
