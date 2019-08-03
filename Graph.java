
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

	public void removeNode( Coordinate coord ){

	}


	public void algorithm(){
		int k = 4;
		for( int i = 0; i < Nodes.size( ); i++){
			Coordinate parent = Nodes.get( i ).get( 0 );
			for( int j = 0; j < Nodes.size(); j++ ){
				if( i==j ){
					continue;
				}

				Coordinate child = Nodes.get( j ).get( 0 );

				else if( Nodes.get( i ).size( ) < k+1 ){
					addEdge( parent, child );
				}
				else if( getDistance( parent, child ) < getMaxDistance(  ) ){
					// remove edge
					
				}

			}
		}
	}
	// RETURN MAXIMUM DISTANCE FROM PARENT NODE TO CHILDREN NODES
	public double getDistance( Coordinate one, Coordinate two ){
		double dist = Math.sqrt( ( one.getX( ) - two.getX( ) )^2 + ( one.getY( ) - two.getY( ) )^2 );
	}

	public double getMaxDistance( Coordinate parent ){

		int parentIndex = getNodeIndex( parent );

		double maxDist = 0;
		for( int j = 1; j < Nodes.get( parentIndex ).size( ); i++ ){
			// Coordinate connected = Nodes.get( parentIndex ).get( j );
			double dist = getDistance( parent, Nodes.get( parentIndex ).get( j ) );
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
		return null;
	}

}
