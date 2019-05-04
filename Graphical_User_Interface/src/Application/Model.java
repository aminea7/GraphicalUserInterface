package Application;
import net.sf.mpxj.MPXJException;
import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.explorer.ProjectFilePanel;
import net.sf.mpxj.reader.UniversalProjectReader;

public class Model {
	public Model() {
		
	}
	
	public static ProjectFile getSchedule(int scenario) {
		UniversalProjectReader reader = new UniversalProjectReader();
		ProjectFile schedule = null;
		try {
			schedule = reader.read("../Resources/" + scenario + "/schedule.mpp");
		} catch (MPXJException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return schedule;
	}
}
