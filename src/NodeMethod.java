
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class NodeMethod {
        static int i=1;
        static int j=0;

        public static void listePrenom(File repertoire) {

                try {

                	String[] listefichiers;

            		int k;
            		listefichiers = repertoire.list();
            		for (k = 0; k < listefichiers.length; k++) {
            			if (listefichiers[k].endsWith(".xml") == true) {
                        File fXmlFile = new File("C:\\Users\\Aymon\\Desktop\\Test\\"
									+ listefichiers[k]);

                        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                        Document doc = dBuilder.parse(fXmlFile);

                        doc.getDocumentElement().normalize();
                        NodeList nList = doc.getElementsByTagName("inventors");

                        for (int temp = 0; temp < nList.getLength(); temp++) {

                                Node nNode = nList.item(temp);

                                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                                        Element eElement = (Element) nNode;
                                        if (eElement.getElementsByTagName("first-name").item(0)!=null){
                                                i=1;
                                        }
                                        while (i>0){


                                        System.out.println("First Name : " + eElement.getElementsByTagName("first-name").item(j).getTextContent());
                                        j++;

                                        if (eElement.getElementsByTagName("first-name").item(j)==null)
                                        {
                                                i=-1;
                                        }
                                        }
                                }
                        }}}}
                     catch (Exception e) {
                       /* e.printStackTrace();*/
                    }
            		
                  }
                }





        