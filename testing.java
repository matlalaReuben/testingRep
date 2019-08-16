
import java.util.Arrays;
import java.util.ArrayList;
import java.io.*;
import java.util.LinkedList;
import java.sql.*; 
// import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.Random;

import java.util.Scanner;

public class testing{
	public static void main(String args[]){

		System.out.println("start");
		
		// testingTwo();
		// testingThree();
		// testingFour();
		// testingFive();
		// testingSix();
		// testNine();
		
		testTen();
		
		System.out.println("end");
	}
	
	
	
	public static void testTen(){
		
		ArrayList< Integer > arrayList = new ArrayList< Integer >( 4 );
		
		// int length = arrayList.size( );
		for( int i = 0; i < 10; i++ ){
			arrayList.add( i );
		}
		
		System.out.println("before : "+arrayList);
		
		arrayList.clear( );
		
		System.out.println( "after : "+arrayList );
		
		
		// System.out.println( "length : "+length );
		
		
	}
	
	// public static void testNine(){
		
		// ArrayList< ArrayList< Integer > > arrayList = new ArrayList< ArrayList < Integer > > ( 3 )( 5 );
		
		// int lengthX = arrayList.getSize();
		// System.out.printf( " lenghtX : %d \n", lengthX );
		// if( lengthX > 0 ){
			// int lengthY = arrayList.get( 0 ).size( );
			// System.out.printf( " lenghtX : %d \n", lengthX );
		// }
		
	// }
	
	public void testEight(){
		
		LinkedList< Integer > linkedList = new LinkedList< Integer >();
		
		for( int i = 0; i < 5; i++ ){
			linkedList.add( i );
		}
		
		
	}
	
	public static void testingSix(){
		System.out.println( "testingSix" );
		
		try{  
			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.jdbc.Driver");  
			// jdbc:mysql://192.168.15.25:3306/yourdatabase
			// Connection con = DriverManager.getConnection( "jdbc:mysql://remotemysql.com", "l18Jt8LSkG", "root");  
			// // //here sonoo is database name, root is username and password  
			// // Statement stmt = con.createStatement();  
			// // ResultSet rs=stmt.executeQuery("select * from emp");  
			// // // while( rs.next( ) ){
				// // // System.out.println( rs.getInt( 1 )+"  "+ rs.getString( 2 )+"  "+ rs.getString( 3 ) );  
			// // // }
			// // con.close( );
			// System.out.println( "finished" );
			System.out.println( "finished" );
		}
		catch( Exception e ){
			System.out.println( "error occured" );
			e.printStackTrace( );
			// System.out.println( e );
		} 
		
	
		// Context context = new InitialContext();
		// DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDB");
		
		 // ========
		
		// MysqlDataSource dataSource = new MysqlDataSource();
		// dataSource.setUser("l18Jt8LSkG");
		// dataSource.setPassword("vcVj5ay1JU");
		// dataSource.setServerName("remotemysql.com");
		
		
		// Connection conn = dataSource.getConnection();
		// Statement stmt = conn.createStatement();
		// ResultSet rs = stmt.executeQuery("SELECT * FROM dummyTable");
		
		
		// // ...
		
		
		// rs.close();
		// stmt.close();
		// conn.close();
		// System.out.println( "finished" );
		
	}
	
	public static void testingFive(){
		
		Integer value = new Integer( 5 );
		
		Codetwo codetwo = new Codetwo( value );
		codetwo.setValue( 10 );
		
		System.out.println( "now value : "+value );
		
	}
	
	// testing nested functon
	// public static void testingFour(){
		
		// static void nestedFunction(){
			// System.out.println( "line from nested function" );	
		// }
		
		// nestedFunction();
	// }
	
	public static void testingTwo(){
		System.err.println( "This is suppossed to be an error" );
	}
	
	
	// testing linkedlist
	public static void testingThree(){
		
		LinkedList< Integer > unsorted = new LinkedList< Integer >();
		
		Random random = new Random();
		
		for( int i = 0; i < 5; i++ ){
			unsorted.add( random.nextInt( 100 ) );
		}
	
		System.out.println( unsorted );
		
		LinkedList< Integer > sorted = new LinkedList< Integer >();
		LinkedList< Integer > indexes = new LinkedList< Integer >();
		
		for( int i = 0; i < unsorted.size(); i++ ){
			int j = 0;
			int length = sorted.size( );
			while( j < length ){
				if( sorted.get( j ) > unsorted.get( i )){
					break;
				}
				++j;
			}
			
			sorted.add( j ,unsorted.get( i ) );
			indexes.add( j, i );
		}
		
		System.out.println( "sorted->"+sorted );
		System.out.println( "indexes->"+indexes );
		
		// int i = 0;
		// int length = unsorted.size( );
		// while( i < legnth ){
			// if( unsorted.get( i ) > distance ){
				// break;
			// }
			// ++i;
		// }
	
		// this.distances.add( i, distance );
		// this.indexes.add( i, index );
		
		// System.out.println( linkedlist );
		
	}
	
	// testing == sign
	public static void testing(){
		int a,b,c;
		
		Scanner inputScanner = new Scanner( System.in );
		
		
		System.out.print( "Enter a : " );
		a = inputScanner.nextInt( );
		System.out.printf("a = %d\n", a);
		
		
		System.out.printf( "Enter b : " );
		b = inputScanner.nextInt( );
		System.out.printf("b = %d\n", b);
		
		System.out.printf( "Enter c : " );
		c = inputScanner.nextInt( );
		System.out.printf("c = %d\n", c);
	
		boolean equal = a==b && a==c;
		
		
		System.out.println("equal = "+equal);
		
	}
}
