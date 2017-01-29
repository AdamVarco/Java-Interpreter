package interpreter;


public class AssignmentStatement implements Statement

{

   private ID variable;
   
   private ArithmeticExpr AEX;
   
   private MemoryStorage ms;

   public AssignmentStatement(ID variable, ArithmeticExpr AEX, MemoryStorage ms)
   {
     this.variable = variable;
     this.AEX = AEX;
     this.ms = ms;
    }

  @Override
   public void execute()
   {
    ms.store(variable, AEX.value());
   }
   
}