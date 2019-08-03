
import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;

public class testing{
	public static void main(String args[]){

		System.out.println("start");

		


		// String filename = "GraphInputSample.txt";
		// File file = new File( filename );
		//
		// ArrayList<String> lines = new ArrayList<String>();
		//
		// try{
		//
		// 	FileReader fr = new FileReader( file );
		// 	BufferedReader br = new BufferedReader( fr );
		// 	String line;
		// 	while( (line = br.readLine( ) ) != null ){
		// 		lines.add( line );
		// 	}
		//
		// }catch( Exception e ){
		// 		System.out.println( e );
		// }
		//
		// //	PRINT LINES
		// // System.out.println("[");
		// // for( int i = 0; i < lines.size(); i++ ){
		// // 	System.out.println( lines.get( i ) );
		// // }
		// // System.out.println("]");
		//
		// Graph graph = new Graph();
		//
		// int nNodes = Integer.parseInt ( lines.get( 0 ) );
		// for( int i = 0; i < nNodes; i++ ){
		// 	Coordinate coord =  new Coordinate( lines.get( i + 1 ).split(",") );
		// 	graph.addNode( coord );
		// }
		//
		// int nEdges = Integer.parseInt( lines.get( 1+nNodes ) );
		// for( int i = 0; i < nEdges; i++ ){
		// 	String[] coordinates = lines.get( 2+nNodes+i ).split( ";" );
		// 	// System.out.printf( "%s\n", Arrays.toString( coordinates ) );
		// 	Coordinate coordOne = new Coordinate( coordinates[0].split( "," ) );
		// 	Coordinate coordTwo = new Coordinate( coordinates[1].split( "," ) );
		// 	graph.addEdge( coordOne, coordTwo );
		// }
		//
		// graph.printGraph();

		System.out.println("end");
	}
}
