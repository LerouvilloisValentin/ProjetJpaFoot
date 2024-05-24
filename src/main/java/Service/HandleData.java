package Service;

import EntitiesCsv.GoalScorers;
import EntitiesCsv.Result;
import EntitiesCsv.Shootouts;
import EntitiesData.ResultData;

public class HandleData {
	/*
	 * lit le fichier csv dans un tableau d'obejt de type Result
	 */
	public static Result getResult() {
		String filePath = ClassLoader.getSystemClassLoader().getResource("results.csv").getFile();
		return ResultUtils.lire(filePath);
	}

	/*
	 * lit le fichier csv dans un tableau d'obejt de type GoalScorers
	 */
	public static GoalScorers getGoalScorers() {
		String filePath2 = ClassLoader.getSystemClassLoader().getResource("goalscorers.csv").getFile();
		return GoalScorersUtils.lire(filePath2);
	}

	/*
	 * lit le fichier csv dans un tableau d'objet de type Shootouts
	 */
	public static Shootouts getShootouts() {
		String filePath3 = ClassLoader.getSystemClassLoader().getResource("shootouts.csv").getFile();
		return ShootoutsUtils.lire(filePath3);
	}

	public static void main(String[] args) {
//		Result result = getResult();
//		System.out.println(result);
//
//		GoalScorers goalScorers = getGoalScorers();
//		System.out.println(goalScorers);

		Shootouts shootouts = getShootouts();
		System.out.println(shootouts);
	}
}
