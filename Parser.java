package interpreter;

import java.io.FileNotFoundException;


import interpreter.Addition;
import interpreter.ArithmeticExpr;
import interpreter.Division;
import interpreter.Multiplication;
import interpreter.Subtraction;
import interpreter.UnaryExpr;

import interpreter.Constant;
import interpreter.ID;

import interpreter.ArithmeticExpr;
import interpreter.AssignmentStatement;
import interpreter.ID;

import interpreter.BooleanExpr;
import interpreter.EqualTo;
import interpreter.GreatorThanorEqualTo;
import interpreter.GreatorThan;
import interpreter.ID;
import interpreter.LessThanorEqualTo;
import interpreter.LessThan;
import interpreter.NotEqualTo;
import interpreter.Operand;
import interpreter.PrintStatement;

import interpreter.Program;

import interpreter.StatementList;

import interpreter.ParserException;

public class Parser {
	private Lex lex;
	

	
	private MemoryStorage ms;
	
	
	
	
	public Parser(String filename, MemoryStorage ms)throws FileNotFoundException{

		lex = new Lex(filename);
		this.ms= new MemoryStorage();
	}

	
	public Program parser()throws ParserException{
		String lexeme= getLexeme();
		
		if(!lexeme.equalsIgnoreCase("program"))
		throw new ParserException("reserved Word program expected");
	
	
		ID var = getID();
		
		CompoundStatement stat = getCompundStatement();
		return new Program(var, stat);
		
	}
     private ID getID()throws ParserException {
	
    	 String lexeme = lex.getNextLexeme();
    	 
    	 
		if(!isValidID(lexeme)){
			throw new ParserException("ID expected");
		}
		
			
	
		return new ID(lexeme, ms);
	}
	private boolean isValidID(String lexeme) {
		
		return lexeme.length() == 1 && Character.isLetter(lexeme.charAt(0));
	}

	
	private StatementList getStatementList() throws ParserException{
		StatementList list = new StatementList();
		Statement state = getStatement();
		list.addStatement(state);
		String lexeme= lex.getNextLexeme();
		if(lexeme.equals(";")){
	     state = getStatement();
	     lex.returnLexeme(lexeme);
	     list.addStatement(state);
		 lexeme = lex.getNextLexeme();
			}
		else
		lex.returnLexeme(lexeme);
		
		return new StatementList();
	}

	private boolean isValidStatementStart(String lexeme) {
		return lexeme.equalsIgnoreCase("if") || lexeme.equalsIgnoreCase("while") || isValidID(lexeme) ||
		lexeme.equalsIgnoreCase("print")|| lexeme.equalsIgnoreCase("begin");
	

	}

	private Statement getStatement() throws ParserException{
		Statement State;
		String lexeme = lex.getNextLexeme();
		lex.returnLexeme(lexeme);
		if (lexeme.equalsIgnoreCase("if"))
			State = getIfStatement();
		else if (lexeme.equalsIgnoreCase("while"))
			State = getWhileStatement();
		else if (lexeme.equalsIgnoreCase("print"))
			State = getPrintStatement();
		else if (isValidID(lexeme))
			State = getAssignmentStatement(lexeme);
		else if(lexeme.equalsIgnoreCase("begin"))
			State = (Statement) getCompundStatement();
		else 
			throw new ParserException("Statement expected");
		return State;
	}
	private CompoundStatement getCompundStatement()throws ParserException {
		String lexeme= getLexeme();
	
		if(!lexeme.equalsIgnoreCase("begin"))
			throw new ParserException("reserved Word begin expected");
	
	
		StatementList statements= getStatementList();
		
		lexeme = lex.getNextLexeme();
		if(!lexeme.equalsIgnoreCase("end"))
			
			throw new ParserException("reserved Word end expected");
		
		return new CompoundStatement (statements);
		}
		
	private Statement getAssignmentStatement(String lexeme)throws ParserException {
		String token = getLexeme();
		ID var = new ID (lexeme, ms);
		
		token = lex.getNextLexeme();
	
		if (!token.equals(":="))
			throw new ParserException (":= expected");
		ArithmeticExpr expr = getArithmeticExpression ();
		
		return new AssignmentStatement (var, expr, ms);
		// TODO Auto-generated method stub
		
	}

