package Journal;



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
		
		int matricule = 2;
		String email = "asma@gmail.com";
		try {
			if (!serv.getStudRep().Exists(matricule,serv.getJournal()) && !serv.getStudRep().Exists(email, serv.getJournal()))
		    {
				serv.inscription(matricule, "chennouf", "asmaa", email,"xxxx", 1);
		    }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
