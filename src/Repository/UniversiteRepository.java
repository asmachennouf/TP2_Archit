package Repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UniversiteRepository implements IUniversite {
	
	@Override
	public Universite GetById(int universityId ,  IJournal j) throws SQLException {
		
		DBConnection BD= DBConnection.getInstance();
		Connection connect=BD.getConn(); 
		Statement stmt = connect.createStatement();
		j.outPut_Msg("LogBD : d�but recherche de id universit� dans la base de donn�e");
		
		String sql = "select * from universite where id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
			
		j.outPut_Msg("LogBD : universit� r�cup�r�e");
		
		connect.close();
		return u;	
	
		
	}
	@Override
	public int NbrLivreAutoriser(int universityId) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Universite univ=this.GetById(universityId, null);
		
		AbstractFactory abs = new ConcretFactory();
		Package pack = abs.getPackage(univ.getPack()); 
		return pack.getNbrLivreAutorise();
	}
	
	@Override
	public int GetNbrBonus(int universityId) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Universite univ=this.GetById(universityId, null);
		AbstractFactory abs = new ConcretFactory();
		Package pack = abs.getPackage(univ.getPack()); 
		return pack.getNbrLivreBonus();
	}
	
}
