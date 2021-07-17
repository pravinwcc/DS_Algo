package datastructure.filereader;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.concurrent.TimeUnit;

public class LineNumberReaderExample {

	public static void main(String[] args) throws IOException {
		{
			long startTime = System.nanoTime();
			String filename = "C:\\Enterprise.txt";
			LineNumberReader lineNumberReader = null;
			try {
				// Construct the LineNumberReader object
				lineNumberReader = new LineNumberReader(new FileReader(filename));

				// Print initial line number
				System.out.println("Line " + lineNumberReader.getLineNumber());

				// Setting initial line number
				lineNumberReader.setLineNumber(5);

				// Get current line number
				System.out.println("Line " + lineNumberReader.getLineNumber());

				// Read all lines now; Every read increase the line number by 1
				String line = null;
				System.out.println(lineNumberReader.skip(10));
				lineNumberReader.mark(100000);
				lineNumberReader.reset();
				long lines=0;
				while ((line = lineNumberReader.readLine()) != null) {
					lines++;
				//	System.out.println("Line " + lineNumberReader.getLineNumber() + ": " + line);
				}
				System.out.println(lines);
				long endTime = System.nanoTime();
				long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
				System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				// Close the LineNumberReader
				try {
					if (lineNumberReader != null) {
						lineNumberReader.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			
		}

	}
}