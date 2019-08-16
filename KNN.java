

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;


public class KNN extends Thread{

	private ArrayList < ArrayList <Double > > distances = new ArrayList< ArrayList < Double > >( );
	private ArrayList < Coordinate > nodes = new ArrayList< Coordinate >( );

	// private

	private int K = 5;
	private Graph graph;

	KNN( Graph graph ){
		this.graph = graph;
		this.nodes = new ArrayList< Coordinate >( graph.getNodes( ) );

	}


	public void setK( int k ){
		this.K = k;
	}

	public int getK(){
		return this.K;
	}

	public void run(){

		// DELETE ENTRIES BEFORE ALGORITHM COULD RUN
		// adjecencyMatrix SIZE SHOULD BE LESS OR EQUAL TO NUMBER
		// OF Nodes
		// adjecencyMatrix.clear();

		for( int i = 0; i < this.nodes.size( ); i++ ){
			ArrayList< Integer > sortedIndexes = this.getClose( i );
			List< Integer > asList = sortedIndexes.subList( 0, this.K );

			for( int j = 0; j < asList.size(); j++ ){
				this.graph.addEdge( i,  asList.get( j ) );
			}

		}
	}


	public void buildAdjecencyMatrix( List< Integer > list ){

	}

	public ArrayList< Integer > getClose( Coordinate coord ){
		int parentIndex = this.getNodeIndex( coord );

		return this.getClose( parentIndex );
	}

	public ArrayList< Integer > getClose( int parentIndex ){

		TopSort topSort = new TopSort( this.nodes, parentIndex );
		topSort.run();
		ArrayList < Integer > indexes = new ArrayList< Integer >( topSort.getIndexes( ) );
	// LinkedList < Double > linkedList = TopSort.getDistances( );
		ArrayList< Double > dist = new ArrayList< Double >( topSort.getDistances( ) );

		this.distances.add( dist );

		return indexes;

	}


	public int getNodeIndex( Coordinate coord ){

		for( int i = 0; i < this.nodes.size(); i++ ){
			if( coord.equals( this.nodes.get( i ) ) ){
				return i;
			}
		}
		return -1;
	}

	public Graph getGraph(){
		return this.graph;
	}

	public ArrayList< ArrayList	< Double > > getDistances( ){
		return this.distances;
	}
}
