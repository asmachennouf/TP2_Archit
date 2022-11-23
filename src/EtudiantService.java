import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class EtudiantService {
	
	private IEtudiant StudRep;
	private IUniversite UnivRep;
	private IJournal j;

	public void setEtudRep(IEtudiant StudRep) {
		this.StudRep = StudRep;
	}
	public void setUnivRep(IUniversite UnivRep) {
		this.UnivRep = UnivRep;
	}
	public void setJournal(IJournal j) {
		this.j = j;
	}
	public IJournal getJournal() {
		return this.j;
	}
	public IEtudiant getStudRep() {
		return this.StudRep;
	}

	boolean inscription (int matricule, String nom, String pr�nom, String email,String pwd, int id_universite) throws SQLException	
	{
		IEtudiant StudRep= new EtudiantRepository();
	    IUniversite UnivRep= new UniversiteRepository();
	    Etudiant stud = new Etudiant(matricule, nom, pr�nom, email,pwd,id_universite);
	    Universite univ=UnivRep.GetById(id_universite,j);
	    
	    j.outPut_Msg("Log: d�but de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);
	    
	   
		
		
		
		 if (univ.getPack() == TypePackage.Standard)
	     {
	          stud.setNbLivreMensuel_Autorise(10);
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 stud.setNbLivreMensuel_Autorise(10*2);
	     }                           
	     
		 StudRep.add(stud,j);
		 j.outPut_Msg("Log: Fin de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);
		 return true;
	    
		
	}
	
	
	




	
}
