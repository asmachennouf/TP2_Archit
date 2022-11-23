import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class AffichageFile implements IJournal {

	@Override
	public void outPut_Msg(String message) {
		try {
			File f = new File("C:\\Users\\LOTFI\\Desktop\\TPArchi\\TP2 SOLID\\src\\filejournal.txt");
			FileWriter fw = new FileWriter(f, true);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(message);
			pw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
