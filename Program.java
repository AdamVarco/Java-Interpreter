package interpreter;

import interpreter.CompoundStatement;

public class Program {
	//private ID var;
	private CompoundStatement CS;

	public Program(ID var, CompoundStatement CS) {
		//this.var = var;
		this.CS = CS;
	}

	public void execute() {
		CS.execute();
	}
}
