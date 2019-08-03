
import java.util.Arrays;
import java.util.ArrayList;

public class Graph{

	private ArrayList< ArrayList<Coordinate> > Nodes = new ArrayList< ArrayList<Coordinate> >( );
	private ArrayList< Integer > Distances = new ArrayList<Integer>( );
	// PARENT ARRAY AND CHILD ARRAY
	public Graph(){
		System.out.println("graph constructor");
	}


	public void addNode(Coordinate coord){
		if( ! nodeExist( coord ) ){
			Nodes.add( new ArrayList<Coordinate>() );
			Nodes.get( Nodes.size( ) - 1).add( coord );
		}
	}


	public boolean nodeExist(Coordinate coord){
			for( int i = 0; i < Nodes.size(); i++ ){
				if( equalNodes( Nodes.get( i ).get( 0 ), coord ) ){
					return true;
				}
			}
			return false;
	}

	public void addEdge(Coordinate one, Coordinate two){
		System.out.printf("add edge between %s and %s\n", one.toString( ), two.toString( ) );
		if( ! nodeExist( one ) ){
			addNode( two );
		}
		if( ! nodeExist( two ) ){
			addNode( one );
		}
		for( int i = 0 ; i < Nodes.size(); i++ ){
			if( equalNodes( Nodes.get( i ).get( 0 ), one ) ){
				Nodes.get( i ).add( two );
			}
			if( equalNodes(Nodes.get( i ).get( 0 ), two ) ){
				Nodes.get( i ).add( one );
			}
		}
	}

	public void removeEdge(Coordinate one, Coordinate two){
		System.out.printf( "edge between %s - %s", one.toString( ), two.toString( ) );
		int indexOfOne = getNodeIndex( one );
		int indexOfTwo = getNodeIndex( two );
		int[] indexes = { indexOfOne, indexOfTwo };
		//
		for( int i = 0; i < 2 ; i++ ){
			for( int j = 1; j < Nodes.get( indexes[ i ] ).size( ); j++ ){
				if( equalNodes( Nodes.get( indexes[ i ] ).get( j ), one  ) || equalNodes( Nodes.get( indexes[ i ] ).get( j ), two  ) ){
					System.out.printf( " removed %s from %s", Nodes.get( indexes[ i ] ).get( j ).toString( ), Nodes.get( indexes[ i ] ).get( 0 ).toString( )	 );
					Nodes.get( indexes[ i ] ).remove( j );
					break;
				}
			}
		}
		System.out.println();
		// System.out.println( "not found" );
	}

	public boolean equalNodes( Coordinate one, Coordinate two ){
		if( one.getX() == two.getX() &&  one.getY() == two.getY()  ){
			return true;
		}
		return false;
	}


	public void printGraph(){
		for( int i = 0; i < Nodes.size(); i++ ){
			System.out.printf("(%s)->", Nodes.get( i ).get( 0 ).toString( ) );
			for( int j = 1; j < Nodes.get( i ).size(); j++ ){
				System.out.printf( " %s", Nodes.get( i ).get( j ).toString(  ) );
			}
			System.out.println();
		}
	}

	// public void removeNode( Coordinate coord ){
	//
	// }


	public void runKNN(){
		int k = 4;
		double maxDist = -1;
		for( int i = 0; i < Nodes.size( ); i++){
			Coordinate parent = Nodes.get( i ).get( 0 );
			for( int j = 0; j < Nodes.size(); j++ ){
				Coordinate child = Nodes.get( j ).get( 0 );
				if( i==j ){
					continue;
				}
				else if( Nodes.get( i ).size( ) < k+1 && Nodes.get( j ).size( ) < k+1  ){
					addEdge( parent, child );
				}
				else if( getDistance( parent, child ) < getMaxDistance( i ) ){
					// remove edge with maximum length
					removeMaxLengthEdge( i );
				}
			}
		}
	}
	// RETURN MAXIMUM DISTANCE FROM PARENT NODE TO CHILDREN NODES
	public double getDistance( Coordinate one, Coordinate two ){
		double dist = Math.sqrt( ( one.getX( ) - two.getX( ) )^2 + ( one.getY( ) - two.getY( ) )^2 );
		return dist;
	}

	//	REMOVES NODE WITH MAXIMUM LENGTH
	public void removeMaxLengthEdge( int parentIndex ){
		int maxIndex = 0;
		// double prevDist = -1;
		double maxDist = -1;
		Coordinate parent = Nodes.get( parentIndex ).get( 0 );
		for( int j = 1; j < Nodes.get( parentIndex ).size( ); j++ ){
			double currDist = getDistance( parent, Nodes.get( parentIndex ).get( j ) );
			if( currDist > maxDist ){
				maxDist = currDist;
				maxIndex = j;
			}
		}
		removeEdge( parent, Nodes.get( parentIndex ).get( maxIndex ) );
	}

	public double getMaxDistance( Coordinate parent ){
		int parentIndex = getNodeIndex( parent );
		return getMaxDistance( parentIndex );
	}

	public double getMaxDistance( int parentIndex ){
		double maxDist = 0;
		for( int j = 1; j < Nodes.get( parentIndex ).size( ); j++ ){
			// Coordinate connected = Nodes.get( parentIndex ).get( j );
			double dist = getDistance( Nodes.get( parentIndex ).get( 0 ), Nodes.get( parentIndex ).get( j ) );
			if( dist > maxDist ){
				maxDist = dist;
			}
		}
		return maxDist;
	}

	public int getNodeIndex( Coordinate coord ){
		for( int i = 0; i < Nodes.size(); i++ ){
			if( equalNodes( Nodes.get( i ).get( 0 ), coord ) ){
				return i;
			}
		}
		return -1;
	}

}
