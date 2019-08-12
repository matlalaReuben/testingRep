

public class Obsticle{
	
	private Coordinate topLeft;
	private Coordinate bottomRight;
	
	public Obsticle(Coordinate topLeft, Coordinate bottomRight){
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}
	
	
	public boolean betweenX( int x ){
		return ( x >= topLeft.getX( ) && x <= bottomRight.getX( ) );
	}
	
	
	public boolean betweenY( int y ){
		return ( y >= topLeft.getY( ) && y <= bottomRight.getY( ) );
	}
	
	
	public boolean BetweenX( Coordinate coord ){
		return betweenX( coord.getX() );
	}
	
	
	public boolean betweenY( Coordinate coord){
		return betweenY( coord.getY() );
	}
	
	
	public boolean pointOnObsticle( Coordinate coord ){
		return betweenX( coord.getX( ) ) && betweenY( coord.getY() );
	}
	
	
}