
package RandomMazeSolver;

public class Location {
	private int x;//
	private int y;//
	//this is constructor of location, if you create robot's location you use this constructor
	Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//this is constructor of location, if
	Location(Location location) {
		this.x = location.x;
		this.y = location.y;
	}//
        public void setx(int x){
            this.x = x;
        }
        public int getx(){
            return x;
        }
        public void sety(int y){
            this.y=y;
        }
        public int gety(){
            return y;
        }
	//
	boolean equals(int x, int y) {
		return this.x == x && this.y == y;
	}
        
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else {
			if (obj instanceof Location) {
				Location objLocation = (Location)obj;
				return this.x == objLocation.x && this.y == objLocation.y;
			}
			else
				return false;
		}
	}

	@Override
	public String toString() {
		return "P(" + x + ", " + y + ")";
	}
        
}

