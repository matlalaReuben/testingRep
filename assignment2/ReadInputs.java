

import java.util.ArrayList;
import java.io.*;


public class ReadInputs{
	

	ArrayList< String > keys = new ArrayList< String >( );
	ArrayList< String > values = new ArrayList< String >( );
	
	//index
	private String filename;
	private boolean divide = false;
	
	ReadInputs( String filename ){
		this.filename =  filename;
		// this.readInputs();
		
	}
	
	public void readInputs( ){
		
		File file = new File( this.filename );
		
		try{
			
			FileReader fr = new FileReader( file );
			BufferedReader br = new BufferedReader( fr );
			
			String line;
			
			while( ( line=br.readLine() ) != null ){
				if( this.divide ){
					String[] values = line.split( ":" );
				
					this.keys.add( values[0] );
					this.values.add( values[1] );
				}
				else{
					this.values.add( line );
					
				}
				
			}			
			
			br.close( );
		}
		catch( Exception e ) {
			e.printStackTrace( );
		}
	}
	
	public void setDivide( boolean div ){
		this.divide = div;
	}
	
	public String get( String key){
		// return this.values.get( this.keys.indexOf( key ) );
		return this.getAt( this.keys.indexOf( key ) );
	}
	
	public String getAt( int index ){
		return this.values.get( index );
	}
	
	public ArrayList< String > getValues(){
		return this.values;
	}
	
	public <T> void writeToFile( ArrayList< T > arrayList ){
		
		
		File file = new File( this.filename );
		
		try{
			
			FileWriter fr = new FileWriter( file );
			BufferedWriter bw = new BufferedWriter( fr );
			
			for( int i = 0; i < arrayList.size(); i++ ){
				bw.write( arrayList.get( i )+"\n");
			}
	
			bw.close(  );
			
		}
		catch( Exception e ){
			e.printStackTrace( );
		}

	}
	
}
