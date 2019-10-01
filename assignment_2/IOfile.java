import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

//import com.sun.java.util.jar.pack.Package.File;

public class IOfile{

  private String filename;
  private boolean useDelimeter = false;
  
  private ArrayList< String > lines = new ArrayList< String >();
  
  public IOfile( String filename ){
    this.filename = filename;
  }


  public void readInputs(){
    String line;

    File file = new File( filename );
    try{
      FileReader fr = new FileReader( file );
      BufferedReader br = new BufferedReader( fr );

      int lineNum = 0;
      while( ( line = br.readLine() ) != null ){
        System.out.print( String.format("%d - %s\n", lineNum, line) );
        ++lineNum;
      }

    }
    catch( Exception e ){
    	e.printStackTrace();
    }
  }

  public void useDelimeter( Boolean useDelimeter ){
    this.useDelimeter = useDelimeter;
  }



}
