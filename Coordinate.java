

public class Coordinate{

  private int x;
  private int y;

  public Coordinate( int x, int y ){
    this.x = x;
    this.y = y;
  }

  public Coordinate(String[] values){
    this.x = Integer.parseInt( values[0] );
    this.y = Integer.parseInt( values[1] );
  }

  public int getX(){
    return this.x;
  }

  public int getY(){
    return this.y;
  }

  public String toString(){
    return "("+Integer.toString( x )+","+Integer.toString( y )+")";
  }
  
  public boolean equals( Coordinate coord ){
      return this.equals( coord.getX(), coord.getY() );
  }
  
  
  public boolean equals( int x, int y ){
      return this.x==x && this.y==y;
  }

  public double distanceTo( Coordinate coord ){
      return this.distanceTo( coord.getX(), coord.getY() );
  }
  
  public double distanceTo( int x, int y ){
      
      // double dist = Math.sqrt( ( one.getX( ) - two.getX( ) )^2 + ( one.getY( ) - two.getY( ) )^2 );
      double sumX = ( this.x - x )^2;
      double sumY = ( this.x - y )^2;
      
      double res = Math.sqrt( sumX + sumY );
      return res;
  }
  

}
