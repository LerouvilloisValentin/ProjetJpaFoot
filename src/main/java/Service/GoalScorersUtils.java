package Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import EntitiesCsv.GoalScorers;

public class GoalScorersUtils {

	public static GoalScorers lire(String cheminFichier) {
		GoalScorers goalScorers = new GoalScorers();
		
		List<String> lignes = null;
		try {
			File file = new File(cheminFichier);
			lignes = FileUtils.readLines(file, "UTF-8");
			
			// On supprime la ligne d'entéte avec les noms des colonnes
			lignes.remove(0);
			
			for (String ligne: lignes){
				ParseurGoalScorers.ajoutLigne(goalScorers, ligne);
			}
			return goalScorers;
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
