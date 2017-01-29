package interpreter;

public class IfStatement implements Statement
{

  private BooleanExpr be;
  
  private Statement fs;

  private Statement ss;


  public IfStatement(BooleanExpr be, Statement fs, Statement ss)
  {
    this.be = be;
    this.fs = fs;
    this.ss = ss;
  }

 @Override
  public void execute()
  {
   if(be.value())
    fs.execute();
   else
    ss.execute();
  }

}