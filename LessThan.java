package interpreter;

public class LessThan extends BooleanExpr
{

  public LessThan(Operand first, Operand second)
  {
   super(first, second);
  }

@Override 

 public boolean value()
 {
  return getFirst().value()< getSecond().value();
 }
}
