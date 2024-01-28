package RandomMazeSolver;
import static RandomMazeSolver.World.CellType.Wall;
public class RandomMazeSolver {
        RandomMazeSolver() {       
	}
        
	
	static SolverResult solve(World world, int experimentCount) {
		SolverResult solverResult = new SolverResult();

		int trialFactor = 100;
		int maximumTrialCount = trialFactor * world.getArea();
		
		for (int i=0; i<experimentCount; i++) {
			if (i % 256 == 0) {
				System.out.print(".");
			}
			
			executeExperiment(world, maximumTrialCount);
			
			if (world.isRobotDead())
				solverResult.incrementDead();
			else {
				if (world.isRobotAtEnd())
					solverResult.incrementSuccess();
				else
					solverResult.incrementFailure();
			}
		}
		
		System.out.println("\n");
		return solverResult;
	}
	
        
	static void executeExperiment(World world, int maximumTrialCount) {
            world.restartTheWorld();
            for(int i=0;i<maximumTrialCount;i++){
                 if (world.isRobotAtEnd() || world.isRobotDead()) {
                    break;
                }
                world.moveRobotRandomly();
            }
        }
	
}