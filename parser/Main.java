package parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {
		Parser parser;
		try {
			parser = new Parser(new Scanner(
					new BufferedReader(new FileReader("foo.txt"))));
			parser.parse( );
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		}
			    
			    System.out.println("\n done");

	}

}
