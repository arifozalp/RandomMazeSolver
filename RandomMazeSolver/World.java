
package RandomMazeSolver;

import java.util.Random;

public class World {
	
        static Random rand = new Random();
	final int initialLifeCount = 100;
	private int robotLifeCount;
	private Location robot = null;
        final Location start;
	final Location end;
	final double holeProbability;
	final double wallProbability;

	enum CellType {
		Wall,
		Corridor;
		
		@Override
		public String toString() {
			return this == Wall ? "#" : ".";
		}
		
		static CellType random(double wallProbability) {
			return (rand.nextDouble() < wallProbability ? Wall : Corridor);
		}
	}
	
	final CellType[][] cells;

	World(int width, int height, double holeProbability, double wallProbability, Location start, Location end) {
		this.holeProbability = holeProbability;
		this.wallProbability = wallProbability;
		this.start = start;
		this.end = end;
						
		cells = new CellType[height][width];
		
		restartTheWorld();		
	}
	
	void restartTheWorld() {
		createRandomMaze(holeProbability, wallProbability);
		rebootTheRobot();		
	}
	
	void createRandomMaze(double holeProbability, double wallProbability) {
		for (int y=0; y<cells.length; y++) {
			CellType[] row = cells[y];
			
			for (int x=0; x<row.length; x++) {
				if (start.equals(x, y) || end.equals(x, y))
					row[x] = CellType.Corridor;
				else {
					if (rand.nextDouble() > holeProbability)
						row[x] = CellType.random(wallProbability);
					else
						row[x] = null;
				}
			}
		}		
	}
	
	int getArea() {
		return cells.length * cells[0].length;
	}
        public int getrobotLifeCount(){
            return robotLifeCount;
        }
	
	void rebootTheRobot() {
		robotLifeCount = initialLifeCount;
		
		this.robot = new Location(start);
	}
	
	boolean isRobotDead() {
		return (robotLifeCount <= 0);
	}
	
	boolean isRobotAtStart() {
		return !isRobotDead() && robot.equals(start);
	}
	
	boolean isRobotAtEnd() {
		return !isRobotDead() && robot.equals(end);
	}
	
	CellType robotAt() {
		return robot == null ? null : cells[ robot.gety()][robot.getx()];
	}
		
	void moveRobotRandomly() {
		int deltaX, deltaY;
		do {
			deltaX = rand.nextInt(-1, 2);
			deltaY = rand.nextInt(-1, 2);
		}
		while (Math.abs(deltaX) + Math.abs(deltaY) != 1);
		
		int newX = robot.getx()+ deltaX;
		int newY = robot.gety() + deltaY;
		
		boolean canMove = (newY >= 0 && newY < cells.length &&
						   newX >= 0 && newX < cells[newY].length &&
						   cells[newY][newX] != CellType.Wall); 
		if (canMove) {
			robot.setx(newX);
			robot.sety(newY);
                        
			
			if (cells[ robot.gety()][robot.getx()] == null) {
				robotLifeCount--;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int y=0; y<cells.length; y++) {
			CellType[] row = cells[y];

			for (int x=0; x<row.length; x++) {		
				if (robot != null && robot.equals(x, y))
					sb.append("*");
				else {
					if (row[x] == null)
						sb.append("x");
					else {
						if (start.equals(x, y))
							sb.append("S");
						else
							if (end.equals(x, y))
								sb.append("E");
							else
								sb.append(row[x]);
					}
				}
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
}
