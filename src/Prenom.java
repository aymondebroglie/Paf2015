

	public class Prenom {
		
		private String Prenom;
		private String Genre;
		
		public Prenom(String prenom, String genre){
			Prenom = prenom;
			Genre = genre;
		}
		
		public Prenom(){
			Prenom = "";
			Genre = "";
		}
		
		public void setPrenom( String prenom){
			Prenom = prenom;
		}
		
		public void setGenre( String genre){
			Genre = genre;
		}
		
		public String getPrenom(){
			return Prenom;
		}
		
		public String getGenre(){
			return Genre;
		}
	}
		

