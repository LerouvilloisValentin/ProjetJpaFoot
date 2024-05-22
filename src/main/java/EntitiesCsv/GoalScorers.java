package EntitiesCsv;

import java.util.ArrayList;
import java.util.List;

import EntitiesData.GoalScorersData;
import EntitiesData.ResultData;

public class GoalScorers {

	private List<GoalScorersData> GoalScorersData = new ArrayList<>();

	public List<GoalScorersData> getGoalScorersData() {
		return GoalScorersData;
	}

	public void setGoalScorersData(List<GoalScorersData> GoalScorersData) {
		this.GoalScorersData = GoalScorersData;
	}

	@Override
	public String toString() {
		return "GoalScorers GoalScorersData=" + GoalScorersData ;
	}
	
}
