package RandomMazeSolver;

public class RandomMazeSolverTest {

   
    public static void main(String[] args) {
                int width = 25;
		int height = 10;
		double holeProbability = 0.01;
		double wallProbability = 0.25;
		Location start = new Location(0, 0);
		Location end = new Location(width-1, height-1);
		World world = new World(width, height, holeProbability, wallProbability, start, end);
		
		System.out.println(world);
		
		int experimentCount = 10000;
		SolverResult solverResult = RandomMazeSolver.solve(world, experimentCount);
		System.out.println(solverResult);
                
    }
    
}
