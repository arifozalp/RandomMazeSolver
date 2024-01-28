package RandomMazeSolver;

public class SolverResult {
	private int deadCount = 0;//
	private int failureCount = 0;//
	private int successCount = 0;//
	
	int getTotal() {
		return deadCount + failureCount + successCount;
	}
	
	void incrementDead() {
		deadCount++;
	}
	
	int getDeadCountCount() {
		return deadCount;
	}
	
	double getDeadPercentage() {
		int total = getTotal();
		
		return total > 0 ? (100.0 * deadCount) / total : 0.0;
	}	
	
	void incrementFailure() {
		failureCount++;
	}
	
	int getFailureCount() {
		return failureCount;
	}
	
	double getFailurePercentage() {
		int total = getTotal();
		
		return total > 0 ? (100.0 * failureCount) / total : 0.0;
	}	
	
	void incrementSuccess() {
		successCount++;
	}
	
	int getSuccessCount() {
		return successCount;
	}	
	
	double getSuccessPercentage() {
		int total = getTotal();
		
		return total > 0 ? (100.0 * successCount) / total : 0.0;
	}	
	
	@Override
	public String toString() {
		return  "Dead percentage: " + getDeadPercentage() + "%\n" +
				"Failure percentage: " + getFailurePercentage() + "%\n" +
				"Success percentage: " + getSuccessPercentage() + "%";
	}
}
