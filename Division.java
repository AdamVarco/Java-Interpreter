package interpreter;

public class Division extends ArithmeticOp
{

	public Division(Operand first, Operand second)
	{
		super(first, second);
	}

	@Override
	public int value()
	{
             if(getSecond().value() == 0)
                throw new RuntimeException ("division by zero");
             return getFirst().value() * getSecond().value();
	}

	
}
