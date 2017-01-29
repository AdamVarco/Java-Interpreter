package interpreter;

public class LessThanorEqualTo extends BooleanExpr
{

	public LessThanorEqualTo(Operand first, Operand second)
	{
		super(first, second);
	}

	@Override
	public boolean value()
	{
		return getFirst().value() <= getSecond().value();
	}

}
