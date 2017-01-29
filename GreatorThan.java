package interpreter;

public class GreatorThan extends BooleanExpr
{
  
  public GreatorThan(Operand first, Operand second)
  {
   super(first, second);
  }

 @Override
  public boolean value()
  {
  return getFirst().value() > getSecond().value(); 
  }
}