package Tester;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DB1.DBConnection;
import Journal.afficherCompsite;
import Repository.EtudiantRepository;
import Repository.InterfaceDBConnection;
import Repository.UniversiteRepository;
import Services.Etudiant;
import Services.EtudiantService;
import Services.InterfEtudiant;
import Services.InterfEtudiantRep;
import Services.InterfUniversiteRep;

class TestEtudiantService {

	afficherCompsite jcomp;
	InterfaceDBConnection db;
	InterfUniversiteRep UnivRep;
	InterfEtudiantRep StudRep;
	EtudiantService serv;
	InterfEtudiant etud;

	@BeforeEach
	public void init() throws SQLException {

		jcomp= new afficherCompsite();
		db=DBConnection.getInstance();
		UnivRep=new UniversiteRepository(db,jcomp);
		StudRep=new EtudiantRepository(db,jcomp);
		serv=new EtudiantService(StudRep,UnivRep,jcomp);


	}









	@Test
	void test() throws SQLException, IOException {




		etud = new Etudiant(20, "Anis", "Hamitouche", "amiranis99@gmail.com","xxxxxxxx", 3);
		boolean b=serv.inscription(etud);

		assertEquals(true,b);


	}

}