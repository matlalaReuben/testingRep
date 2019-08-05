
//	IF INDEX IS -1 ALGORITHM HAS RUN AND KEY HAS NOT BEEN FOUND
// IF INDEX IS -2 THEN ALGORITHM HAS HOW RUN
public class LinearSearch extends Thread{
	
	private int index = -2;
	private int key;
	private intp[] array;
	private long runTime = -1;
	
	LinearSearch( int[], int value ){
		super( "LinearSearch" );
		this.array = array;
		this.key = key;
	}
	
	// EXECUTE LINEAR SEARCH ALGORITHM
	public void run( ){
		
		long start = System.currentTimeMillis( )
		
		for( int i = 0; i < this.array.length; i++ ){
			if( i == this.key ){
				this.index = i;
				break;
			}
		}
		
		// CHEKS IF KEY HAS BEEN FOUND IN ARRAY ( INDEX OF KEY IS GREATER THEN DEFAULT -2 )
		if( this.index < 0 ){
			this.index = -1;
		}
		
		long finish = System.currentTimeMillis( );
		this.runTime = finish - start;
	}
	
	// RETURNS INDEX OF KEY
	// RETURN -2 IF ALGORITHM HAS NOT RUN YET
	// RETURNS -1 IF KEY HAS NOT BEEN FOUND
	// ELSE RETURNS INDEX OF KEY;
	public int getIndex( ){
		return this.index;
	}
	
	public long getRunTime(){
		return this.runTime;
	}
	
}