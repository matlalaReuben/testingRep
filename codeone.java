import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Point;
import java.util.Arrays;
import java.io.*;

public class codeone{
	public static void main(String args[]){
		System.out.println("start");

		// Scanner int_scanner = new Scanner(System.in);
		// Scanner string_scanner = new Scanner(System.in);

		// String filePath = "C://Users//memoria//Documents//SCHOOL//2019//semester_2//coms3005-aaa//project//inputSample.txt";
		String filePath = "inputSample.txt";

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

		int x,y;
		Coordinate[] startEndCoords = new Coordinate[2];
		//	START AND END POINT
		for( int i = 0; i < 2; i++){
			String[] coord = lines.get( i + 1 ).split( "," );
			// System.out.printf( "coord=(%s)\n", Arrays.toString( coord ) );
			x = Integer.parseInt( coord[ 0 ] );
			y = Integer.parseInt( coord[ 1 ] );
			startEndCoords[ i ] = new Coordinate( x, y );
			graph.addNode( startEndCoords[ i ] );
			// map[x][y] = i;
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
				// System.out.printf("obssticle point = %d,%d\n", x, y);
				points[ j ] = new Point( x, y );
			}

			// putObsticles( points[0], points[1], map );
		}

		// READING SAMPLE POINTS

		for( int i = 0; i < n; i++){

			String[] coord = lines.get( i+(2+1)+p ).split( "," );
			x = Integer.parseInt( coord[ 0 ] );
			y = Integer.parseInt( coord[ 1 ] );
			graph.addNode( new Coordinate( x, y ) );
			// map[ y ][ x ] = 1;
			// System.out.printf("sample point = %d,%d\n", x, y);
		}

		// for( int i = 0; i < d; i++ ){
		// 	for(int j = 0; j < d; j++ ){
		// 		System.out.print( map[ i ][ j ] );
		// 	}
		// 	System.out.println( );
		// }
		graph.runKNN( );
		graph.printGraph( );

		System.out.println("end");
	}


	// public static void putObsticles(Point l_t, Point b_r, int[][] map ){
	// 	int x_l = (int) l_t.getX(), x_r = (int) b_r.getX();
	// 	int y_t = (int) l_t.getY(), y_b = (int) b_r.getY();
	// 	for( int x = x_l; x <= x_r; x++){
	// 		for( int y = y_t; y <= y_b; y++){
	// 			map[y][x] = 2;
	// 		}
	// 	}
	// }
}
