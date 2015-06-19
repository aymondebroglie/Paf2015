
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;



public  class IDTF  implements Comparable<IDTF>  {
	

	public ArrayList<double[]> getVecteurs (ArrayList<IDTF> docs) {
		ArrayList<double[]> res=new ArrayList<double[]>();
		int j=0;
		int p=0;
		for (int i=0; i<docs.size(); i++) {
			j=j+1;
			String mot=docs.get(i).getMot();
			if(mot.equals("fin")) {
				if (j>0) {
					double vecteur[]=new double[j-1];
					for(int k=0; k<j; k++) {
						vecteur[k]=docs.get(p+k).getIdtf();
					}
					res.add(vecteur);
					p=p+j;
					j=0;
				}
			}
		}
		return res;
	}
	
	
	private double idtf;
	private String mot;
	
	public IDTF(String mot, double idtf)
	{
		this.mot=mot;
		this.idtf=idtf;
		
	}
	
	public void setIdtf(double idtf){
		this.idtf=idtf;
		
	}
	
	public double getIdtf(){
		return idtf;
	}
	
	public void setMot(String mot) {
		this.mot=mot;
	}
	
	public String getMot() {
		return mot;
	}
	
	
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
            
			File repertoire= new File("C:/Users/oussama/Desktop/INPI/2014/FR_FRNEWST36_2014_48/doc/2992519_1");
			 String[] listefichiers = repertoire.list();
            
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            for (int k=0; k<listefichiers.length;k++)
            {
            	 if(listefichiers[k].endsWith(".xml")==true)
            	 {             
            File fXmlFile = new File("C:/Users/oussama/Desktop/INPI/2014/FR_FRNEWST36_2014_48/doc/2992519_1/"+"2992519.xml");
            Document doc = dBuilder.parse(fXmlFile);
            
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("abstract");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                     
                    Node nNode = nList.item(temp);
     
                 //   System.out.println("\nCurrent Element :" + nNode.getNodeName());
     
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                            
                            Element eElement = (Element) nNode;
                           
                                    
                            
                           String s= eElement.getElementsByTagName("p").item(0).getTextContent();
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
		
		//String c=tout.get(0);
		tout.removeAll(Collections.singleton(""));
		
		ListeIDTF repFre= new ListeIDTF();
		int p=0;
        for (String s : tout) 
        {
    		double idfCalculator = idfCalculator(listTitre, s);
    		double tfCalculator= tfCalculator(tout, s);
    		double f= idfCalculator*tfCalculator;
    		IDTF idtf= new IDTF(s, f);
    		repFre.addIDTF(idtf);
    		p++;

        }
        
        repFre.trier();
       for (int i=0;i<repFre.getListe().size();i++) {
    	   System.out.println(repFre.getListe().get(i).getMot() +"  "+ repFre.getListe().get(i).getIdtf());
       }
        
        
		
		
      }

	 public int compareTo(IDTF idtf) {
		// TODO Auto-generated method stub
		if (this.idtf>idtf.getIdtf()) return 1;
		else if (this.idtf<idtf.getIdtf()) return -1;
		else return 0;
	}



     

    


}

