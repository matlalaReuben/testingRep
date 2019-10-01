
/**
 * 
 * @author vmuser
 *	0 - invalid hole
 *	1 - filled hole
 *  2 - empty hole
 */
public class Board{

  private int[][] board = new int[7][7];

  public Board( ){

  }
  
  public boolean equalBoardConfig( Board board ){
	  boolean equal = true;
	  for( int i = 0; i < this.board.length; i++ ){
		  for( int j = 0; j < this.board[i].length; j++ ){
			  if( this.board[ i ][ j ] =  ){
				  return false;
			  }
		  }
	  }
	  return true;
	  
  }
  
  public int[][] getBoard(){
	  return this.board;
  }
//  /*
  public void setHorizontalAt( int[] array ){
	  
  }
  
  public void setAt( int x, int y, int value ){
	  this.board[x][y] = value; 
  }
  
  public void makeMove( Move move ){
	  this.makeMove(move.getX(), move.getY(), move.getDirection() );
  }
  
  public void makeMove( int x, int y,  String direction){
	  this.board[x][y] = ;
  }
  
  public boolean moveAvailable( Move move ){
	  return this.moveAvailable( move.getX(), move.getY(), move.getDirection() );
  }
  
  public boolean moveAvailable( int x, int y, String dir ){
	  
	  if( this. ){
		  if(  ){
			  
		  }
		  if else(){
			  
		  }
		  if else(){
			  
		  }
		  if else(){
			  
		  }
		  else{
			  
		  }
	  }
	  
  }
  
  public boolean holeEmpty( int x, int y ){
	  boolean ret = this.board[x][y] == 2 ? true : false;
	  return ret;
  }
//  */
  
  /*
  public void setVerticalAt( int x ){
	  
  }
  */



}
