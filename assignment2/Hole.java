

public class Hole{

	private int x;
	private int y;

	public Hole( ){
		this( 0, 0 );
	}

	public Hole( int x, int y ){
		this.x = x;
		this.y = y;
	}

	public int getY(){
		return this.y;
	}

	public int getX(){
		return this.x;
	}
	
	public void setX( int x ){
		this.x = x;
	}
	
	public void setY( int y ){
		this.y = y;
	}
	
	public String toString(){
		String line = String.format( "%d,%d", this.x, this.y );
		return line;
	}
	
}