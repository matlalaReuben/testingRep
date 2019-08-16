
import java.util.ArrayList;

public class AdjecencyMatrix{
	
	
	private ArrayList< ArrayList< Integer > > adjecencyMatrix = new ArrayList< ArrayList< Integer > >( );	
	// private int n;
	

	AdjecencyMatrix(  ){

	}
	
	private ArrayList< Integer > getArrayList( int n ){
		ArrayList< Integer > arrayList = new ArrayList< Integer >( );
		
		for( int i = 0; i < n; i++ ){
			arrayList.add( 0 );
		}
		return arrayList;
	}
	
	public void addRow( ){
		int size = this.adjecencyMatrix.size( );
		ArrayList arrayList = this.getArrayList( size );
		this.adjecencyMatrix.add( arrayList );
	}
	
	public void addColumn( ){
		for( int i = 0; i < this.adjecencyMatrix.size( ); i++ ){
			this.adjecencyMatrix.get( i ).add( 0 );
		}
	}
	
	public int getSize( ){
		return this.adjecencyMatrix.size(  );
	}
	
	
	// add row and column
	public void add( ){
		
	}
	
	public void addAt(){
		
	}
	
	// remove row and column at specified positiion
	public void removeAt( ){
		
	}
	
	// public getNumRows(){
		// return this.adjecencyMatrix.size( );
	// }
	
	// public int getNumColumn(){
		// int numRows = this.getNumRows( );
		// if(){
			// return this.ad
		// }
	// }
	
}