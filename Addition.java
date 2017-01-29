package interpreter;

public class Addition extends ArithmeticOp
{

	public Addition(Operand first, Operand second)
	{
		super(first, second);
	}

	@Override
	public int value()
	{
		return getFirst().value() + getSecond().value();
	}

	
}
