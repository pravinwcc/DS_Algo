package datastructure.filereader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class FileReader {

	public static void main(String[] args) throws IOException {
			 
	        long startTime = System.nanoTime();
	        Path file = Paths.get("C:\\Enterprise.txt");
	        try
	        {
	            //Java 8: Stream class
	            Stream<String> lines = Files.lines( file, StandardCharsets.UTF_8 );
	            
	            for( String line : (Iterable<String>) lines::iterator )
	            {
	              // System.out.println(line);
	            }
	        
	        } catch (IOException ioe){
	            ioe.printStackTrace();
	        }
	 
	        long endTime = System.nanoTime();
	        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
	        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
	    }
}
