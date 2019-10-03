
public class Move extends Hole{
	
	// private int x;
	// private int y;
	String direction;
	
	public Move( ){
		this( 0, 0, "" );
	}
	
	public Move( int x, int y, String dir  ){
		super(x, y);
		this.direction = dir;
	}
	
	public void setDirection( String dir ){
		this.direction = dir;
	}
	
	public String getDirection( ){
		return this.direction;
	}
	
	public String toString(){
		String line = String.format( "(%d, %d, %s)", this.getX(), this.getY(), this.direction );
		return line;
	}
	
	public void set( Move move ){
		super.setX(move.getX());
		super.setY(move.getY());
		this.direction = move.getDirection();
	}

}
