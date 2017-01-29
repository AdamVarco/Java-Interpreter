package interpreter;

public class Subtraction extends ArithmeticOp
{

	public Subtraction(Operand first, Operand second)
	{
		super(first, second);
	}

	@Override
	public int value()
	{
		return getFirst().value() - getSecond().value();
	}

	
}
