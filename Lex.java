package interpreter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Lex {
	
	private Scanner input;
	
	private String token;
	
	private boolean returned;
	
	public Lex(String filename) throws FileNotFoundException{
		this.input = new Scanner(new File(filename));
		returned = false;
	}
	public String getNextLexeme(){
		String line;
		if(returned){
			line = token;
			returned = false;
		}
		else 
			line = input.next();
		return line;
	}
	public boolean moreLexemes(){
		return returned || input.hasNext();
	}
	public void returnLexeme(String tr)
	{
		token = tr;
		returned = true;
	}

}
