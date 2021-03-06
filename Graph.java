
import java.util.ArrayList;
// import java.util.List;
// import java.util.LinkedList;

public class Graph{

	private ArrayList< Coordinate > Nodes = new ArrayList< Coordinate >();
	private ArrayList< Obsticle > Obsticles = new ArrayList< Obsticle >( );
	private AdjecencyMatrix adjecencyMatrix = new AdjecencyMatrix( );

	Graph(  ){

	}


	// POPULATE THE ADJECENCY MATRIX WITH ZEROS
	// public void populateAdjecencyMatrix( ){
	// 	adjecencyMatrix = new ArrayList< ArrayList< Integer > >( );
	//
	// 	int length = this.nodes.size();
	//
	// 	for( int i = 0; i < length; i++){
	// 		for( int j = 0; j < length; j++){
	// 			adjecencyMatrix.get( 0 ).set( j, 0 );
	// 		}
	// 	}
	//
	// 	}

	// public void removeNode( Coordinate coord ){

		// this.removeEdge();
		// this.removeEdge();
	// }

	public void addObsticle(Coordinate topLeft, Coordinate bottomRight){
		Obsticles.add( new Obsticle( topLeft, bottomRight ) );
	}


	// CHECKS IF A SAMPLE POINT IS ON ANY OF THE OBSTICLES
	public boolean nodeOnObsticle( Coordinate coord ){
		for( int i = 0; i < Obsticles.size( ); i++ ){
			if( this.Obsticles.get( i ).pointOnObsticle( coord ) ){
				return true;
			}
		}
		return false;
	}


	// RETURNS TRUE IF obsticle EXIST IN Obsticles LIST
	public boolean obsticleExist( Obsticle obsticle ){
		for( int i = 0; i < this.Obsticles.size( ); i++ ){
			if( obsticle.equals( this.Obsticles.get( i ) ) ){
				return true;
			}
		}
		return false;
	}

	// RETURNS ARRAYLIST OF NODES CONNECTED TO PARENT
	public ArrayList< Integer > getConnected( Coordinate coord ){
		int parentIndex = this.getIndex( coord );
		return this.getConnected( parentIndex );
	}


	public ArrayList< Integer > getConnected( int parentIndex ){
		// int parentIndex = this.getIndex( coord );

		ArrayList< Integer > subArray = this.adjecencyMatrix.getRow( parentIndex );
		ArrayList< Integer > connected = new ArrayList< Integer >( );
		for( int i = 0; i < this.Nodes.size( ); i++ ){
			if( this.edgeExist( parentIndex, i ) ){
				connected.add( i  );
			}
		}
		return connected;

	}


	public void removeEdge( Coordinate parent, Coordinate child ){

		int parentIndex = this.getIndex( parent );
		int childIndex = this.getIndex( child );

		this.removeEdge( parentIndex, childIndex );
	}

	public void removeEdge( int parentIndex, int childIndex ){

		this.adjSet( parentIndex, childIndex, 0 );
	}

	public void addEdge( Coordinate parent, Coordinate child ){
		int parentIndex = this.getIndex( parent );
		int childIndex = this.getIndex( child );

		this.addEdge( parentIndex, childIndex );
	}

	public void addEdge( int parentIndex, int childIndex ){
		System.out.printf("adding %d -> %d\n", parentIndex, childIndex );
		this.adjSet(  parentIndex, childIndex, 1 );
	}


	public void adjSet( Coordinate parent, Coordinate child, int v){

		int parentIndex = this.getIndex( parent );
		int childIndex = this.getIndex( child );

		this.adjSet( parentIndex, childIndex, v );
	}

	public void adjSet( int indexParent, int indexChild , int v){
		this.adjecencyMatrix.set( indexParent, indexChild, v );
	}

	public boolean edgeExist( int parentIndex, int childIndex ){

		if( this.adjGetAt( parentIndex, childIndex ) == 1){
			return true;
		}
		return false;
	}

	public boolean inBoundNodeIndex( int nodeIndex ){
		if( nodeIndex < this.Nodes.size( ) ){
			return true;
		}
		return false;
	}

	public int adjGetAt( int x, int y ){
		return this.adjecencyMatrix.get( x, y );
	}

	public boolean edgeExist( Coordinate parent, Coordinate child ){

		int parentIndex = this.getIndex( parent );
		int childIndex = this.getIndex( child );

		return this.edgeExist( parentIndex, childIndex );
	}

	public void addNode( Coordinate coord ){
		if( nodeExist( coord ) ){
			System.out.println("Node already exist");
		}
		else{
			this.Nodes.add( coord );

			// adding row and column in adjecencyMatrix
			this.adjecencyMatrix.add( );
		}
	}


	public boolean nodeExist( Coordinate coord){
		for( int i = 0; i < this.Nodes.size( ); i++ ){
			if( coord.equals( this.Nodes.get( i ) ) ){
				return true;
			}
		}
		return false;
	}


