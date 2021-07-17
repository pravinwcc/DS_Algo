package datastructure.filereader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Java8 {
	public static void main(String[] args) throws IOException {
		long startTime = System.nanoTime();
		int totalLines = (int) Files.lines(Paths.get("C:\\Enterprise.txt")).count();
		 long endTime = System.nanoTime();
	        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
	        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
		System.out.println(totalLines);
	try (BufferedReader reader = Files.newBufferedReader(
			
	        Paths.get("C:\\Enterprise.txt"), StandardCharsets.UTF_8)) {
		while(totalLines>0){
		
			totalLines--;
		}
	    List<String> line = reader.lines()
	                              .skip(0)
	                              .limit(12932670)
	                              .collect(Collectors.toList());

	    line.stream().forEach(System.out::println);
	}
}
}
