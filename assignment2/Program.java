import java.util.ArrayList;
import java.util.Arrays;

public class Program{
	
	
	public Program(){
		
	}
	
	public static void main(String args[ ]){
		
		IOfile iofile = new IOfile( "input_sample.txt" );
		iofile.read();
		String[] lines = iofile.getlines	();
		
		Program program = new Program();
		
		// if(  program.inputsCheck( lines ) ==  true ){
			
		// }
		
		Board startBoard = new Board();
		Board endBoard = new Board();
		for( int i = 0; i < 7; i++ ){
			String start_line = lines[i];
			String end_line = lines[7+i];
			
			String[] start_line_values = start_line.split(" ");
			String[] end_line_values = end_line.split(" ");
			
			for( int j = 0; j < 7; j++ ){
				startBoard.setAt( j, i, Integer.parseInt( start_line_values[ j ] ) );
				endBoard.setAt( j, i, Integer.parseInt( end_line_values[ j ] ) );
			}
		}
		System.out.printf("START : \n%s%s", Color.BRIGHT_BLUE, startBoard);
		Color.resetColor();
		
		System.out.printf("END : \n%s%s", Color.BRIGHT_GREEN, endBoard);
		Color.resetColor();
		
		
		Node parent = new Node( );
		parent.setParent( parent );
		program.foo( parent, startBoard );
		
		
	}
	
	
	/**
	 * inputs : A node - Node Board state and previous/parent node
	 *
	 *
	 */
	public void foo( Node parent, Board board ){
		Move[] validMoves = board.getAllValidMoves();
		if( validMoves.length > 0 ){
			for( Move m : validMoves ){
				Node c = new Node( parent, m);
				parent.addChild( c );
				
				Board b = new Board();
				board.cloneBoardTo( b );
				b.makeMove( m );
				foo( c, b );
			}
		}
	}
	
	public boolean inputsCheck(String[] lines){
		if( lines.length != 7 ){
			return false;
		}
		return true;
	}
}
