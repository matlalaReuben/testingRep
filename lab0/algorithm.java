

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
	
import java.util.Arrays;

public class algorithm{

	public static void main(String args[]){
		System.out.println("start");
		
		Scanner inputScanner = new Scanner( System.in );
		int n = 0;
		while( n != -1 ){
			System.out.print( "enter number of elements : " );
			n = inputScanner.nextInt( );
			System.out.println( );
			
			RandomOrderedIntegers roi = new RandomOrderedIntegers( n );
			
			roi.start( );
				
			try{
				roi.join( );
			}catch( Exception e ){
				System.out.println( e );
			}
			
			long runTime = roi.getRunTime( );
			System.out.println( "runTime=("+runTime+")" );
			
			// System.out.printf( "Thread name=(%s)\n", roi.getId( ) );
			// System.out.printf( "Thread isAlive=(%b)\n", roi.isAlive( ) );
			
			
		}
		// int n = inputScanner.nextInt( );
		
		
		
		
		
		System.out.println( "end" );
		
	}

}

