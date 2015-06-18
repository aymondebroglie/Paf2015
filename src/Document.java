import java.util.ArrayList;

//une classe qui represente un document
public class Document {

	private String path;
	private ListeIDTF listIDTF;
	private ArrayList<Document> autresDocuments; //la liste des autres documents pour pouvoir calculer la tf-idf
	
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
		for (int i=0; i<nbMots; i++) {
			double tfidf=listIDTF.getListe().get(i).getIdtf();
			listIDTF.getListe().get(i).setIdtf(tfidf);
		}
	}
	
	
	
}
