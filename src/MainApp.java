


public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		EtudiantService serv=new EtudiantService();
		serv.setEtudRep(new EtudiantRepository());
		serv.setUnivRep(new UniversiteRepository());
		serv.setJournal(new AffichageAll());
		AffichageAll jTemp = (AffichageAll)serv.getJournal();
		jTemp.addJournal(new AffichageEcran());
		jTemp.addJournal(new AffichageFile());
		jTemp.addJournal(new AffichageDetail());
		serv.setJournal(jTemp);
		try {
			serv.inscription(2, "Guendouziiiii", "wassila", "guen@gmail.com","xxxx", 1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
