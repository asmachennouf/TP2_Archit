package Repository;
import java.io.IOException;
import java.sql.SQLException;

public interface IUniversite {
	
	public Universite GetById(int universityId, IJournal j) throws SQLException;

	int GetNbrBonus(int universityId) throws SQLException, IOException;

	int NbrLivreAutoriser(int universityId) throws SQLException, IOException;
}
