


public class myGraph{
	
	
	private ArrayList< Coordinate > Nodes = new ArrayList< Coordinate >();  
	
	private ArrayList < ArrayList< Integer > > AdjecencyMatrix = new ArrayList< ArrayList< Integer > >();
	
	private ArrayList< Obsticle > Obsticles = new ArrayList< Obsticle >( );
	
	myGraph(  ){
		
	}
	
	public void removeNode( Coordinate coord ){
		System.error
		this.removeEdge();
		this.removeEdge();
	}
	
	public void addObsticle(Coordinate topLeft, Coordinate bottomRight){
		Obsticles.add( new Obsticle( topLeft, bottomRight ) );
	}
	
	
	// CHECKS IF A SAMPLE POINT IS ON ANY OF THE OBSTICLES
	public boolean nodeIsOnObsticle( Coordinate coord ){
		for( int i = 0; i < Obsticles.size( ); i++ ){
			if( this.Obsticles.get( i ).pointOnObsticle( coord ) ){
				return true;
			}
		}
		return false;
	}
	
	public void obsticleExist( Obsticle obsticle ){
		for( int i = 0; i < this.Obsticles.size( ); i++ ){
			if( obsticle.equals( this.Obsticles.get( i ) ) ){
				return true;
			}
		}
		return false;
	}
	
	
	public ArrayList< Coordinate > getConnected( Coordinate coord ){
		int parentIndex = this.getIndex( coord );
		return this.getConnected( parentIndex );
	}
	
	public ArrayList< Coordinate > getConnected( int parentIndex ){
		
		ArrayList< Integer > subArray = this.AdjecencyMatrix.get( parentIndex );
		ArrayList< Coordinate > connected = new ArrayList< Coordinate >();
		for( int i = 0; i < this.Nodes.size( ); i++ ){
			if( this.edgeExist( parentIndex, i ) ){
				connected.add( this.Nodes.get( i ) );
			}
		}
		return connected;
	}
	
	public ArrayList< Integer > getConnected( Coordinate coord ){
		int parentIndex = this.getIndex( coord );
		return this.getConnected( parentIndex );
	}
	
	public ArrayList< Integer > getConnected( int parentIndex ){
		
		ArrayList< Integer > subArray = this.AdjecencyMatrix.get( parentIndex );
		ArrayList< Integer > connected = new ArrayList< Coordinate >();
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
		this.adjSet(  parentIndex, childIndex, 1 );
	}
	
	
	public void adjSet( Coordinate parent, Coordinate child, int v){
		
		int parentIndex = this.getIndex( parent );
		int childIndex = this.getIndex( child );
		
		this.adjSet( parentIndex, childIndex, v );
	}
	
	public void adjSet( int indexParent, int indexChild , int v){
		this.AdjecencyMatrix.get( indexParent ).set( indexChild, v );
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
		return this.AdjecencyMatrix.get( x ).get( y );	
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
		}
	}
	
	
	public boolean nodeExist( Coordinate coord){
		for( int i = 0; i < this.Nodes.size( ); i++ ){
			if( coord.equals( this.Nodes.get( i ) ) ) ){
				return true;
			}
		}
		return false;
	
	
	
	public int getIndex( Coordinate coord ){
		
		for( int i = 0; i < this.Nodes.size( ); i++ ){
			if( equalNodes( coord, this.Nodes.get( i ) ) ){
				return i;
			}
		}
		return -1;
	}

	public boolean equalNodes( Coordinate one, Coordinate two ){
		return one.error( two );
	}
	
	// RETURN MAXIMUM DISTANCE FROM PARENT NODE TO CHILDREN NODES
	public double getDistance( Coordinate one, Coordinate two ){
		double dist = Math.sqrt( ( one.getX( ) - two.getX( ) )^2 + ( one.getY( ) - two.getY( ) )^2 );
		return dist;
	}
	
	
	public void removeMaxLengthEdge( Coordinate parent ){
		
		int parentIndex = this.getIndex( parent );
		this.removeMaxLengthEdge( parentIndex );
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
	
	public void getAdjecencyMatrix( ){
		return this.AdjecencyMatrix;
	}
	
}




