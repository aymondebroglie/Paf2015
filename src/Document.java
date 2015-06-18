import java.util.ArrayList;

//une classe qui represente un document
public class Document {

	private String path;
	private ListeIDTF listIDTF;
	private ArrayList<Document> autresDocuments; //la liste des autres documents pour pouvoir calculer la tf-idf
	private ArrayList<String> listMots;
	
	public String getPath() {
		return path;
	}
	public ListeIDTF getListIDTF() {
		return listIDTF;
	}
	public ArrayList<Document> getAutresDocuments() {
		return autresDocuments;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	public void setAutresDocuments(ArrayList<Document> autresDocuments) {
		this.autresDocuments = autresDocuments;
	}
	
	
	//une methode qui calcule les tf-idf de tous les termes du document
	public void calculerIDTF() {
		int nbMots=listIDTF.getListe().size();
		ArrayList<String[]> tousDocuments = new ArrayList<String[]>();
		for (int i=0; i<autresDocuments.size(); i++) {
			tousDocuments.add((String[]) autresDocuments.get(i).listMots.toArray());
		}
		for (int i=0; i<nbMots; i++) {
			double tf=IDTF.tfCalculator(listMots, listMots.get(i));
			double idf=IDTF.idfCalculator(tousDocuments, listMots.get(i));
			listIDTF.getListe().get(i).setIdtf(tf*idf);
		}
	}
	
	
	
}
