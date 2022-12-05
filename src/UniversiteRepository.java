
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
		j.outPut_Msg("LogBD : début recherche de id université dans la base de donnée");
		
		String sql = "select * from universite where id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
			
		j.outPut_Msg("LogBD : université récupérée");
		
		connect.close();
		return u;	
	
		
	}	
	
	@Override
	public int GetNbrBonus(int universityId) throws SQLException, IOException {
		// TODO Auto-generated method stub
		Universite univ=this.GetById(universityId, null);
		if (univ.getPack() == TypePackage.Standard)
	     {
	          return 5;
	     }
	     else if (univ.getPack() == TypePackage.Premium)
	     {
	    	 return 10;
	     }     
		return 0;
	}
	
}
