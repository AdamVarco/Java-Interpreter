package interpreter;

public abstract class ArithmeticOp implements ArithmeticExpr
{

	private Operand first;
	
	private Operand second;

	public ArithmeticOp(Operand first, Operand second)
	{
		this.first = first;
		this.second = second;
	}

	/**
	 * @return the first op
	 */
	protected Operand getFirst()
	{
		return first;
	}

	/**
	 * @return the second op
	 */
	protected Operand getSecond()
	{
		return second;
	}
	
	
}