package interpreter;

public abstract class BooleanExpr {

	private Operand first;

	private Operand second;

	public BooleanExpr(Operand first, Operand second) {
		this.first = first;

		this.second = second;

	}

	protected Operand getFirst() {
		return first;
	}

	protected Operand getSecond() {
		return second;
	}

	public abstract boolean value();
}


