package EntitiesCsv;

import java.util.ArrayList;
import java.util.List;

import EntitiesData.ResultData;
import EntitiesData.ShootoutsData;

public class Shootouts {

	/*
	 * liste d'objet typé pour les données du fichier csv shootouts
	 */
	private List<ShootoutsData> shootoutsData = new ArrayList<>();

	public List<ShootoutsData> getShootoutsData() {
		return shootoutsData;
	}

	public void setShootoutsData(List<ShootoutsData> shootoutsData) {
		this.shootoutsData = shootoutsData;
	}

	@Override
	public String toString() {
		return "Result shootoutsData=" + shootoutsData;
	}

}
