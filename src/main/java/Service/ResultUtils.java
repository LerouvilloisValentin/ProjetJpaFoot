package Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import EntitiesCsv.Result;

public class ResultUtils {
	/*
	 * méthode qui permet la lecture du fichier
	 */
	public static Result lire(String cheminFichier) {
		Result result = new Result();

		List<String> lignes = null;
		try {
			File file = new File(cheminFichier);
			lignes = FileUtils.readLines(file, "UTF-8");
			/*
			 * On supprime la ligne d'entéte avec les noms des colonnes
			 */
			lignes.remove(0);

			for (String ligne : lignes) {
				/*
				 * méthode qui permet d'ajouter une virgule entre chaques attributs du tableau
				 * et qui les regroupent dans un attributs
				 */
				ParseurResult.ajoutLigne(result, ligne);
			}
			return result;

		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
