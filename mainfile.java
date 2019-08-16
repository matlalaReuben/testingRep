import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Point;
import java.util.Arrays;
import java.io.*;

public class mainfile{
	public static void main(String args[]){
		System.out.println("start");

		// Scanner int_scanner = new Scanner(System.in);
		// Scanner string_scanner = new Scanner(System.in);

		// String filePath = "C://Users//memoria//Documents//SCHOOL//2019//semester_2//coms3005-aaa//project//inputSample.txt";
		// String filePath = "inputSample.txt";
		String filePath = "task1_sample_input.txt";

		File file = new File( filePath );




		ArrayList<String> lines = new ArrayList<String>();

		try{
			String line;
			FileReader fr = new FileReader( file );
			BufferedReader br = new BufferedReader( fr );

			while ( ( line = br.readLine( ) ) != null){
				lines.add( line );
			}
		}catch(Exception e){
			System.out.println( e );
		}

		int k,p,n,d;
		String[] inputs = lines.get( 0 ).split( " " );
		k = Integer.parseInt( inputs[0] );
		p = Integer.parseInt( inputs[1] );
		n = Integer.parseInt( inputs[2] );
		d = Integer.parseInt( inputs[3] );

		// System.out.printf("k=(%d), p=(%d), n=(%d), d=(%s)\n",k,p,n,d);

		// int[][] map = new int[d][d];
		Graph graph = new Graph();



		// I WAS TOO LAZY TO READ START AND END NODE SEPERATLY
		// START AND END NODE ARE STORED IN startEndCoords ARRAY
		// OF SIZE 2 -> CONTAINS BOTH START AND END NODES
		//
		int x,y;
		Coordinate[] startEndCoords = new Coordinate[2];
		//	START AND END POINT
		for( int i = 0; i < 2; i++){
			String[] coord = lines.get( i + 1 ).split( "," );
			x = Integer.parseInt( coord[ 0 ] );
			y = Integer.parseInt( coord[ 1 ] );


			startEndCoords[ i ] = new Coordinate( x, y );

			// ADDING NODE TO GRAPH
			graph.addNode( startEndCoords[ i ] );
		}


		ArrayList<Integer> obticles = new ArrayList<Integer>( );
		ArrayList<Integer> sample_points = new ArrayList<Integer>( );

		// READING OBSTICLE POINTS

		for(int i = 0; i < p; i++){
			String line = lines.get( i+(2+1) );
			String[] points_line = line.split( ";" );   //top-left and bottom_left
			Point[] points = new Point[ 2 ];
			for(int j = 0; j < 2; j++){
				String[] coord = points_line[ j ].split( "," );
				x = Integer.parseInt(  coord[ 0 ] );
				y = Integer.parseInt(  coord[ 1 ] );
				points[ j ] = new Point( x, y );
			}

		}

		// READING SAMPLE POINTS

		for( int i = 0; i < n; i++){

			String[] coord = lines.get( i+(2+1)+p ).split( "," );
			x = Integer.parseInt( coord[ 0 ] );
			y = Integer.parseInt( coord[ 1 ] );
			graph.addNode( new Coordinate( x, y ) );

		}

		// KKN IS A CLASS THAT EXTENDS THREAD CLASS
		//
		KNN knn = new KNN( graph );
		knn.run(  );

		graph = knn.getGraph( );


		System.out.println( "distances	" );
		ArrayList< ArrayList < Double > > distances = knn.getDistances( );
		for( int i = 0; i < distances.size( ); i++ ){
			System.out.println( distances.get( i ) );
		}

		System.out.println( "matrix" );
		System.out.println( graph.getAdjecencyMatrix( ) );


		System.out.println("end");
	}















}
