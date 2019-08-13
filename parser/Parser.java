package parser;



public class Parser {

    private Scanner scanner;
    private Environment environment;


		public Parser(Scanner scanner) {
		    this.scanner = scanner;
		} 
		
		
		public void parse ( ) {
			environment = new Environment();
		    sequence();
		}
		
		
		private void sequence( ) {
		    
			Sequence seq;			   
	    	seq = new Sequence(scanner, environment);
	    	
		    
		}
		

}
