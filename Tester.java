package interpreter;

import interpreter.ParserException;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws java.io.FileNotFoundException 
	{
	     
	    	  try{
	    		 MemoryStorage ms = new MemoryStorage();
	    		  String filename = new String("C:/Users/Adam/Desktop/prog4.txt");
	    		  Parser parse =  new Parser(filename, ms);
	    		  Program program = parse.parser();
	    		  program.execute();
	    		  //System.out.println(program);
	    	  }
	      catch (ParserException e)
			{
				System.out.println (e.getMessage());
				e.printStackTrace();
			}
			catch (RuntimeException e)
			{
				System.out.println (e.getMessage());
				e.printStackTrace();
			}
			catch (Exception e)
			{
				System.out.println ("unknown error occurred - terminating");
				e.printStackTrace();
			}
	        	  
	          }
	    		  
	    	  

	}