	public int getIndex( Coordinate coord ){

		for( int i = 0; i < this.Nodes.size( ); i++ ){
			if( equalNodes( coord, this.Nodes.get( i ) ) ){
				return i;
			}
		}
		return -1;
	}

	public boolean equalNodes( Coordinate one, Coordinate two ){
		return one.equals( two );
	}

	// RETURN MAXIMUM DISTANCE FROM PARENT NODE TO CHILDREN NODES
	public double getDistance( Coordinate one, Coordinate two ){
		double dist = Math.sqrt( ( one.getX( ) - two.getX( ) )^2 + ( one.getY( ) - two.getY( ) )^2 );
		return dist;
	}


	// public void removeMaxLengthEdge( Coordinate parent ){

		// int parentIndex = this.getIndex( parent );
		// this.removeMaxLengthEdge( parentIndex );
	// }

	//	REMOVES NODE WITH MAXIMUM LENGTH
	// public void removeMaxLengthEdge( int parentIndex ){
		// int maxIndex = 0;
		// // double prevDist = -1;
		// double maxDist = -1;
		// Coordinate parent = Nodes.get( parentIndex );
		// for( int j = 1; j < Nodes.get( parentIndex ).size( ); j++ ){
			// double currDist = getDistance( parent, Nodes.get( parentIndex ).get( j ) );
			// if( currDist > maxDist ){
				// maxDist = currDist;
				// maxIndex = j;
			// }
		// }
		// removeEdge( parent, Nodes.get( parentIndex ).get( maxIndex ) );
	// }

	public AdjecencyMatrix getAdjecencyMatrix( ){
		return this.adjecencyMatrix;
	}

	public ArrayList< Coordinate > getNodes( ){
		return this.Nodes;
	}

}

// ==========================================================================
// ==========================================================================
// ==========================================================================
// ==========================================================================
// ==========================================================================
// ==================== THIS IS THE SEPERATION OF ALTERNATIVE CODE ==========
// ==========================================================================
// ==========================================================================
// ==========================================================================
// ==========================================================================



// import java.util.Arrays;
// import java.util.ArrayList;

