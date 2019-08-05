


// CREATES RANDOM POSITIVE INTEGERS


import java.util.Arrays;
import java.util.Random;

public class RandomIntegers extends Thread{
	
	private long runTime = -2; 
	private int n;
	private int[] array;
	
	RandomIntegers( int n){
		super("RandomIntegers");
		this.n = n;
		this.array = new int[ n ];
	}
	
	public void run(){
		
		long start = System.currentTimeMillis( );
		
		Random rand = new Random( );
		int randV = rand.nextInt( n * 1000  );
		int i = 0;
		while( i < n ){
			if( !Arrays.asList( this.array ).contains( randV ) ){
				this.array[ i ] = randV;
				++i;
			}
			randV = rand.nextInt( n * 1000 );
		}
		
		long finish = System.currentTimeMillis( );
		this.runTime = finish - start;
		
	}
	
	public int[] getArray(){
		return this.array;
	}
	
	public long getRunTime( ){
		return this.runTime;
	}
	
	
}