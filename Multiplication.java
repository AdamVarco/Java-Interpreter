package interpreter;


public class Multiplication extends ArithmeticOp
{

	public Multiplication(Operand first, Operand second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}



	@Override
	public int value()
	{
		return getFirst().value() * getSecond().value();
	}

	
}
