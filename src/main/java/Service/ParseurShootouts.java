package Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import EntitiesCsv.Result;
import EntitiesCsv.Shootouts;
import EntitiesData.ResultData;
import EntitiesData.ShootoutsData;

public class ParseurShootouts {

	public static void ajoutLigne(Shootouts shootouts, String ligne) {
		/*
		 * Permet de diviser les sous chaine (morceaux) en utilisant une virgule
		 */
		String[] morceaux = ligne.split(",");
		/*
		 * assure du bon format de date et parse le localDate en type String
		 */
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateMatch = LocalDate.parse(morceaux[0], formatter);
		String homeTeam = morceaux[1];
		String awayTeam = morceaux[2];
		String winner = morceaux[3];
		/*
		 * Vérifiez si la colonne firstShooter est présente
		 */
		String firstShooter = morceaux.length > 4 ? morceaux[4] : " ";
		/*
		 * stock les donnée dans un objet de type GoalScorersData
		 */
		ShootoutsData data = new ShootoutsData(dateMatch, homeTeam, awayTeam, winner, firstShooter);
		/*
		 * ajoute ces données dans une liste d'objet de type GoalScorers
		 */
		shootouts.getShootoutsData().add(data);
	}
}
