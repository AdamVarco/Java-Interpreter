package interpreter;
import interpreter.StatementList;

public class CompoundStatement
{

	private StatementList stmtList;

	public CompoundStatement(StatementList stmtList)
	{
		this.stmtList = stmtList;
	}
	
	public void execute()
	{
		stmtList.execute();
	}
	
}
