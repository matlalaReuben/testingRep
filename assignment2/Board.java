
/**
 * 
 * @author vmuser
 *	0 - invalid hole
 *	1 - filled hole
 *  2 - empty hole
 */
 
 import java.util.ArrayList;
 
 
public class Board{

  private int[][] board = new int[7][7];

  public Board(){

  }
  
  public boolean equalBoardConfig(Board board){
	  boolean equal = true;
	  for( int i = 0; i < this.board.length; i++ ){
		  for( int j = 0; j < this.board[i].length; j++ ){
			  if( board.getAt( i, j) != this.getAt( i, j ) ){
				  return false;
			  }
		  }
	  }
	  return true;
  }
  
  public int[][] getBoard(){
	  return this.board;
  }
	
	

  /*public void setRowAt( int[] array, int row ){
		if( array.length = this.board){
			
		}
		else{
			throw( "" );
			return;
		}
  }*/
  
  public void setAt(int x, int y, int value){
	  this.board[y][x] = value; 
  }
  
  public int getAt(int x, int y){
	  return this.board[y][x];
  }
  
  public void makeMove(Move move){
	  this.makeMove(move.getX(), move.getY(), move.getDirection() );
  }
  
  public void setHoleFilled(int x, int y){
	  this.setAt( x, y, 1 );
  }
  
  public void setHoleEmpty(int x , int y){
	  this.setAt( x, y, 2 );
  }
  
  public void setHoleInvalid(int x, int y){
	  this.setAt( x, y, 0 );
  }
  
  public void makeMove(int x, int y, String direction){
	  // System.out.printf( "makeMove( %d, %d, %s ) | board[%d][%d] : %d ", x, y, direction, x, y, this.getAt( x, y ) );
	 
	System.out.printf( "BOARD[1][3] : %d | BORAD[2][3] : %d | BOARD[3][3] : %d\n	", this.getAt(1,3), this.getAt(2,3), this.getAt(3,3) );
	 Hole[] h2_h3 = this.getHolesInDirection( x, y, direction );
	  this.setHoleEmpty( x, y );
	  this.setHoleEmpty( h2_h3[0].getX(), h2_h3[0].getY() );
	  this.setHoleFilled( h2_h3[1].getX(), h2_h3[1].getY() );
	  System.out.printf( "H2 : %s | H3 : %s\n", h2_h3[0], h2_h3[1] );
  }
  
  
  public  Hole[] getHolesInDirection(Move move){
	  return this.getHolesInDirection( move.getX(), move.getY(), move.getDirection() );
  }
  
  public Hole[] getHolesInDirection(int x, int y, String dir){
		Hole[] holes = new Hole[2];
		int x_dir = 0;
		int y_dir = 0;
		
		if( dir.equals( "RIGHT" ) ){
			x_dir = 1;
		}
		else if( dir.equals( "LEFT" ) ){
			x_dir = -1;
		}
		else if( dir.equals( "TOP" ) ){
			y_dir = 1;
		}
		else if( dir.equals( "BOTTOM" ) ){
			y_dir = -1;
		}
		holes[0] = new Hole( x + x_dir, y + y_dir );
		holes[1] = new Hole( x + x_dir * 2, y + y_dir * 2);
		return holes;
  }
  
  public boolean moveIsValid(Move move){
	  return this.moveIsValid( move.getX(), move.getY(), move.getDirection() );
  }  
  
   /**
	* THIS METHOD ASSUME THAT X AND Y ARE IN RANGE ( 0 <= X,Y <= 7 )
	* X AND Y ARE BETWEEN 0 AND 7 AND DIR CAN BE { RIGHT, LEFT, TOP, BOTTOM }
	*/
  public boolean moveIsValid(int x, int y, String dir){
	  // System.out.printf( "moveIsValid( %d, %d, %s ) ", x, y, dir );
	  boolean move = false;
	  int x_dir = 0;
	  int y_dir = 0;
	  // System.out.printf( "BOARD.getAt(%d, %d) : %d ", x, y, this.getAt( x, y ) );
	  if( this.holeFilled( x, y ) ){
		   if( dir.equals( "RIGHT" ) ){
			   x_dir = 1;
		   }
		   else if( dir.equals( "LEFT" ) ){
			   x_dir = -1;
		   }
		   else if( dir.equals( "TOP" ) ){
			   y_dir = 1;
		   }
		   else if( dir.equals( "BOTTOM" ) ){
			   y_dir = -1;
		   }
	  }
	  else{
		  System.out.printf( "HOLE IS NOT FILLED\n" );
		  return false;
	  }
	  // Hole h2 = new Hole(  x + x_dir, y + y_dir );
	  // Hole h3 = new Hole(  x + x_dir * 2, y + y_dir * 2 );
	  // // System.out.printf( "X_DIR : %d y_DIR : %d CHECKING H2 %s AND H3 %s ", x_dir, y_dir, h2, h3 );
	  try{
		  if( this.holeFilled( x + x_dir, y + y_dir ) && this.holeEmpty( x + x_dir * 2, y + y_dir * 2) ){
			  move = true;
		  }
	  }
	  catch( java.lang.ArrayIndexOutOfBoundsException e ){
		  return false;
	  }
	  // System.out.printf("RETURNING : %s\n", move );
	  return move;
  }
  
  
   /**
	* RETURNS ALL VALID MOVES FROM HOLE AT POSITION X, Y
	*/
  
