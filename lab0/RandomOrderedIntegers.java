
// CREATE RANDOM ORDERED INTEGERS
// RUNS MULTIPLE

public class RandomOrderedIntegers extends Thread{
	
	private long runTime = -2;
	private int n;
	private int[ ] array;
	
	RandomOrderedIntegers( int n ){
		// super( "RandomOrderedIntegers" );
		this.n = n;
		// this.array = new int[ n ];
	}
	
	public void run( ){
		
		long start = System.currentTimeMillis( );
		
		// CREATING ARRAY USING RANDONINTEGERS CLASS
		RandomIntegers randInt = new RandomIntegers( n );
		randInt.run();
		this.array = randInt.getArray( );
		
		// SORTTING ARRRAY WITH BUBBLESORT CLASS
		BubbleSort bubbleSort = new BubbleSort( this.array );
		bubbleSort.run( );
		this.array = bubbleSort.getArray( );
		
		long finish = System.currentTimeMillis( );
		this.runTime = finish - start;
		
	}
	
	public int[ ] getArray( ){
		return this.array;
	}
	
	public long getRunTime(){
		return this.runTime;
	}
	
	
}