package interpreter;

public class WhileStatement implements Statement {
	
	private BooleanExpr be;
	
	private Statement state;
	
	
	public WhileStatement(BooleanExpr be, Statement state)
	{
		this.be = be;
		this.state = state;
	}

	@Override
	public void execute() {
		while(be.value()){
			state.execute();
		}
		
		
	}
}
	