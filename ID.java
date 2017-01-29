package interpreter;

public class ID implements Operand{

  private String variable;
  


  
  private MemoryStorage ms;

  public ID(String variable, MemoryStorage ms)
  {
    this.variable = variable;
    this.ms = ms;
  }
 public String getVar()
  {
   return variable;
  }
  
  @Override
 public int value()
  {
  return ms.fetch(this);
  }
}
