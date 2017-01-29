package interpreter;

public class GreatorThanorEqualTo extends BooleanExpr
{

	public GreatorThanorEqualTo(Operand first, Operand second)
	{
		super(first, second);
	}

	@Override
	public boolean value()
	{
		return getFirst().value() >= getSecond().value();
	}

}
