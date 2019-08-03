

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

}
