
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

public class TopSort extends Thread{
	
	private LinkedList< Double > distances = new LinkedList < Double >();
	private LinkedList< Integer >  indexes = new LinkedList< Integer >();
 	private LinkedList< Coordinate > nodes;
	
	private int parentIndex;
	
	
	TopSort( ArrayList< Coordinate > nodes , int parentIndex ){
		this.nodes = new LinkedList< Coordinate >( nodes );
		this.parentIndex = parentIndex;
	}
	
	public void run( ){
		
		for( int i = 0; i < this.nodes.size( ); i++ ){
			if( i != parentIndex ){
				Coordinate coord = this.nodes.get( i );
				double distance = this.nodes.get( this.parentIndex ).distanceTo( coord );
				this.addToDistances( distance, i);
				
			}
		}	
	}
	
	public void addToDistances( double distance, int childIndex){
		//System.oout
		int i = 0;
		int length = this.distances.size( );
		System.out.println( "length : "+length );
		while( i < length ){
			if( this.distances.get( i ) > distance ){
				break;
			}
			++i;
		}
		System.out.println("adding at "+i);
		this.distances.add( i, distance );
		this.indexes.add( i, childIndex );
		
	}
	
	public void setParent( Coordinate parent ){
		int parentIndex = this.getNodeIndex( parent );
		this.setParent( parentIndex );
	}
	
	public void setParent( int parentIndex ){
		this.parentIndex = parentIndex;
	}
	
	public LinkedList< Double > getDistances( ){
		return this.distances;
	}
	
	public LinkedList< Integer > getIndexes( ){
		return this.indexes;
	}
	
	public int getNodeIndex( Coordinate coord ){
		
		for( int i = 0; i < this.nodes.size(); i++ ){
			if( coord.equals( this.nodes.get( i ) ) ){
				return i;
			}
		}
		return -1;
	}
	
}