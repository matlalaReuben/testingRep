

public class BubbleSort extends Thread{
	
	
	private int[] array;
	private long runTime = -2;
	BubbleSort( int[] array ){
		super( "BubbleSort" );
		this.array = array;
	}
	
	public void run(){
		
		long start = System.currentTimeMillis( );
		
		for( int i = 0; i < array.length; i++ ){
			for( int j = 0; j < array.length - 1 - i ; j++){
				if( array[ j ] > array[ j + 1 ] ) {
					int temp = array[ j ];
					array[ j ] = array[ j + 1 ] ;
					array[ j + 1] = temp;
				}
			}
		}
		
		long finish = System.currentTimeMillis( );
		this.runTime = finish - start;
	}
	
	public int[] getArray( ){
		return this.array;
	}
	
	public long getRunTime( ){
		return this.runTime;
	}
	
	
	
}