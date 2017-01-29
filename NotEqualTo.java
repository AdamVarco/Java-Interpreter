package interpreter;
public class NotEqualTo extends BooleanExpr
{

	public NotEqualTo(Operand first, Operand second)
	{
		super(first, second);
	}

	@Override
	public boolean value()
	{
		return getFirst().value() != getSecond().value();
	}

}