	private ArithmeticExpr getArithmeticExpression() throws ParserException {
		ArithmeticExpr expr;
		Operand op1 = getOperand();
		String lexeme = lex.getNextLexeme();
		if (!isArithmeticOp(lexeme))
		{
			lex.returnLexeme(lexeme);
			expr = new UnaryExpr(op1);
		}
		else
		{
			Operand op2 = getOperand();
			if (lexeme.equals("+"))
				expr = new Addition (op1, op2);
			else if (lexeme.equals("-"))
				expr = new Subtraction(op1, op2);
			else if (lexeme.equals("*"))
				expr = new Multiplication (op1, op2);
			else
				expr = new Division (op1, op2);
		}		
		return expr;
	}
		
	

	private boolean isArithmeticOp(String lexeme) {
		return lexeme.equals("+") || lexeme.equals("-") || lexeme.equals("*") || lexeme.equals("/");
	}

	private Statement getPrintStatement() throws ParserException {
		String lexeme = getLexeme();
		if(!lexeme.equalsIgnoreCase("print"))
			throw new ParserException("reserved word print expected");
		lexeme= lex.getNextLexeme();
		if (!isValidID(lexeme))
			throw new ParserException ("id expected");
		ID var = new ID (lexeme, ms);
        System.out.println(lexeme);
	
		return new PrintStatement (var);
		
		
	}

	private Statement getWhileStatement() throws ParserException {
		String lexeme = lex.getNextLexeme();
		if(!lexeme.equalsIgnoreCase("while"))
			throw new ParserException("reserved word while expected");
		BooleanExpr expr = getBooleanExpr();
		lexeme = lex.getNextLexeme();
		if(!lexeme.equalsIgnoreCase("do"))
			throw new ParserException("reserved word do expected");
	    Statement state = getStatement();
		return new WhileStatement(expr, state);
	}

	private Statement getIfStatement() throws ParserException {
		String lexeme = lex.getNextLexeme();
		if(!lexeme.equalsIgnoreCase("if"))
			throw new ParserException("reserved word if expected");
		BooleanExpr expr = getBooleanExpr();
		lexeme = lex.getNextLexeme();
		if(!lexeme.equalsIgnoreCase("then"))
			throw new ParserException("reserved word then expected");
		Statement state = getStatement();
		lexeme = lex.getNextLexeme();
		if(!lexeme.equalsIgnoreCase("else"))
			throw new ParserException("reserved word else expected");
		Statement state2 = getStatement();
		return new IfStatement(expr,state,state2);
		
	
	}

	private BooleanExpr getBooleanExpr() throws ParserException {
		BooleanExpr expr;
		Operand op1 = getOperand();
		String lexeme = lex.getNextLexeme();
		if (!isValidRelativeOp(lexeme))
			throw new ParserException ("relative operator expected");
		Operand op2 = getOperand();
		if (lexeme.equalsIgnoreCase ("="))
			expr = new EqualTo (op1, op2);
		else if (lexeme.equalsIgnoreCase("/="))
			expr = new NotEqualTo (op1, op2);
		else if (lexeme.equalsIgnoreCase("<"))
			expr = new LessThan (op1, op2);
		else if (lexeme.equalsIgnoreCase("<="))
			expr = new LessThanorEqualTo (op1, op2);
		else if (lexeme.equalsIgnoreCase(">"))
			expr = new GreatorThan (op1, op2);
		else
			expr = new GreatorThanorEqualTo (op1, op2);
		return expr;
		
		
	}

	private boolean isValidRelativeOp(String lexeme) {
		
		return lexeme.equals("=") || lexeme.equals("/=") || lexeme.equals("<") || lexeme.equals("<=")
		|| lexeme.equals(">") || lexeme.equals(">=");
	}

	private Operand getOperand() throws ParserException{
		
		Operand op = null;
		String lexeme = lex.getNextLexeme();
		if (isValidID (lexeme))
			op = new ID(lexeme, ms);
		else if (isValidConstant(lexeme))
			op = new Constant (Integer.parseInt(lexeme));
		    
		else
			throw new ParserException ("operand expected");
		return op;
		
	}

	private boolean isValidConstant(String lexeme) throws ParserException{
		int value = 0;
	
		try
		{
		value = Integer.parseInt(lexeme);
	
			
		}
		catch (NumberFormatException e)
		{
			throw new ParserException ("invalid constant");
		}
		return true;
		
		
	}

	private String getLexeme() throws ParserException
	{
		if (!lex.moreLexemes())
			throw new ParserException ("illegal end of program");
		return lex.getNextLexeme();
	}
}




	
