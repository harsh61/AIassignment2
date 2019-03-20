package tsp;

public class City {

	int cityX;
	int cityY;
	
	//Here I am assigning a city randomly 
	public City(){
		this.cityX = (int)(Math.random() * 200);
		this.cityY = (int)(Math.random() * 200);
	}
	
	//Here is the chosen city
	public City(int cityX, int cityY){
		this.cityX = x;
		this.cityY = y;
	}
	
	// get citys x coordinates 
	public int getcityX(){
		return this.cityX;
	}
	
	// get citys y coordinates 
	public int getcityY(){
		return this.cityY;
	}
	
	//This is for the distance between the given city
	public double distanceTo (City city){
		int xDis = Math.abs(getcityX() - city.getcityX());
		int yDis = Math.abs(getcityY() - city.getcityY());
		double distance = Math.sqrt( (xDis*xDis) + (yDis*yDis));
	
		return distance;
	}
	
	@override
	public String toString(){
		return getcityX() + "," + getcityY();
	}
}	
	
	
	
	
	
}