// public class Graph{

	// // private ArrayList< ArrayList<Coordinate> > Nodes = new ArrayList< ArrayList<Coordinate> >( );
	// private ArrayList< Coordinate >  Nodes = new ArrayList< Coordinate >( );
	// private ArrayList< Integer > Distances = new ArrayList< Integer >( );
	// private ArrayList< Obsticle > Obsticles = new ArrayList< Obsticle >( );



	// private ArrayList < ArrayList< Integer> > AdjecencyMatrix = new ArrayList< ArrayList< Integer > >();
	// // PARENT ARRAY AND CHILD ARRAY
	// public Graph(){
		// System.out.println("graph constructor");
	// }


	// public void addNode(Coordinate coord){
		// if( ! nodeExist( coord ) && ! nodeIsOnObsticle( coord ) ){

			// Nodes.add( new ArrayList<Coordinate>() );
			// Nodes.get( Nodes.size( ) - 1).add( coord );
		// }
	// }


	// public boolean nodeExist(Coordinate coord){
			// for( int i = 0; i < Nodes.size(); i++ ){
				// if( equalNodes( Nodes.get( i ).get( 0 ), coord ) ){
					// return true;
				// }
			// }
			// return false;
	// }

	// public boolean edgeExist( Coordinate one, Coordinate two){
		// int indexOfOne = getNodeIndex( one );    //index of node_one as parent on parent ArrayList
		// int indexOfTwo = getNodeIndex( two );	// index of node_two as parent on parent ArrayList

		// boolean twoInOne = Nodes.get( indexOfOne ).contains( two );		//
		// boolean oneInTwo = Nodes.get( indexOfTwo ).contains( one );    //

		// return  ( twoInOne && oneInTwo );

	// }

	// public void addEdge	( Coordinate one, Coordinate two ){

		// int parentIndex = getNodeIndex( one );
		// this.Nodes.get( parentIndex ).add( two );

	// }


	// public void removeEdge(Coordinate one, Coordinate two){
		// System.out.printf( "edge between %s - %s\n", one.toString( ), two.toString( ) );
		// int indexOfOne = getNodeIndex( one );
		// int indexOfTwo = getNodeIndex( two );
		// int[] indexes = { indexOfOne, indexOfTwo };
		// //
		// for( int i = 0; i < 2 ; i++ ){
			// for( int j = 1; j < this.Nodes.get( indexes[ i ] ).size( ); j++ ){
				// if( equalNodes( this.Nodes.get( indexes[ i ] ).get( j ), one  ) || equalNodes( Nodes.get( indexes[ i ] ).get( j ), two  ) ){

					// this.Nodes.get( indexes[ i ] ).remove( j );

					// break;
				// }
			// }
		// }
		// System.out.println();
		// // System.out.println( "not found" );
	// }

	// public boolean equalNodes( Coordinate one, Coordinate two ){
		// if( one.getX() == two.getX() &&  one.getY() == two.getY()  ){
			// return true;
		// }
		// return false;
	// }


	// public void printGraph(){
		// for( int i = 0; i < Nodes.size(); i++ ){
			// System.out.printf("(%s)->", Nodes.get( i ).get( 0 ).toString( ) );
			// for( int j = 1; j < Nodes.get( i ).size(); j++ ){
				// System.out.printf( " %s", Nodes.get( i ).get( j ).toString(  ) );
			// }
			// System.out.println();
		// }
	// }

	// public void printGraphWithPositions(){
		// for( int i = 0; i < Nodes.size(); i++ ){
			// System.out.printf("(%d)%s ->", i , Nodes.get( i ).get( 0 ).toString( ) );
			// for( int j = 1; j < Nodes.get( i ).size(); j++ ){
				// Coordinate curr = this.Nodes.get( i ).get( j );
				// System.out.printf( " (%d)%s", getNodeIndex( curr ) , curr.toString(  ) );
			// }
			// System.out.println();
		// }
	// }

	// public void removeNode( Coordinate coord ){
		// for( int i = 0; i < Nodes.size( ); i++ ){
			// int index = Nodes.get( i ).indexOf( coord );
			// if( index == 0 ){
				// Nodes.remove( i );
				// --i;
			// }
			// else if( index > 0 ){
				// Nodes.get( i ).remove( index );
			// }
		// }
	// }


	// public void runKNN(){
		// int k = 6	;
		// double maxDist = -1;
		// for( int i = 0; i < Nodes.size( ); i++){
			// Coordinate parent = Nodes.get( i ).get( 0 );
			// System.out.printf("for parent : %s\n", parent.toString( ) );
			// for( int j = 0; j < Nodes.size(); j++ ){
				// Coordinate child = Nodes.get( j ).get( 0 );
				// if( i==j ){

				// }
				// else if( this.Nodes.get( i ).size( ) < k+1 ){     // && Nodes.get( j ).size( ) < k+1  ){
					// addEdge( parent, child );
				// }
				// else if( getDistance( parent, child ) < getMaxDistance( i ) ){
					// // remove edge with maximum length
					// removeMaxLengthEdge( i );
					// addEdge( parent, child );
				// }
				// else{
					// System.out.println("non -> parent size = "+this.Nodes.get(i).size());
					// System.out.println("parent -> "+parent);

				// }
			// }
			// System.out.println("==============================================================");
		// }
	// }
	// // RETURN MAXIMUM DISTANCE FROM PARENT NODE TO CHILDREN NODES
	// public double getDistance( Coordinate one, Coordinate two ){
		// double dist = Math.sqrt( ( one.getX( ) - two.getX( ) )^2 + ( one.getY( ) - two.getY( ) )^2 );
		// return dist;
	// }

	// //	REMOVES NODE WITH MAXIMUM LENGTH
	// public void removeMaxLengthEdge( int parentIndex ){
		// int maxIndex = 0;
		// // double prevDist = -1;
		// double maxDist = -1;
		// Coordinate parent = Nodes.get( parentIndex ).get( 0 );
		// for( int j = 1; j < Nodes.get( parentIndex ).size( ); j++ ){
			// double currDist = getDistance( parent, Nodes.get( parentIndex ).get( j ) );
			// if( currDist > maxDist ){
				// maxDist = currDist;
				// maxIndex = j;
			// }
		// }
		// removeEdge( parent, Nodes.get( parentIndex ).get( maxIndex ) );
	// }

	// public double getMaxDistance( Coordinate parent ){
		// int parentIndex = getNodeIndex( parent );
		// return getMaxDistance( parentIndex );
	// }

	// public double getMaxDistance( int parentIndex ){
		// double maxDist = 0;
		// for( int j = 1; j < Nodes.get( parentIndex ).size( ); j++ ){
			// // Coordinate connected = Nodes.get( parentIndex ).get( j );
			// double dist = getDistance( Nodes.get( parentIndex ).get( 0 ), Nodes.get( parentIndex ).get( j ) );
			// if( dist > maxDist ){
				// maxDist = dist;
			// }
		// }
		// return maxDist;
	// }

	// public int getNodeIndex( Coordinate coord ){
		// for( int i = 0; i < Nodes.size(); i++ ){
			// if( equalNodes( Nodes.get( i ).get( 0 ), coord ) ){
				// return i;
			// }
		// }
		// return -1;
	// }

	// public void addObsticle(Coordinate topLeft, Coordinate bottomRight){
		// Obsticles.add( new Obsticle( topLeft, bottomRight ) );
	// }

	// // CHECKS IF A SAMPLE POINT IS ON ANY OF THE OBSTICLES
	// public boolean nodeIsOnObsticle(Coordinate coord){
		// for( int i = 0; i < Obsticles.size( ); i++ ){
			// if( Obsticles.get( i ).pointOnObsticle( coord ) ){
				// return true;
			// }
		// }
		// return false;
	// }

// }
