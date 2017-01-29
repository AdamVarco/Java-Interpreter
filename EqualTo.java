package interpreter;

public class EqualTo extends BooleanExpr {

	public EqualTo(Operand first, Operand second) {
		super(first, second);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean value() {
		// TODO Auto-generated method stub
		 return getFirst().value() == getSecond().value(); 
	}

}
