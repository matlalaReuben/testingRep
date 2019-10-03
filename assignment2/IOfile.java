

import java.util.ArrayList;
import java.io.*;


public class IOfile{
	

	ArrayList< String > keys = new ArrayList< String >( );
	ArrayList< String > values = new ArrayList< String >( );
	
	private String filename;
	private boolean useDelimiter = false;
    private String delimiter;
  
	
	IOfile( String filename ){
		this.filename =  filename;		
	}
	
	public void read( ){
		
		File file = new File( this.filename );
		
		try{
			
			FileReader fr = new FileReader( file );
			BufferedReader br = new BufferedReader( fr );
			
			String line;
			
			while( ( line=br.readLine() ) != null ){
				if( this.useDelimiter ){
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
	
	public void setDelimiter( String delim ){
		this.delimiter = delim;
	}
	
    
    public void useDelimiter( boolean delim ){
        this.useDelimiter = delim;
    }
    
    /**
     * 
     *
     */
	public String get( String key){
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
	
	
	public String[] getlines(){
		
        String[] v = new String[ this.values.size() ];
        v = this.values.toArray( v );
        return v;
	}
	
}