  public Move[] getValidMovesAt(int x, int y){
	  String[] directions = {"RIGHT", "LEFT", "TOP", "BOTTOM"};
	  ArrayList<Move> moves = new ArrayList< Move >( ) ;
	  for( String dir : directions ){
		  if( this.moveIsValid( x, y, dir) ){
			  moves.add( new Move(x, y, dir ) );
		  }
	  }
	  Move[] m = new Move[moves.size() ];
	  m = moves.toArray( m );
	  return m;	
  }
  
  
  public Hole[] getFilledHoles(){
	  
	  ArrayList< Hole > filledHoles = new ArrayList< Hole >();
	  for( int i = 0; i < this.board.length; i++){
		  for( int j  = 0; j < this.board[i].length; j++ ){
			  if( this.holeFilled( i, j ) ){
				  filledHoles.add( new Hole( i, j ) );
			  }
		  }
	  }
	  Hole[] fh = new Hole[ filledHoles.size( ) ];
	  fh = filledHoles.toArray( fh );
	  return fh;
  }
  
  public Move[] getAllValidMoves(){
	  Hole[] filledHoles = this.getFilledHoles();
	  ArrayList< Move > validMoves = new ArrayList< Move >(); 
	  for( Hole filledHole : filledHoles ){
		  Move[] point_moves = this.getValidMovesAt( filledHole.getX(), filledHole.getY() );
		  if( point_moves.length > 0 ){
			  for( Move move : point_moves ){
				  validMoves.add( move );
			  }
		  }
	  }
	  
	  Move[] vm = new Move[ validMoves.size() ];
	  vm = validMoves.toArray( vm );
	  return vm;
  }
	
    
   /** 
	* RETURN TRUE IF HOLE AT POSITION X,Y IS EMPTY
	* EXAMPLE : BOARD[X][Y] = 2
	*/
  public boolean holeEmpty(int x, int y){
	  boolean ret = this.getAt( x, y ) == 2 ? true : false;
	  return ret;
  }
  
  
    
   /** 
	* RETURN TRUE IF HOLE AT POSITION X,Y IS FILLED (  )
	* EXAMPLE : BOARD[X][Y] = 1
	*/
  public boolean holeFilled(int x, int y){
	  boolean ret = false;
	  // try{
		ret = this.getAt( x, y ) == 1 ? true : false;
	  return ret;
	  
  }
  
  
  /** RETURN TRUE IF HOLE AT POSITION X,Y IS INVALID (  )
	* EXAMPLE : BOARD[X][Y] = 0
	*/
  public boolean holeInvalid(int x, int y){
	  boolean ret = false; 
	  // try{
		ret = this.getAt( x, y ) == 0 ? true : false;
	  // }
	  // catch( Exception e ){
		  // e.printStackTrace();
	  // }
	  return ret;
  }
  
  public String toString(){
	  String line = "";
	  for( int i = 0; i < 7; i++ ){
		  for( int j = 0; j < 7; j++ ){
			  String l = String.format( "%d%s", this.getAt( j, i ), j < 6 ? " ":"" );
			  line += l;
		  }
		  line+="\n" ;
	  }
	  return line;
  }
  
  public void cloneBoardTo( Board board ){
	  for( int i = 0; i < 7; i++ ){
		  for( int j = 0; j < 7; j++ ){
			  board.setAt( i, j, this.getAt( i, j ) );
		  }
	  }
  }
  
  // public void printStatus(){
	  
  // }
  
  
  /** RETURNS ALL VALID MOVES ON THE BOARD */
  /*public Move[] getValidMoves(){
	  ArrayList< Move > availableMoves = new ArrayList< Move >();
	  
	  Hole[] filledHoles = this.getFilledHoles();
	  
  }*/
  
//  */
  
  /*
  public void setVerticalAt( int x ){
	  
  }
  */


	
}
