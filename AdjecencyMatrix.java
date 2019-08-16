
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
		ArrayList< Integer > arrayList = this.getArrayList( size + 1 );
		this.adjecencyMatrix.add( arrayList );
	}

	public ArrayList< Integer > getRow( int parentIndex ){
		return this.adjecencyMatrix.get( parentIndex );
	}

	public ArrayList < Integer > getColumn( int columnIndex ){
		ArrayList< Integer > arrayList = new ArrayList< Integer >( );
		int l = this.getSize( );
		for( int i = 0; i < this.getSize( ); i++ ){
			arrayList.add( this.adjecencyMatrix.get( i ).get( l - 1 ) );
		}
		return arrayList;
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
		this.addRow( );
		this.addColumn( );
	}

	public void set( int xIndex, int yIndex, int v ){
		this.adjecencyMatrix.get( xIndex ).set( yIndex, v );
	}

	public int get( int x, int y ){
		return this.adjecencyMatrix.get( x ).get( y );
	}

	public String toString( ){
		String line	 = "";
		for( int i = 0; i < this.adjecencyMatrix.size( ); i++ ){
			line += this.adjecencyMatrix.get( i )+"\n";
		}
		return line;
	}

	// public void addAt(){
	//
	// }

	// remove row and column at specified positiion
	// public void removeAt( ){
	//
	// }

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
