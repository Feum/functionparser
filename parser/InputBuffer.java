package parser;

import java.io.BufferedReader;
import java.io.IOException;

public class InputBuffer {
	
	//Reads the input char by char and line by line
	
	private String line = "";
	private int linePosition = 0;
	private BufferedReader  inputStream;

	public InputBuffer (BufferedReader in) {
	    this.inputStream = in;
	} 


	public char get ( ) throws IOException {
	    linePosition++;
	    if (line == null) return '$';
	    if (linePosition >= line.length()) {
			
			line = inputStream.readLine();

			
			if (line == null) 
			    return '$';
			linePosition = 0;
			line = line + "\n";   
	    } 
	    return line.charAt(linePosition);
	}
	

	public char lookAhead() throws IOException{
		int lookAhead = linePosition < 0? 0 : linePosition;
		if (line == null) return '$';
		
		while (Character.isWhitespace(line.charAt(lookAhead))) {
			
			lookAhead++;
		
			if (lookAhead >= line.length()) {
					
				line = inputStream.readLine();

				if (line == null) 
				    return '$';
				linePosition = -1;
				lookAhead = 0;
				line = line + "\n"; 
			}
		}
		
		return line.charAt(lookAhead);
	}
	
	
}
