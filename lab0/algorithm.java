

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class algorithm{

	public static void main(String args[]){
		System.out.println("start");
		
	
		// ArrayList <Integer> arrayList = new ArrayList<Integer>();
		// for( int i = 0; i < 10; i++){
		// 	arrayList.add(i*i);
		// }
		
		// printArray( arrayList );
		
		// arrayList.set(0, 8);
		// System.out.println( arrayList.get(0) );
		// printArray( arrayList );
		
	
		System.out.print("enter number of elemets : ");
		Scanner inputScanner = new Scanner(System.in);
		int n = inputScanner.nextInt();
		System.out.println();
		while(n != -1){
			
			long start = System.currentTimeMillis();
			
			taskOne(n);
			
			long finish = System.currentTimeMillis();
			long timeElapsed = finish - start;
			System.out.println("time elapsed : 	"+ timeElapsed);
			
			n = inputScanner.nextInt();
		}
		
		System.out.println("end");
	}


	public static void printArray(ArrayList<Integer> arrayList){

		System.out.print("["+arrayList.get(0));
		for(int i = 1; i < arrayList.size(); i++){
			System.out.print(", "+arrayList.get(i));
		}
		System.out.println("]");

	}
	
	
	public static ArrayList<Integer> taskOne(int n){
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Random rand = new Random();
		int randV;
		for(int i = 0; i < n; i++){
			randV = rand.nextInt(n*10);
			if( !arrayList.contains( randV ) ){
				arrayList.add( randV );
			}
		}
		return arrayList;
	}
	
	
	public static ArrayList<Integer> taskTwo(int n){
		
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Random rand = new Random();
		int randV;
		for(int i = 0; i < n; i++){
			randV = rand.nextInt(n*10);
			if( !arrayList.contains( randV ) ){
				arrayList.add( randV );
			}
		}
		return arrayList;
	}
	
	// 
	public static ArrayList<Integer> sortList(ArrayList<Integer> arrayList){
		int temp;
		for(int i = 0; i < arrayList.size(); i++){
			for(int j = i+1; j < arrayList.size(); j++){
				if( arrayList.get(j) < arrayList.get(i) ){
					temp = arrayList.get(i);
					arrayList.set(i, arrayList.get(j) );
					arrayList.set(j, temp );
				}
			}
		}
		return arrayList;
	}
	
	public static void linearSearch(ArrayList<Integer> arrayList, int key){
		for(){
			
		}
	}
}
