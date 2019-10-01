
public class Move {
	
	private int x;
	private int y;
	String direction;
	
	public Move(){
		
	}
	
	public void setX( int x )  {
		this.x = x;
	}
	
	
	public void setY( int y ){
		this.y = y;
	}
	
	public void setDirection( String dir ){
		this.direction = dir;
	}
	
	public int getX()  {
		return this.x;
	}
	
	
	public int getY(){
		return this.y;
	}
	
	public String getDirection( ){
		return this.direction;
	}

}
