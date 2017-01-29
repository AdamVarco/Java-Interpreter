package interpreter;

import interpreter.Operand;

public class UnaryExpr implements ArithmeticExpr {

	private Operand op;

	public UnaryExpr(Operand op)
	{
		this.op = op;
	}

	@Override
	public int value()
	{
		return op.value();
	}
}
